/*
 *         File : AdvancedModule.java
 *    Classname : AdvancedModule
 *    Author(s) : eznlzhi
 *      Created : 2018-08-28
 *
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
