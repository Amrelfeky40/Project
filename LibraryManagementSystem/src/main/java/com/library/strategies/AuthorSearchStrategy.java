package main.java.com.library.strategies;

import main.java.com.library.interfaces.Searchable;
import main.java.com.library.models.Book;
import java.util.List;
import java.util.stream.Collectors;

public class AuthorSearchStrategy implements SearchStrategy {

    @Override
    public List<Searchable> search(List<Searchable> items, String keyword) {
        return items.stream()
                .filter(item -> matches(item, keyword))
                .collect(Collectors.toList());
    }

    @Override
    public boolean matches(Searchable item, String keyword) {
        // This assumes item is a Book - in real implementation, check type
        if (item instanceof Book) {
            Book book = (Book) item;
            return book.getAuthor().getName().toLowerCase().contains(keyword.toLowerCase());
        }
        return false;
    }
}