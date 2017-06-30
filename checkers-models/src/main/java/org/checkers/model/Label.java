package org.checkers.model;

import org.checkers.model.component.AbstractShape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.FontMetrics;

/**
 * Write a description of class Label here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Label extends AbstractShape {
    
    public Label(int x, int y, String text){
        this.x=x;
        this.y=y;
        this.name = text;
    }
    
    public boolean isInsideShape(int x, int y){
        return false;
    }
    
    public void drawShape(Graphics g){        
        FontMetrics fm = g.getFontMetrics();
        int xText;
        int yText;
        xText= x - fm.stringWidth(name)/2;
        yText= y + fm.getHeight()/3;
        g.setColor(Color.white);
        g.drawString(name, xText, yText); 
    }
    
    public int getValue(){
        return 0;
    }
   
}
