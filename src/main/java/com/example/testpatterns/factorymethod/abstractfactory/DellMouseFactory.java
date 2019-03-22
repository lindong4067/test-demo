package com.example.testpatterns.factorymethod.abstractfactory;

public class DellMouseFactory implements MouseFactory {
    @Override
    public Mouse getMouse() {
        return new DellMouse();
    }
}
