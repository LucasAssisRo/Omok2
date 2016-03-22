package edu.utep.cs.cs4330.hw3.omok.model;

import android.util.Log;

/**
 * Created by lucasassisrodrigues on 3/15/16.
 */
public class OmokGame {

    private Board board;
    private Player[] players;
    private int turn;
    private boolean winner;
    private boolean gameRunning = false;


    public OmokGame() {
        board = new Board();
        players = new Player[2];
        turn = 0;
        winner = false;
    }

    public OmokGame(boolean strategyMode) {
        board = new Board();
        players = new Player[2];
        gameMode(strategyMode);
        turn = 0;
        winner = false;
    }

    public void gameMode(boolean strategyMode) {
        players[0] = new Human(true);
        players[1] = strategyMode ? new Computer(false) : new Human(true);
    }

    public void placeStone(Coordinates coordinates) {
        Log.i("click", board.checkWinner(players[turn], coordinates) + "");
        if (board.placeStone(players[turn], coordinates))
            if (!board.checkWinner(players[turn], coordinates))
                flipTurn();
            else
                gameRunning = false;
    }

    private void flipTurn() {
        turn = (turn == 0) ? 1 : 0;
    }

    public int getTurn() {
        return turn;
    }

    public boolean isWinner() {
        return winner;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Player getCurrentPlayer() {
        return players[turn];
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public boolean isGameRunning() {
        return gameRunning;
    }

    public void setGameRunning(boolean gameRunning) {
        this.gameRunning = gameRunning;
    }
}