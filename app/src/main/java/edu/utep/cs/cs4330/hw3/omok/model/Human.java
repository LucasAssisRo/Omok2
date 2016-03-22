package edu.utep.cs.cs4330.hw3.omok.model;

/**
 * Created by lucasassisrodrigues on 3/15/16.
 */
public class Human extends Player {
    private int winCount;
    private int lossCount;
    private String name;

    public Human(boolean playerOne) {
        super(playerOne);
    }

    public void addWin() {
        winCount++;
    }

    public void addLoss() {
        lossCount++;
    }

    public int getWinCount() {
        return winCount;
    }

    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }

    public int getLossCount() {
        return lossCount;
    }

    public void setLossCount(int lossCount) {
        this.lossCount = lossCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
