package edu.utep.cs.cs4330.hw3.omok.model;

/**
 * Created by lucasassisrodrigues on 3/15/16.
 */
public class Computer extends Player {
    private Strategy strategyMode;


    public Computer(boolean playerOne) {
        super(playerOne);
    }

    public Strategy getStrategyMode() {
        return strategyMode;
    }

    public void setStrategyMode(Strategy strategyMode) {
        this.strategyMode = strategyMode;
    }
}
