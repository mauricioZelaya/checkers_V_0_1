package org.checkers.view;

import org.checkers.view.component.AbstractShape;
import org.checkers.view.component.ChipShape;

import java.awt.Graphics;
import java.awt.Color;
/**
 * [ VIEW ]
 * GamePiece allows to attach an Abstractshape to it to give a particular visual look on the board.
 *
 * @author (Leonardo Antezana)
 * @version (July 2017)
 */
public class GamePiece
{
    private AbstractShape shape;

    public GamePiece(int xCoord, int yCoord, int tileWidth, Color color) {
        shape = new ChipShape(xCoord, yCoord, tileWidth, color);
     }

     /**
      * Returns the Abstractshape of the Gamepiece to work on it.
      */
    public AbstractShape getShape() {
        return shape;
    }

    /**
     * Draws the contained Abstractshape.
     */
    public void drawShape(Graphics g){
        shape.drawShape(g);
     }
}