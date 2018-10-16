/*
 *         File : Display.java
 *    Classname : Display
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
import java.util.Observer;

public class Display extends Observable implements Observer {
    private String status = "未开";

    public void setStatus(String status) {
        this.status = status;
    }

    private void displayTemputer(int temperature){
        if (temperature > 95){
            this.setStatus("沸腾");
            this.setChanged();
            this.notifyObservers();
        }
        System.out.println("状态：" + status + " 现在温度：" + temperature + "");
    }

    @Override
    public void update(Observable o, Object arg) {
        displayTemputer(((Heater)o).getTemperature());
    }
}
