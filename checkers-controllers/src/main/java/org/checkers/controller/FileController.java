package org.checkers.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileController implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Exit")){
            System.exit(0);
        }
    }
}