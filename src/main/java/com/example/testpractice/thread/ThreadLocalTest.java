package com.example.testpractice.thread;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ThreadLocalTest {
    private static ThreadLocal<Connection> connectionHolder = ThreadLocal.withInitial(() -> {
        try {
            return DriverManager.getConnection("http://127.0.0.1:3306/mysql");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    });

    private static ThreadLocal<Integer> seqNum = ThreadLocal.withInitial(() -> 0);

    public int getNextNum() {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }

    public static Connection getConnection() {
        return connectionHolder.get();
    }

    public static void main(String[] args) {
        ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        TestClient client1 = new TestClient(threadLocalTest);
        TestClient client2 = new TestClient(threadLocalTest);
        TestClient client3 = new TestClient(threadLocalTest);
        client1.start();
        client2.start();
        client3.start();
    }

    private static class TestClient extends Thread {
        private ThreadLocalTest threadLocal;

        public TestClient(ThreadLocalTest threadLocal) {
            this.threadLocal = threadLocal;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                //每个线程打出3个序列值
                System.out.println("thread[" + Thread.currentThread().getName() + "] --> sn["
                        + threadLocal.getNextNum() + "]");
            }
        }
    }
}
