/*
 *         File : Advanced1.java
 *    Classname : Advanced1
 *    Author(s) : eznlzhi
 *      Created : 2018-09-28
 *
 *
 */

package com.example.testpatterns.lazyloading.demo;

import java.util.function.Supplier;

public class Advanced1 {
    Supplier<Entity> entitySupplier = this::createAndCacheEntity;
    private synchronized Entity createAndCacheEntity(){
        Entity entity = new Entity();
        entitySupplier = () -> entity;
        return entity;
    }
}
