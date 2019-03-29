/*
 *         File : Client.java
 *    Classname : Client
 *    Author(s) : eznlzhi
 *      Created : 2018-07-19
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

package com.example.testpatterns.command.demo1;

import static com.example.testpatterns.command.demo1.Button.*;

/**
 * Command pattern, It's not just that.
 */
public class Client {
    public static void main(String[] args) {
        button(OPEN_TV);
        button(CLOSE_TV);
        button(OPEN_LIGHT);
        button(CLOSE_LIGHT);

    }
    private static void button(Button button){
        TV tv = new TV();
        Light light = new Light();
        TVCommand tvCommand = new TVCommand(tv);
        LightCommand lightCommand = new LightCommand(light);
        switch(button){
            case OPEN_TV:
                tvCommand.execute();
                break;
            case CLOSE_TV:
                tvCommand.undo();
                break;
            case OPEN_LIGHT:
                lightCommand.execute();
                break;
            case CLOSE_LIGHT:
                lightCommand.undo();
                break;
            default:
                System.out.println("Please try again!");
                break;
        }
    }
}
