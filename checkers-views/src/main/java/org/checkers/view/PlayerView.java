package org.checkers.view;

import javax.swing.JPanel;
package org.checkers.view;
import java.awt.*;
import javax.swing.*;

/**
 * Created by Kenneth on 7/10/2017.
 * This class defines the view for the entire player information
 */
public class PlayerView extends JPanel {

  //Player1
  private JLabel playerNameLabel = new JLabel("Player name: ");
  private JLabel chipsLabel = new JLabel("Active chips: ");
  private JLabel codeLabel = new JLabel("Player: ");
  private JLabel isTurnLabel = new JLabel("Is my turn?");

  private JTextField playerNameText = new JTextField(10);
  private JTextField chipsText = new JTextField(10);
  private JTextField codeText = new JTextField(10);
  private JTextField isTurnText = new JTextField(10);

  //Player2
  private JLabel playerNameLabel2 = new JLabel("Nombre del jugador: ");
  private JLabel chipsLabel2 = new JLabel("Cantidad de chips: ");
  private JLabel codeLabel2 = new JLabel("Jugador: ");
  private JLabel isTurnLabel2 = new JLabel("Es mi turno?");


  private JLabel playerNameTextReturn2 = new JLabel("test");
  private JLabel chipsTextReturn2 = new JLabel("test");
  private JLabel codeTextReturn2 = new JLabel("test");
  private JLabel isTurnTextReturn2 = new JLabel("test");

  public PlayerView() {

    JPanel mainContainer = new JPanel();
    mainContainer.setBackground(Color.green);

    mainContainer.setLayout(new GridBagLayout());
    GridBagConstraints mainPanelFormatting = new GridBagConstraints();

    JPanel playerOnePanel = new JPanel(new GridBagLayout());
    JPanel playerTwoPanel = new JPanel(new GridBagLayout());

    // set border for the panel for Player 1
    playerOnePanel.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createEtchedBorder(), "Player 1"));

    // set border for the panel fro Player 2
    playerTwoPanel.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createEtchedBorder(), "Player 2"));

    GridBagConstraints panelFormatting = new GridBagConstraints();
    panelFormatting.insets = new Insets(10, 10, 10, 10);
    panelFormatting.anchor = GridBagConstraints.CENTER;


    mainPanelFormatting.gridx = 0;
    mainPanelFormatting.gridy = 1;
    mainPanelFormatting.weightx = 0.5;
    mainPanelFormatting.anchor = GridBagConstraints.CENTER;
    mainContainer.add(playerOnePanel, mainPanelFormatting);

    mainPanelFormatting.weightx = 0.5;
    mainPanelFormatting.gridx = 0;
    mainPanelFormatting.gridy = 2;
    mainPanelFormatting.anchor = GridBagConstraints.CENTER;
    mainContainer.add(playerTwoPanel, mainPanelFormatting);
    /*Formating
     * for player 1
     * information*/

    // First row
    panelFormatting.gridx = 0;
    panelFormatting.gridy = 1;
    playerOnePanel.add(playerNameLabel, panelFormatting);

    panelFormatting.gridx = 1;
    panelFormatting.gridy = 1;
    playerOnePanel.add(playerNameText, panelFormatting);

    //Second row
    panelFormatting.gridx = 0;
    panelFormatting.gridy = 2;
    playerOnePanel.add(chipsLabel, panelFormatting);

    panelFormatting.gridx = 1;
    panelFormatting.gridy = 2;
    playerOnePanel.add(chipsText, panelFormatting);

    // Third row

    panelFormatting.gridx = 0;
    panelFormatting.gridy = 3;
    playerOnePanel.add(codeLabel, panelFormatting);

    panelFormatting.gridx = 1;
    panelFormatting.gridy = 3;
    playerOnePanel.add(codeText, panelFormatting);

    //forht row

    panelFormatting.gridx = 0;
    panelFormatting.gridy = 4;
    playerOnePanel.add(isTurnLabel, panelFormatting);

    panelFormatting.gridx = 1;
    panelFormatting.gridy = 4;
    playerOnePanel.add(isTurnText, panelFormatting);

     /*Formating
     * for player 2
     * information*/

    // First row
    panelFormatting.gridx = 0;
    panelFormatting.gridy = 1;
    playerTwoPanel.add(playerNameLabel2, panelFormatting);

    panelFormatting.gridx = 1;
    panelFormatting.gridy = 1;
    playerTwoPanel.add(playerNameTextReturn2, panelFormatting);

    //Second row
    panelFormatting.gridx = 0;
    panelFormatting.gridy = 2;
    playerTwoPanel.add(chipsLabel2, panelFormatting);

    panelFormatting.gridx = 1;
    panelFormatting.gridy = 2;
    playerTwoPanel.add(chipsTextReturn2, panelFormatting);

    // Third row

    panelFormatting.gridx = 0;
    panelFormatting.gridy = 3;
    playerTwoPanel.add(codeLabel2, panelFormatting);

    panelFormatting.gridx = 1;
    panelFormatting.gridy = 3;
    playerTwoPanel.add(codeTextReturn2, panelFormatting);


    panelFormatting.gridx = 0;
    panelFormatting.gridy = 4;
    playerTwoPanel.add(isTurnLabel2, panelFormatting);

    panelFormatting.gridx = 1;
    panelFormatting.gridy = 4;
    playerTwoPanel.add(isTurnTextReturn2, panelFormatting);


    //Adding the whole panel to the screen
    add(mainContainer);

  }

  //Player one view Sets and gets
  public String getPlayerName() {
    return playerNameText.getText();
  }

  public int getChips() {
    return Integer.parseInt(chipsText.getText());
  }

  public int getCode() {
    return Integer.parseInt(codeText.getText());
  }

  public String getIsTurn() {
    return isTurnText.getText();
  }

  public void setViewCode2(int code) {
    codeTextReturn2.setText(Integer.toString(code));
  }

  public void setViewChips2(int chips) {
    chipsTextReturn2.setText(Integer.toString(chips));
  }

  public void setViewPlayerName2(String PlayerName) {
    playerNameTextReturn2.setText(PlayerName);
  }

  public void setViewIsTurn2(Boolean isTurn) {
    isTurnTextReturn2.setText(isTurn.toString());
  }
}

