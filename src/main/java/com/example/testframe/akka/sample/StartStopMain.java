package com.example.testframe.akka.sample;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

import java.io.IOException;

public class StartStopMain {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("test-system");
        ActorRef actorRef = system.actorOf(Props.create(StartStopActor1.class), "first");
        actorRef.tell("stop", ActorRef.noSender());

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
