/*
 *         File : CustomServer.java
 *    Classname : CustomServer
 *    Author(s) : eznlzhi
 *      Created : 2018-10-16
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

package com.example.testpractice.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

@Slf4j
public class CustomServer {
    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(8888)) {
            log.info("Server start...");
            Socket s = ss.accept();
            log.info("Client-{} connection.", s.getInetAddress().getHostAddress());

            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String msg = br.readLine();
            log.info("Client : {}", msg);

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            bw.write(msg + "\n");
            bw.flush();
        } catch (IOException e) {
            log.error(e.getMessage());
        }

    }
}
