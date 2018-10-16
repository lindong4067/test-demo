/*
 *         File : Simple.java
 *    Classname : Simple
 *    Author(s) : eznlzhi
 *      Created : 2018-09-28
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

package com.example.testpatterns.lazyloading.demo;

public class Simple {
    private Entity entity;

    public Entity getEntity() {
        if (entity == null){
            entity = new Entity();
        }
        return entity;
    }
}
