package org.checkers.core;



/**
 * Created by Mauricio Zelaya on 7/4/2017.
 */
public class CheckersGameRules implements IBoardGamesRules {
  @Override
  public boolean isEmptyTile(int row, int col, int[][] matrix) {

    return matrix[row][col] == 0;
  }

  @Override
  public boolean isValidDirection(int playerChip, int initRow, int endRow) {
    if (playerChip == 10) {
      return toNorth(initRow, endRow);
    }
    if (playerChip == 20) {
      return toSouth(initRow, endRow);
    }
    return false;
  }

  @Override
  public boolean isValidTile(int tileValue) {
    return tileValue == 0;
  }

  /**
   * @param playerNumber - player whom the chip belongs
   * @param row          - row where chip is positioned
   * @return - return true if chip will be crowned
   */
  @Override
  public boolean crownTheChip(int playerNumber, int row) {
    return (playerNumber == 1 && row == 7) || (playerNumber == 2 && row == 0);
  }

  @Override
  public boolean killOpponent(int initRow, int initCol, int [][] matrix, int player) {
    return chipInFront(initRow, initCol, matrix, player);// && (isValidTile(matrix[initRow - 2][initCol + 2]) || isValidTile(matrix[initRow - 2][initCol - 2]));
  }

  @Override
  public boolean crownedKillOpponent(int initRow, int initCol, int[][] matrix) {
    int playerChip = matrix[initRow][initCol];
    return chipAround(initRow, initCol, playerChip, matrix) && validTileAround(initRow, initCol, matrix);
  }

  @Override
  public boolean isCrownedChip(int tileValue) {
    return tileValue == 3 || tileValue == 4;
  }

  @Override
  public boolean crownedValidMove(int row, int col, int[][] matrix) {
    return matrix[row + 1][col + 1] == 0 || matrix[row + 1][col - 1] == 0 || matrix[row - 1][col + 1] == 0 || matrix[row - 1][col - 1] == 0;
  }

  @Override
  public boolean playerTurn(int playerTurn) {
    return playerTurn == 1;
  }

  private boolean chipInFront(int initRow, int initCol, int [][]matrix, int player) {

    int limitCol = initCol < 7 && initCol > 0 ? 1 : 0;
    if (player == 1) {
      return (matrix[initRow - 1][initCol + limitCol] == 2) || (matrix[initRow - 1][initCol - limitCol] == 2);
    }
    return (matrix[initRow + 1][initCol + limitCol] == 1) || (matrix[initRow + 1][initCol - limitCol] == 1);
  }


  /**
   * @param initRow - initial row where chip is situated
   * @param endRow  - final row where chip wants to go
   * @return boolean value according the evaluation
   */
  private boolean toSouth(int initRow, int endRow) {
    return initRow < endRow;
  }

  private boolean toNorth(int initRow, int endRow) {
    return initRow > endRow;
  }

  private boolean validTileAround(int initRow, int initCol, int[][] matrix) {
    return matrix[initRow+2][initCol+2] == 0 || matrix[initRow+2][initCol-2] == 0 || matrix[initRow-2][initCol+2] == 0 || matrix[initRow-2][initCol-2] == 0;
  }

  private boolean chipAround(int initRow, int initCol, int playerChip, int[][] matrix) {
    if(playerChip == 3)
      if (matrix[initRow + 1][initCol + 1] == 2 || matrix[initRow + 1][initCol + 1] == 4 || matrix[initRow - 1][initCol + 1] == 2 || matrix[initRow - 1][initCol + 1] == 4 || matrix[initRow + 1][initCol - 1] == 2 || matrix[initRow + 1][initCol - 1] == 4 || matrix[initRow - 1][initCol - 1] == 2 || matrix[initRow - 1][initCol - 1] == 4)
        return true;
    if(playerChip == 4)
      if (matrix[initRow + 1][initCol + 1] == 1 || matrix[initRow + 1][initCol + 1] == 3 || matrix[initRow - 1][initCol + 1] == 1 || matrix[initRow - 1][initCol + 1] == 3 || matrix[initRow + 1][initCol - 1] == 1 || matrix[initRow + 1][initCol - 1] == 3 || matrix[initRow - 1][initCol - 1] == 1 || matrix[initRow - 1][initCol - 1] == 3)
        return true;
    return false;
  }

}