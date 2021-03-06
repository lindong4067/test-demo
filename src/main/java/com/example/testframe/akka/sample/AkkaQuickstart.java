package com.example.testframe.akka.sample;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class AkkaQuickstart {
  public static void main(String[] args) {
    final ActorSystem system = ActorSystem.create("helloakka");
    try {
      //#create-actors
      final ActorRef printerActor = system.actorOf(Printer.props(), "printerActor");
      final ActorRef howdyGreeter = system.actorOf(Greeter.props("Howdy!", printerActor), "howdyGreeter");
      final ActorRef helloGreeter = system.actorOf(Greeter.props("Hello!", printerActor), "helloGreeter");
      final ActorRef goodDayGreeter = system.actorOf(Greeter.props("Good day!", printerActor), "goodDayGreeter");
      //#MyMvcMain-send-messages

      howdyGreeter.tell(new Greeter.WhoToGreet("Akka"), ActorRef.noSender());
      howdyGreeter.tell(new Greeter.Greet(), ActorRef.noSender());

      howdyGreeter.tell(new Greeter.WhoToGreet("Lightbend"), ActorRef.noSender());
      howdyGreeter.tell(new Greeter.Greet(), ActorRef.noSender());

      helloGreeter.tell(new Greeter.WhoToGreet("Java"), ActorRef.noSender());
      helloGreeter.tell(new Greeter.Greet(), ActorRef.noSender());

      goodDayGreeter.tell(new Greeter.WhoToGreet("Play"), ActorRef.noSender());
      goodDayGreeter.tell(new Greeter.Greet(), ActorRef.noSender());
      //#MyMvcMain-send-messages

    } finally {
      system.terminate();
    }
  }
}
