package main.java.com.library.factories;

import main.java.com.library.interfaces.Borrowable;
import main.java.com.library.models.Book;
import main.java.com.library.models.Magazine;
import main.java.com.library.models.DVD;

public class ItemFactory {

    public static Borrowable createItem(String type, String title, String id,
                                        String creator, int year, int copies) {
        switch (type.toUpperCase()) {
            case "BOOK":
                return new Book(title, id, creator, year, copies);
            case "MAGAZINE":
                return new Magazine(title, id, creator, year, copies);
            case "DVD":
                return new DVD(title, creator, id, year, 120); // Default 120 minutes
            default:
                throw new IllegalArgumentException("Unknown item type: " + type);
        }
    }

    // Overloaded method for books with reference option
    public static Borrowable createReferenceBook(String title, String isbn,
                                                 String author, int year) {
        Book book = new Book(title, isbn, author, year, 1);
        book.setReferenceOnly(true);
        return book;
    }
}