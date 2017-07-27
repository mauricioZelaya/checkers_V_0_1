package org.checkers.controller;

import org.checkers.core.Utils;
import org.checkers.model.InterfaceMatrix;
import org.checkers.model.Movement;

import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.checkers.core.IBoardGamesRules;
import org.checkers.core.CheckersGameRules;

/**
 * Updated by Susana on 7/20/2017.
 * Class to admin the movements.
 */
public class MovementGestor extends MouseAdapter {

    private final JPanel panel;
    private final InterfaceMatrix matrix;
    private final Movement movement;
    private final IBoardGamesRules rules;

    /**
     * Constructor.
     *
     * @param newPanel  an instance of {@link JPanel}.
     * @param newMatrix an instance of {@link InterfaceMatrix}.
     */
    public MovementGestor(final JPanel newPanel, final InterfaceMatrix newMatrix) {
        this.panel = newPanel;
        this.matrix = newMatrix;
        movement = new Movement();
        newPanel.addMouseListener(this);
        rules = new CheckersGameRules();
    }

    /**
     * To overrides the mouse clicked class.
     *
     * @param event an instance of {@link MouseEvent}
     */
    @Override
    public void mouseClicked(final MouseEvent event) {

      String coordinatesFrom = movement.returnFirstMove();
      //int player = matrix.getValueAtCoordinates(coordinatesFrom);
      //
        if (matrix.hasSelectedPiece() && validateRule(matrix, event)) {

          matrix.printMatrix();
            movement.movePiece(matrix, event.getX(), event.getY());
          matrix.printMatrix();
          if(rules.killOpponent(Utils.getRow(coordinatesFrom)-1 ,Utils.getColumn(coordinatesFrom)-1, matrix.getMatrix())){
            String whoDied = whoDied(coordinatesFrom, matrix.getCoordinatesAtXY(event.getX(),event.getY()));
            matrix.captureGamePiece(whoDied);
          }
        } else {
            movement.selectPiece(matrix, event.getX(), event.getY());
          }
        panel.repaint();
    }

    private boolean validateRule(InterfaceMatrix matrix, MouseEvent event) {
        String cordinates = matrix.getCoordinatesAtXY(event.getX(), event.getY());
        return rules.isValidTile(matrix.getValueAtCoordinates(cordinates));
    }

    private String whoDied(String from, String to) {
      int fromCol = Utils.getColumn(from);
      int fromRow = Utils.getRow(from);
      int toCol = Utils.getColumn(to);
      int toRow = Utils.getRow(to);

      int addCol = (toCol - fromCol)/2;
      int addRow = (toRow - fromRow)/2;

      int deadCol = fromCol + addCol;
      int deadRow = fromRow + addRow;

      return Utils.coordinatesFromColRow(deadCol, deadRow);



    }
}
