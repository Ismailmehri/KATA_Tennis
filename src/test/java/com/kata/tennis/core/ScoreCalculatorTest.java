package com.kata.tennis.core;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.kata.tennis.core.ScoreCalculator;
import com.kata.tennis.domain.Player;

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
		assertThat(calculator.getTheWinner(), equalTo(""));
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
		player2.winPoint();
		
		//Then
		assertThat(calculator.getTheWinner(), equalTo(player1.getName()));
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
		player2.winPoint();
		
		//Then
		assertThat(calculator.gameHasEnded(), equalTo(true));
	}
}
