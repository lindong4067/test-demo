package com.example.testpractice.thread;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AwaitTerminationMethod {
    private static void executorService() throws InterruptedException {
        BlockingDeque<Runnable> blockingDeque = new LinkedBlockingDeque<>(10);
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MILLISECONDS, blockingDeque);

        poolExecutor.execute(() -> {
            System.out.println("running 1");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        poolExecutor.execute(() -> {
            System.out.println("running 2");
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        poolExecutor.shutdown();
        /**
         * timeout 每隔多久查看一次
         * TimeUnit 单位
         */
        while (!poolExecutor.awaitTermination(1, TimeUnit.SECONDS)) {
            System.out.println("thread is running...");
        }
        System.out.println("main thread over");
    }

    public static void main(String[] args) throws InterruptedException {
        executorService();
    }
}
