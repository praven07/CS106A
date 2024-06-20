/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.program.*;
import java.awt.*;

public class Hangman extends ConsoleProgram {

	public static final int APPLICATION_WIDTH = 1000;
	public static final int APPLICATION_HEIGHT = 600;

	
	/*
	 * (non-Javadoc)
	 * It creates a canvas to display the scaffold
	 * @see acm.program.ConsoleProgram#init()
	 */
	public void init() {

		canvas = new HangmanCanvas();
		canvas.setBackground(Color.YELLOW);
		add(canvas);
	}

	/*
	 * (non-Javadoc)
	 * main run method 
	 * @see acm.program.ConsoleProgram#run()
	 */
	public void run() {

		wordProvider = new HangmanLexicon();
		String word = wordProvider.getWord();
		canvas.reset();
		welcomeMessage();
		playGame(word);
	}

	/*
	 * displays a welcome message on the console
	 */
	private void welcomeMessage() {

		println("Welcom to Hangman");
	}

	/*
	 * It plays the game
	 */
	private void playGame(String w) {

		originalWord = w;
		String hiddenWord = hideWord(w);
		while (true) {
			if (wordFilled(hiddenWord)) {
				println("You won the game");
				break;
			} else if (guessLeft == 0) {
				println("The word was " + originalWord);
				println("You loose");
				break;
			}
			println("You have " + guessLeft + " guesses left");
			String userGuess = letterToUppercase(readLine("Enter your guess: "));
			hiddenWord = checkWord(originalWord, hiddenWord, userGuess);
			println("The word now looks like this: " + hiddenWord);
			canvas.displayWord(hiddenWord);
		}
	}

	private String hideWord(String word) {

		String result = "";
		for (int i = 0; i < word.length(); i++) {
			result += "-";
		}
		println("The word now looks like this: " + result);
		canvas.displayWord(result);
		return result;
	}

	private String checkWord(String word, String hiddenWord, String userGuess) {

		String result = "";
		if (validGuess(userGuess)) {
			char guess = userGuess.charAt(0);
			for (int i = 0; i < word.length(); i++) {
				if (word.charAt(i) == guess) {
					result += guess;
				} else if ((hiddenWord.charAt(i) >= 'A')
						&& hiddenWord.charAt(i) <= 'Z') {
					result += word.charAt(i);
				} else {
					result += "-";
				}
			}
			if (word.indexOf(userGuess) == -1) {
				canvas.noteIncorrectGuess(guess);
				guessLeft--;
			}
		} else {
			println("Invalid input");
			return hiddenWord;
		}
		return result;
	}

	private boolean validGuess(String userGuess) {

		if (userGuess.length() == 1) {
			char ch = userGuess.charAt(0);
			if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
				return true;
			}
		}
		return false;
	}

	private boolean wordFilled(String word) {

		int place = word.indexOf('-');
		if (place == -1) {
			return true;
		}
		return false;
	}

	private String letterToUppercase(String letter) {

		return (letter.toUpperCase());
	}

	private HangmanCanvas canvas;
	private HangmanLexicon wordProvider;
	private String originalWord;
	private int guessLeft = 9;
}
