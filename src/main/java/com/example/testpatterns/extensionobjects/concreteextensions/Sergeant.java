package com.example.testpatterns.extensionobjects.concreteextensions;

import com.example.testpatterns.extensionobjects.abstractextensions.SergeantExtension;
import com.example.testpatterns.extensionobjects.units.SergeantUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class defining Sergeant
 */
public class Sergeant implements SergeantExtension {

  private SergeantUnit unit;

  public Sergeant(SergeantUnit sergeantUnit) {
    this.unit = sergeantUnit;
  }

  final Logger logger = LoggerFactory.getLogger(Sergeant.class);

  @Override
  public void sergeantReady() {
    logger.info("[Sergeant] {} is ready! ", unit.getName());
  }
}
