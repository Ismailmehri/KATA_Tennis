package com.kata.tennis.core;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.kata.tennis.core.ScoreCalculator;
import com.kata.tennis.domain.Player;
import com.kata.tennis.domain.Score;

public class ScoreCalculatorTest {

	private Player player1;
	private Player player2;
	private ScoreCalculator calculator;
	
	@Before
	public void setup() {
		player1 = new Player("Player 1");
		player2 = new Player("Player 2");
		calculator = new ScoreCalculator(player1, player2);
	}
	
	@Test
	public void should_return_game_has_not_ended() {
		assertThat(calculator.gameHasEnded(), equalTo(false));
	}
	
	@Test
	public void should_return_empty_string() {
		assertThat(calculator.getTheWinner(), equalTo(null));
	}
	
	@Test
	public void player_1_should_be_the_winner() {
		
		// When
		player1.winPoint();
		player1.winPoint();
		player1.winPoint();
		player1.winPoint();
		player2.winPoint();
		player2.winPoint();
		
		//Then
		assertThat(calculator.getTheWinner(), equalTo(player1));
	}
	
	public void should_return_empty_string_DEUCE() {
		
		// When
		player1.winPoint();
		player1.winPoint();
		player1.winPoint();
		player2.winPoint();
		player2.winPoint();
		player2.winPoint();
		
		//Then
		assertThat(calculator.getTheWinner(), equalTo(player1));
	}
	
	@Test
	public void should_return_game_ended() {
		
		// When
		player1.winPoint();
		player1.winPoint();
		player1.winPoint();
		player1.winPoint();
		player2.winPoint();
		player2.winPoint();
		
		//Then
		assertThat(calculator.gameHasEnded(), equalTo(true));
	}
	
	@Test
	public void should_return_game_ended_DEUCE() {
		
		// When
		player1.winPoint();
		player1.winPoint();
		player1.winPoint();
		player2.winPoint();
		player2.winPoint();
		player2.winPoint();
		
		player1.winPoint();
		player1.winPoint();
		
		//Then
		assertThat(calculator.gameHasEnded(), equalTo(true));
	}
	
	@Test
	public void should_return_game_not_ended() {
		
		// When
		player1.winPoint();
		player1.winPoint();
		player1.winPoint();
		player2.winPoint();
		player2.winPoint();
		player2.winPoint();
		
		//Then
		assertThat(calculator.gameHasEnded(), equalTo(false));
	}
	
	@Test
	public void should_isAdvanced_return_true () {
		
		// When
		player1.winPoint();
		player1.winPoint();
		player1.winPoint();
		player2.winPoint();
		player2.winPoint();
		player2.winPoint();
		
		player1.winPoint();
		player2.winPoint();
		player1.winPoint();
		
		//Then
		assertThat(calculator.isAdvantage(), equalTo(true));
		
	}
	
	@Test
	public void should_isAdvanced_return_false () {
		
		// When
		player1.winPoint();
		player1.winPoint();
		player1.winPoint();
		player2.winPoint();
		player2.winPoint();
		player2.winPoint();
		
		//Then
		assertThat(calculator.isAdvantage(), equalTo(false));
		
	}
	
	@Test
	public void should_isDeuce_return_true () {
		
		// When
		player1.winPoint();
		player1.winPoint();
		player1.winPoint();
		player2.winPoint();
		player2.winPoint();
		player2.winPoint();
		
		//Then
		assertThat(calculator.isDeuce(), equalTo(true));
		
	}
	
	@Test
	public void should_isDeuce_return_false() {
		
		// When
		player1.winPoint();
		player1.winPoint();
		player2.winPoint();
		
		//Then
		assertThat(calculator.isDeuce(), equalTo(false));
		
	}
	
	@Test
	public void should_update_game_score() {
		
		// Given
		player1.winPoint();
		player1.winPoint();
		player2.winPoint();
		
		// When
		calculator.updateGameScore();
		
		// Then
		assertThat(player1.getScore().getGameScore(), equalTo(Score.GAME_SCORE_30));
		assertThat(player2.getScore().getGameScore(), equalTo(Score.GAME_SCORE_15));

	}
	
	@Test
	public void should_update_game_score_deuce() {
		
		// Given
		player1.winPoint();
		player1.winPoint();
		player1.winPoint();
		player1.winPoint();
		player2.winPoint();
		player2.winPoint();
		player2.winPoint();
		player2.winPoint();
		
		// When
		calculator.updateGameScore();
		
		// Then
		assertThat(player1.getScore().getGameScore(), equalTo(Score.GAME_SCORE_DEUCE));
		assertThat(player2.getScore().getGameScore(), equalTo(Score.GAME_SCORE_DEUCE));

	}
	
	@Test
	public void should_update_game_score_adv() {
		
		// Given
		player1.winPoint();
		player1.winPoint();
		player1.winPoint();
		player1.winPoint();
		
		player2.winPoint();
		player2.winPoint();
		player2.winPoint();
		player2.winPoint();
		player2.winPoint();

		
		// When
		calculator.updateGameScore();
		
		// Then
		assertThat(player1.getScore().getGameScore(), equalTo(Score.GAME_SCORE_40));
		assertThat(player2.getScore().getGameScore(), equalTo(Score.GAME_SCORE_ADV));

	}
}
