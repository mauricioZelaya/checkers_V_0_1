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
    private String fromXY="";
    private String toXY="";
    private int moveCycle = 0;

    public DrawingPanel(){
        setBackground(Color.GRAY);
        board = new Board(50, 50, 50, 8);
        board.placePieces(boardTest);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                movePiece(event.getX(), event.getY());
            }
        });
    }

    public void movePiece(int mouseX, int mouseY) {
        if(fromXY.equals("")) {
            fromXY = board.getCoordinatesAtXY(mouseX, mouseY);
            board.toggleGamePieceState(fromXY);
        }
        else {
            if(toXY.equals("")) {
                toXY = board.getCoordinatesAtXY(mouseX, mouseY);
            }
        }
        //System.out.println(String.format("[%s] m [%s]", fromXY, toXY));
        if(fromXY.equals(toXY)) {
            board.toggleGamePieceState(fromXY);
            fromXY = "";
            toXY = "";
        }
        else {
            if(!fromXY.equals(toXY) && !toXY.equals("")) {
                board.toggleGamePieceState(fromXY);
                board.moveGamePiece(fromXY, toXY, "");
                fromXY = "";
                toXY = "";
            }
        }
        //System.out.println(String.format("Mouse [%s] m [%s]", fromXY, toXY));
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        board.drawShape(g);
    }
}