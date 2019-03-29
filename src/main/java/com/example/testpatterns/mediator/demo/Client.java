package com.example.testpatterns.mediator.demo;

import java.util.Arrays;

public class Client {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();

        ConcreteUser zhangSan = new ConcreteUser(mediator, "Zhang San");
        ConcreteUser liSi = new ConcreteUser(mediator, "Li Si");
        ConcreteUser wangWu = new ConcreteUser(mediator, "Wang Wu");
        ConcreteUser zhaoLiu = new ConcreteUser(mediator, "Zhao Liu");

        System.out.println("======================");
        zhangSan.sendMessage("Hello, every one!");

        System.out.println("======================");
        zhangSan.sendMessage("Hello, Li Si!", liSi);

        System.out.println("======================");
        zhangSan.sendMessage("Hi, Wang Wu and Zhao Liu!", Arrays.asList(wangWu, zhaoLiu));
    }
}
