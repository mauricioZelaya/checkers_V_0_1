package org.checkers.model.component;

import java.util.Vector;
import java.awt.Graphics;
import java.awt.Color;
/**
 * Write a description of class CompositeShape here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CompositeShape extends AbstractShape {

    protected Vector<AbstractShape> elements;

    public CompositeShape(){
        elements = new Vector<AbstractShape>();
    }

    @Override //recheck logic for container check
    public boolean isInsideShape(int x, int y){
        for(AbstractShape element:elements) {
            if(element.isInsideShape(x, y)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getValue(){
        return 0;
    }

    @Override
    public void setValue(int value) {
    }

    @Override
    public void drawShape(Graphics g){
        for(AbstractShape element:elements) {
            element.draw(g);
        }
    }

    @Override
    public void setAllShapeProperties(int x, int y) {
        for(AbstractShape element:elements) {
            element.setX(x);
            element.setY(y);
        }
    }

    @Override
    public void toggleState() {
    }
}
