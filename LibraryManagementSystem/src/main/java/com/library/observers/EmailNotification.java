package main.java.com.library.observers;

public class EmailNotification implements LibraryObserver {

    @Override
    public void update(String message) {
        System.out.println("[EMAIL] Sending notification: " + message);
        
    }

    @Override
    public String getObserverType() {
        return "Email Notification";
    }
}