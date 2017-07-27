package org.checkers.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

public class BunchPane extends JPanel{
  private static final long serialVersionUID = -6054874751622774800L;

  protected PlayerView playerView;
  protected ReplayPane replayPane;

  public BunchPane(){
    setLayout(new BorderLayout(10,10));

    playerView = new PlayerView();
    replayPane = new ReplayPane();

    setPreferredSize(new Dimension(200,200));
    add(playerView, BorderLayout.CENTER);
    add(replayPane, BorderLayout.PAGE_END);
  }

  public PlayerView getPlayerView() {
    return playerView;
  }

  public ReplayPane getReplayPane() {
    return replayPane;
  }
}
