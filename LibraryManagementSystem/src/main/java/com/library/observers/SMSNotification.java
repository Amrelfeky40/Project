package main.java.com.library.observers;

public class SMSNotification implements LibraryObserver {

    @Override
    public void update(String message) {
        System.out.println("[SMS] Sending notification: " + message);
        // In real implementation, send actual SMS
    }

    @Override
    public String getObserverType() {
        return "SMS Notification";
    }
}