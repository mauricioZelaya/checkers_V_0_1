package org.checkers.core;

/**
 * Created by Administrator on 7/4/2017.
 */
public class CheckersGameRules implements IBoardGamesRules {

    @Override
    public boolean isEmptyTile(int row, int col, int[][] matrix) {
        return matrix[row][col] == 0 ? true:false;
    }

    @Override
    public boolean isValidDirection(int playerChip, int initRow, int endRow) {
        if(playerChip==1){
            return toNorth(initRow, endRow);
        }
        else if(playerChip==2){
            return toSouth(initRow, endRow);
        }
        return false;
    }

    @Override
    public boolean isValidTile(int tileValue) {
        if(tileValue==0){
            return true;
        }
        return false;
    }

    private boolean toSouth(int initRow, int endRow) {
        if(initRow>endRow) {
            return true;
        }
        return false;
    }

    private boolean toNorth(int initRow, int endRow) {
        if(initRow<endRow) {
            return true;
        }
        return false;
    }
}
