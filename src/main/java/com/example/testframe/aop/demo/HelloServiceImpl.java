package com.example.testframe.aop.demo;

public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("Hello World!");
    }
}
