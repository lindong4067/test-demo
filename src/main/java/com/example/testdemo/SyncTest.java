package com.example.testdemo;

public class SyncTest {

    private static final Object LOCK = new Object();
    private static long num;

    public static void main(String[] args) {

        Runnable oldRunnable = () -> {
            System.out.println(Thread.currentThread().getName() + ": Old Runnable");
            if(num < 2){
                synchronized (LOCK){
                    num++;
                }
            }
            System.out.println(num);
        };
        Runnable newRunnable = () -> {
            System.out.println(Thread.currentThread().getName() + ": New Lambda Runnable");
            if(num < 2){
                synchronized (LOCK){
                    num++;
                }
            }
            System.out.println(num);
        };
        new Thread(oldRunnable).start();
        new Thread(oldRunnable).start();
        new Thread(newRunnable).start();
        new Thread(newRunnable).start();
    }
}
