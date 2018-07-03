/*
 *         File : Person.java
 *    Classname : Person
 *    Author(s) : eznlzhi
 *      Created : 2018-06-22
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

package com.example.testbean;

public class HelloWorld {

    private String say;

    public String getSay() {
        return say;
    }

    public void setSay(String say) {
        this.say = say;
    }

    public void init(){
        System.out.println("Person Init.");
    }

    public void destroy(){
        System.out.println("Person Destroy.");
    }

    @Override
    public String toString() {
        return "Person{" +
                "say='" + say + '\'' +
                '}';
    }
}
