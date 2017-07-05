package org.checkers.model.component;

import java.awt.Color;
import java.util.Vector;
/**
 * Write a description of class Chip here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ChipShape extends CompositeShape {

    public ChipShape(int x, int y, int side, Color color) {
        super();
        this.x = x;
        this.y = y;
        this.color = color;
        Circle outer = new Circle(x, y); //border circle
        outer.setColor(color);
        outer.setValue((side-6)/2);
        Circle inner = new Circle(x, y); //top circle
        inner.setColor(color);
        inner.setValue((side-12)/2);

        elements.add(outer);
        elements.add(inner);
    }

    @Override
    public void toggleState() {
        AbstractShape element;
        element = elements.firstElement();
        element.setColor((element.getColor()== color)? Color.green : color);
    }
}