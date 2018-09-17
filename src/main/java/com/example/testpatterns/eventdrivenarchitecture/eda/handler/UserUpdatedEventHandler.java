package com.example.testpatterns.eventdrivenarchitecture.eda.handler;

import com.example.testpatterns.eventdrivenarchitecture.eda.event.UserUpdatedEvent;
import com.example.testpatterns.eventdrivenarchitecture.eda.framework.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Handles the {@link UserUpdatedEvent} message.
 */
public class UserUpdatedEventHandler implements Handler<UserUpdatedEvent> {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserUpdatedEventHandler.class);

  @Override
  public void onEvent(UserUpdatedEvent event) {
    LOGGER.info("User '{}' has been Updated!", event.getUser().getUsername());
  }
}
