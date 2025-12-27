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


### 📁 Directory Overview

| Directory | Purpose | SOLID/Pattern Demonstrated |
|-----------|---------|----------------------------|
| **`models/`** | Domain entities | Single Responsibility Principle |
| **`interfaces/`** | Contract definitions | Interface Segregation Principle |
| **`services/`** | Business logic | Singleton Pattern |
| **`repositories/`** | Data access layer | Dependency Inversion Principle |
| **`factories/`** | Object creation | Factory Pattern |
| **`strategies/`** | Algorithm variations | Strategy Pattern |
| **`observers/`** | Event notifications | Observer Pattern |
