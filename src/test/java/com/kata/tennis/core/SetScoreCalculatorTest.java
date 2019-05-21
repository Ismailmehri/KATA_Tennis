package com.kata.tennis.core;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import com.kata.tennis.domain.Player;

public class SetScoreCalculatorTest {

	private Player player1;
	private Player player2;
	private SetScoreCalculator calculator;
	
	@Before
	public void setup() {
		player1 = new Player("Player 1");
		player2 = new Player("Player 2");
		calculator = new SetScoreCalculator(player1, player2);
	}
	
	@Test
	public void should_return_gamehasended_false() {
		
		// Given
		player1.winSet();
		player2.winSet();
		
		// When
		boolean gameHasEnded = calculator.hasGameEnded();
		
		// Then
		assertThat(gameHasEnded, equalTo(false));
	}
	
	@Test
	public void should_return_gamehasended_false_newGame() {
		
		// Given
		player1.winSet();
		player1.winSet();
		player1.winSet();
		player1.winSet();
		player1.winSet();
		player1.winSet();
		
		player2.winSet();
		player2.winSet();
		player2.winSet();
		player2.winSet();
		player2.winSet();
		
		// When
		boolean gameHasEnded = calculator.hasGameEnded();
		
		// Then
		assertThat(gameHasEnded, equalTo(false));
	}
	
	@Test
	public void should_return_gamehasended_true_newGame() {
		
		// Given
		player1.winSet();
		player1.winSet();
		player1.winSet();
		player1.winSet();
		player1.winSet();
		player1.winSet();
		
		player2.winSet();
		player2.winSet();
		player2.winSet();
		player2.winSet();
		player2.winSet();
		player2.winSet();
		player2.winSet();

		
		// When
		boolean gameHasEnded = calculator.hasGameEnded();
		
		// Then
		assertThat(gameHasEnded, equalTo(true));
	}
	
	@Test
	public void should_return_gamehasended_true() {
		
		// Given
		player1.winSet();
		player1.winSet();
		player1.winSet();
		player1.winSet();
		player1.winSet();
		player1.winSet();
		
		player2.winSet();
		
		
		// When
		boolean gameHasEnded = calculator.hasGameEnded();
		
		// Then
		assertThat(gameHasEnded, equalTo(true));
	}
	
	@Test
	public void should_return_player_1_name() {
		
		// Given
		player1.winSet();
		player1.winSet();
		player1.winSet();
		player1.winSet();
		player1.winSet();
		player1.winSet();
		
		player2.winSet();
		
		
		// When
		String name = calculator.getTheWinner();
		
		// Then
		assertThat(name, equalTo(player1.getName()));
	}
	
	public void should_return_player_2_name() {
		
		// Given
		player1.winSet();
		player1.winSet();
		player1.winSet();
		player1.winSet();
		player1.winSet();
		player1.winSet();
		
		player2.winSet();
		player2.winSet();
		player2.winSet();
		player2.winSet();
		player2.winSet();
		player2.winSet();
		player2.winSet();

		
		// When
		String name = calculator.getTheWinner();
		
		// Then
		assertThat(name, equalTo(player2.getName()));
	}
}
