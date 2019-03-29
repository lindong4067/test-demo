package com.example.testpatterns.bridge.demo;

public class RedRefill implements Refill {
    @Override
    public void color() {
        System.out.printf("install the red cartridge and write the red font.\n");
    }
}
