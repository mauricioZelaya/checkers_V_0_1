package org.checkers.model;

/**
 * Updated by Susana on 7/20/2017.
 * Entity class for movements.
 */
public class Movement {
    private int getCoordinate = 0;
    private String fromXY = "";
    private String toXY = "";

    private int mouseX;
    private int mouseY;

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

        if (!fromXY.equals(toXY) && !toXY.equals("")) {
            matrix.moveGamePiece(fromXY, toXY, "");
        }

        matrix.toggleSelectedGamePiece(toXY);
        resetMovement();
    }

    /**
     * This method is to select a piece on the game.
     *
     * @param newMatrix an instance of {@link InterfaceMatrix}.
     */
    private void selectGamePiece(final InterfaceMatrix newMatrix) {
        fromXY = newMatrix.getCoordinatesAtXY(mouseX, mouseY);

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
