package org.checkers.view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import org.checkers.model.InterfaceMatrix;

/**
 * Write a description of class DrawingPanel here.
 *
 * @author not known (the owner should update it).
 * Updated by Susana on 7/20/2017.
 */
public class DrawingPanel extends JPanel implements Observer{

    private static final long serialVersionUID = -5505243596773486698L;
    private final InterfaceBoard board;

    public DrawingPanel(InterfaceBoard board){
        setBackground(Color.GRAY);
        this.board = board;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        board.drawShape(g);
    }

    @Override
    public void update(Observable o, Object arg) {
        board.placePieces((int[][])arg);
        this.repaint();
    }
}