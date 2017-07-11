package org.checkers.view;
import javax.swing.JPanel;
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

  private JLabel playerNameResponse = new JLabel("test");
  private JLabel chipsResponse = new JLabel("test");
  private JLabel codeResponse = new JLabel("test");
  private JLabel isTurnResponse = new JLabel("test");


  //Player2
  private JLabel playerNameLabel2 = new JLabel("Player name: ");
  private JLabel chipsLabel2 = new JLabel("Active chips: ");
  private JLabel codeLabel2 = new JLabel("Player: ");
  private JLabel isTurnLabel2 = new JLabel("Is my turn?");

  private JLabel playerNameResponse2 = new JLabel("test2");
  private JLabel chipsResponse2 = new JLabel("test2");
  private JLabel codeResponse2 = new JLabel("test2");
  private JLabel isTurnResponse2 = new JLabel("test2");


  public PlayerView() {

    JPanel mainContainer = new JPanel();
    //mainContainer.setBackground(Color.green);

    mainContainer.setLayout(new GridBagLayout());
    GridBagConstraints mainPanelFormatting = new GridBagConstraints();
  mainPanelFormatting.gridwidth = java.awt.GridBagConstraints.RELATIVE;
  mainPanelFormatting.fill = java.awt.GridBagConstraints.HORIZONTAL;

  mainPanelFormatting.weightx = 1.0;
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
    mainPanelFormatting.gridy = 0;
    mainPanelFormatting.anchor = GridBagConstraints.CENTER;
    mainContainer.add(playerOnePanel, mainPanelFormatting);

    mainPanelFormatting.gridx = 0;
    mainPanelFormatting.gridy = 1;
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
    playerOnePanel.add(playerNameResponse, panelFormatting);

    //Second row
    panelFormatting.gridx = 0;
    panelFormatting.gridy = 2;
    playerOnePanel.add(chipsLabel, panelFormatting);

    panelFormatting.gridx = 1;
    panelFormatting.gridy = 2;
    playerOnePanel.add(chipsResponse, panelFormatting);

    // Third row

    panelFormatting.gridx = 0;
    panelFormatting.gridy = 3;
    playerOnePanel.add(codeLabel, panelFormatting);

    panelFormatting.gridx = 1;
    panelFormatting.gridy = 3;
    playerOnePanel.add(codeResponse, panelFormatting);

    //forht row

    panelFormatting.gridx = 0;
    panelFormatting.gridy = 4;
    playerOnePanel.add(isTurnLabel, panelFormatting);

    panelFormatting.gridx = 1;
    panelFormatting.gridy = 4;
    playerOnePanel.add(isTurnResponse, panelFormatting);

     /*Formating
     * for player 2
     * information*/

    // First row
    panelFormatting.gridx = 0;
    panelFormatting.gridy = 1;
    playerTwoPanel.add(playerNameLabel2, panelFormatting);

    panelFormatting.gridx = 1;
    panelFormatting.gridy = 1;
    playerTwoPanel.add(playerNameResponse2, panelFormatting);

    //Second row
    panelFormatting.gridx = 0;
    panelFormatting.gridy = 2;
    playerTwoPanel.add(chipsLabel2, panelFormatting);

    panelFormatting.gridx = 1;
    panelFormatting.gridy = 2;
    playerTwoPanel.add(chipsResponse2, panelFormatting);

    // Third row

    panelFormatting.gridx = 0;
    panelFormatting.gridy = 3;
    playerTwoPanel.add(codeLabel2, panelFormatting);

    panelFormatting.gridx = 1;
    panelFormatting.gridy = 3;
    playerTwoPanel.add(codeResponse2, panelFormatting);


    panelFormatting.gridx = 0;
    panelFormatting.gridy = 4;
    playerTwoPanel.add(isTurnLabel2, panelFormatting);

    panelFormatting.gridx = 1;
    panelFormatting.gridy = 4;
    playerTwoPanel.add(isTurnResponse2, panelFormatting);


    //Adding the whole panel to the screen
    add(mainContainer);

  }
//Sets for Chips response

  public void setChipsLabel(int chipsLabel) {
    chipsResponse.setText(Integer.toString(chipsLabel));
  }

  public void setChipsLabel2(int chipsLabel2) {
    chipsResponse2.setText(Integer.toString(chipsLabel2));
  }
//Sets for code response
  public void setCodeResponse(int codeResponse) {
    this.codeResponse.setText(Integer.toString(codeResponse));
  }

  public void setCodeResponse2(int codeResponse2) {
    this.codeResponse2.setText(Integer.toString(codeResponse2));
  }
//Sets for turns
  public void setIsTurnResponse(boolean isTurnResponse) {
    if(isTurnResponse){
      this.isTurnResponse.setText("Yes");
    }
    else{
      this.isTurnResponse.setText("No");
    }
  }

  public void setIsTurnResponse2(boolean isTurnResponse2) {
    if(isTurnResponse2){
      this.isTurnResponse2.setText("Yes");
    }
    else{
          this.isTurnResponse2.setText("No");
    }
  }
//Sets for player name
  public void setPlayerNameResponse(String playerNameResponse) {
    this.playerNameResponse.setText(playerNameResponse);
  }

  public void setPlayerNameResponse2(String playerNameResponse2) {
    this.playerNameResponse2.setText(playerNameResponse2);
  }
}

