package com.example.testpatterns.reactor.simpledemo;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

@Slf4j
public class SocketReadHandler implements Runnable{
    private SocketChannel socketChannel;

    public SocketReadHandler(Selector selector, SocketChannel socketChannel) throws IOException {
        this.socketChannel = socketChannel;
        socketChannel.configureBlocking(false);
        SelectionKey selectionKey = socketChannel.register(selector, 0);
        selectionKey.attach(this);
        selectionKey.interestOps(SelectionKey.OP_READ);
        selector.wakeup();
    }

    @Override
    public void run() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.clear();
        try {
            socketChannel.read(buffer);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
