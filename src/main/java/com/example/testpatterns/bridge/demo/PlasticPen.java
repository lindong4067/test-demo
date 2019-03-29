package com.example.testpatterns.bridge.demo;

public class PlasticPen extends AbstractPen {

    @Override
    public void texture() {
        System.out.print("This is a plastic pen, ");
    }
}
