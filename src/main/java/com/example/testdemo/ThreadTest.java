package com.example.testdemo;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class ThreadTest {

    @Test
    public void testMain() {
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

    @Test
    public void testGroup(){
        ThreadGroup group = new ThreadGroup("Test");
        group.setMaxPriority(7);
        Thread thread = new Thread(group, "test-Thread");
        thread.setPriority(10);//指定group的Thread优先级不能大于group的
        System.out.println(thread.getPriority());//线程优先级
        //main方法默认的线程优先级是5
        System.out.println(thread.getId());//线程ID
    }

    @Test
    public void testLeader(){
        ClassLoader classLoader = this.getClass().getClassLoader();
        this.getClass().isEnum();
        System.out.println(classLoader);
    }

    @Test
    public void testJoin() throws InterruptedException {
        Thread thread = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread1 = new Thread(new Domino(thread), String.valueOf(i));
            thread1.start();
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(thread.getName() + " terminate.");
    }

    private class Domino implements Runnable {

        private Thread thread;

        public Domino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(thread.getName() + " terminate.");
        }
    }
}
