package com.example.testpatterns.abstractdocument.domain;

import com.example.testpatterns.abstractdocument.Document;

import java.util.Optional;

/**
 * HasModel trait for static access to 'model' property
 */
public interface HasModel extends Document {

  String PROPERTY = "model";

  default Optional<String> getModel() {
    return Optional.ofNullable((String) get(PROPERTY));
  }

}
