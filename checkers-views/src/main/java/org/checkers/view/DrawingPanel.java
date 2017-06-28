package org.checkers.view;

import org.checkers.model.Board;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Write a description of class DrawingPanel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DrawingPanel extends JPanel{

    private Board board;
    private int xLast=0;
    private int yLast=0;
    private String fromXY="";
    private String toXY="";
    private int moveCycle = 0;
    
    public DrawingPanel(){

        board = new Board();

        setBackground(Color.GRAY);        
        
        addNewBoard();
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {

                //simulation of move / logic should be on model
                if(fromXY=="") {
                    fromXY = board.clickIsOnTileXY(event.getX(), event.getY());
                    board.toggleChip(fromXY);
                }
                else
                    if(toXY=="") {
                        toXY = board.clickIsOnTileXY(event.getX(), event.getY());
                    }
                System.out.println(String.format("[%s] m [%s]", fromXY, toXY));
                if(fromXY==toXY) {
                    board.toggleChip(fromXY);
                    fromXY = "";
                    toXY = "";
                }
                else 
                    if(fromXY!=toXY && toXY !="") {
                        board.toggleChip(fromXY);
                        board.hideChip(fromXY);
                        board.showChip(toXY);
                        fromXY = "";
                        toXY = "";
                    }                
                repaint();
            }
        });
    }
    
    private void addNewBoard() {
        board = new Board();
    }

    private boolean clickIsInsideAnyShape (MouseEvent event) {
        boolean isInsideAnyShape = false;
            if(board.isInsideShape(event.getX(), event.getY())) {
                isInsideAnyShape = true;
            }
        return isInsideAnyShape;
    } 

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        board.draw(g);

    }
}


