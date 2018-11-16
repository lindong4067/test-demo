package com.example.testpatterns.tolerantreader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 
 * Tolerant Reader is an integration pattern that helps creating robust communication systems. The
 * idea is to be as tolerant as possible when reading data from another service. This way, when the
 * communication schema changes, the readers must not break.
 * <p>
 * In this example we use Java serialization to write representations of {@link RainbowFish} objects
 * to file. {@link RainbowFish} is the initial version which we can easily read and write using
 * {@link RainbowFishSerializer} methods. {@link RainbowFish} then evolves to {@link RainbowFishV2}
 * and we again write it to file with a method designed to do just that. However, the reader client
 * does not know about the new format and still reads with the method designed for V1 schema.
 * Fortunately the reading method has been designed with the Tolerant Reader pattern and does not
 * break even though {@link RainbowFishV2} has new fields that are serialized.
 *
 */
public class App {

  private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

  /**
   * Program entry point
   */
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    // Write V1
    RainbowFish fishV1 = new RainbowFish("Zed", 10, 11, 12);
    LOGGER.info("fishV1 name={} age={} length={} weight={}", fishV1.getName(),
        fishV1.getAge(), fishV1.getLengthMeters(), fishV1.getWeightTons());
    RainbowFishSerializer.writeV1(fishV1, "fish1.out");
    // Read V1
    RainbowFish deserializedFishV1 = RainbowFishSerializer.readV1("fish1.out");
    LOGGER.info("deserializedFishV1 name={} age={} length={} weight={}",
        deserializedFishV1.getName(), deserializedFishV1.getAge(),
        deserializedFishV1.getLengthMeters(), deserializedFishV1.getWeightTons());
    // Write V2
    RainbowFishV2 fishV2 = new RainbowFishV2("Scar", 5, 12, 15, true, true, true);
    LOGGER.info(
        "fishV2 name={} age={} length={} weight={} sleeping={} hungry={} angry={}",
        fishV2.getName(), fishV2.getAge(), fishV2.getLengthMeters(), fishV2.getWeightTons(),
        fishV2.getHungry(), fishV2.getAngry(), fishV2.getSleeping());
    RainbowFishSerializer.writeV2(fishV2, "fish2.out");
    // Read V2 with V1 method
    RainbowFish deserializedFishV2 = RainbowFishSerializer.readV1("fish2.out");
    LOGGER.info("deserializedFishV2 name={} age={} length={} weight={}",
        deserializedFishV2.getName(), deserializedFishV2.getAge(),
        deserializedFishV2.getLengthMeters(), deserializedFishV2.getWeightTons());
  }
}
