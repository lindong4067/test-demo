package com.example.testpractice.thread;

import java.util.concurrent.TimeUnit;

public class StopThread implements Runnable {
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println(Thread.currentThread().getName() + " is running");
        }
        System.out.println(Thread.currentThread().getName() + " is stop");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new StopThread(), "Thread A");
        threadA.start();

        System.out.println("Main thread is running");
        TimeUnit.MILLISECONDS.sleep(10);
        threadA.interrupt();
    }
}
