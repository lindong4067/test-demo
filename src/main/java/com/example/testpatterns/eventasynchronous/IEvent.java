package com.example.testpatterns.eventasynchronous;

/**
 * Events that fulfill the start stop and list out current status behaviour
 * follow this interface
 */
public interface IEvent {

  void start();

  void stop();

  void status();

}
