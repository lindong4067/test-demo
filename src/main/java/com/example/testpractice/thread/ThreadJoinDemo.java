package com.example.testpractice.thread;

public class ThreadJoinDemo {
    private static void join() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("running");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }) ;
        Thread t2 = new Thread(() -> {
            System.out.println("running2");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }) ;

        t1.start();
        t2.start();

        //等待线程1终止
        t1.join();

        //等待线程2终止
        t2.join();
        System.out.println("main over");
    }

    public static void main(String[] args) throws InterruptedException {
        join();
    }
}
