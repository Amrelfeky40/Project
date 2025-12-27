# 📚 Library Management System (Java)

A clean, object-oriented Java application demonstrating **SOLID principles** and **design patterns** through a functional library management system.

![Java](https://img.shields.io/badge/Java-17-blue)
![SOLID](https://img.shields.io/badge/Principles-SOLID-orange)
![Design Patterns](https://img.shields.io/badge/Patterns-GOF-green)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

## ✨ Features

- **Complete Library Operations**: Add/remove books, manage members, handle borrowing/returning
- **Multiple Media Types**: Support for Books, Magazines, and DVDs
- **Advanced Search**: Search by title, author, or ISBN using Strategy Pattern
- **Notification System**: Email and SMS notifications via Observer Pattern
- **Comprehensive Reporting**: Generate inventory, member, and overdue reports
- **Loan Management**: Automatic due date tracking and fine calculation

## 🏗️ SOLID Principles Demonstrated

| Principle | Implementation Example |
|-----------|-----------------------|
| **Single Responsibility** | `Book` class handles only book data, `LibraryService` handles business logic |
| **Open/Closed** | New item types can be added without modifying existing code |
| **Liskov Substitution** | All `Borrowable` items can be used interchangeably |
| **Interface Segregation** | Separate interfaces: `Borrowable`, `Searchable`, `Notifiable` |
| **Dependency Inversion** | `LibraryService` depends on `LibraryRepository` abstraction |

## 🎨 Design Patterns Implemented

1. **Singleton Pattern** - `LibraryService.getInstance()`
2. **Factory Pattern** - `ItemFactory.createItem()`
3. **Strategy Pattern** - `SearchStrategy` implementations
4. **Observer Pattern** - `LibraryObserver` for notifications
5. **Repository Pattern** - `LibraryRepository` interface

## 📦 Project Structure
LibraryManagementSystem/
├── src/main/java/com/library/
│ ├── Main.java # Entry point
│ ├── models/ # Domain models
│ │ ├── Book.java, Magazine.java, DVD.java
│ │ ├── Member.java, Author.java, Loan.java
│ ├── interfaces/ # SOLID interfaces
│ │ ├── Borrowable.java, Searchable.java
│ │ └── Notifiable.java
│ ├── services/ # Business logic
│ │ ├── LibraryService.java (Singleton)
│ │ ├── NotificationService.java (Observer)
│ │ └── SearchService.java, ReportService.java
│ ├── repositories/ # Data access
│ │ ├── LibraryRepository.java
│ │ └── InMemoryLibraryRepository.java
│ ├── factories/ # Creation patterns
│ │ └── ItemFactory.java
│ ├── strategies/ # Behavioral patterns
│ │ ├── SearchStrategy.java
│ │ ├── TitleSearchStrategy.java
│ │ └── AuthorSearchStrategy.java
│ └── observers/ # Observer pattern
│ ├── LibraryObserver.java
│ ├── EmailNotification.java
│ └── SMSNotification.java
├── pom.xml # Maven configuration
└── README.md # This file
