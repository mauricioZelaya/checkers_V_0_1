package org.checkers.view.component;

import java.awt.Color;
import java.awt.Graphics;
/**
 * [ VIEW ]
 * Abstract class AbstractShape allows more generic and extendable shapes.
 *
 * @author (Done in class)
 * @version (June 2017)
 */
public abstract class AbstractShape {

    protected int x; //(x, y) define the center coordinates of shape
    protected int y;
    protected Color color;

    public abstract boolean isInsideShape(int x, int y);
    public abstract void drawShape(Graphics g);
    public abstract int getValue(); //this was used for compare, returns unique radius/side value
    public abstract void setValue(int value);
    public abstract void toggleState();
    public abstract void crownShape();

    public AbstractShape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
       g.setColor(color);
       drawShape(g);
    }

    public void setColor(Color color){
        this.color=color;
    }

    public Color getColor() {
        return color;
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