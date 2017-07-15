package org.checkers.core;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the Utils class methods.
 *
 * @author  (Leonardo Antezana)
 * @version (July 2017)
 */

public class UtilsTest
{
    @Test //there is a transformation
    public void testColumnRow11AreCoordinatesA8() {
        assertEquals("A8", Utils.coordinatesFromColRow(1, 1));
    }

    @Test //there is a transformation
    public void testColumnOfA8Is1() {
        assertEquals(1, Utils.getColumn("A8"));
    }

    @Test //there is a transformation
    public void testRowOfA8Is1() {
        assertEquals(1, Utils.getRow("A8"));
    }

    @Test //there is a transformation
    public void testColumnRow88AreCoordinatesH1() {
        assertEquals("H1", Utils.coordinatesFromColRow(8, 8));
    }

    @Test //there is a transformation
    public void testColumnOfH1Is8() {
        assertEquals(8, Utils.getColumn("H1"));
    }

    @Test //there is a transformation
    public void testRowOfH1Is8() {
        assertEquals(8, Utils.getRow("H1"));
    }

    @Test
    public void testIndexArrayOfA8Is0() {
        assertEquals(0, Utils.seekTileIndex("A8", 8));
    }

    @Test
    public void testIndexArrayOfE6Is20() {
        assertEquals(20, Utils.seekTileIndex("E6", 8));
    }

    @Test
    public void testIndexArrayOfH1Is63() {
        assertEquals(63, Utils.seekTileIndex("H1", 8));
    }

    @Test
    public void testStringWrapForFileOfJustPlayer() {
        assertEquals("1,,,", Utils.wrapCoordinatesIntoString("1", "", "", "", 1));
    }

    @Test
    public void testStringWrapForFileOfJustFromCoordinate() {
        assertEquals(",B5,,", Utils.wrapCoordinatesIntoString("", "B5", "", "", 1));
    }

    @Test
    public void testStringWrapForFileOfJustToCoordinate() {
        assertEquals(",,A7,", Utils.wrapCoordinatesIntoString("", "", "A7", "", 1));
    }

    @Test
    public void testStringWrapForFileOfJustCaptureCoordinate() {
        assertEquals(",,,H5", Utils.wrapCoordinatesIntoString("", "", "", "H5", 1));
    }

    @Test
    public void testStringWrapForFileOfPlayerAndAllCoordinates() {
        assertEquals("1,C6,E7,H5", Utils.wrapCoordinatesIntoString("1", "C6", "E7", "H5", 1));
    }

    @Test
    public void testStringWrapForPrintOfPlayerAndAllCoordinates() {
        assertEquals("1 | C6 -> E7 x[H5]", Utils.wrapCoordinatesIntoString("1", "C6", "E7", "H5", 0));
    }

    @Test
    public void testStringWrapForPrintOfPlayerAndFromToCoordinates() {
        assertEquals("1 | C6 -> E7 x[]", Utils.wrapCoordinatesIntoString("1", "C6", "E7", "", 0));
    }

    @Test
    public void testStringUnWrapForPlayerAndAllCoordinates() {
        String[] compareTo = {"1","C6","E7","H5"};
        assertArrayEquals(compareTo, Utils.unwrapCoordinatesFromString("1,C6,E7,H5"));
    }

    @Test
    public void testStringUnWrapForPlayerAndFromToCoordinates() {
        String[] compareTo = {"1","C6","E7"};
        assertArrayEquals(compareTo, Utils.unwrapCoordinatesFromString("1,C6,E7,"));
    }
}