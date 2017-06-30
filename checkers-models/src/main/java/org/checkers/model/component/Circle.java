package org.checkers.model.component;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Comparator;

import java.util.*;

/**
 * Write a description of class Circle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Circle extends AbstractShape {

    protected int radius;
   
    public Circle(int x, int y) {
       this.x = x;
       this.y = y;
       this.color = Color.blue;//getNextColor();
       radius = 25;
    }

    @Override
    public boolean isInsideShape(int x, int y) {
        int xCenter = this.x;
        int yCenter = this.y;
        double d = Math.hypot(yCenter - y, xCenter - x);        
        return (d <= radius);
    }    
    
    //getRadius
    @Override
    public int getValue() {
        return radius;
    }
    
    @Override
    public void drawShape(Graphics g) {
        if(state!=HIDE) {
            g.setColor((getState()== SHOW)? color : Color.green); //extends draw functionality for circle and "border" simulation (toggle effect)
            g.fillOval(x - radius, y - radius, radius*2, radius*2);
        }
    }
    
   
    public void setRadius(int radius){
        this.radius=radius;
    }   

}
