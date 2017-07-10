package org.checkers.model;

/**
 * Created by Kenneth Perez on 7/10/2017.
 * This class  models the player and all its required attributes, also adding sets and gets to it.
 */
public class Player {


    private String name;
    private int code;//Later used to define player one or two
    private int chips;// Amount of chips that the player has
    private boolean isTurn;// boolean that represents whether or not is the player turn

    public void player(int code){
        name = "Player";
        chips = 12; //Started at base 12 since that is the basic of each player
        this.code = code;
        isTurn=false;
    }

    //Sets and gets

    public int getChips() {
        return chips;
    }

    public void setChips(int chips) {
        this.chips = chips;
    }

    public boolean isTurn() {
        return isTurn;
    }

    public void setTurn(boolean turn) {
        isTurn = turn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}

