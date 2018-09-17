/*
 *         File : UserDeleteEvent.java
 *    Classname : UserDeleteEvent
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

package com.example.testpatterns.eventdrivenarchitecture.eda.event;

import com.example.testpatterns.eventdrivenarchitecture.eda.model.User;

public class UserDeleteEvent extends AbstractEvent {

    private User user;

    public UserDeleteEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
