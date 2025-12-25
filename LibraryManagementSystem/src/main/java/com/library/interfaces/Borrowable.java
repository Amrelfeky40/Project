package main.java.com.library.interfaces;

import main.java.com.library.models.Member;

public interface Borrowable {
    String getTitle();
    boolean borrowItem(Member member);
    boolean returnItem(Member member);
    boolean isAvailable();
    int getAvailableCopies();
}