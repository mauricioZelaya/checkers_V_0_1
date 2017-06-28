package org.checkers.app;

import org.checkers.view.DrawingPanel;
import org.checkers.view.MenuBar;

import javax.swing.JFrame;
/**
 * Write a description of class DrawingWindow here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DrawingWindow extends JFrame
{
   private DrawingPanel panel;
   private MenuBar menuBar;

   public DrawingWindow(String title) {
       super(title);

       panel = new DrawingPanel();

       menuBar = new MenuBar();

       setJMenuBar(menuBar.getMenuBar());
       
       panel.setSize(300, 300);
       getContentPane().add(panel);
   }
}
