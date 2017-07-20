package org.checkers.controller;


import org.checkers.model.Movement;
import org.checkers.view.Board;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Write a description of class DrawingPanel here.
 *
 * @author (your name).
 * @version (a version number or a date).
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

    private Movement m = new Movement();
    private MovementGestor mg = new MovementGestor();

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