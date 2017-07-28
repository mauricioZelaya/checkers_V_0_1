package org.checkers.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import org.checkers.model.HistoryModel;
import org.checkers.model.InterfaceMatrix;
import org.checkers.view.ReplayPane;

public class ReplayController implements ActionListener{

  private final ReplayPane replayPane;
  private HistoryModel historyModel;
  private InterfaceMatrix matrix;

  public ReplayController(ReplayPane replay, InterfaceMatrix matrix, HistoryModel historyModel){
    replayPane = replay;
    this.historyModel = historyModel;
    this.matrix = matrix;
    addListeners();
  }

  private void addListeners() {
    replayPane.getFordwardButton().addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if ("Next Movement".equals(e.getActionCommand())){
        fordwardAction();
    }
  }

  private void fordwardAction() {
    String movement = historyModel.getFordwardMovement();
    List<String> steps = Arrays.asList(movement.split(","));
    System.out.println(steps.get(1));
    matrix.moveGamePiece(steps.get(1),steps.get(2));
    if (steps.size() > 3){
      matrix.captureGamePiece(steps.get(3));
    }
    replayPane.getFordwardButton().setEnabled(historyModel.historyHasMovements());
  }
}
