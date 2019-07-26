/*
 *         File : Light.java
 *    Classname : Light
 *    Author(s) : eznlzhi
 *      Created : 2018-07-19

 */

package com.example.testpatterns.command.demo1;

public class Light implements HouseholdAppliances {
    @Override
    public void on() {
        System.out.println("The Light is on.");
    }

    @Override
    public void off() {
        System.out.println("The Light is off.");
    }
}
