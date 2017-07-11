package org.checkers.model;

import java.awt.event.MouseEvent;

/**
 * Created by Administrator on 6/30/2017.
 */
public class Movement {
    private String fromXY = "", toXY = "";

    public void setFromXY(String newFromXY) {
        this.fromXY = newFromXY;
    }

    public void setToXY(String newToXY) {
        this.toXY = newToXY;
    }

    public String getFromXY() {
        return fromXY;
    }

    public String getToXY() {
        return toXY;
    }

    public void getNext(Board board, MouseEvent event) {
        setToXY(board.getCoordinatesAtXY(event.getX(), event.getY()));
    }

    public void getPrevious(Board board, MouseEvent event) {
        setFromXY(board.getCoordinatesAtXY(event.getX(), event.getY()));
        board.toggleGamePieceState(getFromXY());
    }
}
