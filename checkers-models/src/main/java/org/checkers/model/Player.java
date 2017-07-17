package org.checkers.model;

/**
 * Created by Kenneth Perez on 7/10/2017.
 * This class  models the player and all its required attributes, also adding sets and gets to it.
 */
public class Player {

  private String name;
  private int code;
  private int chips;
  private boolean isTurn;

  public Player(int code) {
    name = "PlayerName";
    chips = 12;
    this.code = code;
    isTurn = false;
  }

  //Sets and gets

  public int GetChips() {
    return chips;
  }

  public void SetChips(int chips) {
    this.chips = chips;
  }

  public boolean IsTurn() {
    return isTurn;
  }

  public void SetTurn(boolean turn) {
    isTurn = turn;
  }

  public void SetName(String name) {
    this.name = name;
  }

  public String GetName() {
    return name;
  }

  public int GetCode() {
    return code;
  }

  public void SetCode(int code) {
    this.code = code;
  }

  /**
   * Method that decreases by 1 the amount of chips that a player has
   */
  public void DecreaseChip() {
    chips--;
  }

}

