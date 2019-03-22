package com.example.testpatterns.builder.demo;

public class Client {
    public static void main(String[] args) {

        Director director = new Director(new BikeBuilder());
        Bike bike = director.construct();
        bike.setFrame(new AlloyFrame());
        bike.setSeat(new DermisSeat());
        bike.setTire(new SolidTire());
    }
}
