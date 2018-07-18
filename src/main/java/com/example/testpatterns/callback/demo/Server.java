/*
 *         File : Server.java
 *    Classname : Server
 *    Author(s) : eznlzhi
 *      Created : 2018-07-17
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
