package com.example.testpatterns.observer.demo3;

public interface Observerable {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObserver();
}
