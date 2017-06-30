package org.checkers.model.component;

import java.awt.Color;

/**
 * Write a description of class TileChip here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TileChip extends CompositeShape
{
    private boolean testingOn = true; //erase for final
    
    public TileChip(int x, int y, int side, Color color, String positionXY) {
        super();
        setName(positionXY);
        Square tile = new Square(x, y); 
        tile.setName("tile");
        Circle outer = new Circle(x, y); //border circle
        outer.setName("inner");
        outer.setColor(color);
        outer.setRadius((side-6)/2);
        Circle inner = new Circle(x, y); //top circle
        inner.setName("outer");
        inner.setColor(color);
        inner.setRadius((side-10)/2);
        
        elements.add(tile);
        elements.add(outer);
        elements.add(inner);
    }
    
    //for testing
    public void printCompositeStates() {
        System.out.println(getName() + " " + getState());
        for(AbstractShape element:elements) {
            System.out.println(element.getName() + " " +element.getState());            
        }
        System.out.println();        
    }
    
    public void setToggleState() {
        for(AbstractShape element:elements) {
            if(element.getName()=="inner") {
                element.setState((element.getState()== SHOW)? SELECTED : SHOW);
            }
        }
        this.state = (getState()== SHOW)? SELECTED : SHOW;
    }
}
