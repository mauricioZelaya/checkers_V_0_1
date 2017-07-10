package org.checkers.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.checkers.view.MenuBar;
import org.checkers.view.util.MenuItem;

public class FileController implements ActionListener {

  private final MenuBar menuBar;

  public FileController(MenuBar menuBar) {
    this.menuBar = menuBar;
    addListeners();
  }

  private void addListeners() {
    menuBar.getExitMenuItem().addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals(MenuItem.FILE_EXIT_GAME)) {
      System.exit(0);
    }
  }
}