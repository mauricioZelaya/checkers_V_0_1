package org.checkers.core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * ReadFile class
 */
public class ReadFile {

  /**
   * The Method read the file to get the info related steps and matrix
   *
   * @param filePath filePath
   * @return List<string> add a ned string with the infor realted to steps or matrix line</>
   */
  public List<String> ReadFiles(File filePath) {

    List<String> listString = new ArrayList<>();

    try {
      BufferedReader reader = new BufferedReader(new FileReader(filePath));

      String readLine;
      while ((readLine = reader.readLine()) != null) {
        listString.add(readLine);
      }

      reader.close();
    } catch (Exception e) {
      System.err.print(e.getMessage());
    }

    return listString;
  }
}
