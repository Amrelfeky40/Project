package main.java.com.library.strategies;

import main.java.com.library.interfaces.Searchable;
import java.util.List;

public interface SearchStrategy {
    List<Searchable> search(List<Searchable> items, String keyword);
    boolean matches(Searchable item, String keyword);
}