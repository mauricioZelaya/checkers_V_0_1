package org.checkers.model.component;

/**
 * Write a description of class Tile here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TileShape extends CompositeShape
{
    private int side;

    public TileShape(int x, int y, int side) {
        super();
        this.x = x;
        this.y = y;
        this.side = side;
        Square tile = new Square(x, y);
        tile.setValue(side);

        elements.add(tile);
    }
}