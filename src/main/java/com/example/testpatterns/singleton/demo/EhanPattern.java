package com.example.testpatterns.singleton.demo;

public final class EhanPattern {

    private EhanPattern() {
    }

    private static EhanPattern instance = new EhanPattern();

    public static EhanPattern getInstance() {
        if (instance != null) {
            instance = new EhanPattern();
        }
        return instance;
    }

    public static void main(String[] args) {
        EhanPattern instance = EhanPattern.getInstance();
        System.out.println(instance);
    }
}
