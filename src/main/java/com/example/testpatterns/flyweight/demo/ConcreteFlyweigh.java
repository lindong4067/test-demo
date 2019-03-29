package com.example.testpatterns.flyweight.demo;

public class ConcreteFlyweigh extends Flyweight {

    protected ConcreteFlyweigh(String outside) {
        super(outside);
    }

    @Override
    public void operate(int i) {
        System.out.println("操作：" + i);
    }
}
