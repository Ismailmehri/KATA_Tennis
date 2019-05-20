package com.kata.tennis.domain;

/**
 * The player score class
 * 
 * @author mehri
 *
 */
public class Score {
	
    /**
     * Player current score
     */
    private int currentScore;
    
    /**
     * Constructor
     */
    public Score() {
    	this.currentScore = 0;
    }
    
    /**
     * Return the current score
     * @return
     */
    public int getCurrentScore() {
		return currentScore;
	}


	/**
     * Increment the current score
     */
    public void incrementScore() {
    	this.currentScore++;
    }
    
}
