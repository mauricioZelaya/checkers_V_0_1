package org.checkers.model;

/**
 * Write a description of interface InterfaceBoard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface InterfaceBoard
{
    /**
     * Initializes the board with Piece positions as defined by "matrix".
     */
    void placePieces(int matrix[][]);

    /**
     * Given "tileCoordinates" it toggles it to selected/deselected.
     */
    public void toggleGamePieceState(String tileCoordinates);

    /**
     * Moves a GamePiece "fromTile" "toTile", if "capturePieceAtTile" is not empty it deletes tiles given in its coordinates
     */
    public void moveGamePiece(String fromTile, String toTile, String capturePieceAtTile);

    /**
     * Given column and row by indexes "x" "y" this method returns it in the coordinates of the Board as "A5", for example
     */
    public String getCoordinatesAtXY(int x, int y);

    /**
     * Checks that a captured mouse event has XY coordinates within the board area.
     */
    public Boolean clickIsInsideBoard(int x, int y);
}

