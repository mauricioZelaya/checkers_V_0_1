package org.checkers.core;

/**
 * Created by Administrator on 7/4/2017.
 */
public interface IBoardGamesRules {
    boolean isEmptyTile(int row, int col, int matrix[][]);
    boolean isValidDirection(int playerChip, int initRow, int initCol, int endRow, int endCol);
}
