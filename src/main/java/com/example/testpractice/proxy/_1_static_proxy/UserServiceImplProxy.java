package com.example.testpractice.proxy._1_static_proxy;

public class UserServiceImplProxy implements UserService {

    UserServiceImpl userService = new UserServiceImpl();

    @Override
    public String doFirst() {
        String s = userService.doFirst();
        return s.toUpperCase();
    }

    @Override
    public void doSecond() {
        userService.doSecond();
    }
}
