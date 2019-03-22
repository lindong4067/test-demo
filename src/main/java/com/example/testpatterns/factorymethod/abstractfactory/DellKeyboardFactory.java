package com.example.testpatterns.factorymethod.abstractfactory;

public class DellKeyboardFactory implements KeyboardFactory {
    @Override
    public Keyboard getKeyboard() {
        return new DellKeyboard();
    }
}
