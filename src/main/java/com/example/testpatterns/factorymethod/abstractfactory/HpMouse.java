package com.example.testpatterns.factorymethod.abstractfactory;

public class HpMouse implements Mouse {
    @Override
    public void description() {
        System.out.println("This is a HP Mouse.");
    }
}
