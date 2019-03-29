package com.example.testpatterns.iterator.demo;

public interface List {
    void add(Object object);
    Object get(int index);
    Interator interator();
    int getSize();
}
