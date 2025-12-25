package main.java.com.library.models;

import main.java.com.library.interfaces.Borrowable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Loan {
    private Borrowable item;
    private Member member;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    private static final int LOAN_PERIOD_DAYS = 14;

    public Loan(Borrowable item, Member member) {
        this.item = item;
        this.member = member;
        this.borrowDate = LocalDate.now();
        this.dueDate = borrowDate.plusDays(LOAN_PERIOD_DAYS);
        this.returnDate = null;
    }

    // Getters
    public Borrowable getItem() { return item; }
    public Member getMember() { return member; }
    public LocalDate getBorrowDate() { return borrowDate; }
    public LocalDate getDueDate() { return dueDate; }
    public LocalDate getReturnDate() { return returnDate; }

    public boolean isOverdue() {
        if (returnDate != null) return false;
        return LocalDate.now().isAfter(dueDate);
    }

    public long getDaysOverdue() {
        if (!isOverdue()) return 0;
        return ChronoUnit.DAYS.between(dueDate, LocalDate.now());
    }

    public void returnItem() {
        this.returnDate = LocalDate.now();
    }

    public double calculateFine() {
        if (!isOverdue()) return 0.0;
        long daysOverdue = getDaysOverdue();
        return daysOverdue * 0.50; // $0.50 per day
    }

    @Override
    public String toString() {
        return String.format("Loan: %s borrowed by %s on %s, Due: %s, %s",
                item.getTitle(), member.getName(), borrowDate, dueDate,
                isOverdue() ? "OVERDUE" : "On time");
    }
}