package org.checkers.view;

import java.awt.Component;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TimerView extends JPanel implements Observer{

  private static final long serialVersionUID = 1858432219240702834L;
  private final JLabel timeLabel;

  public TimerView(){
    setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Timer"));

    timeLabel = new JLabel("00:00:00", SwingConstants.CENTER);
    timeLabel.setFont(new Font("Segoe UI", 0, 18));
    timeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

    add(timeLabel);
  }

  @Override
  public void update(Observable o, Object arg) {
    timeLabel.setText((String) arg);
  }

  /**
   * Following is an usage example, remove when will be added to game

  public static void main(String... args) {
    JFrame window = new JFrame("Cronometro");
    window.setLayout(new BorderLayout());
    window.setPreferredSize(new Dimension(100,100));

    //MOdel
    TimerModel timerModel = new TimerModel();

    //View
    TimerView timerView = new TimerView();

    //Obervar
    timerModel.addObserver(timerView);
    timerModel.initTimer();

    window.add(timerView, BorderLayout.CENTER);

    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.pack();

    window.setVisible(true);
  }
   */
}
