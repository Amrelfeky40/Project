package main.java.com.library;

import main.java.com.library.factories.ItemFactory;
import main.java.com.library.interfaces.Borrowable;
import main.java.com.library.models.*;
import main.java.com.library.services.LibraryService;
import main.java.com.library.services.NotificationService;
import main.java.com.library.strategies.SearchStrategy;
import main.java.com.library.strategies.TitleSearchStrategy;
import main.java.com.library.observers.EmailNotification;
import main.java.com.library.observers.SMSNotification;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Library Management System ===");
        System.out.println("Demonstrating OOP and SOLID Principles\n");

        // Create services
        LibraryService libraryService = LibraryService.getInstance();
        NotificationService notificationService = new NotificationService();

        // Add observers
        notificationService.addObserver(new EmailNotification());
        notificationService.addObserver(new SMSNotification());

        // Create sample data using Factory Pattern
        Borrowable book1 = ItemFactory.createItem("BOOK",
                "Clean Code", "9780132350884", "Robert Martin", 2008, 5);
        Borrowable magazine1 = ItemFactory.createItem("MAGAZINE",
                "National Geographic", "NG202401", "Various", 2024, 10);
        Borrowable dvd1 = ItemFactory.createItem("DVD",
                "Design Patterns", "DP001", "Gang of Four", 1994, 3);

        // Add items to library
        libraryService.addItem(book1);
        libraryService.addItem(magazine1);
        libraryService.addItem(dvd1);

        // Create members
        Member member1 = new Member("M001", "Amr Elfeky", "Amrelfeky_@outlook.com.com", "123-456-7890");
        Member member2 = new Member("M002", "Nesma Mohamed", "Nesma@email.com", "987-654-3210");

        libraryService.registerMember(member1);
        libraryService.registerMember(member2);

        // Demonstrate borrowing
        System.out.println("=== Borrowing Operations ===");
        boolean borrowed = libraryService.borrowItem(member1, book1);
        if (borrowed) {
            notificationService.notifyObservers(
                    "Item borrowed: " + book1.getTitle() + " by " + member1.getName());
        }

        // Search using different strategies (Strategy Pattern)
        System.out.println("\n=== Search Operations ===");
        SearchStrategy titleSearch = new TitleSearchStrategy();
        System.out.println("Search by title 'Clean': " +
                libraryService.searchItems("Clean", titleSearch));

        // Generate reports
        System.out.println("\n=== Library Report ===");
        libraryService.generateReport();

        // Demonstrate SOLID principles
        demonstrateSOLIDPrinciples();
    }

    private static void demonstrateSOLIDPrinciples() {
        System.out.println("\n=== SOLID Principles Demonstration ===");
        System.out.println("1. Single Responsibility: Each class has one purpose");
        System.out.println("2. Open/Closed: New item types can be added without modifying existing code");
        System.out.println("3. Liskov Substitution: All Borrowable items can be used interchangeably");
        System.out.println("4. Interface Segregation: Specific interfaces for specific behaviors");
        System.out.println("5. Dependency Inversion: High-level modules depend on abstractions");
    }
}