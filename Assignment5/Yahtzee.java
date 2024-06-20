/*
 * File: Yahtzee.java
 * ------------------
 * This program will eventually play the Yahtzee game.
 */

import acm.io.*;
import acm.program.*;
import acm.util.*;
import java.util.*;

public class Yahtzee extends GraphicsProgram implements YahtzeeConstants {
	
	public static void main(String[] args) {
		new Yahtzee().start(args);
	}

	/*
	 * (non-Javadoc)
	 * @see acm.program.GraphicsProgram#run()
	 * Gets the number of players and the name of the players
	 */
	public void run() {
		IODialog dialog = getDialog();
		while(true){
			nPlayers = dialog.readInt("Enter number of players");
			if(nPlayers > 0 && nPlayers <= 4)break;
		}
		selectedCategory = new int[nPlayers][N_CATEGORIES];
		categoryScore = new int[nPlayers][N_CATEGORIES];
		playerNames = new String[nPlayers];
		for (int i = 1; i <= nPlayers; i++) {
			playerNames[i - 1] = dialog.readLine("Enter name for player " + i);
		}
		display = new YahtzeeDisplay(getGCanvas(), playerNames);
		playGame();
	}

	/*
	 * the playing of the game is managed in this method
	 */
	private void playGame() {
		
		for(int i=0; i<N_CATEGORIES; i++){
			for(int j=0; j<nPlayers; j++){
				firstRoll(j);
				secondAndThirdRoll(j);
				selectCatagorie(j);
			}
		}
		
	}
	
	/*
	 * It first prints a message 
	 * and then waits for the given player to click the roll dice button 
	 * It is the first turn to roll the dice
	 */
	private void firstRoll(int playerNumber){
		
		rollDice();
		display.printMessage(playerNames[playerNumber] + "'s turn click \"Roll Dice\" Button to roll the dice" );
		display.waitForPlayerToClickRoll(playerNumber+1);
		display.displayDice(diceRolled);
	}
	
	/*
	 * It is the second and third turn to roll the dice
	 */
	private void secondAndThirdRoll(int playerNumber){
		
		for(int i=0; i<2; i++){
			display.printMessage("Select any dice that you wish to \"Re-roll\" and then click \"Roll Dice\"");
			display.waitForPlayerToSelectDice();
			reRollDice();
			display.displayDice(diceRolled);
		}
	}
	
	/*
	 * It rolls the dice for the first time by generating a random 
	 * number 
	 */
	private void rollDice(){
		
		for(int i=0; i<N_DICE; i++){
			int value = rgen.nextInt(1, 6);
			diceRolled[i] = value;
		}
	}

	/*
	 * It re-rolls the dice by changing the values in the array 
	 */
	private void reRollDice(){
		
		for(int i=0; i<N_DICE; i++){
			if(display.isDieSelected(i)){
				int value = rgen.nextInt(1,6);
				diceRolled[i] = value;
			}
		}
	}
	
	private void selectCatagorie(int playerNumber){
		
		display.printMessage("Select a categorie on the score board to update the scores");
		category = display.waitForPlayerToSelectCategory();
		if(validCatagorie(playerNumber)){
			updateCatagorieSelected(playerNumber,category);
			updateScoreBoard(playerNumber);
		}
	}

	private boolean validCatagorie(int playerNumber){
		
		if(selectedCategory[playerNumber][category] == 0){
			return true;
		}
		return false;
	}
	
	private void updateCatagorieSelected(int playerNumber, int catagorie){
		
		selectedCategory[playerNumber][catagorie] = 1;
	}

	private void updateScoreBoard(int playerNumber){
		
		if(checkValidCatagorie()){
			display.printMessage("Score Updated");
			setCatagorieScore(playerNumber);
		}else{
			display.updateScorecard(category, playerNumber+1, 0);
			categoryScore[playerNumber][category] = 0;
		}	
		updateTotal(playerNumber);
	}
	
