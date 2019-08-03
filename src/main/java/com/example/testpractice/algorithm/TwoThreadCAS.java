package com.example.testpractice.algorithm;

/**
 * 两个线程交替打印
 * CAS 实现
 */
public class TwoThreadCAS {
    private volatile int start = 0;

    public TwoThreadCAS(int start) {
        this.start = start;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public static void main(String[] args) {
        TwoThreadCAS cas = new TwoThreadCAS(0);
        new Thread(new ThreadOne(cas)).start();
        new Thread(new ThreadTwo(cas)).start();
    }
}

class ThreadOne implements Runnable {
    private TwoThreadCAS cas;

    public ThreadOne(TwoThreadCAS cas) {
        this.cas = cas;
    }

    @Override
    public void run() {
        while (true) {
            int start = cas.getStart();
            if (start == cas.getStart() && start < 100) {
                    cas.setStart(start + 1);
                    System.out.println("Thread one: " + (start + 1));
            }
        }
    }
}

class ThreadTwo implements Runnable {
    private TwoThreadCAS cas;

    public ThreadTwo(TwoThreadCAS cas) {
        this.cas = cas;
    }

    @Override
    public void run() {
        while (true) {
            int start = cas.getStart();
            if (start == cas.getStart() && start < 100) {
                    cas.setStart(start + 1);
                    System.out.println("Thread two: " + (start + 1));
            }
        }
    }
}
