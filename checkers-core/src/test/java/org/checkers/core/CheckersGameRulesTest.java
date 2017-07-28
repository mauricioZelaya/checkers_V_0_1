package org.checkers.core;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 7/4/2017.
 */
public class CheckersGameRulesTest {

    private CheckersGameRules checkerGame;
    private int firstMatrix[][];
    private int row;
    private int col;
    private int playerNumber;

    /**
     * initial settings needed along the execution of all unit tests
     */
    @Before
    public void initialSettings(){
        checkerGame = new CheckersGameRules();
        firstMatrix = new int[8][8];
    }

    /**
     * Unit test to validate that selected tile is empty
     */
    @Test
    public void movementIsValid() {
        firstMatrix[4][3] = 0;
        assertTrue(checkerGame.isEmptyTile(5, 2, firstMatrix));
    }

    /**
     * Validating is not possible move to an invalid tile
     */
    @Test
    public void movementIsInvalid() {
        firstMatrix[4][4] = 9;
        assertFalse(checkerGame.isEmptyTile(4, 4, firstMatrix));
    }

    /**
     * validating  direction of movement of player 1
     */
    @Test
    public void validDirectionNorth(){
        assertTrue(checkerGame.isValidDirection(10,7,6));
    }

    /**
     * validating  direction of movement of player 2
     */
    @Test
    public void validDirectionSouth(){
        assertTrue(checkerGame.isValidDirection(20,2,3));
    }

    /**
     * Validating that selected tile is a valid tile
     */
    @Test
    public void validTile(){
        assertTrue(checkerGame.isValidTile(0));
    }

    /**
     * Validating that selected tile is an invalid tile
     */
    @Test
    public void invalidTile(){
        assertFalse(checkerGame.isValidTile(9));
    }

    @Test
    public void crownToTheChip(){
        playerNumber = 2;
        row = 0;
        assertTrue(checkerGame.crownTheChip(playerNumber, row));
    }

    @Test
    public void aChipIsEatableByOpponent(){
        int player = 1;
        row = 5;
        col = 2;
        firstMatrix[5][2] = 1;
        firstMatrix[4][3] = 2;
        firstMatrix[3][4] = 0;
        assertTrue(checkerGame.killOpponent(row, col, firstMatrix, player));
    }

    @Test
    public void theChipIsACrownedChip(){
        int tileValue = 3;
        assertTrue(checkerGame.isCrownedChip(tileValue));
    }

    @Test
    public void aCrownedChipIsAbleToMoveInAnyDirection(){
        row = 4;
        col = 3;
        firstMatrix[5][2] = 1;
        firstMatrix[5][4] = 1;
        firstMatrix[3][2] = 2;
        firstMatrix[3][4] = 0;
        assertTrue(checkerGame.crownedValidMove(row, col, firstMatrix));
    }

    @Test
    public void isThePlayerTurn(){
        int playerTurn = 1;
        assertTrue(checkerGame.playerTurn(playerTurn));
    }

    @Test
    public void crownedChipEatOpponentChip(){
        row = 3;
        col = 4;
        firstMatrix[2][5] = 2;
        firstMatrix[3][4] = 3;
        firstMatrix[1][6] = 0;
        assertTrue(checkerGame.crownedKillOpponent(row, col, firstMatrix));
    }
}
