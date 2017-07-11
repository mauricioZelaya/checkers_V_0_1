package org.checkers.model;

import org.checkers.model.component.AbstractShape;
import org.checkers.model.component.ChipShape;

import java.awt.Graphics;
import java.awt.Color;
/**
 * Write a description of class GamePiece here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GamePiece
{
    private AbstractShape shape;

    public GamePiece(int xCoord, int yCoord, int tileWidth, Color color) {
        shape = new ChipShape(xCoord, yCoord, tileWidth, color);
    }

    public AbstractShape getShape() {
        return shape;
    }

    public void drawShape(Graphics g){
        shape.drawShape(g);
    }
}