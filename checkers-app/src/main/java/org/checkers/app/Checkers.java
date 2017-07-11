package org.checkers.app;

import javax.swing.*;


public class Checkers {
  public static void main(String args[]) {
    DrawingWindow window = new DrawingWindow("Checkers Game v0.1");
    window.setSize(800, 600);

    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setLocationRelativeTo(null);
    window.setVisible(true);
  }
}
