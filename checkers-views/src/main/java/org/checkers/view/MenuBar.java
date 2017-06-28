package org.checkers.view;

import org.checkers.controller.FileController;

import javax.swing.*;

public class MenuBar {

    //Creation of the MenuBar object
    private JMenuBar menuBar;
    //Creation of each one of the menu main items
    private JMenu fileMenu;

    //Creation of menu items
    private JMenuItem saveMenuItem;
    private JMenuItem loadMenuItem;
    private JMenuItem saveReplayMenuItem;
    private JMenuItem loadReplayMenuItem;
    private JMenuItem exitMenuItem;

    private FileController controller;

    public MenuBar(){

        controller = new FileController();

        menuBar = new JMenuBar();

        //Building FileMenu
        fileMenu = new JMenu("File");

        //Buildig save with action listener
        saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(controller);
        fileMenu.add(saveMenuItem);

        //Buildig save with action listener

        loadMenuItem = new JMenuItem("Load");
        loadMenuItem.addActionListener(controller);
        fileMenu.add(loadMenuItem);


        //Buildig saveReplay with action listener
        saveReplayMenuItem = new JMenuItem("Save Replay");
        saveReplayMenuItem.addActionListener(controller);
        fileMenu.add(saveReplayMenuItem);

        //Buildig loadReplay with action listener
        loadReplayMenuItem = new JMenuItem("Load Replay");
        loadReplayMenuItem.addActionListener(controller);
        fileMenu.add(loadReplayMenuItem);

        //Buildig exit (action listener will be implemented differently)
        exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(controller);
        fileMenu.add(exitMenuItem);

        // add menus to menubar
        menuBar.add(fileMenu);
    }

    public JMenuBar getMenuBar(){
        return menuBar;
    }
}
