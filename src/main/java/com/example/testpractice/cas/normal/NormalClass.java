package com.example.testpractice.cas.normal;

class Counter {
    private int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void add() {
        ++count;
    }

    public void dec() {
        --count;
    }
}

class AddDataThread extends Thread {

    private Counter counter;

    public AddDataThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < NormalClass.LOOP; ++i) {
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
        for (int i = 0; i < NormalClass.LOOP; ++i) {
            counter.dec();
        }
    }
}

public class NormalClass {

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
