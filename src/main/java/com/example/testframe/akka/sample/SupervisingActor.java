/*
 *         File : SupervisingActor.java
 *    Classname : SupervisingActor
 *    Author(s) : eznlzhi
 *      Created : 2018-10-30
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

package com.example.testframe.akka.sample;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class SupervisingActor extends AbstractActor {

    @Override
    public Receive createReceive() {
        ActorRef child = getContext().actorOf(Props.create(SupervisedActor.class), "supervised-actor");
        return receiveBuilder().matchEquals("failchild", f -> child.tell("fail", getSelf())).build();
    }
}
