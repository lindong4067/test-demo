package com.example.testpatterns.executearound;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * Interface for specifying what to do with the FileNIO resource.
 *
 */
public interface FileWriterAction {

  void writeFile(FileWriter writer) throws IOException;

}
