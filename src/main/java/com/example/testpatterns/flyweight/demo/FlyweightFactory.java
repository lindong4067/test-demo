package com.example.testpatterns.flyweight.demo;

import java.util.HashMap;

public class FlyweightFactory {
    private static HashMap<String, Flyweight> pool = new HashMap<>();

    public static Flyweight getFlyweight(String outside) {
        Flyweight flyweight;

        if (pool.containsKey(outside)) {
            flyweight = pool.get(outside);
            System.out.println("Pool中存在：" + outside);
        }else {
            flyweight = new ConcreteFlyweigh(outside);
            pool.put(outside, flyweight);
            System.out.println("创建新新的：" + outside);
        }
        return flyweight;
    }
}
