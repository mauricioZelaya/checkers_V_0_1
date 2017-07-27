package org.checkers.model;

/**
 * This Interface defines the methods expected to come out from a Matrix implementation in order to properly manage it.
 * Extends the intermediate InterfaceObservable to avoid issues with the class that extends the Observable class.
 *
 * @author (Leonardo Antezana)
 * @version (July 2017)
 */
public interface InterfaceMatrix extends InterfaceObservable {
  /**
   * Sets the state of the internal matrix array to a specified one given by newMatrix.
   *
   * @newMatrix is an int matrix which can be mapped to the coordinates of a Board class. Holds game state. Where:
   * 0 = available spot/tile
   * 9 = illegal spot/tile (not available in game)
   * 1 = player 1 gamepiece
   * 2 = player 2 gamepiece
   * 3 = player 1 gamepiece crowned
   * 4 = player 2 gamepiece crowned
   */
  public void setMatrix(int newMatrix[][]);

  /**
   * This method retuns the matrix array of board states as an int matrix.
   */
  public int[][] getMatrix();

  /**
   * This method returns the value in the matrix array that corresponds to tileCoordinates.
   *
   * @tileCoordinates is a string holding the coordinates of a tile such as "B8".
   */
  public int getValueAtCoordinates(String tileCoordinates);

  /**
   * This method takes various coordinates and operates on them in the matrix array to change its state to reflect a gamepiece movement, and, if defined,
   * a piece capture.
   *
   * @fromTile string with board coordinates of the form "B8", origin tile.
   * @toTile string with board coordinates of the form "B8", destination tile.
   * @capturePieceAtTile string with board coordinates of the form "B8", captured piece tile, can be empty string to indicate a no-capture move.
   */
  public void moveGamePiece(String fromTile, String toTile);

  /**
   *  Took this method out of Move in order to make it single responsability.
   * @param capturePieceAtTile
   */

  public void captureGamePiece(String capturePieceAtTile);

  /**
   * This method provides the actual initialization of the matrix List with an initial default state. This way the call can trigger the
   * update of the observers. Setting it through the constructor didn't allow for the observer to be registered first.
   */
  public void initMatrixToDefaultState();

  /**
   * Initializes the Matrix to an empty state.
   */
  public void initMatrixToEmptyBoard();

  /**
   * This method returns the coordinates of the Tile in which a mouse's XY fall in. Instead of an Array scan it gets the Column/Row where the XY belong.
   */
  public String getCoordinatesAtXY(int x, int y);

  /**
   * Toggles a valid matrix value as "selected/unselected" (by multiplying/dividing 10), this will trigger the corresponding View update.
   */
  public void toggleSelectedGamePiece(String tileCoordinates);

  /**
   * Changes a valid matrix value into a "crowned" one (by adding 2), this will trigger the corresponding View update.
   */
  public void crownGamePiece(String tileCoordinates);

  /**
   *
   */
  public Boolean hasSelectedPiece();

  public int countPlayerGamePieces(int player);
}