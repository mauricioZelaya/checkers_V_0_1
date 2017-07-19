package org.checkers.core;

/**
 * This Utils class contains general methods for coordinate conversion between column/row (indexes) and board coordinates of the form "A5".
 *
 * The general idea for it to be a stateless class was found online, and considered the appropriate approach for the current implementations.
 *
 * @author (Leonardo Antezana)
 * @version (June 2017)
 */
public final class Utils
{
    private Utils() {
    }

    //Board - starting at 1
    public static String coordinatesFromColRow(int column, int row) {
        return Character.toString((char)(column+64))+Integer.toString(9-row);
     }

    //Tile - returning from 1
    public static int getColumn(String coordinates) {
        return (int)coordinates.charAt(0)-64;
     }

    //Tile - returning from 1
    public static int getRow(String coordinates) {
        return 9-(coordinates.charAt(1)-'0');
     }

    /**
     * Using the coordinates of a Tile, this method obtains the index of it in the tile array. This way getting a specific tile is a Seek process
     * rather than a full Array Scan.
     *
     * After a generalization between Board/Matrix it helps in both implementations.
     */
    public static int seekTileIndex(String coordinates, int nTileSide) {
       int tileArrayIndex = (Utils.getRow(coordinates)-1)*nTileSide + Utils.getColumn(coordinates)-1;
       return tileArrayIndex;
     }

    /**
     * Provided all movement Coordinates this method returns a formatted string to be used by the History class which is easy to parse. This format is also used
     * when saving/loading to/from a file.
     *
     * Can also return a printable String format.
     */
    public static String wrapCoordinatesIntoString(String player, String fromTile, String toTile, String capturedTile, int forFile) {
        if(forFile == 1) {
            return String.format("%s,%s,%s,%s", player, fromTile, toTile, capturedTile);
        }
        return String.format("%s | %s -> %s x[%s]", player, fromTile, toTile, capturedTile);
    }

    /**
     * With a properly wrappedString this method returns a String array with its components.
     *
     * @fromFile Is a string with the format "%s,%s,%s,%s".
     */
    public static String[] unwrapCoordinatesFromString(String fromFile) {
        return fromFile.split(",");
    }
}