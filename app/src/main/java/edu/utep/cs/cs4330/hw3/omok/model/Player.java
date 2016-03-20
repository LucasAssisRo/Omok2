package edu.utep.cs.cs4330.hw3.omok.model;

/**
 * Created by lucasassisrodrigues on 3/15/16.
 */
public abstract class Player {
   private boolean playerOne;

    public boolean isPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(boolean playerOne) {
        this.playerOne = playerOne;
    }
}
