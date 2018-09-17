/*
 *         File : UserDeleteEventHandler.java
 *    Classname : UserDeleteEventHandler
 *    Author(s) : eznlzhi
 *      Created : 2018-09-04
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

package com.example.testpatterns.eventdrivenarchitecture.eda.handler;

import com.example.testpatterns.eventdrivenarchitecture.eda.event.UserDeleteEvent;
import com.example.testpatterns.eventdrivenarchitecture.eda.framework.Handler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserDeleteEventHandler implements Handler<UserDeleteEvent> {
    @Override
    public void onEvent(UserDeleteEvent event) {
        log.info(event.getUser().getUsername());
    }
}
