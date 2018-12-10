package com.example.testpractice.proxy._3_cglib_dynamic_proxy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;

@Slf4j
public class TestCglibProxy {

    @Test
    public void test1(){
        UserServiceInterceptor interceptor = new UserServiceInterceptor();
        UserService userService = interceptor.myCglibCreater();
        String s = userService.doFirst();
        log.debug(s);
        userService.doSecond();
    }

    @Test
    public void test2(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new UserServiceInterceptor());
        UserService userService = (UserService) enhancer.create();
        String first = userService.doFirst();
        log.debug(first);
        userService.doSecond();
    }
}
