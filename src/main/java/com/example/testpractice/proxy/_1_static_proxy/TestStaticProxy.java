package com.example.testpractice.proxy._1_static_proxy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class TestStaticProxy {

    @Test
    public void test1(){
        UserService userService = new UserServiceImpl();
        log.debug(userService.doFirst());
        userService.doSecond();
    }

    @Test
    public void test2(){
        UserService userService = new UserServiceImplProxy();
        log.debug(userService.doFirst());
        userService.doSecond();
    }
}
