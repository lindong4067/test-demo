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
