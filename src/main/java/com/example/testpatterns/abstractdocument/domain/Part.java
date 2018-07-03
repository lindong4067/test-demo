package com.example.testpatterns.abstractdocument.domain;

import com.example.testpatterns.abstractdocument.AbstractDocument;

import java.util.Map;


/**
 * Part entity
 */
public class Part extends AbstractDocument implements HasType, HasModel, HasPrice {

  public Part(Map<String, Object> properties) {
    super(properties);
  }

}
