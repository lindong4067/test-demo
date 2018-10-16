package com.example.testframe.akka.sample;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class Printer extends AbstractActor {

  private LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

  static Props props() {
    return Props.create(Printer.class, Printer::new);
  }

  static class Greeting {
    public final String message;

    Greeting(String message) {
      this.message = message;
    }
  }


  private Printer() {
  }

  @Override
  public Receive createReceive() {
    return receiveBuilder().match(Greeting.class, greeting -> log.info(greeting.message))
        .build();
  }
}
