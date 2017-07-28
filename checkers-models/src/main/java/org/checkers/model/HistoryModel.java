package org.checkers.model;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Observable;

import org.checkers.core.ReadFile;
import org.checkers.core.WriteFile;

/**
 * This class allow save the movements on a List of strings
 */
public class HistoryModel extends Observable {

  private List<String> history;
  private ListIterator<String> historyIterator;
  private WriteFile writeFile;

  public HistoryModel() {
    history = new ArrayList<>();
  }


  public void addMovement(String movement) {
    history.add(movement);
  }

  public List<String> getListMovements() {
    return history;
  }

  /**
   * This method save the last game state in a file
   * @param matrix InterfaceMatrix
   * @param file file create in the Menu
   */
  public void saveGameState(InterfaceMatrix matrix, File file){
    writeFile = new WriteFile(file);

    int [][] matrixToSave = matrix.getMatrix();

    for(int row=0; row<=7; row++) {
      String rowString = "";

            for(int column=0; column<=7; column++) {
              rowString += matrixToSave[row][column] + ",";
            }

            writeFile.saveHistory(rowString);
            System.out.println(rowString);
        }
  }

  /**
   * This method clear the file content
   * @param file file select in the Menu
   */
  public void clearExistFile(File file){
    writeFile = new WriteFile(file);
    writeFile.clearFile();
  }

  /**
   * This method recive the File selected in the Menu and create an array of integers
   * @param matrix intefaceMatrix
   * @param file recive the file selected in the Menu
   * @return a new array matrix.
   */
  public  int[][]  loadGameState(InterfaceMatrix matrix, File file){
    ReadFile read = new ReadFile();
    List<String> loadFileRows = read.ReadFiles(file);
    return read.getLoadFile(loadFileRows);
  }

  /**
   * All movements will be written on selected file
   */
  public void saveGameReplay(File file) {
    writeFile = new WriteFile(file);
    for(String row : history){
      writeFile.saveHistory(row);
    }
  }

  /**
   * Recover all movements from a file
   */
  public void loadGameReplay(File file) {
    ReadFile read = new ReadFile();
    history.clear();
    history = read.ReadFiles(file);
    historyIterator = history.listIterator();
    setChanged();
    notifyObservers(true);
  }

  /**
   * Returns a movement into a list, this method will look for a movement into history through
   * parameter position and the movement will be splitted on strings.
   */
  public String getFordwardMovement(){
    if(historyIterator.hasNext()) {
      return historyIterator.next();
    }
    return "None";
  }

  public boolean historyHasMovements(){
    return historyIterator.hasNext();
  }

}