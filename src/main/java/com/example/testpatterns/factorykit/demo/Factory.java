package com.example.testpatterns.factorykit.demo;

public class Factory {

    enum Type {
        A, B, C
    }
    public Product getProduct(Type type) {
        Product product = null;
        switch (type) {
            case A:
                product = new ProductA();
                break;
            case B:
                product = new ProductB();
                break;
            case C:
                product = new ProductC();
                break;
            default:
                throw new IllegalArgumentException("Type not definition.");
        }
        return product;
    }

    public static void main(String[] args) {
        Factory factory = new Factory();
        Product productA = factory.getProduct(Type.A);
        System.out.println(productA.getDescription());

        Product productB = factory.getProduct(Type.B);
        System.out.println(productB.getDescription());

        Product productC = factory.getProduct(Type.C);
        System.out.println(productC.getDescription());
    }
}
