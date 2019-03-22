package com.example.testpractice.thread;

import java.util.concurrent.*;

public class FutureTaskDemo {
    public static void main(String[] args) {
        MyCallable myCallable1 = new MyCallable(1000L);
        MyCallable myCallable2 = new MyCallable(2000L);

        FutureTask<String> futureTask1 = new FutureTask<>(myCallable1);
        FutureTask<String> futureTask2 = new FutureTask<>(myCallable2);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(futureTask1);
        executorService.execute(futureTask2);

        while (true) {
            if (futureTask1.isDone() && futureTask2.isDone()) {
                System.out.println("All tasks done.");
                executorService.shutdown();
                break;
            } else {
                System.out.println("Tasks on going.");
            }

            if (futureTask1.isDone()) {
                try {
                    String task1 = futureTask1.get();
                    System.out.println("Task1 response: " + task1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }

            if (futureTask2.isDone()) {
                try {
                    String task2 = futureTask2.get();
                    System.out.println("Task2 response: " + task2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}

class MyCallable implements Callable<String> {
    long stop;

    MyCallable(long stop) {
        this.stop = stop;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(stop);
        return Thread.currentThread().getName();
    }
}