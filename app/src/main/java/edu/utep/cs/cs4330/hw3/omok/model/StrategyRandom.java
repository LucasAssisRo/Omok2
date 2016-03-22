package edu.utep.cs.cs4330.hw3.omok.model;
import java.util.Random;

public class StrategyRandom implements Strategy{
    Random xCoor = new Random();
    Random yCoor = new Random();


    @Override
    public Coordinates play(Board board) {
        Coordinates coordinates = new Coordinates();
        coordinates.setX(xCoor.nextInt(10));
        coordinates.setY(yCoor.nextInt(10));
        return coordinates;
    }
}
