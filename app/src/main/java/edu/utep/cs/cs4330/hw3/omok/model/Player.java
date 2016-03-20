package edu.utep.cs.cs4330.hw3.omok.model;

public abstract class Player {
    private char stone;
    private boolean playerOne;

    public Player() {
    }

    public Player(boolean playerOne) {
        this.playerOne = playerOne;
        if (this.playerOne) {
            stone = 'B';
        } else {
            stone = 'W';
        }
    }

    public boolean isPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(boolean playerOne) {
        this.playerOne = playerOne;
    }

    public char getStone() {
        return stone;
    }

    public void setStone(char stone) {
        this.stone = stone;
    }
}
