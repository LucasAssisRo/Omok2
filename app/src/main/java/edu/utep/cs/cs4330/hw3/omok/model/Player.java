package edu.utep.cs.cs4330.hw3.omok.model;

public class Player {
    private String name;
    private char stone;
    private boolean playerOne;
    
    public Player(){
        name = "First Player";
        stone = 'B';
        playerOne = true;
    }
    
    public Player(String name, int num){
        this.name=name;
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
    
    public String getName(){
        return name;
    }
}
