/*
 *         File : UserDeleteEvent.java
 *    Classname : UserDeleteEvent
 *    Author(s) : eznlzhi
 *      Created : 2018-09-04
 *
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
