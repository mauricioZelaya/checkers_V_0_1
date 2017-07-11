package org.checkers.core;

/**
 * Write a description of class Matrix here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Matrix {
    Utils utils;

    //indexes are row/column
    private int[][] matrix = {{9, 2, 9, 2, 9, 2, 9, 2},
        {2, 9, 2, 9, 2, 9, 2, 9},
        {9, 2, 9, 2, 9, 2, 9, 2},
        {0, 9, 0, 9, 0, 9, 0, 9},
        {9, 0, 9, 0, 0, 0, 9, 0},
        {1, 9, 1, 9, 1, 9, 1, 9},
        {9, 1, 9, 2, 9, 1, 9, 1},
        {1, 9, 1, 9, 1, 9, 1, 9}};

    public Matrix(){
        utils = new Utils();
    }

    //assemble thinking row/column indexes
    public void setMatrix(final int[]... newMatrix) {
      int[][] intermediateMatrix;
      intermediateMatrix = newMatrix;
      matrix = intermediateMatrix;
    }



    public int [][] getMatrix() {
      int[][] matrix2;
      matrix2 = matrix;
      return matrix2;
    }

    public int getValueAtCoordinates(String tileCoordinates) {
        return matrix[utils.getRow(tileCoordinates)-1][utils.getColumn(tileCoordinates)-1];
    }

    public void setValueAtCoordinates(String tileCoordinates, int value) {
        matrix[utils.getRow(tileCoordinates)-1][utils.getColumn(tileCoordinates)-1] = value;
    }
}

