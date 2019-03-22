package com.example.testpatterns.factorymethod.factorymethod;

public class FactoryA implements Factory {
    @Override
    public Product getProduct() {
        return new ProductA();
    }
}
