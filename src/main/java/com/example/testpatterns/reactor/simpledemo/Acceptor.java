package com.example.testpatterns.reactor.simpledemo;

import lombok.extern.slf4j.Slf4j;

import java.nio.channels.SocketChannel;

@Slf4j
public class Acceptor implements Runnable {
    private Reactor reactor;

    public Acceptor(Reactor reactor) {
        this.reactor = reactor;
    }

    @Override
    public void run() {
        try {
            SocketChannel socketChannel = reactor.serverSocketChannel.accept();
            if (socketChannel != null){
                new SocketReadHandler(reactor.selector, socketChannel);
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }
}
