package com.example.testpatterns.factorymethod.abstractfactory;

public class Client {
    public static void main(String[] args) {
        Factory hpFactory = new HpFactory();
        KeyboardFactory hpKeyboardFactory = hpFactory.getKeyboardFactory();
        Keyboard hpKeyboard = hpKeyboardFactory.getKeyboard();
        hpKeyboard.description();

        Factory dellFactory = new DellFactory();
        MouseFactory dellMouseFactory = dellFactory.getMouseFactory();
        Mouse dellMouse = dellMouseFactory.getMouse();
        dellMouse.description();
    }
}
