/*
 *         File : SupervisorMain.java
 *    Classname : SupervisorMain
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

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

import java.io.IOException;

public class SupervisorMain {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("test-system");
        ActorRef supervising = system.actorOf(Props.create(SupervisingActor.class), "supervising-actor");
        supervising.tell("failchild", ActorRef.noSender());

        System.out.println("Continue");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            system.terminate();
        }
    }
}
