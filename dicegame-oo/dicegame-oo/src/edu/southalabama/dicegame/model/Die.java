package edu.southalabama.dicegame.model;

public class Die {

    private int faceValue;

    private int numSides;

    public Die(int numSides){
        this.numSides = numSides;
    }

    public int getFaceValue(){
        return faceValue;
    }

    public void roll(){
        this.faceValue = (int)((Math.random() * numSides) + 1);
    }

	
}
