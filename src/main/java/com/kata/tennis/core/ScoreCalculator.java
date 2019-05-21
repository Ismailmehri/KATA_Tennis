package com.kata.tennis.core;

import com.kata.tennis.domain.Player;
import com.kata.tennis.domain.Score;

/**
 * Score calculator class
 * @author mehri
 *
 */
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
		return (player1.getScore().getCurrentScore() > 3 && player1.getScore().getCurrentScore() - player2.getScore().getCurrentScore() > 1) || 
				(player2.getScore().getCurrentScore() > 3 && player2.getScore().getCurrentScore() - player1.getScore().getCurrentScore() > 1);
	}
	
	/**
	 * The function return name of winner if the game is ended
	 * @return {@link Player} or {@code <code>null</code>} if the game does not ended 
	 */
	public Player getTheWinner() {
		return gameHasEnded() ? player1.compareTo(player2) > 0 ? player1 : player2 : null;
	}
	
	/**
	 * return true if is advantage
	 * @return 
	 */
	public boolean isAdvantage() {
		return player1.getScore().getCurrentScore() >= 3 && player2.getScore().getCurrentScore() >= 3
				&& player1.getScore().getCurrentScore() != player2.getScore().getCurrentScore();
	}
	
	/**
	 * return true if is deuce
	 * @return
	 */
	public boolean isDeuce() {
		return player1.getScore().getCurrentScore() >= 3 && player2.getScore().getCurrentScore() >= 3
				&& player1.getScore().getCurrentScore() == player2.getScore().getCurrentScore();
	}
	
	/**
	 * update the game score
	 */
	public void updateGameScore() {
		if (!isDeuce() && !isAdvantage()) {
			player1.getScore().setGameScore(getGameScore(player1));
			player2.getScore().setGameScore(getGameScore(player2));
		} else if (isDeuce()) {
			player1.getScore().setGameScore(Score.GAME_SCORE_DEUCE);
			player2.getScore().setGameScore(Score.GAME_SCORE_DEUCE);
		} else {
			if (player1.compareTo(player2) > 0) {
				player1.getScore().setGameScore(Score.GAME_SCORE_ADV);
				player2.getScore().setGameScore(Score.GAME_SCORE_40);
			} else {
				player2.getScore().setGameScore(Score.GAME_SCORE_ADV);
				player1.getScore().setGameScore(Score.GAME_SCORE_40);
			}
		}
	}
	
	private String getGameScore(Player player) {
		
		switch (player.getScore().getCurrentScore()) {
			case 0 : return Score.GAME_SCORE_0;
			case 1 : return Score.GAME_SCORE_15;
			case 2 : return Score.GAME_SCORE_30;
			case 3 : return Score.GAME_SCORE_40;
			default : return "XX";
		}
	}
}
