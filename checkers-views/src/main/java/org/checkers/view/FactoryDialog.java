package org.checkers.view;

import java.io.File;

import javax.swing.JFileChooser;

/**
 *
 */
public class FactoryDialog {

  public static File openDialog(){
    JFileChooser fileChooser = new JFileChooser();
    int result = fileChooser.showOpenDialog(null);

    return result == JFileChooser.APPROVE_OPTION ? fileChooser.getSelectedFile() : null;
  }

  public static File saveDialog(){
    JFileChooser fileChooser = new JFileChooser();
    int result = fileChooser.showSaveDialog(null);

    return result == JFileChooser.APPROVE_OPTION ? fileChooser.getSelectedFile() : null;
  }
}
