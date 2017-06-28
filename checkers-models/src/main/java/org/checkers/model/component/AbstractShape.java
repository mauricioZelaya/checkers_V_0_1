package org.checkers.model.component;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Comparator;
/**
 * Abstract class AbstractShape - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class AbstractShape {
    
    protected final int HIDE = 0;
    protected final int SHOW = 1;
    protected final int SELECTED = 2;
    protected final int ILLEGAL = 3;
    
    protected int x; //(x, y) define the center of shape
    protected int y;
    protected Color color;
    protected int state;
    protected String name = ""; //added to give Chips a coordinates name/used in label too
   
    public abstract boolean isInsideShape(int x, int y);
    public abstract void drawShape(Graphics g);
    public abstract int getValue(); //this was used for compare, returns unique radius/side value
   
    public void draw(Graphics g) {
       g.setColor(color);
       drawShape(g);
    }
    
    public void setColor(Color color){
        this.color=color;
    }
    
    public void setState(int state) {
        this.state = state;
    }
    
    public int getState() {
        return state;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return(name);
    }
}
