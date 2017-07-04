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
    public boolean isValidDirection(int playerChip, int initRow, int initCol, int endRow, int endCol) {
        if(playerChip==1){
            return toNorth(initRow, initCol, endRow, endCol);
        }
        else if(playerChip==2){
            return toSouth(initRow, initCol, endRow, endCol);
        }
        return false;
    }

    private boolean toSouth(int initRow, int initCol, int endRow, int endCol) {
        if(initRow+1==endRow && (initCol-1==endCol||initCol+1==endCol))
            return true;
        return false;
    }

    private boolean toNorth(int initRow, int initCol, int endRow, int endCol) {
        if(initRow-1==endRow && (initCol-1==endCol||initCol+1==endCol))
            return true;
        return false;
    }
}
