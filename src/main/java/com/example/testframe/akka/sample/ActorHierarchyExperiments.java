package com.example.testframe.akka.sample;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

import java.io.IOException;

public class ActorHierarchyExperiments {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("testSystem");
        ActorRef actorRef = system.actorOf(Props.create(PrintMyActorRefActor.class), "first-actor");
        System.out.println("First: " + actorRef);
        actorRef.tell("printit", ActorRef.noSender());

        System.out.println("press any key to continue.");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            system.terminate();
        }
    }
}
