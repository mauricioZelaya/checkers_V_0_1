package org.checkers.model;
import org.checkers.core.IBoardGamesRules;
import org.checkers.core.CheckersGameRules;
import org.checkers.core.Utils;

/**
 * Updated by Susana on 7/20/2017.
 * Entity class for movements.
 */
public class Movement {
    private int getCoordinate = 0;
    private String fromXY = "";
    private String toXY = "";
    private int player = 0;

    private int mouseX;
    private int mouseY;

    private IBoardGamesRules rules;

    public Movement(){
        rules = new CheckersGameRules();
    }

    /**
     * This method is to have coordinates of X and Y from mouse.
     *
     * @param matrix    an instance of {@link InterfaceMatrix}.
     * @param newMouseX has mouse X value.
     * @param newMouseY has the mouse Y value.
     */
    public void selectPiece(final InterfaceMatrix matrix, final int newMouseX, final int newMouseY) {
        this.mouseX = newMouseX;
        this.mouseY = newMouseY;

        selectGamePiece(matrix);
    }

    /**
     * This method is to have move the piece.
     *
     * @param matrix    an instance of {@link InterfaceMatrix}.
     * @param newMouseX has mouse X value.
     * @param newMouseY has the mouse Y value.
     */
    public void movePiece(final InterfaceMatrix matrix, final int newMouseX, final int newMouseY) {
        this.mouseX = newMouseX;
        this.mouseY = newMouseY;

        selectedDestinationTile(matrix);

        if (!fromXY.equals(toXY) && !toXY.equals("") && isValidMove(matrix)) {
            matrix.moveGamePiece(fromXY, toXY);
            System.out.println(String.format("%s(%s, %s)",fromXY,Utils.getRow(fromXY)-1, Utils.getColumn(fromXY)-1));
            if(rules.killOpponent(Utils.getRow(fromXY)-1 ,Utils.getColumn(fromXY)-1, matrix.getMatrix(), player)){
                String whoDied = whoDied(fromXY, toXY);
                matrix.captureGamePiece(whoDied);
            }
        }

        matrix.toggleSelectedGamePiece(toXY);
        resetMovement();
    }

    private boolean isValidMove(InterfaceMatrix matrix) {
        String coordinates = matrix.getCoordinatesAtXY(mouseX, mouseY);
        return rules.isValidTile(matrix.getValueAtCoordinates(coordinates));
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

    /**
     * This method is to select a piece on the game.
     *
     * @param newMatrix an instance of {@link InterfaceMatrix}.
     */
    private void selectGamePiece(final InterfaceMatrix newMatrix) {
        fromXY = newMatrix.getCoordinatesAtXY(mouseX, mouseY);

        player = newMatrix.getValueAtCoordinates(fromXY);

        if (!fromXY.equals("")) {
            newMatrix.toggleSelectedGamePiece(fromXY);
            getCoordinate = 1;
        } else {
            fromXY = "";
        }
    }

    /**
     * This method is to select the destination Tile.
     *
     * @param newMatrix has matrix values.
     */
    private void selectedDestinationTile(final InterfaceMatrix newMatrix) {
        toXY = newMatrix.getCoordinatesAtXY(mouseX, mouseY);

        if (!toXY.equals("")) {
            getCoordinate = 2;
        }
    }

    /**
     * This method is to reset the movements.
     */
    private void resetMovement() {
        fromXY = "";
        toXY = "";
        getCoordinate = 0;
    }
}
