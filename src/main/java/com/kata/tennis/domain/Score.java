package com.kata.tennis.domain;

/**
 * The player score class
 * 
 * @author mehri
 *
 */
public class Score {
	
	public static final String GAME_SCORE_0 = "0";
	public static final String GAME_SCORE_15 = "15";
	public static final String GAME_SCORE_30 = "30";
	public static final String GAME_SCORE_40 = "40";
	public static final String GAME_SCORE_ADV = "ADV";
	public static final String GAME_SCORE_DEUCE = "DEUCE";
    /**
     * Player current score
     */
    private int currentScore;
    
    /**
     * the game score
     */
    private String gameScore;
    
    /**
     * Constructor
     */
    public Score() {
    	this.currentScore = 0;
    	this.gameScore = GAME_SCORE_0;
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
     * return the game score
     * @return the game score
     */
	public String getGameScore() {
		return gameScore;
	}

	/**
	 * set the game score
	 * @param gameScore the game score
	 */
	public void setGameScore(String gameScore) {
		this.gameScore = gameScore;
	}
    
}
