package org.checkers.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.checkers.view.ReplayPane;

public class ReplayController implements ActionListener{

  private final ReplayPane replayPane;

  public ReplayController(ReplayPane replay){
    replayPane = replay;
    addListeners();
  }

  private void addListeners() {
    replayPane.getBackwardButton().addActionListener(this);
    replayPane.getFordwardButton().addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()){
      case "Backward":
        backwardAction();
        break;
      default:
        fordwardAction();
        break;
    }
  }

  private void backwardAction() {
    System.out.println("Replay: backward action");
  }

  private void fordwardAction() {
    System.out.println("Replay: fordward action");
  }
}
