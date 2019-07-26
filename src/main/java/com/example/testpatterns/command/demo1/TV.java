/*
 *         File : TV.java
 *    Classname : TV
 *    Author(s) : eznlzhi
 *      Created : 2018-07-19
 *
 *
 */

package com.example.testpatterns.command.demo1;

public class TV implements HouseholdAppliances {
    @Override
    public void on() {
        System.out.println("The TV is on.");
    }

    @Override
    public void off() {
        System.out.println("The TV is off.");
    }
}
