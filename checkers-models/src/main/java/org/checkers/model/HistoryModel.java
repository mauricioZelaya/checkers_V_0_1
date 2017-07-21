package org.checkers.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.checkers.core.WriteFile;

/**
 * This class allow save the movements on a List of strings
 */
public class HistoryModel {

  private final List<String> history;


  public HistoryModel() {
    history = new ArrayList<>();
  }


  public void addMovement(String movement) {
    history.add(movement);
  }

  public List<String> getListMovements() {
    return history;
  }

  public boolean saveGameState(InterfaceMatrix matrix, File file){
    WriteFile writeFile = new WriteFile(file);

    int [][] matrixToSave = matrix.getMatrix();

    for(int row=0; row<=7; row++) {
      String rowString = "";

            for(int column=0; column<=7; column++) {
              rowString += matrixToSave[row][column] + ",";
            }

            writeFile.saveHistory(rowString);
            System.out.println(rowString);
        }

    return false;
  }
}