package org.checkers.core;

import java.util.ArrayList;
import java.util.List;

import java.util.Observable;

/**
 * This Matrix class is the manager of the "state" of a Board in order to help with rules validation. It implements an InterfaceMatrix.
 *
 * The internal use of a List to represent the integer matrix was deemed a better approach, and helped avoid various CheckStyle problems.
 *
 * Update: Was made an Observable class so that the View (Board) can update on its own.
 *
 * @author (Leonardo Antezana)
 * @version (July 2017)
 */
public class Matrix extends Observable implements InterfaceMatrix{
    //indexes are row/column
    private final int[][] defaultBoardState = {{9, 2, 9, 2, 9, 2, 9, 2},
                                               {2, 9, 2, 9, 2, 9, 2, 9},
                                               {9, 2, 9, 2, 9, 2, 9, 2},
                                               {0, 9, 0, 9, 0, 9, 0, 9},
                                               {9, 0, 9, 0, 9, 0, 9, 0},
                                               {1, 9, 1, 9, 1, 9, 1, 9},
                                               {9, 1, 9, 1, 9, 1, 9, 1},
                                               {1, 9, 1, 9, 1, 9, 1, 9}};

    private List<Integer> matrix;

    public Matrix(){
        matrix = new ArrayList<>();
    }

    /**
     * This method provides the actual initialization of the matrix List with an initial default state. This way the call can trigger the
     * update of the observers.
     */
    public void initMatrixToDefaultState() {
        setMatrix(defaultBoardState);
        setChanged(); //set change has been done for observers
        notifyObservers(getMatrix()); //notify observers of change and send matrix new state
    }

    /**
     * Initializes the Matrix array with the values of an integer matrix. It receives the default board state when used in the Constructor.
     */
    public void setMatrix(int[][] newMatrix) {
        for(int row=0; row<=7; row++) {
            for(int column=0; column<=7; column++) {
                matrix.add(newMatrix[row][column]);
            }
        }
    }

    /**
     * Returns the value at tileCoordinates. Transforms coordinates from the Board into an array index to
     * get the desired value of the Matrix array.
     */
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
    public void toggleSelectedGamePiece(String tileCoordinates) {
        int originalValue = getValueAtCoordinates(tileCoordinates);
        if(originalValue != 0 && originalValue !=9) {
            setValueAtCoordinates(tileCoordinates, (originalValue >= 10? originalValue / 10: originalValue * 10));
            setChanged();
            notifyObservers(getMatrix());
        }

    }

    /**
     * Changes a valid matrix value into a "crowned" one (by adding 2), this will trigger the corresponding View update.
     */
    public void crownGamePiece(String tileCoordinates) {
        int originalValue = getValueAtCoordinates(tileCoordinates);
        if(originalValue == 1 || originalValue ==2) {
            setValueAtCoordinates(tileCoordinates, originalValue+2);
            setChanged();
            notifyObservers(getMatrix());
        }
    }

    /**
     * This method handles the state change of the matrix array. This state will be reflected in the Board.
     */
    public void moveGamePiece(String fromTile, String toTile, String capturePieceAtTile) {
       int movingPiece;
       movingPiece = getValueAtCoordinates(fromTile);
       setValueAtCoordinates(fromTile, 0);
       setValueAtCoordinates(toTile, movingPiece);
       if(!capturePieceAtTile.equals("")) {
           setValueAtCoordinates(capturePieceAtTile, 0);
        }
       setChanged();
       notifyObservers(getMatrix());
    }

    /**
     * This method returns the internal Array as an int matrix.
     */
    public int [][] getMatrix() {
        int[][] newMatrix = new int[8][8];
        for(int row=0; row<=7; row++) {
            for(int column=0; column<=7; column++) {
                newMatrix[row][column] = getValueAtCoordinates(Utils.coordinatesFromColRow(column+1, row+1));
                matrix.add(newMatrix[row][column]);
            }
        }
        return newMatrix;
    }

   /**
    * This method returns the coordinates of the Tile in which a mouse's XY fall in. Instead of an Array scan it gets the Column/Row where the XY belong.
    * Note: Coordinates are returned without validation.
    */
   public String getCoordinatesAtXY(int x, int y) {
       int tileWidth = 50;
       String coordinates;
       int column = (int)((x-tileWidth/2) / tileWidth);
       int row = (int)((y-tileWidth/2) / tileWidth);
       return Utils.coordinatesFromColRow(column, row);
    }

    public void printMatrix() {
        for(int i=0; i<=63; i++) {
            if(matrix.get(i) != 9) {
                System.out.print((matrix.get(i) + " "));
            }
            else {
                System.out.print("_ ");
            }
            if(((i+1) % 8) ==0) {
                System.out.println();
            }
        }
    }
}

