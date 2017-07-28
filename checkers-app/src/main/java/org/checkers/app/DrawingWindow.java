package org.checkers.app;

import java.awt.BorderLayout;
import java.util.Observer;

import javax.swing.JFrame;

import org.checkers.controller.FileController;
import org.checkers.controller.MovementGestor;
import org.checkers.controller.PlayerController;
import org.checkers.controller.ReplayController;
import org.checkers.model.HistoryModel;
import org.checkers.model.InterfaceMatrix;
import org.checkers.model.Matrix;
import org.checkers.model.Player;
import org.checkers.view.*;

/**
 * Updated by Kenneth on 7/11/2017.
 * Updated by Susana on 7/20/2017.
 * Added the proper container to display the view of the player along with the view of the drawing
 */
public class DrawingWindow extends JFrame {

  private static final long serialVersionUID = -7555794747248347388L;
  private final MovementGestor movementGestor;
  private final InterfaceMatrix matrix;
  private final HistoryModel historyModel;

  /**
   * Creation of the Drawing Panel (The board)
   */
  private final DrawingPanel drawingPanel;
  private final MenuBar menuBar;
  private final BunchPane bunchPane;
  private final InterfaceBoard board;

  /**
   * Creation of the controller
   */
  private final FileController fileController;
  private final PlayerController playerController;
  private final ReplayController replayController;

  /**
   * Drawing window construction.
   *
   * @param title title value.
   */
  public DrawingWindow(final String title) {
    super(title);
    setLayout(new BorderLayout());

    matrix = new Matrix();
    historyModel = new HistoryModel();

    board = new Board(50, 50);
    //matrix.initMatrixToEmptyBoard();
    matrix.initMatrixToDefaultState();

    menuBar = new MenuBar();
    drawingPanel = new DrawingPanel(board);
    drawingPanel.repaint();
    bunchPane = new BunchPane();

    matrix.addObserver(drawingPanel);
    historyModel.addObserver(bunchPane.getReplayPane());

    fileController = new FileController(drawingPanel, menuBar, matrix, historyModel);
    movementGestor = new MovementGestor(drawingPanel, matrix, historyModel);
    replayController = new ReplayController(bunchPane.getReplayPane(), matrix, historyModel);

    Player playerOne = new Player(1);
    Player playerTwo = new Player(2);

    playerController = new PlayerController(playerOne, playerTwo, bunchPane.getPlayerView());

    setJMenuBar(menuBar.getMenuBar());

    add(drawingPanel, BorderLayout.CENTER);
    add(bunchPane, BorderLayout.LINE_END);
  }
}
