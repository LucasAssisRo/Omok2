package edu.utep.cs.cs4330.hw3.omok.model;

import android.os.Parcel;

/**
 * Created by lucasassisrodrigues on 3/15/16.
 */
public class Computer extends Player {
    private Strategy strategyMode;


    public Computer(boolean playerOne) {
        super(playerOne);
    }

    public Computer(Parcel in) {
        super(in);
    }

    public Coordinates findCoordinates(char[][] board) {
        return strategyMode.findCoordinates(board);
    }

    public Strategy getStrategyMode() {
        return strategyMode;
    }

    public void setStrategyMode(Strategy strategyMode) {
        this.strategyMode = strategyMode;
    }

    public static final Creator<Computer> CREATOR = new Creator<Computer>() {
        @Override
        public Computer createFromParcel(Parcel in) {
            return new Computer(in);
        }

        @Override
        public Computer[] newArray(int size) {
            return new Computer[size];
        }
    };
}
