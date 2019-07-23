package com.example.testpractice.thread;

public class TwoThreadWaitNotify {
    private int number = 1;

    private boolean flag = false;

    public static void main(String[] args) {
        TwoThreadWaitNotify twoThread = new TwoThreadWaitNotify();

        Thread t1 = new Thread(new OuNum(twoThread));
        t1.setName("A");

        Thread t2 = new Thread(new JiNum(twoThread));
        t2.setName("B");

        t1.start();
        t2.start();
    }

    public static class OuNum implements Runnable {
        private TwoThreadWaitNotify threadThread;

        public OuNum(TwoThreadWaitNotify twoThread) {
            this.threadThread = twoThread;
        }

        @Override
        public void run() {
            while (threadThread.number <= 100) {
                synchronized (TwoThreadWaitNotify.class) {
                    System.out.println("===偶数线程抢到了锁===");
                    if (threadThread.flag) {
                        System.out.println(Thread.currentThread().getName() + "-->" + threadThread.number);
                        threadThread.number++;
                        threadThread.flag = false;
                        TwoThreadWaitNotify.class.notify();
                    } else {
                        try {
                            TwoThreadWaitNotify.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private static class JiNum implements Runnable {
        private TwoThreadWaitNotify threadThread;

        public JiNum(TwoThreadWaitNotify twoThread) {
            this.threadThread = twoThread;
        }

        @Override
        public void run() {
            while (threadThread.number <= 100) {
                synchronized (TwoThreadWaitNotify.class) {
                    System.out.println("===奇数线程抢到了锁===");
                    if (!threadThread.flag) {
                        System.out.println(Thread.currentThread().getName() + "-->" + threadThread.number);
                        threadThread.number++;
                        threadThread.flag = true;
                        TwoThreadWaitNotify.class.notify();
                    } else {
                        try {
                            TwoThreadWaitNotify.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
