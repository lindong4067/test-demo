package com.example.testpatterns.extensionobjects.units;


import com.example.testpatterns.extensionobjects.abstractextensions.UnitExtension;
import com.example.testpatterns.extensionobjects.concreteextensions.Commander;

/**
 * Class defining CommanderUnit
 */
public class CommanderUnit extends Unit {

  public CommanderUnit(String name) {
    super(name);
  }

  @Override
  public UnitExtension getUnitExtension(String extensionName) {

    if (extensionName.equals("CommanderExtension")) {
      if (unitExtension == null) {
        unitExtension = new Commander(this);
      }
      return unitExtension;
    }

    return super.getUnitExtension(extensionName);
  }
}
