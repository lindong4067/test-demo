package com.example.testpatterns.extensionobjects.units;


import com.example.testpatterns.extensionobjects.abstractextensions.UnitExtension;

/**
 * Class defining Unit, other units will extend this class
 */
public class Unit {

  private String name;

  UnitExtension unitExtension = null;

  Unit(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UnitExtension getUnitExtension(String extensionName) {
    return null;
  }
}
