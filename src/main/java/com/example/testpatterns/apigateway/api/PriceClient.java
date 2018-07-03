package com.example.testpatterns.apigateway.api;

/**
 * An interface used to communicate with the Price microservice
 */
public interface PriceClient {
  String getPrice();
}
