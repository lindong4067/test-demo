package com.example.testpatterns.factorymethod.abstractfactory;

public class DellMouse implements Mouse {
    @Override
    public void description() {
        System.out.println("This is a Dell Mouse.");
    }
}
