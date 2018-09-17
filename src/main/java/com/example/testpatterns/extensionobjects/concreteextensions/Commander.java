package com.example.testpatterns.extensionobjects.concreteextensions;

import com.example.testpatterns.extensionobjects.abstractextensions.CommanderExtension;
import com.example.testpatterns.extensionobjects.units.CommanderUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class defining Commander
 */
public class Commander implements CommanderExtension {

  private CommanderUnit unit;

  public Commander(CommanderUnit commanderUnit) {
    this.unit = commanderUnit;
  }

  private final Logger logger = LoggerFactory.getLogger(Commander.class);

  @Override
  public void commanderReady() {
    logger.info("[Commander] {} is ready!", unit.getName());
  }
}
