package org.checkers.core;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class UtilsTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class UtilsTest
{
    @Test //there is a transformation
    public void testColumnRow11AreCoordinatesA8() {
        Utils utils = new Utils();
        assertEquals("A8", utils.coordinatesLiteral(1, 1));
    }

    @Test //there is a transformation
    public void testColumnOfA8Is1() {
        Utils utils = new Utils();
        assertEquals(1, utils.getColumn("A8"));
    }

    @Test //there is a transformation
    public void testRowOfA8Is1() {
        Utils utils = new Utils();
        assertEquals(1, utils.getRow("A8"));
    }

    @Test //there is a transformation
    public void testColumnRow88AreCoordinatesH1() {
        Utils utils = new Utils();
        assertEquals("H1", utils.coordinatesLiteral(8, 8));
    }

    @Test //there is a transformation
    public void testColumnOfH1Is8() {
        Utils utils = new Utils();
        assertEquals(8, utils.getColumn("H1"));
    }

    @Test //there is a transformation
    public void testRowOfH1Is8() {
        Utils utils = new Utils();
        assertEquals(8, utils.getRow("H1"));
    }
}