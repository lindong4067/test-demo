package com.example.testpatterns.singleton.demo;

public final class DoubleCheckPattern {
    private DoubleCheckPattern() {
        // to prevent instantiating by Reflection call
        if (instance != null) {
            throw new IllegalStateException("Already initialized.");
        }
    }

    private static volatile DoubleCheckPattern instance;
    //高效版
    public static DoubleCheckPattern getInstance() {
        DoubleCheckPattern inner = instance;
        if (inner == null) {
            synchronized (DoubleCheckPattern.class) {
                inner = instance;
                if (inner == null) {
                    instance = inner = new DoubleCheckPattern();
                }
            }
        }
        return inner;
    }
    //普通版
    public static DoubleCheckPattern getInstance2() {
        if (instance == null) {
            synchronized (DoubleCheckPattern.class) {
                if (instance == null) {
                    instance = new DoubleCheckPattern();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++) {
            DoubleCheckPattern instance1 = DoubleCheckPattern.getInstance();
            System.out.println(instance1);
        }
    }
}
