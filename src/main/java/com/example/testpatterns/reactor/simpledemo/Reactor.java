/*
 *         File : Reactor.java
 *    Classname : Reactor
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

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

@Slf4j
public class Reactor implements Runnable {
    public final Selector selector;
    public final ServerSocketChannel serverSocketChannel;

    public Reactor(int port) throws IOException {
        this.selector = Selector.open();
        this.serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(InetAddress.getLocalHost(), port);
        serverSocketChannel.accept().bind(inetSocketAddress);
        //设置非阻塞模式
        serverSocketChannel.configureBlocking(false);

        /*
         * 向selector注册该serverSocketChannel
         * SelectionKey.OP_ACCEPT —— 接收连接继续事件，表示服务器监听到了客户连接，服务器可以接收这个连接了
         * SelectionKey.OP_CONNECT —— 连接就绪事件，表示客户与服务器的连接已经建立成功
         * SelectionKey.OP_READ —— 读就绪事件，表示通道中已经有了可读的数据，可以执行读操作了（通道目前有数据，可以进行读操作了）
         * SelectionKey.OP_WRITE —— 写就绪事件，表示已经可以向通道写数据了（通道目前可以用于写操作）
         * 这里 注意，下面两种，SelectionKey.OP_READ ，SelectionKey.OP_WRITE ，
         * 1.当向通道中注册SelectionKey.OP_READ事件后，如果客户端有向缓存中write数据，下次轮询时，则会 isReadable()=true；
         * 2.当向通道中注册SelectionKey.OP_WRITE事件后，这时你会发现当前轮询线程中isWritable()一直为ture，如果不设置为其他事件
         */
        SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        /*
         * 利用selectionKey的attache功能绑定Acceptor 如果有事情，触发Acceptor
         * 该selectionKey为serverSocketChannel的selectionKey
         * attach的为new Acceptor(this)
         * 用于void dispatch(SelectionKey key)中获取key.attachment()
         * 将被本类中的run()方法的selectionKeys.clear(); 清空
         * 第二次的selector.selectedKeys();获取到的将会是socketChannel注册的OP_READ的selectionKey(attach的为SocketReadHandler)
         */
        selectionKey.attach(new Acceptor(this));
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                if (iterator.hasNext())
                    dispatch(iterator.next());
                selectionKeys.clear();
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    private void dispatch(SelectionKey selectionKey) {
        Runnable runnable = (Runnable) selectionKey.attachment();
        if (runnable != null){
            runnable.run();
        }
    }

}
