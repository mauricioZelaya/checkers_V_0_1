package org.checkers.view;

import javax.swing.JOptionPane;

import org.checkers.view.util.MenuItem;

/**
 * FileChooserFactory class creates a JFileChooser dialog in order to send requested File object.
 */
public class DialogFactory {

  /**
   * It will display a dialog in order to confirm event action.
   * @param event String objetc. Review MenuItem class to know available values.
   * @return TRUE if click YES, FALSE when clicking NO.
   * @see MenuItem
   */
  public static boolean confirmMsg(String event) {
    String message;
    String title;

    switch (event) {
      case MenuItem.FILE_NEW_GAME:
        message = "Are you sure you want to start a new game?";
        title = "New Game";
        break;

      case MenuItem.FILE_EXIT_GAME:
        message = "Are you sure you want to exit?";
        title = "Exit Game";
        break;

      default:
        throw new NullPointerException("Selected option is not recognized as valid value.");
    }

    int result = JOptionPane.showConfirmDialog(null, message, title,
        JOptionPane.YES_NO_OPTION);

    return result != 1;
  }
}
