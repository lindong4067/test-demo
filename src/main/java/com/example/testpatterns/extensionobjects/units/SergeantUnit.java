package com.example.testpatterns.extensionobjects.units;


import com.example.testpatterns.extensionobjects.abstractextensions.UnitExtension;
import com.example.testpatterns.extensionobjects.concreteextensions.Sergeant;

/**
 * Class defining SergeantUnit
 */
public class SergeantUnit extends Unit {

  public SergeantUnit(String name) {
    super(name);
  }

  @Override
  public UnitExtension getUnitExtension(String extensionName) {

    if (extensionName.equals("SergeantExtension")) {
      if (unitExtension == null) {
        unitExtension = new Sergeant(this);
      }
      return unitExtension;
    }

    return super.getUnitExtension(extensionName);
  }
}
