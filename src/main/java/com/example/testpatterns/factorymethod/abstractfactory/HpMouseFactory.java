package com.example.testpatterns.factorymethod.abstractfactory;

public class HpMouseFactory implements MouseFactory {
    @Override
    public Mouse getMouse() {
        return new HpMouse();
    }
}
