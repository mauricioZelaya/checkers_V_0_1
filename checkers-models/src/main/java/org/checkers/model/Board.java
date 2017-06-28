package org.checkers.model;

import org.checkers.model.component.AbstractShape;
import org.checkers.model.component.CompositeShape;
import org.checkers.model.component.TileChip;

import java.awt.Color;
/**
 * Write a description of class Board here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Board extends CompositeShape
{
    private int x = 100;
    private int y = 50;
    private int side = 50;
    private final Color BLACK = Color.black;
    private final Color WHITE = Color.white;
    private boolean paintWhite = true;
    
    public Board() {
        super();
        drawLabels();
        drawBoard(); 
    }
    
    public void drawBoard() {
        Color chipColor;
        y += side;
        for(int j=0; j<=7; j++) {
            chipColor = (j<4)? Color.blue : Color.orange;                               
            for(int i=0; i<=7; i++) {
                TileChip tileChip = new TileChip(x+(side*i),y+(side*j), side, chipColor, getXYLiteral(i, 8-j));
                if(paintWhite) {
                    tileChip.setColor(WHITE);
                    paintWhite=false;
                }
                else {
                    tileChip.setColor(BLACK);
                    if(j!=3 && j!=4) {
                        tileChip.setState(SHOW);
                    }                    
                    paintWhite=true;
                }
                elements.add(tileChip);  
            }
            paintWhite= (paintWhite)? false : true;
        }
    }
    
    private String getXYLiteral(int x, int y) {
        return(Character.toString((char)(x+65))+Integer.toString(y));
    }
    
    public void drawLabels() {
        Label label;        
        for(int i=0; i<=7; i++) {
            label = new Label (x+(side*i), y, Character.toString((char)(65+i))); //top
            elements.add(label);
            label = new Label (x-side, y+side+(side*i), Integer.toString(8-i)); //side
            elements.add(label);
        }        
    }
    
    public String clickIsOnTileXY(int x, int y) {
        for(AbstractShape element:elements) {
            if(element instanceof TileChip) {
                if(element.isInsideShape(x, y)) {
                    return(element.getName());
                }
            }
        }
        return "";
    }
    
    public void toggleChip(String xyLiteral) {
        for(AbstractShape element:elements) {
            if(element instanceof TileChip) {
                if(element.getName() == xyLiteral) {
                   ((TileChip)element).setToggleState();
                }
            }
        }
    }
    
    public void hideChip(String xyLiteral) {
        for(AbstractShape element:elements) {
            if(element instanceof TileChip) {
                if(element.getName() == xyLiteral) {
                   element.setState(HIDE);
                }
            }
        }
    }
    
    public void showChip(String xyLiteral) {
        for(AbstractShape element:elements) {
            if(element instanceof TileChip) {
                if(element.getName() == xyLiteral) {
                   element.setState(SHOW);
                }
            }
        }
    }    
}
