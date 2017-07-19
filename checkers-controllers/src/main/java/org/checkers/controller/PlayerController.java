package org.checkers.controller;

import org.checkers.model.Player;
import org.checkers.view.PlayerView;

/**
 * This class allows the interaction of the view and the model in the controller
 */
public class PlayerController {

  public PlayerController(Player thePlayer, Player thePlayer2, PlayerView thePlayerView) {

    //Getting all the info from the object player one and passing it to the view
    thePlayer.SetName("Select player");
    thePlayer.SetTurn(true);
    thePlayerView.setPlayerNameResponse(thePlayer.GetName());
    thePlayerView.setChipsResponse(thePlayer.GetChips());
    thePlayerView.setCodeResponse(thePlayer.GetCode());
    thePlayerView.setIsTurnResponse(1,thePlayer.IsTurn());

   //Getting all the info from the object player two and passing it to the view
    thePlayer2.SetName("Select player");
    thePlayerView.setCodeResponse2(thePlayer2.GetCode());
    thePlayerView.setChipsResponse2(thePlayer2.GetChips());
    thePlayerView.setPlayerNameResponse2(thePlayer2.GetName());
    thePlayerView.setIsTurnResponse(2,thePlayer2.IsTurn());
  }

  /**
   * Changes the  turn of the players and return the player who's turn is next
   * @param player2 -  receives one of the players
   * @param player - receives the other player
   * @return player who's turn is true
   */
  public Player NextPlayerTurn(Player player, Player player2, PlayerView thePlayerView){
    if(player.IsTurn()){
      player2.SetTurn(true);
      player.SetTurn(false);
      thePlayerView.setIsTurnResponse(1,false);
      thePlayerView.setIsTurnResponse(2,true);
      return player2;

    }
    player2.SetTurn(false);
    player.SetTurn(true);
    thePlayerView.setIsTurnResponse(2,false);
    thePlayerView.setIsTurnResponse(1,true);
    return player;
  }

  /**
   * Decreases one on the chips count for the player
   * @param player - a player and decrease one chip out of the chips count
   */
  public void DeacreaseChipControl(Player player, PlayerView thePlayerView){
    player.DecreaseChip();
    if(player.GetCode()==1){
    thePlayerView.setChipsResponse(player.GetChips());}
     if(player.GetCode()==2){
    thePlayerView.setChipsResponse2(player.GetChips());}
  }

  }
