package org.checkers.view.component;

import java.awt.Color;
import java.awt.Graphics;

/**
 * [ VIEW ]
 *Concrete Circle shape, draws a circle and allows working with it.
 *
 * @author (Done in class)
 * @version (June 2017)
 */
public class Circle extends AbstractShape {

    protected int radius;

    public Circle(int x, int y) {
       super(x, y);
       setColor(Color.blue);
       //radius = 25;
    }

    @Override
    public boolean isInsideShape(int x, int y) {
        int xCenter = this.x;
        int yCenter = this.y;
        double d = Math.hypot(yCenter - y, xCenter - x);
        return d <= radius;
    }

    //getRadius
    @Override
    public int getValue() {
        return radius;
    }

    @Override
    public void setValue(int value) {
        this.radius = value;
    }

    @Override
    public void drawShape(Graphics g) {
        g.fillOval(x - radius, y - radius, radius*2, radius*2);
    }

    @Override
    public void toggleState() {
    }

    @Override
    public void crownShape() {
    }
}