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
    
    /**
     * Return the tennis score
     * @return tennis score
     */
    public String getTennisScore() {
    	
    	switch (this.currentScore) {
	    	case 0 : return "0";
	    	case 1 : return "15";
	    	case 2 : return "30";
	    	case 3 : return "40";
	    	default : return "XX";
    	}
    }
}
