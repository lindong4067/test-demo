/*
 *         File : AdvancedModule.java
 *    Classname : AdvancedModule
 *    Author(s) : eznlzhi
 *      Created : 2018-08-28
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

package com.example.testpatterns.dependencyinjection;

import com.google.inject.AbstractModule;

public class AdvancedModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Tobacco.class).to(OldTobyTobacco.class);
    }
}
