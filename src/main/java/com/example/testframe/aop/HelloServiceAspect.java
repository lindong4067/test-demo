package com.example.testframe.aop;

public class HelloServiceAspect {

    public void beforeAdvice() {
        System.out.println("Before advice");
    }

    public void afterAdvice() {
        System.out.println("After advice");
    }
}
