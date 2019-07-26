/*
 *         File : SupervisingActor.java
 *    Classname : SupervisingActor
 *    Author(s) : eznlzhi
 *      Created : 2018-10-30
 *
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
