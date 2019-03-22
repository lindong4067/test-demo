package com.example.testpatterns.factorymethod.abstractfactory;

public class HpFactory implements Factory {
    @Override
    public KeyboardFactory getKeyboardFactory() {
        return new HpKeyboardFactory();
    }

    @Override
    public MouseFactory getMouseFactory() {
        return new HpMouseFactory();
    }
}
