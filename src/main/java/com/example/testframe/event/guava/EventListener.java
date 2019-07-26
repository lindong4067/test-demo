/*
 *         File : EventListener.java
 *    Classname : EventListener
 *    Author(s) : eznlzhi
 *      Created : 2018-09-29
 *
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
