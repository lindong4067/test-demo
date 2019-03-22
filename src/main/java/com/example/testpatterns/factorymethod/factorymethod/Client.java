package com.example.testpatterns.factorymethod.factorymethod;

public class Client {
    public static void main(String[] args) {
        Factory factoryA = new FactoryA();
        factoryA.getProduct().description();

        Factory factoryB = new FactoryB();
        factoryB.getProduct().description();
    }
}
