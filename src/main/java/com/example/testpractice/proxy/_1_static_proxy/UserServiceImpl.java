package com.example.testpractice.proxy._1_static_proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserServiceImpl implements UserService {

    @Override
    public String doFirst() {
        log.debug("Invoke doFirst() method.");
        return "Hello World!";
    }

    @Override
    public void doSecond() {
        log.debug("Invoke doSecond() method.");
    }
}
