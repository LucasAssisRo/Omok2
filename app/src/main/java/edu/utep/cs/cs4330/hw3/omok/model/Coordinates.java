package edu.utep.cs.cs4330.hw3.omok.model;

public class Coordinates {
    
    private int x;
    private int y;
    
    public Coordinates(){
        x = 0;
        y = 0;
    }
    
    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
}
