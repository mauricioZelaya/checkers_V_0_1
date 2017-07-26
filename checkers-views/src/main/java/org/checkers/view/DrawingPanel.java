package org.checkers.view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Observer;

import org.checkers.model.InterfaceMatrix;

/**
 * Write a description of class DrawingPanel here.
 *
 * @author not known (the owner should update it).
 * Updated by Susana on 7/20/2017.
 */
public class DrawingPanel extends JPanel {

    private static final long serialVersionUID = -5505243596773486698L;
    private final InterfaceBoard board;

    public DrawingPanel(InterfaceMatrix matrix){
        setBackground(Color.GRAY);
        board = new Board(50, 50);
        matrix.addObserver((Observer) board);
        matrix.initMatrixToDefaultState();

        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        board.drawShape(g);
    }
}