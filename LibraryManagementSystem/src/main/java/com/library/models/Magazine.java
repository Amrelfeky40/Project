package main.java.com.library.models;

import main.java.com.library.interfaces.Borrowable;
import main.java.com.library.interfaces.Searchable;
import java.time.LocalDate;

public class Magazine implements Borrowable, Searchable {
    private String title;
    private String issueNumber;
    private String publisher;
    private LocalDate publicationDate;
    private int totalCopies;
    private int availableCopies;

    public Magazine(String title, String issueNumber, String publisher, int year, int copies) {
        this.title = title;
        this.issueNumber = issueNumber;
        this.publisher = publisher;
        this.publicationDate = LocalDate.of(year, 1, 1);
        this.totalCopies = copies;
        this.availableCopies = copies;
    }

    @Override
    public String getTitle() { return title; }

    @Override
    public boolean borrowItem(Member member) {
        if (availableCopies > 0) {
            availableCopies--;
            return true;
        }
        return false;
    }

    @Override
    public boolean returnItem(Member member) {
        if (availableCopies < totalCopies) {
            availableCopies++;
            return true;
        }
        return false;
    }

    @Override
    public boolean isAvailable() {
        return availableCopies > 0;
    }

    @Override
    public int getAvailableCopies() {
        return availableCopies;
    }

    @Override
    public boolean matchesSearch(String keyword) {
        return title.toLowerCase().contains(keyword.toLowerCase()) ||
                issueNumber.equals(keyword) ||
                publisher.toLowerCase().contains(keyword.toLowerCase());
    }

    @Override
    public String getItemInfo() {
        return String.format("Magazine: %s (Issue: %s) - %d/%d copies available",
                title, issueNumber, availableCopies, totalCopies);
    }

    // Magazine-specific method
    public LocalDate getPublicationDate() {
        return publicationDate;
    }
}