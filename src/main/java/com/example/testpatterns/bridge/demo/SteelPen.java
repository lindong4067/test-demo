package com.example.testpatterns.bridge.demo;

public class SteelPen extends AbstractPen {
    @Override
    public void texture() {
        System.out.print("This is a steel pen, ");
    }

}
