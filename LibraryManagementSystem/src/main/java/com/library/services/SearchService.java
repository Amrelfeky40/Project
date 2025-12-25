package main.java.com.library.services;



import main.java.com.library.interfaces.Searchable;
import main.java.com.library.strategies.SearchStrategy;
import java.util.List;
import java.util.stream.Collectors;

public class SearchService {

    public List<Searchable> search(List<Searchable> items, String keyword, SearchStrategy strategy) {
        return items.stream()
                .filter(item -> strategy.matches(item, keyword))
                .collect(Collectors.toList());
    }

    public void displaySearchResults(List<Searchable> results) {
        if (results.isEmpty()) {
            System.out.println("No items found.");
        } else {
            System.out.println("Found " + results.size() + " items:");
            results.forEach(item -> System.out.println("  - " + item.getItemInfo()));
        }
    }
}
