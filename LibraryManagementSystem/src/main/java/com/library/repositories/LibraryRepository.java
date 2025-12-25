package main.java.com.library.repositories;

import main.java.com.library.interfaces.Borrowable;
import main.java.com.library.interfaces.Searchable;
import main.java.com.library.models.Member;
import main.java.com.library.models.Loan;
import main.java.com.library.strategies.SearchStrategy;
import java.util.List;

public interface LibraryRepository {
    void addItem(Borrowable item);
    boolean removeItem(String itemId);
    List<Borrowable> getAllItems();

    void addMember(Member member);
    boolean removeMember(String memberId);
    List<Member> getAllMembers();

    void addLoan(Loan loan);
    List<Loan> getLoans();

    List<Searchable> searchItems(String keyword, SearchStrategy strategy);
}