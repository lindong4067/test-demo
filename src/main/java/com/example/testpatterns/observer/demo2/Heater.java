/*
 *         File : Heater.java
 *    Classname : Heater
 *    Author(s) : eznlzhi
 *      Created : 2018-10-12
 *
 *
 */

package com.example.testpatterns.observer.demo2;

import java.util.Observable;

/**
 * 加热器
 */
public class Heater extends Observable {

    private int temperature;

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void boilWater(){
        for (int i = 90; i < 100; i++) {
            temperature = i;
            this.setChanged();
            this.notifyObservers();
        }
    }
}
