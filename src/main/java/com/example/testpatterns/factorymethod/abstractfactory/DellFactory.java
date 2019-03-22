package com.example.testpatterns.factorymethod.abstractfactory;

public class DellFactory implements Factory {
    @Override
    public KeyboardFactory getKeyboardFactory() {
        return new DellKeyboardFactory();
    }

    @Override
    public MouseFactory getMouseFactory() {
        return new DellMouseFactory();
    }
}
