package com.example.testframe.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("static/AopBeans.xml");
//        HelloServiceImpl helloWorldService = context.getBean("helloWorldService", HelloServiceImpl.class);
//        helloWorldService.sayHello();
//
//        HelloServiceAspect aspect = context.getBean("aspect", HelloServiceAspect.class);
//        aspect.beforeAdvice();
    }
}
