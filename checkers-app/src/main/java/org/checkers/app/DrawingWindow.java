package org.checkers.app;

import org.checkers.model.Player;
import org.checkers.view.DrawingPanel;
import org.checkers.view.PlayerView;
import org.checkers.view.MenuBar;
import org.checkers.controller.PlayerController;

import java.awt.*;
import javax.swing.JFrame;

/**
 * Updated by Kenneth on 7/11/2017.
 * Added the proper container to display the view of the player along with the view of the drawing
 */
public class DrawingWindow extends JFrame {
  // Creation of the Drawing Panel (The board)
  private DrawingPanel panel;
  private MenuBar menuBar;
  // Creation of the controller
  private PlayerController miPlayerController;

  //Drawing window construction
  public DrawingWindow(String title) {
    super(title);
    setLayout(new BorderLayout());

    panel = new DrawingPanel();

    //Player Contruction

    Player miPlayerOne = new Player(1);
    Player miPlayerTwo = new Player(2);
    PlayerView newView = new PlayerView();
    PlayerController miPlayerController = new PlayerController(miPlayerOne, miPlayerTwo, newView);
    // Menu bar construction
    menuBar = new MenuBar();
    //Setting menubar and both panels to the main frame
    setJMenuBar(menuBar.getMenuBar());
    add(panel, BorderLayout.CENTER);
    add(newView, BorderLayout.EAST);

  }
}
