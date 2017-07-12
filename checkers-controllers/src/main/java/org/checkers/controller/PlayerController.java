package org.checkers.controller;

import org.checkers.model.Player;
import org.checkers.view.PlayerView;

/**
 * Created by Kenneth on 7/10/2017.
 * Controller for the execution of player model and view
 */
public class PlayerController {

  //Creation of the player model
  private Player thePlayer;
  private Player thePlayer2;
  //Creation of the player  view
  private PlayerView thePlayerView;

  //Controller construction
  public PlayerController(Player thePlayer, Player thePlayer2, PlayerView thePlayerView) {

    this.thePlayerView = thePlayerView;
    this.thePlayer = thePlayer;
    this.thePlayer2 = thePlayer2;
    //Getting all the info from the object player one and passing it to the view
    thePlayer.setName("Kenneth Perez");
    thePlayer.setTurn(true);
    thePlayerView.setPlayerNameResponse(thePlayer.getName());
    thePlayerView.setChipsLabel(thePlayer.getChips());
    thePlayerView.setCodeResponse(thePlayer.getCode());
    thePlayerView.setIsTurnResponse(thePlayer.isTurn());

   //Getting all the info from the object player two and passing it to the view
    thePlayer2.setName("Leonardo Antezana");
    thePlayerView.setCodeResponse2(thePlayer2.getCode());
    thePlayerView.setChipsLabel2(thePlayer2.getChips());
    thePlayerView.setPlayerNameResponse2(thePlayer2.getName());
    thePlayerView.setIsTurnResponse2(thePlayer2.isTurn());
  }

  /**
   * SetPlayerTurn allows the asignation to of the turn to a specific player
   * @param turn
   * receives the turn that will be assigned to the player
   * @param player
   * Received the player wich turn will be assigned
   */
  public void SetPlayerTurn(boolean turn, Player player){
    player.setTurn(turn);
  }

  /**
   * GetPlayerTurn allows a request of the status of the variable turn of a specific player
   * @param player
   * Receibes the player wich turn will be consulted
   * @return
   * a boolean value representing if its the player turn or not
   */
  public boolean GetPlayerTurn(Player player){
    return player.isTurn();
  }

  }
