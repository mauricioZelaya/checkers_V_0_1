package org.checkers.app;
import org.checkers.model.Player;
import org.checkers.view.DrawingPanel;
import org.checkers.view.PlayerView;
import org.checkers.view.MenuBar;
import org.checkers.controller.PlayerController;

import java.awt.*;
import javax.swing.JFrame;
/**
 * Write a description of class DrawingWindow here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DrawingWindow extends JFrame {

  private DrawingPanel panel;
  private MenuBar menuBar;
  private PlayerController miPlayerController;

  public DrawingWindow(String title) {
    super(title);
    setLayout(new BorderLayout());

    panel = new DrawingPanel();
    PlayerView newView = new PlayerView();

    Player miPlayerOne = new Player(1);
    Player miPlayerTwo = new Player(1);

    PlayerController miPlayerController = new PlayerController(miPlayerOne, miPlayerTwo, newView);

    menuBar = new MenuBar();

    setJMenuBar(menuBar.getMenuBar());

    add(panel, BorderLayout.CENTER);
    add(newView, BorderLayout.EAST);

  }
}
