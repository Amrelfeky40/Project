package main.java.com.library.observers;

public interface LibraryObserver {
    void update(String message);
    String getObserverType();
}