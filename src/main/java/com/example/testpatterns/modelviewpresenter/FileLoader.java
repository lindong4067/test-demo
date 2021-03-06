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
package com.example.testpatterns.modelviewpresenter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Every instance of this class represents the Model component in the Model-View-Presenter
 * architectural pattern.
 * <p>
 * It is responsible for reading and loading the contents of a given FileNIO.
 */
public class FileLoader implements Serializable {

  /**
   * Generated serial version UID
   */
  private static final long serialVersionUID = -4745803872902019069L;
  
  private static final Logger LOGGER = LoggerFactory.getLogger(FileLoader.class);

  /**
   * Indicates if the FileNIO is loaded or not.
   */
  private boolean loaded;

  /**
   * The name of the FileNIO that we want to load.
   */
  private String fileName;

  /**
   * Loads the data of the FileNIO specified.
   */
  public String loadData() {
    String dataFileName = this.fileName;
    try (BufferedReader br = new BufferedReader(new FileReader(new File(dataFileName)))) {
      StringBuilder sb = new StringBuilder();
      String line;

      while ((line = br.readLine()) != null) {
        sb.append(line).append('\n');
      }

      this.loaded = true;

      return sb.toString();
    } catch (Exception e) {
      LOGGER.error("File {} does not exist", dataFileName);
    }

    return null;
  }

  /**
   * Sets the path of the FileNIO to be loaded, to the given value.
   * 
   * @param fileName The path of the FileNIO to be loaded.
   */
  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  /**
   * @return fileName The path of the FileNIO to be loaded.
   */
  public String getFileName() {
    return this.fileName;
  }

  /**
   * @return True, if the FileNIO given exists, false otherwise.
   */
  public boolean fileExists() {
    return new File(this.fileName).exists();
  }

  /**
   * @return True, if the FileNIO is loaded, false otherwise.
   */
  public boolean isLoaded() {
    return this.loaded;
  }
}
