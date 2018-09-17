package com.example.testpatterns.doubledispatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * When a message with a parameter is sent to an object, the resultant behaviour is defined by the implementation of
 * that method in the receiver. Sometimes the behaviour must also be determined by the type of the parameter.
 * <p>
 * One way to implement this would be to create multiple instanceof-checks for the methods parameter. However, this
 * creates a maintenance issue. When new types are added we would also need to change the method's implementation and
 * add a new instanceof-check. This violates the single responsibility principle - a class should have only one reason
 * to change.
 * <p>
 * Instead of the instanceof-checks a better way is to make another virtual call on the parameter object. This way new
 * functionality can be easily added without the need to modify existing implementation (open-closed principle).
 * <p>
 * In this example we have hierarchy of objects ({@link GameObject}) that can collide to each other. Each object has its
 * own coordinates which are checked against the other objects' coordinates. If there is an overlap, then the objects
 * collide utilizing the Double Dispatch pattern.
 *
 */
public class App {

  private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

  /**
   * Program entry point
   * 
   * @param args
   *          command line args
   */
  public static void main(String[] args) {
    // initialize game objects and print their status
    List<GameObject> objects = new ArrayList<>();
    objects.add(new FlamingAsteroid(0, 0, 5, 5));
    objects.add(new SpaceStationMir(1, 1, 2, 2));
    objects.add(new Meteoroid(10, 10, 15, 15));
    objects.add(new SpaceStationIss(12, 12, 14, 14));
    objects.forEach(o -> LOGGER.info(o.toString()));
    LOGGER.info("");

    // collision check
    objects.forEach(o1 -> objects.forEach(o2 -> {
      if (o1 != o2 && o1.intersectsWith(o2)) {
        o1.collision(o2);
      }
    }));
    LOGGER.info("");

    // output eventual object statuses
    objects.forEach(o -> LOGGER.info(o.toString()));
    LOGGER.info("");
  }
}
