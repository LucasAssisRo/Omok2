package edu.utep.cs.cs4330.hw3.omok.model;

/**
 * Created by lucasassisrodrigues on 3/15/16.
 */
public class OmokGame {

    private Board board;
    private Player[] players;
    private int turn;
    private boolean winner;

    public OmokGame(){
        board = new Board();
        players = new Player[2];
        turn = 0;
        winner = false;
    }

    public void gameMode(boolean mode){
        players[0] = new Human();
        players[1] = mode ? new Computer() : new Human();
    }

    public boolean placeStone(Coordinates coordinates){
        if(board.placeStone(players[turn], coordinates)){
            if(!board.checkWinner(players[turn], coordinates))
                flipTurn();
            return true;
        }
        return false;
    }

    private void flipTurn(){
        turn = (turn==0) ? 1 : 0;
    }

    public int getTurn(){
        return turn;
    }

    public boolean isWinner(){
        return winner;
    }
}
