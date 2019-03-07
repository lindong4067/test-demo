package com.example.testpatterns.executearound;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * SimpleFileWriter handles opening and closing FileNIO for the user. The user only has to specify what
 * to do with the FileNIO resource through {@link FileWriterAction} parameter.
 *
 */
public class SimpleFileWriter {

  /**
   * Constructor
   */
  public SimpleFileWriter(String filename, FileWriterAction action) throws IOException {
    try (FileWriter writer = new FileWriter(filename)) {
      action.writeFile(writer);
    }
  }
}
