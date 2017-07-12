package org.checkers.core;

/**
 * General methods for coordinate conversion between column/row (indexes) and board coordinates of the form "A5".
 */
public class Utils
{
    //Board - starting at 1
    public String coordinatesLiteral(int column, int row) {
        return Character.toString((char) (column+64))+Integer.toString(9-row);
    }

    //Tile - returning from 1
    public int getColumn(String coordinates) {
        return (int)coordinates.charAt(0)-64;
    }

    public int getRow(String coordinates) {
        return 9- (coordinates.charAt(1)-'0');
    }
}