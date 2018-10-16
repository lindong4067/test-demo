package com.example.testframe.akka.getstart;


import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Inbox;
import akka.actor.Props;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

@Slf4j
public class Client {
    public static void main(String[] args) throws TimeoutException {
        final ActorSystem actorSystem = ActorSystem.create();
        //
        final ActorRef hello = actorSystem.actorOf(Props.create(HelloActor.class), "hello");

        final Inbox inbox = Inbox.create(actorSystem);

        hello.tell("How are you!", ActorRef.noSender());

        inbox.send(hello, "Nice to meet you!");

        String receive = (String) inbox.receive(Duration.ofSeconds(5));
        log.info("Client Receive : {}", receive);

        ActorRef response = actorSystem.actorOf(Props.create(ResponseActor.class));

        actorSystem.scheduler().schedule(Duration.ofSeconds(0), Duration.ofSeconds(1), hello, "OK!", actorSystem.dispatcher(), response);

    }
}
