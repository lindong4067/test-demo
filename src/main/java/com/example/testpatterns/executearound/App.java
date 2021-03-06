package com.example.testpatterns.executearound;

import java.io.FileWriter;
import java.io.IOException;

/**
 * The Execute Around idiom specifies some code to be executed before and after a method. Typically
 * the idiom is used when the API has methods to be executed in pairs, such as resource
 * allocation/deallocation or lock acquisition/release.
 * <p>
 * In this example, we have {@link SimpleFileWriter} class that opens and closes the FileNIO for the
 * user. The user specifies only what to do with the FileNIO by providing the {@link FileWriterAction}
 * implementation.
 *
 */
public class App {

  /**
   * Program entry point
   */
  public static void main(String[] args) throws IOException {

    new SimpleFileWriter("testfile.txt", writer -> {
      writer.write("Hello");
      writer.append(" ");
      writer.append("there!");
    });
  }
}
