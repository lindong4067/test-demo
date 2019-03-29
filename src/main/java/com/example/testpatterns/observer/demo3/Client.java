package com.example.testpatterns.observer.demo3;

public class Client {
    public static void main(String[] args) {
        ChatServer server = new ChatServer();

        User user1 = new User("Zhang");
        User user2 = new User("Wang");
        User user3 = new User("Zhao");

        server.registerObserver(user1);
        server.registerObserver(user2);
        server.registerObserver(user3);

        server.notification("It's time to stand meeting.");

        server.deregisterObserver(user3);

        server.notification("It's time to leave work.");
    }
}
