package com.example.testpatterns.databus.data;

import com.example.testpatterns.databus.AbstractDataType;
import com.example.testpatterns.databus.DataType;

import java.time.LocalDateTime;

/**
 * An event raised when applications starts, containing the start time of the application.
 *
 * @author Paul Campbell (pcampbell@kemitix.net)
 */
public class StartingData extends AbstractDataType {

  private final LocalDateTime when;

  public StartingData(LocalDateTime when) {
    this.when = when;
  }

  public LocalDateTime getWhen() {
    return when;
  }

  public static DataType of(final LocalDateTime when) {
    return new StartingData(when);
  }
}
