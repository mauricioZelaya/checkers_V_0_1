package org.checkers.core;

import java.util.ArrayList;
import java.util.List;

/**
 * This class allow save the movements on a List of strings
 */
public class HistoryMovents {

  private List<String> history;

  public HistoryMovents() {
    this.history = new ArrayList<String>();
  }


  public void addMovement(String movement) {
    this.history.add(movement);
  }

  public List<String> getListMovements() {
    return this.history;
  }
}
