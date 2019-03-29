package com.example.testpatterns.iterator.demo;

public class ConcreteIterator implements Interator {
    private List list;
    private int index;

    public ConcreteIterator(List list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return index < list.getSize();
    }

    @Override
    public Object next() {
        Object o = list.get(index);
        index++;
        return o;
    }
}
