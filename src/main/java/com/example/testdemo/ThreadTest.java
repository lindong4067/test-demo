package com.example.testdemo;

public class ThreadTest {

    public static void main(String[] args) {
        ThreadTest test = new ThreadTest();
        int i=0;
        test.example(++i);
        // ++i 先自加再运算， i++ 先运算再自加。
    }

    private void example(final int i){
        new Thread(() -> System.out.println("Run Thread 01 : " + i)).start();
        new Thread(() -> System.out.println("Run Thread 02 : " + i)).start();
        new Thread(() -> System.out.println("Run Thread 03 : " + i)).start();
        new Thread(() -> System.out.println("Run Thread 04 : " + i)).start();
        new Thread(() -> System.out.println("Run Thread 05 : " + i)).start();
    }
}
