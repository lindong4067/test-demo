package com.example.testpatterns.builder.senior;

public class Client {
    public static void main(String[] args) {
        Computer computer = new Computer
                .Builder()
                .cpu("cpu")
                .screen("screen")
                .memory("memory")
                .mainboard("mainboard")
                .commit();

        System.out.println(computer.getCpu());
        System.out.println(computer.getMemory());
        System.out.println(computer.getScreen());
        System.out.println(computer.getMainboard());

        Bike bike = new Bike.Builder().frame("frame").seat("seat").tire("tire").build();
        System.out.println(bike.getFrame());
        System.out.println(bike.getSeat());
        System.out.println(bike.getTire());

        Bike bike1 = new Bike().setFrame("111").setSeat("222").setTire("333");
        System.out.println(bike1.getFrame());
        System.out.println(bike1.getSeat());
        System.out.println(bike1.getTire());
    }



}
