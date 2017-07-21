package org.checkers.view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Write a description of class DrawingPanel here.
 *
 * @author not known (the owner should update it).
 * Updated by Susana on 7/20/2017.
 */
public class DrawingPanel extends JPanel {

    private int[][] boardTest = {{9, 2, 9, 2, 9, 2, 9, 2},
            {2, 9, 2, 9, 2, 9, 2, 9},
            {9, 2, 9, 2, 9, 2, 9, 2},
            {0, 9, 0, 9, 0, 9, 0, 9},
            {9, 0, 9, 0, 9, 0, 9, 0},
            {1, 9, 1, 9, 1, 9, 1, 9},
            {9, 1, 9, 1, 9, 1, 9, 1},
            {1, 9, 1, 9, 1, 9, 1, 9}};

    private Board board;
    private int xLast=0;
    private int yLast=0;
    private int moveCycle = 0;

    public DrawingPanel(){
        setBackground(Color.GRAY);
        board = new Board(50, 50, 50, 8);
        board.placePieces(boardTest);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        board.drawShape(g);
    }
}