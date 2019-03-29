package com.example.testpatterns.iterator.demo;

public class IteratorTest {
    public static void main(String[] args) {
        List list = new ConcreteAggregate();
        list.add("H");
        list.add("E");
        list.add("L");
        list.add("L");
        list.add("O");
        Interator interator = list.interator();
        while (interator.hasNext()) {
            System.out.println(interator.next());
        }
    }
}
