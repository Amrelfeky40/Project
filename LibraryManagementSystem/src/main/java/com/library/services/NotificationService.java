package main.java.com.library.services;


import main.java.com.library.observers.LibraryObserver;
import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    private List<LibraryObserver> observers;

    public NotificationService() {
        this.observers = new ArrayList<>();
    }

    public void addObserver(LibraryObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(LibraryObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (LibraryObserver observer : observers) {
            observer.update(message);
        }
    }

    public void notifySpecificObserver(LibraryObserver observer, String message) {
        observer.update(message);
    }
}