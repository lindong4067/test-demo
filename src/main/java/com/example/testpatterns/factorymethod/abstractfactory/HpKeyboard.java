package com.example.testpatterns.factorymethod.abstractfactory;

public class HpKeyboard implements Keyboard {
    @Override
    public void description() {
        System.out.println("This is a HP keyboard.");
    }
}
