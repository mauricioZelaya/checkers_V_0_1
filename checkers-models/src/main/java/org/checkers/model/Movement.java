package org.checkers.model;

import org.checkers.view.Board;

import java.awt.event.MouseEvent;

/**
 * Entity class for movements.
 */
public class Movement {
    /**
     * Variables.
     */
    private String fromXY = "", toXY = "";

    /**
     * @param newFromXY coordinates.
     */
    public void setFromXY(final String newFromXY) {
        this.fromXY = newFromXY;
    }

    /**
     * @param newToXY coordinates
     */
    public void setToXY(final String newToXY) {
        this.toXY = newToXY;
    }

    /**
     * @return {@link #fromXY}
     */
    public String getFromXY() {
        return fromXY;
    }

    /**
     * @return {@link #toXY}
     */
    public String getToXY() {
        return toXY;
    }

    /**
     * @param board has board values.
     * @param event has event from mouse values.
     */
    public void getNext(final Board board, final MouseEvent event) {
//        setToXY(board.getCoordinatesAtXY(event.getX(), event.getY()));
    }

    /**
     * @param board has board values
     * @param event has even from mouse values.
     */
    public void getPrevious(final Board board, final MouseEvent event) {
//        setFromXY(board.getCoordinatesAtXY(event.getX(), event.getY()));
        board.toggleGamePieceState(getFromXY());
    }
}
