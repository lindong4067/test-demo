package com.example.testpatterns.abstractdocument.domain;

import com.example.testpatterns.abstractdocument.AbstractDocument;

import java.util.Map;

/**
 * Car entity
 */
public class Car extends AbstractDocument implements HasModel, HasPrice, HasParts {

  public Car(Map<String, Object> properties) {
    super(properties);
  }

}
