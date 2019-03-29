package com.example.testpatterns.mediator.demo;

import java.util.ArrayList;
import java.util.List;

public class ConcreteMediator implements Mediator {
    private final List<User> userList = new ArrayList<>();

    @Override
    public void register(User user) {
        if (user != null && !userList.contains(user)) {
            userList.add(user);
        }
    }

    @Override
    public void notify(User sender, User receiver) {
        if (sender != null && receiver != null ) {
            receiver.receiveMessage(sender.getMessage());
        }
    }

    @Override
    public void notify(User sender, List<User> receivers) {
        if (sender != null) {
            for (User receiver : receivers) {
                receiver.receiveMessage(sender.getMessage());
            }
        }
    }

    @Override
    public void notifyAll(User sender) {
        for (User user : userList) {
            if (sender != null && !sender.equals(user)) {
                user.receiveMessage(sender.getMessage());
            }
        }
    }
}
