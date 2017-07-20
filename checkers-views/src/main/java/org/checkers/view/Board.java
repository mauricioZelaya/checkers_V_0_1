package org.checkers.view;

import org.checkers.core.Utils;
import org.checkers.view.component.AbstractShape;

import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics;
import java.awt.Color;

import java.util.Observer;
import java.util.Observable;

/**
 * [ VIEW ]
 * Board class handles the drawing and management of all visual assets.
 * Update: Made it an observer class so that it can automatically update the View on a change of the Model (Matrix).
 *
 * @author (Leonardo Antezana)
 * @version (July 2017)
 */
public class Board implements Observer, InterfaceBoard {
   private List<Tile> tiles;
   private List<AbstractShape> labels;
   private int xOrigin;
   private int yOrigin;
   private final int tileWidth;
   private final int nTileSide; //board size is nTile x nTile

   private final Color cPlayer1 = Color.red;
   private final Color cPlayer2 = Color.gray;

   /**
    * Required method by the Observer interface. Triggers the update of the board with the states on the matrix passed as argument.
    */
   @Override
   public void update(Observable o, Object arg) {
       placePieces((int[][])arg);
    }

    /**
     * Constructor that accepts the number of tiles by side and tileWidth in pixels.
     */
   public Board(int xOrigin, int yOrigin, int tileWidth, int nTileSide) {
       this.tileWidth = tileWidth;
       this.nTileSide = nTileSide;

       setupBoard(xOrigin, yOrigin);
    }

    /**
     * Main constructor only requiring the pixel pint where the board will be created.
     */
   public Board(int xOrigin, int yOrigin) {
       this.tileWidth = 50;
       this.nTileSide = 8;

       setupBoard(xOrigin, yOrigin);
    }

   /**
    * As the name implies this method initializes de common elements of the Constructor as well as the visual assets of the Board.
    */
   private void setupBoard(int xOrigin, int yOrigin) {
       tiles = new ArrayList<>();
       labels = new ArrayList<>();
       this.xOrigin = xOrigin;
       this.yOrigin = yOrigin;

       drawLabels();
       createBoard();
    }

    /**
     * This method creates the base tiles used by the Board.
     */
   private void createBoard() {
       for(int row = 1; row <= nTileSide; row++) {
            for(int column = 1; column <= nTileSide; column++) {
                Tile tile = new Tile(Utils.coordinatesFromColRow(column, row), xOrigin, yOrigin, tileWidth);
                tiles.add(tile);
            }
        }
    }

    /**
     * Draws the letter labels around the Board.
     */
   private void drawLabels() {
        Label label;
        for(int i=1; i <= nTileSide; i++) {
            label = new Label (xOrigin+(tileWidth*i), yOrigin, Character.toString((char)(64+i))); //top
            label.setColor(Color.black);
            labels.add(label);
            label = new Label (xOrigin, yOrigin+(tileWidth*i), Integer.toString(9-i)); //side
            label.setColor(Color.black);
            labels.add(label);
        }
    }

   /**
    * Using the "matrix" parameter this method fills an empty board with GamePieces in the right coordinates.
    * It will first clear the board of any gamepiece (update for better MVC).
    */
   public void placePieces(int matrix[][]) {
        Tile tile;
        int matrixValue;
        Boolean selectedPiece = false;
        clearPieces();
        for(int row=1; row <= nTileSide; row++) {
            for(int column=1; column <= nTileSide; column++) {
                matrixValue = matrix[row-1][column-1];
                if((matrixValue % 10)!= matrixValue) {
                    selectedPiece = true;
                    matrixValue/=10;
                }
                if(matrixValue!=0 && matrixValue!=9) {
                    tile = getTileAt(Utils.coordinatesFromColRow(column, row));
                    tile.createGamePiece(((matrixValue==1 || matrixValue==3)? cPlayer1 : cPlayer2));
                    if(selectedPiece) {
                        toggleGamePieceState(Utils.coordinatesFromColRow(column, row));
                        selectedPiece = false;
                    }
                    if(matrixValue ==3 || matrixValue ==4) {
                        crownGamePiece(Utils.coordinatesFromColRow(column, row));
                    }
                }
            }
        }
    }

   /**
    * This method takes out all the pieces on the Board to allow a refresh of the state.
    */
   private void clearPieces() {
       for(Tile tile:tiles) {
           if(tile.tileHasGamePiece()) {
               tile.takeGamePiece();
            }
        }
    }

    /**
     * This method returns the tile found at "tileCoordinates" after a seek to the array.
     */
   private Tile getTileAt(String tileCoordinates) {
       return tiles.get(Utils.seekTileIndex(tileCoordinates, nTileSide));
   }

   /**
    * Seeks the tile from coordinates then gets the contained game piece to have it toggle it's "selected" state.
    */
   public void toggleGamePieceState(String tileCoordinates) {
       getTileAt(tileCoordinates)
        .getGamePiece()
        .getShape()
        .toggleState();
    }

   /**
    * Seeks the tile from coordinates then gets the contained game piece to have it "Crowned" (this adds a crown to the game piece).
    */
   public void crownGamePiece(String tileCoordinates) {
       getTileAt(tileCoordinates)
        .getGamePiece()
        .getShape()
        .crownShape();
    }

    /**
     * Makes a check to ensure a mouse click XY coordinates are inside those of the Board.
     */
   public Boolean clickIsInsideBoard(int x, int y) {
       int xBottom = xOrigin + (tileWidth * nTileSide);
       int yBottom = yOrigin + (tileWidth * nTileSide);
       return (x >= xOrigin && x <= xBottom) && (y >= yOrigin && y <= yBottom);
    }

   /**
    * This board drawShape calls each Label/Tile array in order to paint their component shapes.
    */
   public void drawShape(Graphics g) {
       for(AbstractShape label:labels) {
           label.draw(g);
        }
       for(Tile tile:tiles) {
           tile.drawShape(g);
         }
    }
}