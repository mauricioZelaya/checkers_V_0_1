package org.checkers.controller;

import org.checkers.model.HistoryModel;
import org.checkers.model.InterfaceMatrix;
import org.checkers.model.Movement;

import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * Updated by Susana on 7/20/2017.
 * Class to admin the movements.
 */
public class MovementGestor extends MouseAdapter {

    private final JPanel panel;
    private final InterfaceMatrix matrix;
    private final Movement movement;

    /**
     * Constructor.
     *
     * @param newPanel  an instance of {@link JPanel}.
     * @param newMatrix an instance of {@link InterfaceMatrix}.
     */
    public MovementGestor(final JPanel newPanel, final InterfaceMatrix newMatrix, final HistoryModel historyModel) {
        this.panel = newPanel;
        this.matrix = newMatrix;
        movement = new Movement(historyModel);
        newPanel.addMouseListener(this);
    }

    /**
     * To overrides the mouse clicked class.
     *
     * @param event an instance of {@link MouseEvent}
     */
    @Override
    public void mouseClicked(final MouseEvent event) {
        if (matrix.hasSelectedPiece()) {
            movement.movePiece(matrix, event.getX(), event.getY());
        } else {
            movement.selectPiece(matrix, event.getX(), event.getY());
        }
        //panel.repaint();
    }
}
