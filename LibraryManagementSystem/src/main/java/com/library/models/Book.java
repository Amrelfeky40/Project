package main.java.com.library.models;

import main.java.com.library.interfaces.Borrowable;
import main.java.com.library.interfaces.Searchable;

public class Book implements Borrowable, Searchable {
    private String title;
    private String isbn;
    private Author author;
    private int publicationYear;
    private int totalCopies;
    private int availableCopies;
    private boolean isReferenceOnly;

    // Constructor
    public Book(String title, String isbn, String authorName, int publicationYear, int copies) {
        this.title = title;
        this.isbn = isbn;
        this.author = new Author(authorName, "");
        this.publicationYear = publicationYear;
        this.totalCopies = copies;
        this.availableCopies = copies;
        this.isReferenceOnly = false;
    }

    // Getters
    @Override
    public String getTitle() { return title; }
    public String getIsbn() { return isbn; }
    public Author getAuthor() { return author; }
    public int getPublicationYear() { return publicationYear; }

    // Borrowable interface implementation
    @Override
    public boolean borrowItem(Member member) {
        if (availableCopies > 0 && !isReferenceOnly) {
            availableCopies--;
            System.out.println(member.getName() + " borrowed: " + title);
            return true;
        }
        System.out.println("Cannot borrow " + title);
        return false;
    }

    @Override
    public boolean returnItem(Member member) {
        if (availableCopies < totalCopies) {
            availableCopies++;
            System.out.println(member.getName() + " returned: " + title);
            return true;
        }
        return false;
    }

    @Override
    public boolean isAvailable() {
        return availableCopies > 0 && !isReferenceOnly;
    }

    @Override
    public int getAvailableCopies() {
        return availableCopies;
    }

    // Searchable interface implementation
    @Override
    public boolean matchesSearch(String keyword) {
        return title.toLowerCase().contains(keyword.toLowerCase()) ||
                author.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                isbn.equals(keyword);
    }

    @Override
    public String getItemInfo() {
        return String.format("Book: %s by %s (ISBN: %s) - %d/%d copies available",
                title, author.getName(), isbn, availableCopies, totalCopies);
    }

    // Additional book-specific methods
    public void setReferenceOnly(boolean referenceOnly) {
        this.isReferenceOnly = referenceOnly;
    }

    public String getBookDetails() {
        return String.format("Title: %s, Author: %s, Year: %d, ISBN: %s",
                title, author.getName(), publicationYear, isbn);
    }
}