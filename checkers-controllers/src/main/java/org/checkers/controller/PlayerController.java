package org.checkers.controller;

import org.checkers.model.Player;
import org.checkers.view.PlayerView;
/**
 * Created by Kenneth on 7/10/2017.
 * Controller for the execution of player model and view
 */
public class PlayerController {


  private Player thePlayer;
  private Player thePlayer2;

  private PlayerView thePlayerView;

  public PlayerController(Player thePlayer, Player thePlayer2, PlayerView thePlayerView) {

    this.thePlayerView = thePlayerView;
    this.thePlayer = thePlayer;
    this.thePlayer2 = thePlayer2;

        thePlayer.setName("Kenneth");
        thePlayerView.setPlayerNameResponse(thePlayer.getName());
        thePlayerView.setChipsLabel(thePlayer.getChips());
        thePlayerView.setCodeResponse(thePlayer.getCode());
        thePlayerView.setIsTurnResponse(thePlayer.isTurn());

        thePlayer2.setName("Leo");
        thePlayerView.setCodeResponse2(thePlayer2.getCode());
        thePlayerView.setChipsLabel2(thePlayer2.getChips());
        thePlayerView.setPlayerNameResponse2(thePlayer2.getName());
        thePlayerView.setIsTurnResponse2(thePlayer2.isTurn());

  }
}
