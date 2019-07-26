/*
 *         File : Client.java
 *    Classname : Client
 *    Author(s) : eznlzhi
 *      Created : 2018-10-12
 *
 *
 */

package com.example.testpatterns.observer.demo2;

public class Client {
    public static void main(String[] args) {
        Heater heater = new Heater();
        Display display = new Display();
        Alarm alarm = new Alarm();
        heater.addObserver(display);
        display.addObserver(alarm);
        heater.boilWater();
    }
}
