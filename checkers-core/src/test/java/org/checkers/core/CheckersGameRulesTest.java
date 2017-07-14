package org.checkers.core;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 7/4/2017.
 */
public class CheckersGameRulesTest {

    private CheckersGameRules checkerGame;

    @Before
    public void initialSettings(){
        checkerGame = new CheckersGameRules();
    }

    /**
     * Unit test to validate that selected tile is empty
     */
    @Test
    public void movementIsValid() {
        int firstMatrix[][] = new int[8][8];
        firstMatrix[4][3] = 0;
        assertTrue(checkerGame.isEmptyTile(5, 2, firstMatrix));
    }

    /**
     * Validating is not possible move to an invalid tile
     */
    @Test
    public void movementIsInvalid() {
        int firstMatrix[][] = new int[8][8];
        firstMatrix[4][4] = 9;
        assertFalse(checkerGame.isEmptyTile(4, 4, firstMatrix));
    }

    /**
     * validating  direction of movement of player 1
     */
    @Test
    public void validDirectionNorth(){
        assertTrue(checkerGame.isValidDirection(1,6,7));
    }

    /**
     * validating  direction of movement of player 2
     */
    @Test
    public void validDirectionSouth(){
        assertTrue(checkerGame.isValidDirection(2,3,2));
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
        int playerNumber = 2;
        int row = 0;
        assertTrue(checkerGame.crownedChip(playerNumber, row));
    }

    @Test
    public void aChipIsEatableByOpponent(){
        int row = 5;
        int col = 2;
        int firstMatrix[][] = new int[8][8];
        firstMatrix[5][2] = 1;
        firstMatrix[4][3] = 2;
        firstMatrix[3][4] = 0;
        assertTrue(checkerGame.killOpponent(row, col, firstMatrix));
    }

}