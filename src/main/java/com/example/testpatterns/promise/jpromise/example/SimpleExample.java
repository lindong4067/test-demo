/*
 *         File : SimpleExample.java
 *    Classname : SimpleExample
 *    Author(s) : eznlzhi
 *      Created : 2018-10-18
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

package com.example.testpatterns.promise.jpromise.example;

import java.util.concurrent.TimeUnit;

public class SimpleExample {

    private static String getRelatedRoles() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
        }
        return "Related Roles...";
    }

    private static String getRelatedNews() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
        }
        return "Related News...";
    }

    public static void main (String ...s) {
        long start = System.nanoTime();
        //280ms
        String result1 = getRelatedRoles();
        //250ms
        String result2 = getRelatedNews();
        System.out.println("Result:" + result1 + result2);
        System.out.println("take:" + TimeUnit.NANOSECONDS.toMillis((System.nanoTime() - start)) + "ms");
    }
}
