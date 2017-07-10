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

    thePlayerView.setViewCode2(thePlayer.getCode());
    thePlayerView.setViewChips2(thePlayer.getChips());
    thePlayerView.setViewPlayerName2(thePlayer.getName());
    thePlayerView.setViewIsTurn2(thePlayer.isTurn());


    thePlayerView.setViewCode2(thePlayer2.getCode());
    thePlayerView.setViewChips2(thePlayer2.getChips());
    thePlayerView.setViewPlayerName2(thePlayer2.getName());
    thePlayerView.setViewIsTurn2(thePlayer2.isTurn());
  }
  }
