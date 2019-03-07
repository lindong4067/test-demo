package com.example.testpractice.nio.file;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//FileNIO channel
public class FileNIO {

    public static String readFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (RandomAccessFile file = new RandomAccessFile(fileName, "r")){
            FileChannel channel = file.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            int read = channel.read(buffer);
            while (read != -1) {
                System.out.println("Read " + read);
                buffer.flip();

                while (buffer.hasRemaining()) {
                    sb.append((char) buffer.get());
                }

                buffer.clear();
                read = channel.read(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String fileContent = readFile("C:\\Users\\EZNLZHI\\IdeaProjects\\test-demo\\src\\main\\java\\com\\example\\testpractice\\nio\\file\\nio.txt");
        System.out.println(fileContent);
    }
}
