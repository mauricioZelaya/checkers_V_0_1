package org.checkers.model.component;

import java.awt.Color;
import java.awt.Graphics;
/**
 * Abstract class AbstractShape - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class AbstractShape {

    protected int x; //(x, y) define the center of shape
    protected int y;
    protected Color color;

    public abstract boolean isInsideShape(int x, int y);
    public abstract void drawShape(Graphics g);
    public abstract int getValue(); //this was used for compare, returns unique radius/side value
    public abstract void setValue(int value);
    public abstract void toggleState();

    public void draw(Graphics g) {
        g.setColor(color);
        drawShape(g);
    }

    public void setColor(Color color){
        this.color=color;
    }

    public Color getColor() {
        return(color);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setAllShapeProperties(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

