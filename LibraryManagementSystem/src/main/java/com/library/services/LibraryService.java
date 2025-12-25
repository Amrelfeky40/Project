package main.java.com.library.services;

import main.java.com.library.interfaces.Borrowable;
import main.java.com.library.interfaces.Searchable;
import main.java.com.library.models.*;
import main.java.com.library.repositories.LibraryRepository;
import main.java.com.library.repositories.InMemoryLibraryRepository;
import main.java.com.library.strategies.SearchStrategy;
import java.util.List;

public class LibraryService {
    private static LibraryService instance;
    private LibraryRepository repository;

    private LibraryService() {
        // Dependency Injection - depends on abstraction
        this.repository = new InMemoryLibraryRepository();
    }

    public static LibraryService getInstance() {
        if (instance == null) {
            instance = new LibraryService();
        }
        return instance;
    }

    // Item management
    public void addItem(Borrowable item) {
        repository.addItem(item);
        System.out.println("Added item: " + item.getTitle());
    }

    public boolean removeItem(String itemId) {
        return repository.removeItem(itemId);
    }

    // Member management
    public void registerMember(Member member) {
        repository.addMember(member);
        System.out.println("Registered member: " + member.getName());
    }

    // Borrowing operations
    public boolean borrowItem(Member member, Borrowable item) {
        if (!item.isAvailable()) {
            System.out.println("Item not available: " + item.getTitle());
            return false;
        }

        if (member.hasOverdueLoans()) {
            System.out.println("Member has overdue items");
            return false;
        }

        boolean success = item.borrowItem(member);
        if (success) {
            Loan loan = new Loan(item, member);
            member.addLoan(loan);
            repository.addLoan(loan);
            System.out.println("Loan created: " + loan);
        }

        return success;
    }

    public boolean returnItem(Member member, Borrowable item) {
        boolean success = item.returnItem(member);
        if (success) {
            // Find and update the loan
            repository.getLoans().stream()
                    .filter(loan -> loan.getItem().equals(item) &&
                            loan.getMember().equals(member) &&
                            loan.getReturnDate() == null)
                    .findFirst()
                    .ifPresent(Loan::returnItem);
            System.out.println("Item returned: " + item.getTitle());
        }
        return success;
    }

    // Search operations using Strategy Pattern
    public List<Searchable> searchItems(String keyword, SearchStrategy strategy) {
        return repository.searchItems(keyword, strategy);
    }

    // Reporting
    public void generateReport() {
        System.out.println("\n=== Library Report ===");
        System.out.println("Total items: " + repository.getAllItems().size());
        System.out.println("Total members: " + repository.getAllMembers().size());
        System.out.println("Active loans: " + repository.getLoans().size());

        long overdueLoans = repository.getLoans().stream()
                .filter(Loan::isOverdue)
                .count();
        System.out.println("Overdue loans: " + overdueLoans);
    }

    // Getters
    public List<Borrowable> getAllItems() {
        return repository.getAllItems();
    }

    public List<Member> getAllMembers() {
        return repository.getAllMembers();
    }

    public List<Loan> getAllLoans() {
        return repository.getLoans();
    }
}