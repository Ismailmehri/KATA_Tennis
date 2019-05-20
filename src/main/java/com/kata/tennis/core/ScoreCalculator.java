package com.kata.tennis.core;

import com.kata.tennis.domain.Player;


public class ScoreCalculator {

	private Player player1;
	private Player player2;
	
	/**
	 * Constructor
	 * @param player1 {@link Player}
	 * @param player2 {@link Player}
	 */
	public ScoreCalculator(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	/**
	 * return true if the game is ended
	 * @return {@link Boolean}
	 */
	public boolean gameHasEnded() {
		return player1.getScore().getCurrentScore() > 3 || player2.getScore().getCurrentScore() > 3;
	}
	
	/**
	 * The function return name of winner if the game is ended
	 * @return {@link String} 
	 */
	public String getTheWinner() {
		return gameHasEnded() ? 
				player1.compareTo(player2) > 0 ? player1.getName() : player2.getName() : "";
	}
}
