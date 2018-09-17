package com.example.testpatterns.eventsourcing.processor;

import com.example.testpatterns.eventsourcing.event.DomainEvent;

/**
 * This is the implementation of event processor.
 * All events are processed by this class.
 * This processor uses processorJournal to persist and recover events.
 *
 * Created by Serdar Hamzaogullari on 06.08.2017.
 */
public class DomainEventProcessor {

  private final JsonFileJournal processorJournal = new JsonFileJournal();

  /**
   * Process.
   *
   * @param domainEvent the domain event
   */
  public void process(DomainEvent domainEvent) {
    domainEvent.process();
    processorJournal.write(domainEvent);
  }

  /**
   * Reset.
   */
  public void reset() {
    processorJournal.reset();
  }

  /**
   * Recover.
   */
  public void recover() {
    DomainEvent domainEvent;
    while (true) {
      domainEvent = processorJournal.readNext();
      if (domainEvent == null) {
        break;
      } else {
        domainEvent.process();
      }
    }
  }
}
