package com.example.testpractice.thread;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class PipelineDemo {
    private static void piped() throws IOException {
        //面向字符PipedInputStream
        PipedWriter writer = new PipedWriter();
        PipedReader reader = new PipedReader();
        //输入输出流建立连接
        writer.connect(reader);

        Thread t1 = new Thread(() -> {
            System.out.println("running 1");
            try {
                for (int i = 0; i < 10; i++) {
                    writer.write(i + "");
                    Thread.sleep(10);
                }
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            System.out.println("running 2");
            int msg = 0;
            try {
                while ((msg = reader.read()) != -1) {
                    System.out.println("message : " + (char)msg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
    }

    public static void main(String[] args) throws IOException {
        piped();
    }
}
