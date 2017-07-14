package org.checkers.model.component;

/**
 * A Composite container which defines the drawable shapes for a Tile of the Checkers Board.
 *
 * @author (Done in class, extended some to adapt to Checkers game)
 * @version (July 2017)
 */
public class TileShape extends CompositeShape
{
  //protected int side;

    public TileShape(int x, int y, int side) {
        super(x, y);
        //this.side = side;
        Square tile = new Square(x, y);
        tile.setValue(side);

        elements.add(tile);
    }
}