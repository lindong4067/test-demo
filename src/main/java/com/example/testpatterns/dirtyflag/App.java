package com.example.testpatterns.dirtyflag;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * This application demonstrates the <b>Dirty Flag</b> pattern. The dirty flag behavioral pattern allows you to avoid
 * expensive operations that would just need to be done again anyway. This is a simple pattern that really just explains
 * how to add a bool value to your class that you can set anytime a property changes. This will let your class know that
 * any results it may have previously calculated will need to be calculated again when they’re requested. Once the
 * results are re-calculated, then the bool value can be cleared.
 * 
 * There are some points that need to be considered before diving into using this pattern:- there are some things you’ll
 * need to consider:- (1) Do you need it? This design pattern works well when the results to be calculated are difficult
 * or resource intensive to compute. You want to save them. You also don’t want to be calculating them several times in
 * a row when only the last one counts. (2) When do you set the dirty flag? Make sure that you set the dirty flag within
 * the class itself whenever an important property changes. This property should affect the result of the calculated
 * result and by changing the property, that makes the last result invalid. (3) When do you clear the dirty flag? It
 * might seem obvious that the dirty flag should be cleared whenever the result is calculated with up-to-date
 * information but there are other times when you might want to clear the flag.
 *
 * In this example, the {@link DataFetcher} holds the <i>dirty flag</i>. It fetches and re-fetches from <i>world.txt</i>
 * when needed. {@link World} mainly serves the data to the front-end.
 */
public class App {
  /**
   * Program execution point
   */
  public void run() {

    final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    executorService.scheduleAtFixedRate(() -> {
      World world = new World();
      List<String> countries = world.fetch();
      System.out.println("Our world currently has the following countries:-");
      for (String country : countries) {
        System.out.println("\t" + country);
      }
    }, 0, 15, TimeUnit.SECONDS); // Run at every 15 seconds.
  }

  /**
   * Program entry point
   *
   * @param args
   *          command line args
   */
  public static void main(String[] args) {
    App app = new App();

    app.run();
  }

}
