package com.example.testpractice.nio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketClient {
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 8080));
            ByteBuffer writeBuffer = ByteBuffer.allocate(128);
            ByteBuffer readBuffer = ByteBuffer.allocate(128);

            writeBuffer.put("hello".getBytes());
            writeBuffer.flip();

            while (true) {
                writeBuffer.rewind();
                socketChannel.write(writeBuffer);
                writeBuffer.clear();
//                socketChannel.read(readBuffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
