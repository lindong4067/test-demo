/*
 *         File : SupervisorMain.java
 *    Classname : SupervisorMain
 *    Author(s) : eznlzhi
 *      Created : 2018-10-30
 *
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
