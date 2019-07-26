/*
 *         File : SupervisedActor.java
 *    Classname : SupervisedActor
 *    Author(s) : eznlzhi
 *      Created : 2018-10-30
 *
 *
 */

package com.example.testframe.akka.sample;

import akka.actor.AbstractActor;

public class SupervisedActor extends AbstractActor {
    @Override
    public void preStart() throws Exception {
        System.out.println("Supervised Actor Started");
    }

    @Override
    public void postStop() throws Exception {
        System.out.println("Supervised Actor Stopped");
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder().matchEquals("fail", f -> {
            System.out.println("Supervised Actor Failed now");
            throw new Exception("I failed.");
        }).build();
    }
}
