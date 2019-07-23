package com.example.testpractice.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池中一个线程异常停止工作
 */
public class ThreadExceptionTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());

        executor.execute(() -> System.out.println("=== 11 ==="));

        TimeUnit.SECONDS.sleep(5);

        executor.execute(new Run1());

//        TimeUnit.SECONDS.sleep(5);
//
//        executor.execute(new Run2());
//
//        executor.shutdown();
    }

    private static class Run1 implements Runnable {
        @Override
        public void run() {
            int count = 0;
            while (true) {
                count++;
                System.out.println("=== 222 === " + count);
                if (count == 10) {
                    //throw exception, cannot continue
                    //System.out.println(1 / 0);
                    //catch exception
                    try {
                        System.out.println(1 / 0);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (count == 20) {
                    System.out.println("count=" + count);
                    break;
                }
            }
        }
    }

    private static class Run2 implements Runnable {
        public Run2() {
            System.out.println("run2 构造函数");
        }

        @Override
        public void run() {
            System.out.println("run 222");
        }
    }
}
