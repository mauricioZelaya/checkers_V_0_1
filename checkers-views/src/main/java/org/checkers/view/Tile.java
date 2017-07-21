package org.checkers.view;

import java.util.List;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;

import org.checkers.core.Utils;
import org.checkers.view.component.AbstractShape;
import org.checkers.view.component.TileShape;

/**
 * [ VIEW ]
 * This class proceses all the visual assets of a Board's Tile. It has a Shape/Square of its own to visually represent it. And a container Array of possible GamePieces
 * that it can contain.
 *
 * XY position sent to its internal shape, as well as the those of the GamePiece(s), are considered as the center of what gets drawn.
 *
 * @author (Leonardo Antezana)
 * @version (July 2017)
 */
public class Tile
{
    private final List<GamePiece> pieces;
    private final String coordinates; //format: "columnRow", like "A8"
    private final AbstractShape shape; //tile color, bottom of the GamePiece vertical
    private final int xOrigin;
    private final int yOrigin;
    private final int tileWidth;

    public Tile(String coordinates, int xOrigin, int yOrigin, int tileWidth){
        this.coordinates = coordinates;
        this.xOrigin = xOrigin;
        this.yOrigin = yOrigin;
        this.tileWidth = tileWidth;
        pieces = new ArrayList<>();

        shape = new TileShape(getRealX(), getRealY(), tileWidth);
        shape.setColor(((Utils.getColumn(coordinates)+Utils.getRow(coordinates))%2 == 0)? Color.white:Color.black);
     }

    /**
     * GamePiece is created during board initialization, after that all other actions on tile and GamePiece assume the GamePiece object exists in a Tile.
     */
    public void createGamePiece(Color playerColor) {
        GamePiece gamePiece = new GamePiece(getRealX(),  getRealY(), tileWidth, playerColor);
        pieces.add(gamePiece);
    }

    /**
     * Returns reference of the gamepiece on this tile for processing.
     */
    public GamePiece getGamePiece() {
        return pieces.get(0);
    }

    /**
     * Takes the GamePiece out of the tile.
     */
    public GamePiece takeGamePiece() {
        return pieces.remove(0);
    }

    /**
     * Draws the Shape and contained GamePieces.
     */
    public void drawShape(Graphics g) {
       shape.draw(g);
       for(GamePiece piece:pieces) {
           piece.drawShape(g);
         }
     }

     /**
      * Returns the Tile base Shape to operate on it.
      */
    public AbstractShape getShape() {
        return shape;
    }

    /**
     * Using the base xOrigin it returns the actual x on screen.
     */
    private int getRealX() {
        return xOrigin+Utils.getColumn(coordinates)*tileWidth;
    }

    /**
     * Using the base yOrigin it returns the actual y on screen.
     */
    private int getRealY() {
        return yOrigin+Utils.getRow(coordinates)*tileWidth;
    }

    /**
     * Returns true if this Tile has any gamepieces on top.
     */
    public Boolean tileHasGamePiece() {
        return pieces.size() > 0;
    }
}