/*
 *         File : Alarm.java
 *    Classname : Alarm
 *    Author(s) : eznlzhi
 *      Created : 2018-10-12
 *
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
