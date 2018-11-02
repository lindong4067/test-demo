package com.example.testframe.akka.sample;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;

public class PrintMyActorRefActor extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder().matchEquals("printit", p -> {
            ActorRef actorRef = getContext().actorOf(Props.empty(), "second-actor");
            System.out.println("Second: " + actorRef);
        }).build();
    }
}
