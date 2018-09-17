package com.example.testpatterns.extensionobjects.concreteextensions;

import com.example.testpatterns.extensionobjects.abstractextensions.SoldierExtension;
import com.example.testpatterns.extensionobjects.units.SoldierUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class defining Soldier
 */
public class Soldier implements SoldierExtension {

  private SoldierUnit unit;

  public Soldier(SoldierUnit soldierUnit) {
    this.unit = soldierUnit;
  }

  final Logger logger = LoggerFactory.getLogger(Soldier.class);

  @Override
  public void soldierReady() {
    logger.info("[Solider] {}  is ready!", unit.getName());
  }
}
