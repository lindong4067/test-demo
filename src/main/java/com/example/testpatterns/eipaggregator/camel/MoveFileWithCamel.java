/*
 *         File : MoveFileWithCamel.java
 *    Classname : MoveFileWithCamel
 *    Author(s) : eznlzhi
 *      Created : 2018-08-30
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

package com.example.testpatterns.eipaggregator.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class MoveFileWithCamel {
    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file:///C:/Temp/out/?delay=30000").to("file:///C:/Temp/in/");
            }
        });
        context.start();
        boolean loop = true;
        while(loop){
            Thread.sleep(25000);
        }
        context.stop();
    }
}
