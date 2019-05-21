package com.kata.tennis.core;

import java.lang.reflect.Constructor;

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
	public boolean hasGameEnded() {
		return true;
	}
	
	public String getTheWinner() {
		return "";
	}
}
