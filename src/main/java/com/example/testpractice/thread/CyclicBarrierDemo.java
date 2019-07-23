package com.example.testpractice.thread;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    private static void cyclicBarrier() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

        new Thread(() -> {
            System.out.println("thread run");
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("thread end do something");
        }).start();

        new Thread(() -> {
            System.out.println("thread run");
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("thread end do something");
        }).start();

        new Thread(() -> {
            System.out.println("thread run");
            try {
                Thread.sleep(5000);
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("thread end do something");
        }).start();
    }

    public static void main(String[] args) {
        cyclicBarrier();
    }
}
