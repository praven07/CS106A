/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;

public class HangmanCanvas extends GCanvas {

/** Resets the display so that only the scaffold appears */
	public void reset() {
		
		displayScaffold();
	}

	private void displayScaffold(){
		
		double scaffoldTopX = getWidth()/2 - 2*UPPER_ARM_LENGTH;
		double scaffoldTopY = getHeight()/2 - BODY_LENGTH - 2*HEAD_RADIUS - ROPE_LENGTH;
		double scaffoldBottomX = getWidth()/2 - 2*UPPER_ARM_LENGTH;
		double scaffoldBottomY = scaffoldTopY + SCAFFOLD_HEIGHT;
		GLine verticalBeam = new GLine(scaffoldTopX,scaffoldTopY,scaffoldBottomX,scaffoldBottomY);
		add(verticalBeam);
		GLine horizontialBeam = new GLine(scaffoldTopX,scaffoldTopY,scaffoldTopX+BEAM_LENGTH,scaffoldTopY);
		add(horizontialBeam);
		GLine rope = new GLine(scaffoldTopX+BEAM_LENGTH,scaffoldTopY,scaffoldTopX+BEAM_LENGTH,scaffoldTopY+ROPE_LENGTH);
		add(rope);
	}
	
	
/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	public void displayWord(String word) {
		
		int x = getWidth()/2 - BEAM_LENGTH;
		int y = SCAFFOLD_HEIGHT + 100;
		GLabel label = new GLabel(word);
		label.setLocation(x,y);
		label.setFont("Arial-20");
		
		if(getElementAt(x,y) != null){
			remove(getElementAt(x,y));
		}
		add(label);
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(char letter) {
		
		
		incorrectGuesses++;
		int x = getWidth()/2 - BEAM_LENGTH;
		int y = SCAFFOLD_HEIGHT + 130;
		word += letter;
		GLabel label = new GLabel(word);
		label.setLocation(x,y);
		label.setFont("Arial-20");
		if(getElementAt(x,y) != null){
			remove(getElementAt(x,y));
		}
		add(label);
		if(incorrectGuesses == 1) {
			drawHead();
		}
		if(incorrectGuesses == 2) {
			drawBody();
		}
		if(incorrectGuesses == 3) {
			drawLeftArm();
		}
		if(incorrectGuesses == 4) {
			drawRightArm();
		}
		if(incorrectGuesses == 5) {
			drawLeftLeg();
		}
		if(incorrectGuesses == 6) {
			drawRightLeg();
		}
		if(incorrectGuesses == 7) {
			drawLeftFoot();
		}
		if(incorrectGuesses == 8) {
			drawRightFoot();
		}
	}
	
	private void drawHead(){
		double headX = getWidth()/2 - HEAD_RADIUS;
		double headY = getHeight()/2 - BODY_LENGTH - 2*HEAD_RADIUS;
		GOval head = new GOval(2*HEAD_RADIUS,2*HEAD_RADIUS);
		head.setLocation(headX,headY);
		add(head);
	}
	
	private void drawBody(){
		
		double bodyTopX = getWidth()/2;
		double bodyTopY = getHeight()/2 - BODY_LENGTH;
		double bodyBottomX = getWidth()/2;
		double bodyBottomY = getHeight()/2;
		GLine body = new GLine(bodyTopX,bodyTopY,bodyBottomX,bodyBottomY);
		add(body);
	}
	
	private void drawLeftArm(){
		
		double armTopX = getWidth()/2;
		double armTopY = getHeight()/2 - BODY_LENGTH + ARM_OFFSET_FROM_HEAD;
		double armBottomX = getWidth()/2 - UPPER_ARM_LENGTH;
		double armBottomY = armTopY;
		GLine arm = new GLine(armTopX,armTopY,armBottomX,armBottomY);
		add(arm);
		GLine lowerArm = new GLine(armBottomX,armBottomY,armBottomX,armBottomY + LOWER_ARM_LENGTH);
		add(lowerArm);
	}
	
	private void drawRightArm(){
		
		double armTopX = getWidth()/2;
		double armTopY = getHeight()/2 - BODY_LENGTH + ARM_OFFSET_FROM_HEAD;
		double armBottomX = getWidth()/2  + UPPER_ARM_LENGTH;
		double armBottomY = armTopY;
		GLine arm = new GLine(armTopX,armTopY,armBottomX,armBottomY);
		add(arm);
		GLine lowerArm = new GLine(armBottomX,armBottomY,armBottomX,armBottomY + LOWER_ARM_LENGTH);
		add(lowerArm);
	}
	
	private void drawLeftLeg(){
		
		double hipTopX = getWidth()/2;
		double hipTopY = getHeight()/2;
		double hipBottomX = getWidth()/2  - HIP_WIDTH;
		double hipBottomY = hipTopY;
		GLine hip = new GLine(hipTopX,hipTopY,hipBottomX,hipBottomY);
		add(hip);
		GLine leg = new GLine(hipBottomX,hipBottomY,hipBottomX,hipBottomY + LEG_LENGTH);
		add(leg);
	}
	
	private void drawRightLeg(){
		
		double hipTopX = getWidth()/2;
		double hipTopY = getHeight()/2;
		double hipBottomX = getWidth()/2  + HIP_WIDTH;
		double hipBottomY = hipTopY;
		GLine hip = new GLine(hipTopX,hipTopY,hipBottomX,hipBottomY);
		add(hip);
		GLine leg = new GLine(hipBottomX,hipBottomY,hipBottomX,hipBottomY + LEG_LENGTH);
		add(leg);
	}
	
	private void drawLeftFoot(){
		
		double footTopX = getWidth()/2 - HIP_WIDTH;
		double footTopY = getHeight()/2 + LEG_LENGTH;
		double footBottomX = footTopX - FOOT_LENGTH;
		double footBottomY = footTopY;
		GLine leftFoot = new GLine(footTopX,footTopY,footBottomX,footBottomY);
		add(leftFoot);
	}
	
	private void drawRightFoot(){
		
		double footTopX = getWidth()/2 + HIP_WIDTH;
		double footTopY = getHeight()/2 + LEG_LENGTH;
		double footBottomX = footTopX + FOOT_LENGTH;
		double footBottomY = footTopY;
		GLine rightFoot = new GLine(footTopX,footTopY,footBottomX,footBottomY);
		add(rightFoot);
	}
	

	private int incorrectGuesses = 0;
	private String word = "";
	
/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

}
