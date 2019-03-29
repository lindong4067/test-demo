package com.example.testpatterns.iterator.demo;

public class ConcreteAggregate implements List {

    private Object[] list;
    private int size;
    private int index;

    public ConcreteAggregate() {
        index = 0;
        size = 0;
        list = new Object[100];
    }

    @Override
    public void add(Object object) {
        list[index++] = object;
        size++;
    }

    @Override
    public Object get(int index) {
        return list[index];
    }

    @Override
    public Interator interator() {
        return new ConcreteIterator(this);
    }

    @Override
    public int getSize() {
        return size;
    }
}
