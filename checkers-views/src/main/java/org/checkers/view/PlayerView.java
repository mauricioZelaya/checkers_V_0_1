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
  private JLabel playerNameLabel = CreateLabel("Player Name:");
  private JLabel chipsLabel = CreateLabel("Chips:");
  private JLabel codeLabel = CreateLabel("Player: ");
  private JLabel isTurnLabel = CreateLabel("Is my turn?");

  private JLabel playerNameResponse = CreateLabel("");
  private JLabel chipsResponse = CreateLabel("");
  private JLabel codeResponse = CreateLabel("");
  private JLabel isTurnResponse = CreateLabel("");


  //Player2
  private JLabel playerNameLabel2 = CreateLabel("Player name: ");
  private JLabel chipsLabel2 = CreateLabel("Active chips: ");
  private JLabel codeLabel2 = CreateLabel("Player: ");
  private JLabel isTurnLabel2 = CreateLabel("Is my turn?");

  private JLabel playerNameResponse2 = CreateLabel("");
  private JLabel chipsResponse2 = CreateLabel("");
  private JLabel codeResponse2 = CreateLabel("");
  private JLabel isTurnResponse2 = CreateLabel("");


  public PlayerView() {

    JPanel mainContainer = new JPanel();
    mainContainer.setLayout(new GridBagLayout());

    JPanel playerOnePanel = CreatePanel();
    JPanel playerTwoPanel = CreatePanel();

    mainContainer.add(playerOnePanel, MainPanelConstraints(0,0));
    mainContainer.add(playerTwoPanel, MainPanelConstraints(0,1));

    BorderCreation(playerOnePanel,"Player One");
    BorderCreation(playerTwoPanel,"Player Two");

    /*Formating
     * for player 1
     * information*/

    playerOnePanel.add(playerNameLabel, RowsConstraints(0,1));
    playerOnePanel.add(playerNameResponse, RowsConstraints(1,1));
    playerOnePanel.add(chipsLabel, RowsConstraints(0,2));
    playerOnePanel.add(chipsResponse, RowsConstraints(1,2));
    playerOnePanel.add(codeLabel, RowsConstraints(0,3));
    playerOnePanel.add(codeResponse, RowsConstraints(1,3));
    playerOnePanel.add(isTurnLabel, RowsConstraints(0,4));
    playerOnePanel.add(isTurnResponse, RowsConstraints(1,4));

     /*Formating
     * for player 2
     * information*/

    playerTwoPanel.add(playerNameLabel2, RowsConstraints(0,1));
    playerTwoPanel.add(playerNameResponse2, RowsConstraints(1,1));
    playerTwoPanel.add(chipsLabel2, RowsConstraints(0,2));
    playerTwoPanel.add(chipsResponse2, RowsConstraints(1,2));
    playerTwoPanel.add(codeLabel2, RowsConstraints(0,3));
    playerTwoPanel.add(codeResponse2, RowsConstraints(1,3));
    playerTwoPanel.add(isTurnLabel2, RowsConstraints(0,4));
    playerTwoPanel.add(isTurnResponse2, RowsConstraints(1,4));

    //Adding the whole panel to the screen
    add(mainContainer);

  }
  //Sets and gets for Chips response
  public void setChipsResponse(int chipsLabel) {
    chipsResponse.setText(Integer.toString(chipsLabel));
  }
  public void setChipsResponse2(int chipsLabel2) {
    chipsResponse2.setText(Integer.toString(chipsLabel2));
  }
  public void setCodeResponse(int codeResponse) {
    this.codeResponse.setText(Integer.toString(codeResponse));
  }
  public void setCodeResponse2(int codeResponse2) {
    this.codeResponse2.setText(Integer.toString(codeResponse2));
  }
  public void setPlayerNameResponse(String playerNameResponse) {this.playerNameResponse.setText(playerNameResponse);}
  public void setPlayerNameResponse2(String playerNameResponse2) {this.playerNameResponse2.setText(playerNameResponse2);}

  /**
   * updates the UI for player1 with the correct turn status
   * @param isTurnResponse - Receives a boolean value for the turn and
   */
  public void setIsTurnResponse(int playerCode, boolean isTurnResponseValue) {
    if (playerCode == 1) {
      if (isTurnResponseValue) {
        isTurnResponse.setText("Yes");
      } else {
        isTurnResponse.setText("No");
      }
    } else {
      if (isTurnResponseValue) {
        isTurnResponse2.setText("Yes");
      } else {
        isTurnResponse2.setText("No");
      }
    }
  }

  /**
   *Receives a label detail and created a label out of it
   * @param Receives a label detail
   * @return Jlabel
   */
  private JLabel CreateLabel(String labelDetail){
    return new JLabel(labelDetail);
  }

  /**
   * Crates a panel from with GridBagLayout
   * @return Jpanel with GridBagLayour
   */
  private JPanel CreatePanel(){
    return new JPanel(new GridBagLayout());
  }

  /**
   * Receives the panel and a String with the detail of the panels and creates the borders
   * @param panel - A existing JPanel
   * @param detail - A sting wit the detail
   */
  private void BorderCreation(JPanel panel,String detail){

    panel.setBorder(BorderFactory.createTitledBorder(
        BorderFactory.createEtchedBorder(), detail));

  }

  /**
   * Creates the constraints for the formatting of the 2 main panels
   * @param x - grid x order number
   * @param y - grid y order number
   * @return - GridBagLayout formated
   */
  private GridBagConstraints MainPanelConstraints(int x, int y){
    GridBagConstraints mainPanelFormatting = new GridBagConstraints();
    mainPanelFormatting.gridwidth = GridBagConstraints.RELATIVE;
    mainPanelFormatting.fill = GridBagConstraints.HORIZONTAL;
    mainPanelFormatting.gridx = x;
    mainPanelFormatting.gridy = y;
    mainPanelFormatting.anchor = GridBagConstraints.CENTER;
    return mainPanelFormatting;
  }
    /**
   * Creates the constraints for the formatting of the rows inside de panels
   * @param x - grid x order number
   * @param y - grid y order number
   * @return - GridBagLayout formated
   */

  private GridBagConstraints RowsConstraints(int x, int y){
    GridBagConstraints panelFormatting = new GridBagConstraints();
    panelFormatting.insets = new Insets(10, 10, 10, 10);
    panelFormatting.anchor = GridBagConstraints.CENTER;
    panelFormatting.gridx = x;
    panelFormatting.gridy = y;
    return panelFormatting;
  }
}

