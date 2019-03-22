package com.example.testpatterns.factorymethod.factorymethod;

public class FactoryB implements Factory {
    @Override
    public Product getProduct() {
        return new ProductB();
    }
}
