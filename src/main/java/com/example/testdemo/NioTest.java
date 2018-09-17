package com.example.testdemo;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest {

    private long testFileReadAndWriteByIO(File origin, File dist) throws IOException {
        long startTime = System.currentTimeMillis();
        if(!dist.exists()){
            dist.createNewFile();
        }
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(origin));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dist))) {
            byte[] buffer = new byte[1024 * 1024];
            int lenth;
            while ((lenth = bis.read(buffer)) != -1){
                bos.write(buffer, 0, lenth);
            }
        }
        long stopTime = System.currentTimeMillis();
        return stopTime - startTime;
    }

    private long testFileReadAndWriteByNIO(File origin, File dist) throws IOException {
        long startTime = System.currentTimeMillis();
        if(!dist.exists()){
            dist.createNewFile();
        }
        try (RandomAccessFile read = new RandomAccessFile(origin, "rw");
             RandomAccessFile write = new RandomAccessFile(dist, "rw")) {
            FileChannel readChannel = read.getChannel();
            FileChannel writeChannel = write.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024);
            while (readChannel.read(buffer) > 0){
                buffer.flip();
                writeChannel.write(buffer);
                buffer.clear();
            }
        }
        long stopTime = System.currentTimeMillis();
        return stopTime - startTime;
    }

    public static void main(String[] args) throws IOException {
        NioTest test = new NioTest();

        File origin = new File("C:\\Temp\\test.zip");
        File io = new File("C:\\Temp\\test_io.zip");
        File nio = new File("C:\\Temp\\test_nio.zip");

        long l1 = test.testFileReadAndWriteByIO(origin, io);
        long l2 = test.testFileReadAndWriteByNIO(origin, nio);

        System.out.println("IO  :   " + l1);
        System.out.println("NIO :   " + l2);
    }
}
