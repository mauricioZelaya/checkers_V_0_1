package org.checkers.core;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * The WriteFile class contains the method necessary to write and save document
 */
public class WriteFile {
  /**
   * The method create a new document and write the info related row and column
   *
   * @param file  a file created to sabve the game
   * @param moves the movements performed in the game
   */
  public void saveHistory(File file, String moves) {
    if (file.exists()) {
      writeFile(file, moves);
    }
  }

  /**
   * The method write the row and column values in the file
   *
   * @param file  a file created to sabve the game
   * @param moves the movements performed in the game
   */
  private void writeFile(File file, String infoToWrite) {

    FileWriter writer;
    PrintWriter line;

    try {
      writer = new FileWriter(file, true);
      line = new PrintWriter(writer);

      line.println(infoToWrite);
      line.close();
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * The method clear the contain in the Document
   *
   * @param file recive the file
   */
  public void clearFile(File file) {
    FileWriter writer;
    PrintWriter line;

    if (!file.exists()) {
      try {
        writer = new FileWriter(file, true);
        line = new PrintWriter(writer);
        line.flush();
        line.close();
        writer.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
