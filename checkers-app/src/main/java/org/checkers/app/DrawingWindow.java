package org.checkers.app;

import org.checkers.controller.FileController;
import org.checkers.view.DrawingPanel;
import org.checkers.view.PlayerView;
import org.checkers.view.MenuBar;
import org.checkers.controller.PlayerController;
import org.checkers.model.Player;

import java.awt.*;
import javax.swing.JFrame;

/**
 * Updated by Kenneth on 7/11/2017.
 * Added the proper container to display the view of the player along with the view of the drawing
 */
public class DrawingWindow extends JFrame {
  // Creation of the Drawing Panel (The board)
  private DrawingPanel panel = new DrawingPanel();
  private MenuBar menuBar;

  // Creation of the controller
  private PlayerController miPlayerController;

  //Drawing window construction
  public DrawingWindow(String title) {
    super(title);
    setLayout(new BorderLayout());

    //protected FileController controller;

      //Player Contruction

      Player miPlayerOne = new Player(1);
      Player miPlayerTwo = new Player(2);
      PlayerView newView = new PlayerView();
      PlayerController miPlayerController = new PlayerController(miPlayerOne, miPlayerTwo, newView);

      miPlayerController.NextPlayerTurn(miPlayerOne,miPlayerTwo, newView);
      miPlayerController.NextPlayerTurn(miPlayerOne,miPlayerTwo, newView);

      miPlayerController.DeacreaseChipControl(miPlayerOne,newView);
      miPlayerController.DeacreaseChipControl(miPlayerOne,newView);
      miPlayerController.DeacreaseChipControl(miPlayerOne,newView);

      miPlayerController.DeacreaseChipControl(miPlayerTwo,newView);
      miPlayerController.DeacreaseChipControl(miPlayerTwo,newView);
      miPlayerController.DeacreaseChipControl(miPlayerTwo,newView);
      miPlayerController.DeacreaseChipControl(miPlayerTwo,newView);
      miPlayerController.DeacreaseChipControl(miPlayerTwo,newView);

      menuBar = new MenuBar();
      setJMenuBar(menuBar.getMenuBar());
      add(panel, BorderLayout.CENTER);
      add(newView, BorderLayout.EAST);

      // Menu bar construction

      //Setting menubar and both panels to the main frame


      //controller = new FileController(menuBar);

    }
  }
