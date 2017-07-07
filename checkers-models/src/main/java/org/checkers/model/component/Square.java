package org.checkers.model.component;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Write a description of class Square here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Square extends AbstractShape {

    private int side;

    public Square(int x, int y) {
        super(x, y);
    }

    @Override
    public boolean isInsideShape(int x, int y) {
        return x>=this.x-side/2 && x <= this.x+side/2 && y>=this.y-side/2 && y <= this.y+side/2;
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
}