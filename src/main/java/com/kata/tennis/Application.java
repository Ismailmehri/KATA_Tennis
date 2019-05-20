package com.kata.tennis;

import java.util.Scanner;

import com.kata.tennis.core.ScoreCalculator;
import com.kata.tennis.domain.Player;

public class Application {

	public static void main(String[] args) {

		Player p1 = new Player("Player 1");
		Player p2 = new Player("Player 2");

		ScoreCalculator scoreCalculator = new ScoreCalculator(p1, p2);
		Scanner scan = new Scanner(System.in);
        
        
        while(!scoreCalculator.gameHasEnded()) {
        	int input = scan.nextInt();
        	switch (input) {
        		case 0 : printCurrentScore(p1, p2);
        			break;
        		case 1 : p1.getScore().incrementScore();
        			break;
        		case 2 : p2.getScore().incrementScore();
        			break;
        		default : System.out.println("Incorrect value");
        	}
        }
        scan.close();
        printCurrentScore(p1, p2);
		System.out.println("The winner is " + scoreCalculator.getTheWinner());

	}

	private static void printCurrentScore(Player player1, Player player2) {
		StringBuilder sb = new StringBuilder();
		sb.append("Player 1 :");
		sb.append(player1.getScore().getTennisScore());
		sb.append(" | ");
		sb.append("Player 2 :");
		sb.append(player2.getScore().getTennisScore());
		System.out.println(sb.toString());
	}
	
}
