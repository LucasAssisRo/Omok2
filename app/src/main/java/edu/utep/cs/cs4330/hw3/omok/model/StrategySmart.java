package edu.utep.cs.cs4330.hw3.omok.model;

/**
 * Created by lucasassisrodrigues on 3/15/16.
 */
public class StrategySmart implements Strategy{
    Coordinates coordinates = new Coordinates();

    @Override
    public Coordinates play(Board board) {
        checkBoard(board);
        return coordinates;
    }

    public void checkBoard(Board board){
        int east = 0;
        int south = 0;
        int southWest = 0;
        int southEast = 0;
        int temp = 0;
        int max = 0;
        for(int x = 0;x < board.getBoard().length; x++ ){
            for(int y=0; y< board.getBoard().length; y++){
                if(board.getBoard()[x][y]=='W'){
                    temp = board.east(x, y, 'W');
                    east = (temp>east) ? temp : east;
                    temp = board.south(x, y, 'W');
                    south = (temp>south) ? temp : south;
                    temp = board.southWest(x, y, 'W');
                    southWest = (temp>southWest) ? temp : southWest;
                    temp = board.southEast(x, y, 'W');
                    southEast = (temp>southEast) ? temp : southEast;
                }
                max = (east>max) ? east: max;
                max = (south>max) ? south : max;
                max = (southWest>max) ? southWest : max;
                max = (southEast>max) ? southEast : max;
                if(max>3){
                    coordinates.setX(x);
                    coordinates.setY(y);
                }
            }
        }
    }

    public boolean verifyEast(int x, int y){

        if((x+1) <10){
            coordinates.setX(x + 1);
            coordinates.setY(y);
            return true;
        }

        if((x-1) >-1 && (y-1) >-1){
            coordinates.setX(x-1);
            coordinates.setY(y);
            return true;
        }
        return false;
    }

    public boolean verifySouth(int x, int y){

        if((y+1) <10){
            coordinates.setX(x);
            coordinates.setY(y+1);
            return true;
        }

        if((y-1) >-1){
            coordinates.setX(x);
            coordinates.setY(y - 1);
            return true;
        }
        return false;
    }

    public boolean verifySouthWest(int x, int y){

        if((y+1) <10){
            coordinates.setX(x);
            coordinates.setY(y+1);
            return true;
        }

        if((y-1) >-1){
            coordinates.setX(x);
            coordinates.setY(y - 1);
            return true;
        }
        return false;
    }
}
