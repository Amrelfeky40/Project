package main.java.com.library.models;

import main.java.com.library.interfaces.Notifiable;
import java.util.ArrayList;
import java.util.List;

public class Member implements Notifiable {
    private String memberId;
    private String name;
    private String email;
    private String phone;
    private List<Loan> currentLoans;
    private List<Loan> loanHistory;

    public Member(String memberId, String name, String email, String phone) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.currentLoans = new ArrayList<>();
        this.loanHistory = new ArrayList<>();
    }

    // Getters
    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }

    // Loan management
    public void addLoan(Loan loan) {
        currentLoans.add(loan);
    }

    public void returnLoan(Loan loan) {
        currentLoans.remove(loan);
        loanHistory.add(loan);
    }

    public List<Loan> getCurrentLoans() {
        return new ArrayList<>(currentLoans);
    }

    public List<Loan> getLoanHistory() {
        return new ArrayList<>(loanHistory);
    }

    public boolean hasOverdueLoans() {
        return currentLoans.stream().anyMatch(Loan::isOverdue);
    }

    // Notifiable interface implementation
    @Override
    public void sendNotification(String message) {
        System.out.println("Notification to " + name + ": " + message);
    }

    @Override
    public String getContactInfo() {
        return "Email: " + email + ", Phone: " + phone;
    }

    @Override
    public String toString() {
        return String.format("Member ID: %s, Name: %s, Email: %s", memberId, name, email);
    }
}