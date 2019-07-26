/*
 *         File : Client.java
 *    Classname : Client
 *    Author(s) : eznlzhi
 *      Created : 2018-07-17
 *
 *
 */

package com.example.testpatterns.callback.demo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Client implements CSCallback {

    public Server server;

    public Client(Server server) {
        this.server = server;
    }

    public void sendMsg(final String msg){
        log.info("客户端： 发送消息--> msg");
        new Thread(() -> server.getClientMsg(Client.this, msg)).start();
        log.info("客户端： 异步发送成功！");
    }

    @Override
    public void process(String status) {
        log.info("客户端： 服务端返回消息--> {}", status);
    }
}
