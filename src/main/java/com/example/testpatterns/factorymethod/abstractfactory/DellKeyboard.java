package com.example.testpatterns.factorymethod.abstractfactory;

public class DellKeyboard implements Keyboard {
    @Override
    public void description() {
        System.out.println("This is a Dell Keyboard.");
    }
}
