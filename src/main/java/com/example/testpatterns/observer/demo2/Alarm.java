/*
 *         File : Alarm.java
 *    Classname : Alarm
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

public class Alarm implements Observer {

    private void sendAlarm(){
        System.out.println("滴滴滴，水开了");
    }

    @Override
    public void update(Observable o, Object arg) {
        sendAlarm();
    }
}
