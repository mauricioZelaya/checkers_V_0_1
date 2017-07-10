package org.checkers.view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import org.checkers.view.util.MenuItem;

/**
 * Menus and Items are declared and constructed using this class.
 */
public class MenuBar {

  // Declare Menu Bar
  private final JMenuBar menuBar;

  // Declare FileMenu of Menu Bar
  private final JMenu fileMenu;

  // Declare Items of FileMenu
  private final JMenuItem newMenuItem;
  private final JMenuItem saveMenuItem;
  private final JMenuItem loadMenuItem;
  private final JMenuItem saveReplayMenuItem;
  private final JMenuItem loadReplayMenuItem;
  private final JMenuItem exitMenuItem;

  /**
   * Calling this constructor the menu and items will be initialized and displayed when
   * parent container will be showed.
   */
  public MenuBar() {

    menuBar = new JMenuBar();

    fileMenu = new JMenu(MenuItem.MENU_FILE);

    // Create menu items of FileMenu
    newMenuItem = new JMenuItem(MenuItem.FILE_NEW_GAME);
    saveMenuItem = new JMenuItem(MenuItem.FILE_SAVE_GAME);
    loadMenuItem = new JMenuItem(MenuItem.FILE_LOAD_GAME);
    saveReplayMenuItem = new JMenuItem(MenuItem.FILE_SAVE_REPLAY);
    loadReplayMenuItem = new JMenuItem(MenuItem.FILE_LOAD_REPLAY);
    exitMenuItem = new JMenuItem(MenuItem.FILE_EXIT_GAME);

    // Add menu items to FileMenu object
    fileMenu.add(saveMenuItem);
    fileMenu.add(loadMenuItem);
    fileMenu.add(saveReplayMenuItem);
    fileMenu.add(loadReplayMenuItem);
    fileMenu.add(exitMenuItem);

    // Add FileMenu object to MenuBar
    menuBar.add(fileMenu);
  }

  public JMenuBar getMenuBar() {
    return menuBar;
  }

  public JMenuItem getNewMenuItem() {
    return newMenuItem;
  }

  public JMenuItem getSaveMenuItem() {
    return saveMenuItem;
  }

  public JMenuItem getLoadMenuItem() {
    return loadMenuItem;
  }

  public JMenuItem getSaveReplayMenuItem() {
    return saveReplayMenuItem;
  }

  public JMenuItem getLoadReplayMenuItem() {
    return loadReplayMenuItem;
  }

  public JMenuItem getExitMenuItem() {
    return exitMenuItem;
  }
}
