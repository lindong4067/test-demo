package com.example.testpatterns.abstractdocument.domain;

import com.example.testpatterns.abstractdocument.Document;

import java.util.Optional;

/**
 * HasPrice trait for static access to 'priceservice' property
 */
public interface HasPrice extends Document {

  String PROPERTY = "priceservice";

  default Optional<Number> getPrice() {
    return Optional.ofNullable((Number) get(PROPERTY));
  }

}
