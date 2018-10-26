/*
 *         File : PangActor.java
 *    Classname : PangActor
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

package com.example.testframe.akka.pingpang;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Status;
import akka.japi.pf.ReceiveBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PangActor extends AbstractActor {
    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create().matchEquals("ping", s -> sender().tell("pang", ActorRef.noSender()))
                .match(String.class, e -> sender().tell("Unknown type", ActorRef.noSender()))
                .matchAny(x -> sender().tell(new Status.Failure(new Exception("Unknown exception")), self()))
                .build();
    }
}
