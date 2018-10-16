/*
 *         File : EventListener.java
 *    Classname : EventListener
 *    Author(s) : eznlzhi
 *      Created : 2018-09-29
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

package com.example.testframe.event.guava;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EventListener {
    private String lastMessage;

    @Subscribe
    public void listen(Event event){
        lastMessage = event.getMessage();
        log.info("Listen message : {}", lastMessage);
    }

    public String getLastMessage() {
        return lastMessage;
    }

}
