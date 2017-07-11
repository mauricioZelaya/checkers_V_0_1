package org.checkers.core;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MatrixTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MatrixTest
{
    @Test
    public void testValueAtCoordinatesA7Is2() {
        Matrix matrix = new Matrix();
        assertEquals(2, matrix.getValueAtCoordinates("A7"));
    }

    @Test
    public void testValueAtCoordinatesG1Is1() {
        Matrix matrix = new Matrix();
        assertEquals(1, matrix.getValueAtCoordinates("G1"));
    }

    @Test
    public void testValueAtCoordinatesE4Is0() {
        Matrix matrix = new Matrix();
        assertEquals(0, matrix.getValueAtCoordinates("E4"));
    }

    @Test
    public void testValueChangedAtA1Is2() {
        Matrix matrix = new Matrix();
        matrix.setValueAtCoordinates("A1", 2);
        assertEquals(2, matrix.getValueAtCoordinates("A1"));
    }
}