	private boolean checkValidCatagorie(){
		
		if(category >= ONES && category <= SIXES || category == CHANCE){
			return true;
		}
		
		ArrayList<Integer> ones = new ArrayList<Integer>();
		ArrayList<Integer> twos = new ArrayList<Integer>();
		ArrayList<Integer> threes = new ArrayList<Integer>();
		ArrayList<Integer> fours = new ArrayList<Integer>();
		ArrayList<Integer> fives = new ArrayList<Integer>();
		ArrayList<Integer> sixes = new ArrayList<Integer>();
		
		for(int i=0; i<diceRolled.length; i++){
			int value = diceRolled[i];
			if(value == ONES){
				ones.add(1);
			}else if(value == TWOS){
				twos.add(1);
			}else if(value == THREES){
				threes.add(1);
			}else if(value == FOURS){
				fours.add(1);
			}else if(value == FIVES){
				fives.add(1);
			}else if(value == SIXES){
				sixes.add(1);
			}
		}
		if(category == THREE_OF_A_KIND){
			if(ones.size() == 3 || twos.size() == 3 || threes.size() == 3 || fours.size() ==3 || fives.size() == 3 || sixes.size() == 3){
				return true;
			}
		}
		
		if(category == FOUR_OF_A_KIND){
			if(ones.size() == 4 || twos.size() == 4 || threes.size() == 4 || fours.size() ==4 || fives.size() == 4 || sixes.size() == 4){
				return true;
			}
		}
		
		if(category == FULL_HOUSE){
			if(ones.size() == 3 || twos.size() == 3 || threes.size() == 3 || fours.size() == 3 || fives.size() == 3 || sixes.size() == 3){
				if(ones.size() == 2 || twos.size() == 2 || threes.size() == 2 || fours.size() == 2 || fives.size() == 2 || sixes.size() == 2){
					return true;
				}
			}
		}
		
		if(category == SMALL_STRAIGHT){
			if(ones.size() == 1 && twos.size() == 1 && threes.size() == 1 && fours.size() == 1){
				return true;
			}else if(twos.size() == 1 && threes.size() == 1 && fours.size() == 1 && fives.size() == 1){
				return true;
			}else if(threes.size() == 1 && fours.size() == 1 && fives.size() == 1 && sixes.size() == 1){
				return true;
			}
		}
		
		if(category == LARGE_STRAIGHT){
			if(ones.size() == 1 && twos.size() == 1 && threes.size() == 1 && fours.size() == 1 && fives.size() == 1){
				return true;
			}else if(twos.size() == 1 && threes.size() == 1 && fours.size() == 1 && fives.size() == 1 && sixes.size() == 1){
				return true;
			}
		}
		
		if(category == YAHTZEE){
			if(ones.size() == 5 || twos.size() == 5 || threes.size() == 5 || fours.size() == 5 || fives.size() == 5 || sixes.size() == 5){
				return true;
			}
		}
		return false;		
	}
	
	private void setCatagorieScore(int playerNumber){
		
		int score = 0;
		
		if(category >= ONES && category <= SIXES){
			for(int i=0; i<diceRolled.length; i++){
				if(diceRolled[i] == category){
					score += diceRolled[i];
				}
			}
		}else if(category == THREE_OF_A_KIND){
			for(int i=0; i<diceRolled.length; i++){
				score += diceRolled[i];
			}
		}else if(category == FOUR_OF_A_KIND){
			for(int i=0; i<diceRolled.length; i++){
				score += diceRolled[i];
			}
		}else if(category == FULL_HOUSE){
			score = 25;
		}else if(category == SMALL_STRAIGHT){
			score = 30;
		}else if(category == LARGE_STRAIGHT){
			score = 40;
		}else if(category == YAHTZEE){
			score = 50;
		}else if(category == CHANCE){
			for(int i=0; i<diceRolled.length; i++){
				score += diceRolled[i];
			}
		}
		
		categoryScore[playerNumber][category] = score;
		display.updateScorecard(category, playerNumber+1, score);
	}
	
	private void updateTotal(int playerNumber){
		
		int upperScore = 0;
		int lowerScore = 0;
		int totalScore = 0;
		for(int i=1; i<categoryScore[playerNumber].length+1; i++){
			if(i <= SIXES){
				upperScore += categoryScore[playerNumber][i];
			}else if(i >= THREE_OF_A_KIND && i <= CHANCE){
				lowerScore += categoryScore[playerNumber][i];
			}
		}
		
		totalScore = upperScore + lowerScore;
		display.updateScorecard(TOTAL, playerNumber+1, totalScore);
		categoryScore[playerNumber][UPPER_SCORE-1] = upperScore;
		categoryScore[playerNumber][LOWER_SCORE-1] = upperScore;
		categoryScore[playerNumber][TOTAL-1] = totalScore;
	}
	
/* Private instance variables */
	private int nPlayers;
	private String[] playerNames;
	private int[] diceRolled = new int[N_DICE];
	private int category;
	private int[][] selectedCategory;
	private int[][] categoryScore;
	private YahtzeeDisplay display;
	private RandomGenerator rgen = new RandomGenerator();

}
