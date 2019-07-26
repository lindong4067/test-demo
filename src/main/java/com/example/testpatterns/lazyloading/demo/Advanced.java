/*
 *         File : Advanced.java
 *    Classname : Advanced
 *    Author(s) : eznlzhi
 *      Created : 2018-09-28
 *
 *
 */

package com.example.testpatterns.lazyloading.demo;

import java.util.function.Supplier;

public class Advanced {

    private Supplier<Entity> entitySupplier = this::createAndCacheEntity;

    private synchronized Entity createAndCacheEntity(){
        class EntityFactory implements Supplier<Entity>{
            private final Entity entity = new Entity();
            @Override
            public Entity get() {
                return entity;
            }
        }
        if(!(entitySupplier instanceof EntityFactory)){
            entitySupplier = new EntityFactory();
        }
        return entitySupplier.get();
    }
}
