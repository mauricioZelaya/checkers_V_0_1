package org.checkers.view;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Box;

public class ReplayPane extends JPanel {

  private static final long serialVersionUID = 8778754304558159117L;

  protected JButton backwardButton;
  protected JButton fordwardButton;

  public ReplayPane(){
    setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

    backwardButton = new JButton("Backward");
    fordwardButton = new JButton("Fordward");

    Component boxSeparator = Box.createRigidArea(new Dimension(7,0));

    setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Replay"));

    add(backwardButton);
    add(boxSeparator);
    add(fordwardButton);
  }

  public JButton getBackwardButton() {
    return backwardButton;
  }

  public JButton getFordwardButton() {
    return fordwardButton;
  }
}
