package com.example.testpatterns.mediator.demo;

import java.util.List;

public interface Mediator {

    void register(User user);

    void notify(User sender, User receiver);

    void notify(User sender, List<User> receivers);

    void notifyAll(User sender);
}
