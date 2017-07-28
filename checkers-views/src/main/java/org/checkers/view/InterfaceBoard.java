package org.checkers.view;

import java.awt.Graphics;
/**
 * This Interface defines the methods expected to come out from a Board implementation in order to properly manage it.
 *
 * @author (Leonardo Antezana)
 * @version (July 2017)
 */
public interface InterfaceBoard {

    /**
     * This method starts the call to draw the Tiles and GamePieces.
     */

    public void drawShape(Graphics g);

    public void placePieces(int[]... matrix);
}