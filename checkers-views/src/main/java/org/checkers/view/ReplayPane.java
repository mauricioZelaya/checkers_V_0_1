package org.checkers.view;

import java.awt.Component;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Box;

public class ReplayPane extends JPanel implements Observer {

  private static final long serialVersionUID = 8778754304558159117L;

  protected JButton fordwardButton;

  public ReplayPane(){
    setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));

    fordwardButton = new JButton("Next Movement");
    fordwardButton.setEnabled(false);

    Component boxSeparator = Box.createRigidArea(new Dimension(7,0));

    setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Replay"));

    add(boxSeparator);
    add(fordwardButton);
  }

  public JButton getFordwardButton() {
    return fordwardButton;
  }


  @Override
  public void update(Observable o, Object arg) {
    fordwardButton.setEnabled((boolean) arg);
  }
}
