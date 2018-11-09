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
package com.example.testpatterns.specification.creature;


import com.example.testpatterns.specification.property.Color;
import com.example.testpatterns.specification.property.Movement;
import com.example.testpatterns.specification.property.Size;

/**
 * 
 * Base class for concrete creatures.
 *
 */
public abstract class AbstractCreature implements Creature {

  private String name;
  private Size size;
  private Movement movement;
  private Color color;

  /**
   * Constructor
   */
  public AbstractCreature(String name, Size size, Movement movement, Color color) {
    this.name = name;
    this.size = size;
    this.movement = movement;
    this.color = color;
  }

  @Override
  public String toString() {
    return String.format("%s [size=%s, movement=%s, color=%s]", name, size, movement, color);
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public Size getSize() {
    return size;
  }

  @Override
  public Movement getMovement() {
    return movement;
  }

  @Override
  public Color getColor() {
    return color;
  }
}
