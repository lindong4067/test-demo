/*
 *         File : Simple.java
 *    Classname : Simple
 *    Author(s) : eznlzhi
 *      Created : 2018-09-28
 *
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
