/*
 *         File : Server.java
 *    Classname : Server
 *    Author(s) : eznlzhi
 *      Created : 2018-07-17
 *
 *
 */

package com.example.testpatterns.callback.demo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Server {
    public void getClientMsg(CSCallback callback, String msg){
        log.info("服务端： 服务端接收到消息--> {}", msg);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("服务端： 服务器处理完毕！返回状态：200");
        callback.process("200");
    }
}
