package org.checkers.core;

/**
 * Write a description of class Matrix here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Matrix {
    //indexes are row/column
    private int matrix[][] = {{9, 2, 9, 2, 9, 2, 9, 2},
            {2, 9, 2, 9, 2, 9, 2, 9},
            {9, 2, 9, 2, 9, 2, 9, 2},
            {0, 9, 0, 9, 0, 9, 0, 9},
            {9, 0, 9, 0, 0, 0, 9, 0},
            {1, 9, 1, 9, 1, 9, 1, 9},
            {9, 1, 9, 2, 9, 1, 9, 1},
            {1, 9, 1, 9, 1, 9, 1, 9}};

    Utils utils;

    public Matrix(){
        utils = new Utils();
    }

    //assemble thinking row/column indexes
    public void setMatrix(int newMatrix[][]) {
        matrix = newMatrix;
    }

    public int [][] getMatrix() {
        return(matrix);
    }

    public int getValueAtCoordinates(String tileCoordinates) {
        return(matrix[utils.getRow(tileCoordinates)-1][utils.getColumn(tileCoordinates)-1]);
    }

    public void setValueAtCoordinates(String tileCoordinates, int value) {
        matrix[utils.getRow(tileCoordinates)-1][utils.getColumn(tileCoordinates)-1] = value;
    }
}

