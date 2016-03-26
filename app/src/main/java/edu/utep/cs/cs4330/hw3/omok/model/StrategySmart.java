package edu.utep.cs.cs4330.hw3.omok.model;

import java.util.Random;

/**
 * Created by lucasassisrodrigues on 3/15/16.
 */
public class StrategySmart implements Strategy{
    @Override
    public Coordinates findCoordinates(char[][]board) {
        Random random = new Random();
        int x = random.nextInt(board.length);
        int y = random.nextInt(board.length);
        while(board[x][y]!=' ') {
            x = random.nextInt(board.length);
            y = random.nextInt(board.length);
        }
        return new Coordinates(x,y);
    }
}
