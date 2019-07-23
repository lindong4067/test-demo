package com.example.testpractice.thread;

import java.util.concurrent.TimeUnit;

public class VolatileDemo implements Runnable {
    private static volatile boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            System.out.println(Thread.currentThread().getName() + "正在运行...");
        }
        System.out.println(Thread.currentThread().getName() + "执行完毕。");
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileDemo volatileDemo = new VolatileDemo();
        new Thread(volatileDemo, "Thread A").start();
        System.out.println("Main线程正在运行");
        TimeUnit.SECONDS.sleep(1);
        volatileDemo.stopThread();
    }

    private void stopThread() {
        flag = false;
    }
}
