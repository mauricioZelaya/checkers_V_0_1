package org.checkers.app;

import javax.swing.*;


public class Checkers {
    public static void main(String args[]) {
        DrawingWindow window = new DrawingWindow("Checkers Game v0.1");
        window.setSize(600, 600);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
