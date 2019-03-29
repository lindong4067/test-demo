package com.example.testpatterns.flyweight.demo;

public class Client {
    public static void main(String[] args) {
        int num = 26;

        Flyweight liu = FlyweightFactory.getFlyweight("刘备");
        liu.operate(++num);

        Flyweight guan = FlyweightFactory.getFlyweight("关羽");
        guan.operate(++num);

        Flyweight liu2 = FlyweightFactory.getFlyweight("刘备");
        liu2.operate(++num);

        Flyweight liu3 = FlyweightFactory.getFlyweight("刘备");
        liu3.operate(++num);
    }
}
