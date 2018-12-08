package com.example.testpractice.proxy._3_cglib_dynamic_proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserService {

    public String doFirst() {
        log.debug("Invoke doFirst() method.");
        return "Hello World!";
    }

    public void doSecond() {
        log.debug("Invoke doSecond() method.");
    }
}
