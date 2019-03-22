package com.example.testpatterns.builder.demo;

public class BikeBuilder extends Builder{
    private Bike bike = new Bike();
    @Override
    void buildFrame() {
        bike.setFrame(new AlloyFrame());
    }

    @Override
    void buildSeat() {
        bike.setSeat(new DermisSeat());
    }

    @Override
    void buildTire() {
        bike.setTire(new SolidTire());
    }

    @Override
    Bike createBike() {
        return bike;
    }
}
