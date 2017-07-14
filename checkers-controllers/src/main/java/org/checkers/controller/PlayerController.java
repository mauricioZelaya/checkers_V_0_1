package org.checkers.controller;

import org.checkers.model.Player;
import org.checkers.view.PlayerView;

/**
 * Created by Kenneth on 7/10/2017.
 * Controller for the execution of player model and view
 */
public class PlayerController {

  //Creation of the player model
  /*private Player thePlayer;
  private Player thePlayer2;*/
  //Creation of the player  view
  private PlayerView thePlayerView;

  //Controller construction
  public PlayerController(Player thePlayer, Player thePlayer2, PlayerView thePlayerView) {

    /*this.thePlayerView = thePlayerView;
    this.thePlayer = thePlayer;
    this.thePlayer2 = thePlayer2;*/
    //Getting all the info from the object player one and passing it to the view
    thePlayer.setName("Kenneth Perez");
    thePlayer.setTurn(true);
    thePlayerView.setPlayerNameResponse(thePlayer.getName());
    thePlayerView.setChipsResponse(thePlayer.getChips());
    thePlayerView.setCodeResponse(thePlayer.getCode());
    thePlayerView.setIsTurnResponse(thePlayer.isTurn());

   //Getting all the info from the object player two and passing it to the view
    thePlayer2.setName("Leonardo Antezana");
    thePlayerView.setCodeResponse2(thePlayer2.getCode());
    thePlayerView.setChipsResponse2(thePlayer2.getChips());
    thePlayerView.setPlayerNameResponse2(thePlayer2.getName());
    thePlayerView.setIsTurnResponse2(thePlayer2.isTurn());
  }

  /**
   * Changes the  turn of the players and return the player who's turn is next
   * @param player2 -  receives one of the players
   * @param player - receives the other player
   * @return player who's turn is true
   */
  public Player NextPlayerTurn(Player player, Player player2, PlayerView thePlayerView){
    if(player.isTurn()){
      player2.setTurn(true);
      player.setTurn(false);
      thePlayerView.setIsTurnResponse2(true);
      thePlayerView.setIsTurnResponse(false);
      return player2;

    }
    player2.setTurn(false);
    player.setTurn(true);
    thePlayerView.setIsTurnResponse2(false);
    thePlayerView.setIsTurnResponse(true);
    return player;
  }

  /**
   * Decreases one on the chips count for the player
   * @param player - a player and decrease one chip out of the chips count
   */
  public void DeacreaseChipControl(Player player, PlayerView thePlayerView){
    player.decreaseChip();
    if(player.getCode()==1){
    thePlayerView.setChipsResponse(player.getChips());}
     if(player.getCode()==2){
    thePlayerView.setChipsResponse2(player.getChips());}
  }
  }
