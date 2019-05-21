package com.example.testpractice.cas.atomic;

import java.util.concurrent.atomic.AtomicInteger;

class Counter {
    private AtomicInteger count = new AtomicInteger(0);

    public int getCount() {
        return count.get();
    }

    public void add() {
        count.addAndGet(1);
    }

    public void dec() {
        count.decrementAndGet();
    }
}

class AddDataThread extends Thread {

    private Counter counter;

    public AddDataThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < AtomicClass.LOOP; ++i) {
            counter.add();
        }
    }
}

class DecDataThread extends Thread {
    private Counter counter;

    public DecDataThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < AtomicClass.LOOP; ++i) {
            counter.dec();
        }
    }
}

public class AtomicClass {
    final static int LOOP = 10000;

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread addDataThread = new AddDataThread(counter);
        Thread decDataThread = new DecDataThread(counter);
        addDataThread.start();
        decDataThread.start();
        addDataThread.join();
        decDataThread.join();
        System.out.println(counter.getCount());
    }
}
