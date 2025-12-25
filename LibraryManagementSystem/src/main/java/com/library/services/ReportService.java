package main.java.com.library.services;


import main.java.com.library.models.Loan;
import main.java.com.library.models.Member;
import main.java.com.library.interfaces.Borrowable;
import java.util.List;

public class ReportService {

    public void generateInventoryReport(List<Borrowable> items) {
        System.out.println("\n=== Inventory Report ===");
        items.forEach(item ->
                System.out.println(item.getTitle() + ": " +
                        item.getAvailableCopies() + " available"));
    }

    public void generateMemberReport(List<Member> members) {
        System.out.println("\n=== Member Report ===");
        members.forEach(member -> {
            int activeLoans = member.getCurrentLoans().size();
            System.out.println(member.getName() +
                    ": " + activeLoans + " active loans");
        });
    }

    public void generateOverdueReport(List<Loan> loans) {
        System.out.println("\n=== Overdue Items Report ===");
        loans.stream()
                .filter(Loan::isOverdue)
                .forEach(loan ->
                        System.out.println(loan.getItem().getTitle() +
                                " borrowed by " + loan.getMember().getName() +
                                " (Overdue by " + loan.getDaysOverdue() + " days)"));
    }
}
