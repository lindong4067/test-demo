package com.example.testpatterns.eventdrivenarchitecture.eda.handler;

import com.example.testpatterns.eventdrivenarchitecture.eda.event.UserCreatedEvent;
import com.example.testpatterns.eventdrivenarchitecture.eda.framework.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Handles the {@link UserCreatedEvent} message.
 */
public class UserCreatedEventHandler implements Handler<UserCreatedEvent> {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserCreatedEventHandler.class);

  @Override
  public void onEvent(UserCreatedEvent event) {
    LOGGER.info("User '{}' has been Created!", event.getUser().getUsername());
  }

}
