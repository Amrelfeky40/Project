package main.java.com.library.repositories;

import main.java.com.library.interfaces.Borrowable;
import main.java.com.library.interfaces.Searchable;
import main.java.com.library.models.Member;
import main.java.com.library.models.Loan;
import main.java.com.library.strategies.SearchStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryLibraryRepository implements LibraryRepository {
    private List<Borrowable> items;
    private List<Member> members;
    private List<Loan> loans;
    private Map<String, Borrowable> itemMap;

    public InMemoryLibraryRepository() {
        this.items = new ArrayList<>();
        this.members = new ArrayList<>();
        this.loans = new ArrayList<>();
        this.itemMap = new HashMap<>();
    }

    @Override
    public void addItem(Borrowable item) {
        items.add(item);
        itemMap.put(item.getTitle().toLowerCase(), item);
    }

    @Override
    public boolean removeItem(String itemId) {
        return items.removeIf(item -> item.getTitle().equals(itemId));
    }

    @Override
    public List<Borrowable> getAllItems() {
        return new ArrayList<>(items);
    }

    @Override
    public void addMember(Member member) {
        members.add(member);
    }

    @Override
    public boolean removeMember(String memberId) {
        return members.removeIf(member -> member.getMemberId().equals(memberId));
    }

    @Override
    public List<Member> getAllMembers() {
        return new ArrayList<>(members);
    }

    @Override
    public void addLoan(Loan loan) {
        loans.add(loan);
    }

    @Override
    public List<Loan> getLoans() {
        return new ArrayList<>(loans);
    }

    @Override
    public List<Searchable> searchItems(String keyword, SearchStrategy strategy) {
        List<Searchable> searchableItems = new ArrayList<>();
        for (Borrowable item : items) {
            if (item instanceof Searchable) {
                searchableItems.add((Searchable) item);
            }
        }
        return strategy.search(searchableItems, keyword);
    }
}