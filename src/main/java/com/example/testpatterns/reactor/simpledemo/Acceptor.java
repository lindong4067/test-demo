/*
 *         File : Acceptor.java
 *    Classname : Acceptor
 *    Author(s) : eznlzhi
 *      Created : 2018-10-26
 *
 * Copyright (c) 2017 Ericsson AB, Sweden.
 * All rights reserved.
 * The Copyright to the computer program(s) herein is the property of
 * Ericsson AB, Sweden.
 * The program(s) may be used and/or copied with the written permission
 * from Ericsson AB or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s)
 * have been supplied.
 *
 */

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
