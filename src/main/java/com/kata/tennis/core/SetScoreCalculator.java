package com.kata.tennis.core;

import com.kata.tennis.domain.Player;

public class SetScoreCalculator {

	private Player player1;
	private Player player2;
	
	/**
	 * Constructor
	 * @param player1 the first player
	 * @param player2 the second player
	 */
	public SetScoreCalculator(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}
	
	/**
	 * return true if the game is ended
	 * @return
	 */
	public boolean gameHasEnded() {
		return (player1.getScore().getSetScore() == 7 || player2.getScore().getSetScore() == 7) 
				|| (player1.getScore().getSetScore() == 6 && player2.getScore().getSetScore() <= 4)
				|| (player2.getScore().getSetScore() == 6 && player1.getScore().getSetScore() <= 4);
	}
	
	/**
	 * return the winner
	 * @return {@link Player} or {@code <code>null</code>} if the game does not ended
	 */
	public Player getTheWinner() {
		return gameHasEnded() ? player1.getScore().getSetScore() > player2.getScore().getSetScore() 
				? player1 : player2 : null;
	}

	/**
	 * Return true if set score 6 - 6
	 * @return
	 */
	public boolean isTieBreak() {
		return false;
	}

	/**
	 * return true if Tie-Break is ended;
	 * @return {@link Boolean}
	 */
	public boolean isTieBreakEnded() {
		return false;
	}
}
