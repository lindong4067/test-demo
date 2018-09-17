package com.example.testpatterns.extensionobjects.units;


import com.example.testpatterns.extensionobjects.abstractextensions.UnitExtension;
import com.example.testpatterns.extensionobjects.concreteextensions.Soldier;

/**
 * Class defining SoldierUnit
 */
public class SoldierUnit extends Unit {

  public SoldierUnit(String name) {
    super(name);
  }

  @Override
  public UnitExtension getUnitExtension(String extensionName) {

    if (extensionName.equals("SoldierExtension")) {
      if (unitExtension == null) {
        unitExtension = new Soldier(this);
      }

      return unitExtension;
    }
    return super.getUnitExtension(extensionName);
  }
}
