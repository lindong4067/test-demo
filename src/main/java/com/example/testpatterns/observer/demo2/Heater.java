/*
 *         File : Heater.java
 *    Classname : Heater
 *    Author(s) : eznlzhi
 *      Created : 2018-10-12
 *
 * Copyright (c) 2017 Ericsson AB, Sweden.
 * All rights reserved.
 * The Copyright to the computer program(s) herein is the property of
 * Ericsson AB, Sweden.
 * The program(s) may be used and/or copied with the written permission
 * from Ericsson AB or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s)
 * have been supplied.
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
