package org.checkers.view.component;

import java.awt.Graphics;

/**
 * [ VIEW ]
 * Concrete Square shape, draws a square and allows working with it.
 *
 * @author (Done in class)
 * @version (June 2017)
 */
public class Square extends AbstractShape {

    private int side;

    public Square(int x, int y) {
       super(x, y);
    }

    @Override
    public boolean isInsideShape(int x, int y) {
       return (x>=this.x-side/2 && x <= this.x+side/2) && (y>=this.y-side/2 && y <= this.y+side/2);
    }

    //getSide
    @Override
    public int getValue() {
        return side;
    }

    @Override
    public void setValue(int value) {
        this.side = value;
    }

    @Override
    public void drawShape(Graphics g) {
        g.fillRect(x-side/2, y-side/2, side, side);
    }

    @Override
    public void toggleState() {
    }

    @Override
    public void crownShape() {
    }
}