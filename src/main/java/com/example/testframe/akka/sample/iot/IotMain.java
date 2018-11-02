package com.example.testframe.akka.sample.iot;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

import java.io.IOException;

public class IotMain {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("iot-system");
        try {
            ActorRef actorRef = system.actorOf(IotSupervisor.props(), "iot-supervisor");
            System.out.println("Continue");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            system.terminate();
        }
    }
}
