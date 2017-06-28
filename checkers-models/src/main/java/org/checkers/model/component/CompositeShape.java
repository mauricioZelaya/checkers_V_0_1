package org.checkers.model.component;

import java.util.*;
import java.awt.Graphics;
/**
 * Write a description of class CompositeShape here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CompositeShape extends AbstractShape {

    protected Collection<AbstractShape> elements;
    
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
    public void drawShape(Graphics g){
        for(AbstractShape element:elements) {
            element.draw(g);
        }
    }
    
    @Override //has container check. need to think that we have +1 objects on a composite, for the container as well
    public void setState(int state) {
        for(AbstractShape element:elements) {
            element.setState(state);
        }
        this.state = state;
    }
}
