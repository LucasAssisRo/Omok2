package edu.utep.cs.cs4330.hw3.omok.model;

public abstract class Player {
    private char stone;
    private boolean playerOne;
    
    public Player(){
        stone = 'B';
        playerOne = true;
    }
    
    public Player(int num){
        if(num==1){
            stone='B';
            playerOne=true;
        }
        else{
            stone='W';
            playerOne=false;
        }
    }
    
    public char getStone(){
        return stone;
    }
    
    public boolean getPlayerOne(){
        return playerOne;
    }
}
