package org.checkers.model;

import org.checkers.model.component.AbstractShape;
import org.checkers.model.component.TileShape;

import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics;
import java.awt.Color;

/**
 * Write a description of class Tile here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tile
{
    private List<GamePiece> pieces;
    private String coordinates; //format: "columnRow", like "A8"
    private AbstractShape shape; //tile color, bottom of the GamePiece vertical
    private int xOrigin;
    private int yOrigin;
    private int tileWidth;

    public Tile(String coordinates, int xOrigin, int yOrigin, int tileWidth){
        this.coordinates = coordinates;
        this.xOrigin = xOrigin;
        this.yOrigin = yOrigin;
        this.tileWidth = tileWidth;
        pieces = new ArrayList<GamePiece>();


        shape = new TileShape(getRealX(), getRealY(), tileWidth);
        shape.setColor((getColumn()+getRow()) % 2 == 0 ? Color.white : Color.black);
    }

    //the GamePieces are created during board setup initialization (rest assume the gamepiece exists on the tile)
    public void createGamePiece(Color playerColor) {
        GamePiece gamePiece = new GamePiece(getRealX(),  getRealY(), tileWidth, playerColor);
        pieces.add(gamePiece);
    }

    //just return reference of the gamepiece on the tile for processing
    public GamePiece getGamePiece() {
        return pieces.get(0);
    }

    //a taken Piece is put back into a new tile... needs to get values from tile
    public void putGamePiece(GamePiece piece, Color playerColor) {
        piece.getShape().setAllShapeProperties(getRealX(), getRealY()); //updates xy of the GamePiece to current tile
        pieces.add(piece);
    }

    //takes the GamePiece out of the tile
    public GamePiece takeGamePiece() {
        /*GamePiece pieceTaken = pieces.remove(0);
        return(pieceTaken);*/
        return pieces.remove(0);
    }

    //local draw not an override
    public void drawShape(Graphics g) {
        shape.draw(g);
        for(GamePiece piece:pieces) {
            piece.drawShape(g);
        }
    }

    public AbstractShape getShape() {
        return shape;
    }

    private int getColumn() {
        return (int)coordinates.charAt(0)-64;
    }

    private int getRow() {
        return 9- (coordinates.charAt(1)-'0');
    }

    private int getRealX() {
        return xOrigin+getColumn()*tileWidth;
    }

    private int getRealY() {
        return yOrigin+getRow()*tileWidth;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public Boolean isInsideTile(int x, int y) {
        return shape.isInsideShape(x, y);
    }

    public Boolean hasGamePiece() {
        return !pieces.isEmpty();
    }
}