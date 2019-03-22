package com.example.testpatterns.factorymethod.abstractfactory;

public interface Factory {
    KeyboardFactory getKeyboardFactory();
    MouseFactory getMouseFactory();
}
