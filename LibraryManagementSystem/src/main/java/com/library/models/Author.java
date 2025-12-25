package main.java.com.library.models;

import java.util.ArrayList;
import java.util.List;

public class Author {
    private String name;
    private String biography;
    private List<Book> publishedBooks;

    public Author(String name, String biography) {
        this.name = name;
        this.biography = biography;
        this.publishedBooks = new ArrayList<>();
    }

    // Getters and setters
    public String getName() { return name; }
    public String getBiography() { return biography; }
    public List<Book> getPublishedBooks() { return new ArrayList<>(publishedBooks); }

    public void addBook(Book book) {
        publishedBooks.add(book);
    }

    @Override
    public String toString() {
        return String.format("Author: %s (%d books published)",
                name, publishedBooks.size());
    }
}