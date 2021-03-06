package com.example.testpatterns.builder.demo;

public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Bike construct() {
        builder.buildFrame();
        builder.buildSeat();
        builder.buildTire();
        return builder.createBike();
    }
}
