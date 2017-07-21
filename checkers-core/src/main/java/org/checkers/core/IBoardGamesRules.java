package org.checkers.core;

/**
 * Created by Mauricio Zelaya on 7/4/2017.
 */
public interface IBoardGamesRules {
    boolean isEmptyTile(int row, int col, int matrix[][]);
    boolean isValidDirection(int playerChip, int initRow, int endRow);
    boolean isValidTile(int tileValue);
    boolean crownTheChip(int playerNumber, int row);
    boolean killOpponent(int initRow, int initCol, int[][] matrix);
    boolean crownedKillOpponent(int initRow, int initCol, int[][] matrix);
    boolean isCrownedChip(int tileValue);
    boolean crownedValidMove(int row, int col, int[][] matrix);
    boolean playerTurn(int playerTurn);
}