package edu.southalabama.dicegame.model;

import java.util.ArrayList;
import java.util.List;


public class DiceGame {
	
    private Die die1;
    private Die die2;

    public DiceGame(){
        this.die1 = new Die(6);
        this.die2 = new Die(6);
    }

    public void play(){
        die1.roll();
        die2.roll();
    }

    public List<Integer> getDieValues(){
        List dieValues = new ArrayList();
        dieValues.add(die1.getFaceValue());
        dieValues.add(die2.getFaceValue());
        return dieValues;
    }

    public boolean getOutcome(){
        if(die1.getFaceValue() + die2.getFaceValue() == 7 ||
                die1.getFaceValue() + die2.getFaceValue() == 12){
            return true;
        }
        return false;
    }
	
    public int getResult(){
        return die1.getFaceValue() + die2.getFaceValue();
    }
}
