package org.checkers.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;

import org.checkers.model.HistoryModel;
import org.checkers.model.InterfaceMatrix;
import org.checkers.view.DialogFactory;
import org.checkers.view.FileChooserFactory;
import org.checkers.view.MenuBar;
import org.checkers.view.util.MenuItem;

/**
 * FileController will listen all requests from MenuBar view. It will ask to a model for data in
 * order to send them to proper view or another model.
 */
public class FileController implements ActionListener {

  private final MenuBar menuBar;
  private final InterfaceMatrix matrix;
  private final JPanel panel;

  /**
   * Contructor of FileController class. It requires a MenuBar view to be initialized.
   * @param menuBar  The MenuBar view
   */
  public FileController(final JPanel panel, MenuBar menuBar, final InterfaceMatrix matrix) {
    this.menuBar = menuBar;
    this.matrix = matrix;
    this.panel = panel;
    addListeners();
  }

  /**
   * FileController listen through this method all event actions made in MenuBar.
   * @param e  ActionEvent listened by the controller
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    String selectedItem = e.getActionCommand();

    switch (e.getActionCommand()) {
      case MenuItem.FILE_NEW_GAME:
        newGame();
        break;
      case MenuItem.FILE_SAVE_GAME:
        saveGame();
        break;
      case MenuItem.FILE_LOAD_GAME:
        loadGame();

        break;
      case MenuItem.FILE_SAVE_REPLAY:
        saveReplay();
        break;
      case MenuItem.FILE_LOAD_REPLAY:
        loadReplay();
        break;
      default:
        if (DialogFactory.confirmMsg(MenuItem.FILE_NEW_GAME)) {
          System.exit(0);
        }
        break;
    }
  }

  /**
   * It will call a dialog in order to confirm if user wants to start a new game. I will update
   * the Board class if user confirm action.
   */
  protected void newGame() {
    boolean result = DialogFactory.confirmMsg(MenuItem.FILE_NEW_GAME);
    if (result) {
      // Replace following line with correct behaviour
      System.out.println("Notify to Board in order to start a new game");
    }
  }

  /**
   * It will call a dialog in order to create a File. It will be send it to HistoryBoard class in
   * order to record current game data.
   */
  protected void saveGame() {
    File file = FileChooserFactory.getFile(MenuItem.FILE_SAVE_GAME);
    if (file != null) {
      HistoryModel model = new HistoryModel();
      model.clearExistFile(file);
      model.saveGameState(matrix, file);
      System.out.println("Send file to HistoryBoard");
    }
    if(!file.exists())
    {
      try {
        file.createNewFile();

        HistoryModel model = new HistoryModel();
        model.saveGameState(matrix, file);
        System.out.println("Send file to HistoryBoard");
      } catch (IOException e) {
        System.err.print(e.getMessage());
      }
    }
  }

  /**
   * It will call a dialog in order to load a File. It will be send it to HistoryBoard class in
   * order to load recorded game data.
   */
  protected void loadGame() {
    File file = FileChooserFactory.getFile(MenuItem.FILE_LOAD_GAME);

    if (file != null) {
      HistoryModel model = new HistoryModel();
      int[][] newMatrix = model.loadGameState(matrix, file);
      matrix.repaintMatrix(newMatrix);
      panel.repaint();
      System.out.println("Send file to HistoryBoard");
    }

    //panel.repaint();
  }

  /**
   * It will call a dialog in order to create a File. It will be send it to HistoryBoard class in
   * order to record history data of current game.
   */
  protected void saveReplay() {
    File file = FileChooserFactory.getFile(MenuItem.FILE_SAVE_REPLAY);
    if (file != null) {
      // Replace following line with correct behaviour
      System.out.println("Send file to HistoryBoard");
    }
  }

  /**
   * It will call a dialog in order to create a File. It will be send it to HistoryBoard class in
   * order to load the history of a game.
   */
  protected void loadReplay() {
    File file = FileChooserFactory.getFile(MenuItem.FILE_LOAD_REPLAY);
    if (file != null) {
      // Replace following line with correct behaviour
      System.out.println("Send file to HistoryBoard");
    }
  }

  /**
   * Private classe to add listener to all MenuItems in MenuBar.
   */
  private void addListeners() {
    menuBar.getNewMenuItem().addActionListener(this);
    menuBar.getSaveMenuItem().addActionListener(this);
    menuBar.getLoadMenuItem().addActionListener(this);
    menuBar.getSaveReplayMenuItem().addActionListener(this);
    menuBar.getLoadReplayMenuItem().addActionListener(this);
    menuBar.getExitMenuItem().addActionListener(this);
  }
}