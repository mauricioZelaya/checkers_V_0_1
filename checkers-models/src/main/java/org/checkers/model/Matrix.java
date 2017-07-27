package org.checkers.model;

import java.util.ArrayList;
import java.util.List;

import java.util.Observable;

import org.checkers.core.Utils;

/**
 * This Matrix class is the manager of the "state" of a Board in order to help with rules validation. It implements an InterfaceMatrix.
 * <p>
 * The internal use of a List to represent the integer matrix was deemed a better approach, and helped avoid various CheckStyle problems.
 * <p>
 * Update: Was made an Observable class so that the View (Board) can update on its own.
 *
 * @author (Leonardo Antezana)
 * @version (July 2017)
 */
public class Matrix extends Observable implements InterfaceMatrix {
  //indexes are row/column
  private final int[][] defaultBoardState = {{9, 2, 9, 2, 9, 2, 9, 2},
          {2, 9, 2, 9, 2, 9, 2, 9},
          {9, 2, 9, 2, 9, 2, 9, 2},
          {0, 9, 0, 9, 0, 9, 0, 9},
          {9, 0, 9, 0, 9, 0, 9, 0},
          {1, 9, 1, 9, 1, 9, 1, 9},
          {9, 1, 9, 1, 9, 1, 9, 1},
          {1, 9, 1, 9, 1, 9, 1, 9}};

  private final int[][] nullBoardState = {{9, 0, 9, 0, 9, 0, 9, 0},
          {0, 9, 0, 9, 0, 9, 0, 9},
          {9, 0, 9, 0, 9, 0, 9, 0},
          {0, 9, 0, 9, 0, 9, 0, 9},
          {9, 0, 9, 0, 9, 0, 9, 0},
          {0, 9, 0, 9, 0, 9, 0, 9},
          {9, 0, 9, 0, 9, 0, 9, 0},
          {0, 9, 0, 9, 0, 9, 0, 9}};

  private List<Integer> matrix;

  private Boolean coordinateSelected;

  public Matrix() {
    matrix = new ArrayList<>();
    coordinateSelected = false;
  }

  /**
   * This method provides the actual initialization of the matrix List with an initial default state. This way the call can trigger the
   * update of the observers.
   */
  @Override
  public void initMatrixToDefaultState() {
    setMatrix(defaultBoardState);
  }

  /**
   * Initializes the Matrix to an empty state.
   */
  @Override
  public void initMatrixToEmptyBoard() {
    setMatrix(nullBoardState);
  }

  /**
   * This method will trigger the change notice and update call to all registered observers.
   */
  private void informObservers(int[][] newMatrix) {
    setChanged(); //set change has been done for observers
    notifyObservers(newMatrix); //notify observers of change and send matrix new state
  }

  private void informObservers() {
    setChanged(); //set change has been done for observers
    notifyObservers(getMatrix()); //notify observers of change and send matrix new state
  }

  /**
   * Initializes the Matrix array with the values of an integer matrix. It receives the default board state when used in the Constructor.
   * The clear was added to "reinitialize" the array after New and Load methods get called from other controllers.
   */
  @Override
  public void setMatrix(int[][] newMatrix) {
    matrix.clear();
    for (int row = 0; row <= 7; row++) {
      for (int column = 0; column <= 7; column++) {
        matrix.add(newMatrix[row][column]);
      }
    }
    informObservers(newMatrix);
  }

  /**
   * This method returns the internal Array as an int matrix.
   */
  @Override
  public int[][] getMatrix() {
    int count = 0;
    int[][] newMatrix = new int[8][8];
    for (int row = 0; row <= 7; row++) {
      for (int column = 0; column <= 7; column++) {
        newMatrix[row][column] = getValueAtCoordinates(Utils.coordinatesFromColRow(column + 1, row + 1));
      }
    }
    return newMatrix;
  }

  /**
   * Returns the value at tileCoordinates. Transforms coordinates from the Board into an array index to
   * get the desired value of the Matrix array.
   */
  @Override
  public int getValueAtCoordinates(String tileCoordinates) {
    return matrix.get(Utils.seekTileIndex(tileCoordinates, 8));
  }

  /**
   * Sets the value at tileCoordiantes. This method is transforming the coordinates from the Board into an array index to set the desired value.
   */
  public void setValueAtCoordinates(String tileCoordinates, int value) {
    matrix.set(Utils.seekTileIndex(tileCoordinates, 8), value);
  }

  /**
   * Toggles a valid matrix value as "selected/unselected" (by multiplying/dividing 10), this will trigger the corresponding View update.
   */
  @Override
  public void toggleSelectedGamePiece(String tileCoordinates) {
    int originalValue = getValueAtCoordinates(tileCoordinates);
    if (originalValue != 0 && originalValue != 9) {
      setValueAtCoordinates(tileCoordinates, (originalValue >= 10 ? originalValue / 10 : originalValue * 10));
      coordinateSelected = !coordinateSelected;
      informObservers();
    }
  }

  /**
   * @return boolean based on internal data.
   */
  @Override
  public Boolean hasSelectedPiece() {
    return coordinateSelected;
  }

  /**
   * Changes a valid matrix value into a "crowned" one (by adding 2), this will trigger the corresponding View update.
   */
  @Override
  public void crownGamePiece(String tileCoordinates) {
    int originalValue = getValueAtCoordinates(tileCoordinates);
    if (originalValue == 1 || originalValue == 2) {
      setValueAtCoordinates(tileCoordinates, originalValue + 2);
      informObservers();
    }
  }

  /**
   * This method handles the state change of the matrix array. This state will be reflected in the Board.
   */
  @Override
  public void moveGamePiece(String fromTile, String toTile) {
    int movingPiece;
    movingPiece = getValueAtCoordinates(fromTile);
    setValueAtCoordinates(fromTile, 0);
    setValueAtCoordinates(toTile, movingPiece);
    informObservers();
  }

  /**
   *  Took this method out of Move in order to make it single responsability.
   * @param capturePieceAtTile coordinates for tile to capture
   */
  @Override
  public void captureGamePiece(String capturePieceAtTile) {
    setValueAtCoordinates(capturePieceAtTile, 0);
    informObservers();
  }

  @Override
  public int countPlayerGamePieces(int player) {
    int countGamePieces = 0;
    for(int index = 0; index <= 63; index++) {
      if(matrix.get(index)==player) {
        countGamePieces++;
      }
    }
    return countGamePieces;
  }



  /**
   * This method returns the coordinates of the Tile in which a mouse's XY fall in. Instead of an Array scan it gets the Column/Row where the XY belong.
   * Note: Coordinates are returned without validation.
   */
  @Override
  public String getCoordinatesAtXY(int x, int y) {
    int tileWidth = 50;
    String coordinates;
    int column = (int) ((x - tileWidth / 2) / tileWidth);
    int row = (int) ((y - tileWidth / 2) / tileWidth);
    return Utils.coordinatesFromColRow(column, row);
  }

  public void printMatrix() {
    for (int i = 0; i <= 63; i++) {
      if (matrix.get(i) != 9) {
        System.out.print(matrix.get(i) + " ");
      } else {
        System.out.print("_ ");
      }
      if (((i + 1) % 8) == 0) {
        System.out.println();
      }
    }
    System.out.println();
  }
}

