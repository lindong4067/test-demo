package com.example.testpatterns.singleton.demo;

public final class LanhanPattern {
    private LanhanPattern() {
    }

    private static LanhanPattern instance;

    public static LanhanPattern getInstance() {
        if (instance == null) {
            instance = new LanhanPattern();
        }
        return instance;
    }

    public static void main(String[] args) {
        LanhanPattern instance = LanhanPattern.getInstance();
        System.out.println(instance);
    }
}
