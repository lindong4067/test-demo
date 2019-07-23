package com.example.testpractice.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    private static void countDownLatch() throws InterruptedException {
        int thread = 3;
        long start = System.currentTimeMillis();
        final CountDownLatch countDown = new CountDownLatch(thread);
        for (int i = 0; i < thread; i++) {
            new Thread(() -> {
                System.out.println("thread run");
                try {
                    Thread.sleep(2000);
                    countDown.countDown();
                    System.out.println("thread end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        countDown.await();
        long stop = System.currentTimeMillis();
        System.out.println("main over total time: " + (stop - start));
    }

    public static void main(String[] args) throws InterruptedException {
        countDownLatch();
    }
}
