package com.example.testpractice.spi;

import java.util.ServiceLoader;

public class JavaSpiTest {
    public static void main(String[] args) {
        ServiceLoader<Robot> robots = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI: ");
        robots.forEach(Robot::sayHello);
    }
}
