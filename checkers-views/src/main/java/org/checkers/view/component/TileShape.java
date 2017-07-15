package org.checkers.view.component;

/**
 * [ VIEW ]
 * This Composite shape draws the Square that makes up the tile. XY position received is the center of the shape(s)/square.
 *
 * @author (Leonardo Antezana)
 * @version (July 2017)
 */
public class TileShape extends CompositeShape
{
    public TileShape(int x, int y, int side) {
        super(x, y);
        Square tile = new Square(x, y);
        tile.setValue(side);
        elements.add(tile);
    }
}