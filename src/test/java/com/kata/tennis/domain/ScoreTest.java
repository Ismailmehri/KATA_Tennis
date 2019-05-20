package com.kata.tennis.domain;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


import org.junit.Before;
import org.junit.Test;

public class ScoreTest {
	
	private Score score;
	
	@Before
	public void setup() {
		score = new Score();
	}
	
	@Test
	public void score_should_start_with_zero() {
		assertThat(score.getCurrentScore(), equalTo(0));
	}
	
	@Test
	public void score_should_be_incremented() {
		//Given
		assertThat(score.getCurrentScore(), equalTo(0));
		
		//When
		score.incrementScore();
		
		//Then
		assertThat(score.getCurrentScore(), equalTo(1));

	}
	
	@Test
	public void score_should_return_tennis_score() {
		
		//Given
		score = new Score();
		
		// When
		score.incrementScore();
		
		//then
		assertThat(score.getTennisScore(), equalTo("15"));

	}
}
