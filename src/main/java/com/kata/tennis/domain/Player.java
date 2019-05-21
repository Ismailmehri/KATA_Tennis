package com.kata.tennis.domain;

/**
 * Player Class
 * 
 * @author mehri
 */
public class Player implements Comparable<Player> {

    /**
     * Player name
     */
    private String name;
    
    /**
     * The player Score
     */
    private Score score;


    /**
     * The Constructor
     * 
     * @param name the player name
     */
    public Player(String name) {
        this.name = name;
        this.score = new Score();
    }

   
    /**
     * Return player name
     * @return
     */
    public String getName() {
        return name;
    }


    /**
     * return the player score
     * @return {@link Score}
     */
	public Score getScore() {
		return score;
	}
	
	/**
	 * increment player score
	 */
	public void winPoint() {
		this.score.incrementScore();
	}
	
	/**
	 * increment player set score
	 */
	public void winSet() {
		this.score.incrementSetScore();
	}

	/**
	 * Compare the game score of two players
	 */
	public int compareTo(Player player) {
		return this.score.getCurrentScore() - player.getScore().getCurrentScore();
	}
}
