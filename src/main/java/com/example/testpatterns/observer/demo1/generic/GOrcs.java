/**
 * The MIT License
 * Copyright (c) 2014-2016 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.example.testpatterns.observer.demo1.generic;

import com.example.testpatterns.observer.demo1.WeatherType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * GOrcs
 *
 */
public class GOrcs implements Race {

  private static final Logger LOGGER = LoggerFactory.getLogger(GOrcs.class);

  @Override
  public void update(GWeather weather, WeatherType weatherType) {
    onUpdate(weatherType, LOGGER);
  }

  public static void onUpdate(WeatherType weatherType, Logger logger) {
    switch (weatherType) {
      case COLD:
        logger.info("The orcs are freezing cold.");
        break;
      case RAINY:
        logger.info("The orcs are dripping wet.");
        break;
      case SUNNY:
        logger.info("The sun hurts the orcs' eyes.");
        break;
      case WINDY:
        logger.info("The orc smell almost vanishes in the wind.");
        break;
      default:
        break;
    }
  }
}
