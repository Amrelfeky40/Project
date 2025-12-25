package main.java.com.library.strategies;

import main.java.com.library.interfaces.Searchable;
import java.util.List;
import java.util.stream.Collectors;

public class TitleSearchStrategy implements SearchStrategy {

    @Override
    public List<Searchable> search(List<Searchable> items, String keyword) {
        return items.stream()
                .filter(item -> matches(item, keyword))
                .collect(Collectors.toList());
    }

    @Override
    public boolean matches(Searchable item, String keyword) {
        return item.getItemInfo().toLowerCase().contains(keyword.toLowerCase());
    }
}