package com.example.testpractice.nio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class SocketServer {
    public static void main(String[] args) {
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.bind(new InetSocketAddress("127.0.0.1", 8080));
            ssc.configureBlocking(false);

            Selector selector = Selector.open();
            ssc.register(selector, SelectionKey.OP_ACCEPT);

            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            ByteBuffer writeBuffer = ByteBuffer.allocate(128);
            writeBuffer.put("Received: ".getBytes());
            writeBuffer.flip();

            while (true) {
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey selectionKey = iterator.next();
                    iterator.remove();

                    if (selectionKey.isAcceptable()) {
                        SocketChannel socketChannel = ssc.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    } else if (selectionKey.isReadable()) {
                        SocketChannel channel = (SocketChannel) selectionKey.channel();
                        readBuffer.clear();
                        channel.read(readBuffer);
                        readBuffer.flip();
                        System.out.println("received: " + new String(readBuffer.array()));
                        selectionKey.interestOps(SelectionKey.OP_WRITE);
                    } else if (selectionKey.isWritable()) {
                        writeBuffer.rewind();
                        SocketChannel channel = (SocketChannel) selectionKey.channel();
                        channel.write(writeBuffer);
                        selectionKey.interestOps(SelectionKey.OP_READ);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
