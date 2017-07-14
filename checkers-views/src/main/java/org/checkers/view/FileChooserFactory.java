package org.checkers.view;

import java.io.File;

import javax.swing.JFileChooser;

import org.checkers.view.util.MenuItem;

/**
 * FileChooserFactory class creates a JFileChooser dialog in order to send requested File object.
 */
public class FileChooserFactory {

  /**
   * It will display a dialog in order to return a File object.
   * @param menuEvent String object. Review MenuItem class to know available values.
   * @return File selected in the dialog, NULL if select cancel.
   * @see MenuItem
   */
  public static File getFile(String menuEvent) {
    JFileChooser fileChooser = new JFileChooser();
    int result;

    switch (menuEvent) {
      case MenuItem.FILE_SAVE_GAME:
        fileChooser.setDialogTitle("Save Game");
        result = fileChooser.showSaveDialog(null);
        break;

      case MenuItem.FILE_LOAD_GAME:
        fileChooser.setDialogTitle("Load Game");
        result = fileChooser.showOpenDialog(null);
        break;

      case MenuItem.FILE_SAVE_REPLAY:
        fileChooser.setDialogTitle("Save Replay");
        result = fileChooser.showSaveDialog(null);
        break;

      case MenuItem.FILE_LOAD_REPLAY:
        fileChooser.setDialogTitle("Load Replay");
        result = fileChooser.showOpenDialog(null);
        break;

      default:
        throw new NullPointerException("Selected option is not recognized as valid value.");
    }

    return result == JFileChooser.APPROVE_OPTION ? fileChooser.getSelectedFile() : null;
  }
}
