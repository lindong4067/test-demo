package com.example.testpatterns.mediator.demo;

import java.util.List;

public interface User {
    void receiveMessage(String message);
    void sendMessage(String message);
    void sendMessage(String message, User user);
    void sendMessage(String message, List<User> userList);
    String getMessage();
}
