package com.example.testpatterns.observer.demo3;

import java.util.ArrayList;
import java.util.List;

public class ChatServer implements Observerable {
    private List<Observer> observerList;
    private String message;

    public ChatServer() {
        this.observerList = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        if (!observerList.contains(observer)) {
            observerList.add(observer);
        }
    }

    @Override
    public void deregisterObserver(Observer observer) {
        if (!observerList.isEmpty()) {
            observerList.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observerList) {
            observer.update(message);
        }
    }

    public void notification(String message) {
        this.message = message;
        System.out.println("Server notified: " + message);
        notifyObserver();
    }

}
