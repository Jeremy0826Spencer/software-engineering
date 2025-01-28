package edu.southalabama.dicegame;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class DiceGame {
	
	private static volatile long seedQualifier = 432282912137141232L;
	public static Random getRandomNumberGenerator() {
		return new Random(++seedQualifier + System.nanoTime());
	}
	
	private static Scanner commandLine = new Scanner(System.in);

	String name;
	int sides;
	int value;
	int die1Value;
	int die2Value;
	boolean outcome;
	int wins;
	int losses;
	boolean continuingGame = true;

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		DiceGame dg = new DiceGame();
		dg.play();
	}
	
	public void play() throws IOException {
		//get name
		name = getName();
		while(continuingGame) {
			System.out.println(name + ": Rolling the dice...");
			//roll die one at a time
			die1Value = rollDie(6);
			die2Value = rollDie(6);
			if(determineWin(die1Value, die2Value)) {
				wins++;
			} else {
				losses++;
			}
			displayStats(wins, losses);
			continuingGame = isContinuingGame();
		}
	}

	public String getName(){
		System.out.print("Enter player name: ");
		return commandLine.nextLine();
	}

	private int rollDie(int numSides){
		Random random = getRandomNumberGenerator();
		return random.nextInt(numSides) + 1;
	}

	private boolean determineWin(int die1Value, int dies2Value){
		if(die1Value + dies2Value == 7 || die1Value + dies2Value == 12){
			System.out.println("You win!");
			return true;
		}
		System.out.println("You lose!");
		return false;
	}

	private void displayStats(int wins, int losses){
		System.out.println("Die 1: " + die1Value);
		System.out.println("Die 2: " + die2Value);
		System.out.println("Result: " + (die1Value + die2Value));
		System.out.println("Wins: " + wins);
		System.out.println("Losses: " + losses);
	}
	
	private boolean isContinuingGame(){
		String flag = "";
		while(!flag.equalsIgnoreCase("y") || !flag.equalsIgnoreCase("n")) {
			System.out.println("Continue?");
			flag = commandLine.next();
			if (flag.equalsIgnoreCase("y")) {
				return true;
			} else if (flag.equalsIgnoreCase("n")) {
				return false;
			} else {
				System.out.println("Invalid input.");
			}
		}
		return true;
	}
}