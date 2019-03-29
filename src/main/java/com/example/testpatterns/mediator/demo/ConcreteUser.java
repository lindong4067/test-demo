package com.example.testpatterns.mediator.demo;

import java.util.List;

public class ConcreteUser implements User {
    private Mediator mediator;
    private String name;
    private String message;

    public ConcreteUser(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
        mediator.register(this);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(name + " receive message: " + message);
    }

    @Override
    public void sendMessage(String message) {
        this.message = message;
        System.out.println(name + " send message: " + message);
        mediator.notifyAll(this);
    }

    @Override
    public void sendMessage(String message, User user) {
        this.message = message;
        System.out.println(name + " send message: " + message);
        mediator.notify(this, user);
    }

    @Override
    public void sendMessage(String message, List<User> userList) {
        this.message = message;
        System.out.println(name + " send message: " + message);
        mediator.notify(this, userList);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
