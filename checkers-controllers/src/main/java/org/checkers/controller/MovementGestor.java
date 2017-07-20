package org.checkers.controller;

import org.checkers.model.Movement;
import org.checkers.view.Board;

import java.awt.event.MouseEvent;


/**
 * Created by Administrator on 6/30/2017.
 */
public class MovementGestor {

    public static void movTileChip(Board board, MouseEvent event, Movement m) {
        //this is to set the values for "m.setFromXY()" and "m.setToXY()".
        if (m.getFromXY() == "") {
            m.getPrevious(board, event);
        } else if (m.getToXY() == "") {
            m.getNext(board, event);
        }


        if ((!m.getFromXY().equals("")) && (!m.getToXY().equals(""))) {
            //TODO: rules.
//            board.toggleGamePieceState(m.getFromXY());
//            board.moveGamePiece(m.getFromXY(), m.getToXY(), "");
//            board.hideChip(m.getFromXY());
//            board.showChip(m.getToXY());

            //TODO: to get the historical.
            System.out.println(String.format("[%s] m [%s]", m.getFromXY(), m.getToXY()));

            m.setFromXY("");
            m.setToXY("");
        }
    }
}
