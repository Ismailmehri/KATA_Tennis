package com.kata.tennis.domain;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

/**
 * Created by Aymen on 26/06/2016.
 */
public class PlayerTest {

    private Player player;

    @Before
    public void setup() {
        player = new Player("Player 1");
    }

    @Test
    public void player_should_start_with_score_of_0(){
        assertThat( player.getScore().getCurrentScore(), equalTo(0));
    }
    
    @Test
    public void player_should_start_with_set_score_of_0(){
        assertThat( player.getScore().getSetScore(), equalTo(0));
    }
    
    @Test
    public void should_increment_score_if_player_won() {
    	
    	//When
    	player.winPoint();
    	
    	//then
        assertThat( player.getScore().getCurrentScore(), equalTo(1));
    }
    
    @Test
    public void should_compare_two_players() {
    	
    	//Given
    	Player  player2 = new Player("Player 2");
    	player2.winPoint();
    	
    	// When
    	int result = player.compareTo(player2);
    	
    	// Then
    	assertTrue(result < 0);
    }
}
