package main.java.com.library.models;

import main.java.com.library.interfaces.Borrowable;
import main.java.com.library.interfaces.Searchable;

public class DVD implements Borrowable, Searchable {
    private String title;
    private String director;
    private String productCode;
    private int releaseYear;
    private int durationMinutes;
    private boolean isAvailable;

    public DVD(String title, String director, String productCode, int releaseYear, int duration) {
        this.title = title;
        this.director = director;
        this.productCode = productCode;
        this.releaseYear = releaseYear;
        this.durationMinutes = duration;
        this.isAvailable = true;
    }

    @Override
    public String getTitle() { return title; }

    @Override
    public boolean borrowItem(Member member) {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean returnItem(Member member) {
        if (!isAvailable) {
            isAvailable = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public int getAvailableCopies() {
        return isAvailable ? 1 : 0;
    }

    @Override
    public boolean matchesSearch(String keyword) {
        return title.toLowerCase().contains(keyword.toLowerCase()) ||
                director.toLowerCase().contains(keyword.toLowerCase()) ||
                productCode.equals(keyword);
    }

    @Override
    public String getItemInfo() {
        return String.format("DVD: %s directed by %s (%d min) - %s",
                title, director, durationMinutes,
                isAvailable ? "Available" : "Checked Out");
    }

    // DVD-specific method
    public int getDuration() {
        return durationMinutes;
    }
}