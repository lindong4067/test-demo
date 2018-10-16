/*
 *         File : EventPublisher.java
 *    Classname : EventPublisher
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

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;

@Slf4j
public class EventPublisher {
    public static void main(String[] args) {
        AsyncEventBus eventBus = new AsyncEventBus(Executors.newFixedThreadPool(3));
        EventBus eventBus3 = new EventBus();
        EventListener listener = new EventListener();
        eventBus3.register(listener);
        log.info("Publish message : {}", listener.getLastMessage());
        eventBus.post(new Event("Hello! 1"));
        EventBus eventBus1 = new EventBus();
        EventListener listener1 = new EventListener();
        eventBus1.register(listener1);
        log.info("Publish message : {}", listener1.getLastMessage());
        eventBus1.post(new Event("Hello! 2"));

        EventBus eventBus2 = new EventBus();
        EventListener listener2 = new EventListener();
        eventBus2.register(listener2);
        log.info("Publish message : {}", listener2.getLastMessage());

        eventBus.post(new Event("Hello! 3"));
        eventBus.post(new Event("Hello! 4"));

        publishEvent("Hello");
    }

    private static void publishEvent(final String message){
        EventBus eventBus = new EventBus();
        EventListener listener = new EventListener();
        eventBus.register(listener);
        log.info("Event bus : {}", eventBus);
        log.info("Event listener : {}", listener);
        log.info("Publish message : {}", message);
        eventBus.post(new Event(message));
    }
}
