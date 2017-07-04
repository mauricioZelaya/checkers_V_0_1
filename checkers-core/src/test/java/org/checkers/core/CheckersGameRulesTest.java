package org.checkers.core;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 7/4/2017.
 */
public class CheckersGameRulesTest {
    /**
     * Unit test to validate that selected tile is empty
     */
    @Test
    public void movementIsValid() {
        CheckersGameRules checkerGame = new CheckersGameRules();
        int firstMatrix[][] = new int[8][8];
        firstMatrix[4][3] = 0;
        assertTrue(checkerGame.isEmptyTile(5, 2, firstMatrix));
    }

    /**
     * Validating is not possible move to an invalid tile
     */
    @Test
    public void movementIsInvalid() {
        CheckersGameRules checkerGame = new CheckersGameRules();
        int firstMatrix[][] = new int[8][8];
        firstMatrix[4][4] = 9;
        assertFalse(checkerGame.isEmptyTile(4, 4, firstMatrix));
    }

    @Test
    public void validDirectionNorth(){
        CheckersGameRules checkerGame = new CheckersGameRules();
        assertTrue(checkerGame.isValidDirection(1,5,6,4,7));
    }

    @Test
    public void validDirectionSouth(){
        CheckersGameRules checkerGame = new CheckersGameRules();
        assertTrue(checkerGame.isValidDirection(2,2,3,3,2));
    }

}