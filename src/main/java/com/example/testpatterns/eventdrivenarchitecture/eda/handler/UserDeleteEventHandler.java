/*
 *         File : UserDeleteEventHandler.java
 *    Classname : UserDeleteEventHandler
 *    Author(s) : eznlzhi
 *      Created : 2018-09-04
 *
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
