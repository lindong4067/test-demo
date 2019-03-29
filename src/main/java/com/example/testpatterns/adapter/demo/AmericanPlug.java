package com.example.testpatterns.adapter.demo;

public class AmericanPlug implements Plug {
    @Override
    public void input() {
        System.out.println("American style plug input.");
    }
}
