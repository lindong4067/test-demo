/*
 *         File : CustomClient.java
 *    Classname : CustomClient
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
import java.net.Socket;

@Slf4j
public class CustomClient {
    public static void main(String[] args) {
        try (Socket s = new Socket("127.0.0.1", 8888)) {
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            bw.write("Test message...\n");
            bw.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String msg = br.readLine();
            log.info("Server : {}", msg);
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }
}
