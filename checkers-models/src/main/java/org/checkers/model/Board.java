package org.checkers.model;

import org.checkers.model.component.AbstractShape;

import java.util.Collection;
import java.util.ArrayList;

import java.awt.Graphics;
import java.awt.Color;
/**
 * Write a description of class Board2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Board implements InterfaceBoard {
    private Collection<Tile> tiles;
    private Collection<AbstractShape> labels;
    private int xOrigin;
    private int yOrigin;
    private int tileWidth;
    private int nTileSide; //board size is nTile x nTile

    private Color cPlayer1 = Color.red;
    private Color cPlayer2 = Color.orange;

    public Board(int xOrigin, int yOrigin, int tileWidth, int nTileSide) {
        this.xOrigin = xOrigin;
        this.yOrigin = yOrigin;
        this.tileWidth = tileWidth;
        this.nTileSide = nTileSide;

        tiles = new ArrayList<Tile>();
        labels = new ArrayList<AbstractShape>();

        drawLabels();
        createBoard();

    }

    private void createBoard() {
        for(int row = 1; row <= nTileSide; row++) {
            for(int column = 1; column <= nTileSide; column++) {
                //System.out.print("tile at: " + coordinatesLiteral(column, row));
                Tile tile = new Tile(coordinatesLiteral(column, row), xOrigin, yOrigin, tileWidth);
                tiles.add(tile);
            }
            //System.out.println();
        }
    }

    private void drawLabels() {
        Label label;
        for(int i=1; i<=nTileSide; i++) {
            label = new Label (xOrigin + tileWidth * i, yOrigin, Character.toString((char)(64+i))); //top
            label.setColor(Color.black);
            labels.add(label);
            label = new Label (xOrigin, yOrigin+tileWidth*i, Integer.toString(9-i)); //side
            label.setColor(Color.black);
            labels.add(label);
        }
    }

    //figures out the coordinates, ads a piece to the tile in those coordinates
    @Override
    public void placePieces(int[][] matrix) {
        Tile tile;
        int value;
        for(int row=1; row <= nTileSide; row++) {
            for(int column=1; column <= nTileSide; column++) {
                value = matrix[row-1][column-1];
                if(value==1 || value==2) {
                    tile = getTileAt(coordinatesLiteral(column, row));
                    //System.out.print(String.format("Tile [%s]",tile.getCoordinates()));
                    tile.createGamePiece((value == 1) ? cPlayer1 : cPlayer2);
                }
            }
            //System.out.println();
        }
    }

    private Tile getTileAt(String tileCoordinates) {
        for(Tile tile:tiles) {
            if(tile.getCoordinates().equals(tileCoordinates)) {
                return tile;
            }
        }
        return null; //error
    }

    private String coordinatesLiteral(int column, int row) {
        return Character.toString((char) (column+64))+Integer.toString(9-row);
    }

    @Override
    public void toggleGamePieceState(String tileCoordinates) {
        getTileAt(tileCoordinates).getGamePiece().getShape().toggleState();
    }

    @Override
    public void moveGamePiece(String fromTile, String toTile, String capturePieceAtTile) {
        GamePiece movingPiece;
        movingPiece = getTileAt(fromTile).takeGamePiece();
        getTileAt(toTile).putGamePiece(movingPiece, Color.green);
        if(!"".equals(capturePieceAtTile)) {
            getTileAt(capturePieceAtTile).takeGamePiece();
        }
    }

    @Override
    public Boolean clickIsInsideBoard(int x, int y) {
        int xBottom = xOrigin + tileWidth * nTileSide;
        int yBottom = yOrigin + tileWidth * nTileSide;
        return x >= xOrigin && x <= xBottom && y >= yOrigin && y <= yBottom;
    }

    //gets physical coordinates XY and checks where they belong and returns the ColRow coordinates of the tile
    @Override
    public String getCoordinatesAtXY(int x, int y) {
        for(Tile tile:tiles) {
            if(tile.isInsideTile(x,y)) {
                return tile.getCoordinates();
            }
        }
        return "";
    }

    //local draw, not override
    public void drawShape(Graphics g) {
        for(AbstractShape label:labels) {
            label.draw(g);
        }
        for(Tile tile:tiles) {
            tile.drawShape(g);
        }
    }
}

