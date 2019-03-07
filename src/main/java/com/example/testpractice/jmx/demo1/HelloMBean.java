package com.example.testpractice.jmx.demo1;

public interface HelloMBean {
    String getName();
    void setName(String name);
    String printHello();
    String printHello(String whoName);
}
