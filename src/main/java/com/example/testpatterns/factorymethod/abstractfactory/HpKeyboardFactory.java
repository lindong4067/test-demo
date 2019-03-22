package com.example.testpatterns.factorymethod.abstractfactory;

public class HpKeyboardFactory implements KeyboardFactory {
    @Override
    public Keyboard getKeyboard() {
        return new HpKeyboard();
    }
}
