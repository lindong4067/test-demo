package com.example.testpatterns.bridge.demo;

public class Client {
    public static void main(String[] args) {
        Pen steelPen = new SteelPen();
        steelPen.put(new RedRefill());
        steelPen.write();

        Pen plasticPen = new PlasticPen();
        plasticPen.put(new RedRefill());
        plasticPen.write();
    }
}
