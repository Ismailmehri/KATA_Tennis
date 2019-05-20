package com.kata.tennis;

import java.util.Scanner;

import com.kata.tennis.core.ScoreCalculator;
import com.kata.tennis.domain.Player;

public class Application {

	public static void main(String[] args) {

		Player p1 = new Player("Player 1");
		Player p2 = new Player("Player 2");

		start();
		ScoreCalculator scoreCalculator = new ScoreCalculator(p1, p2);
		Scanner scan = new Scanner(System.in);
        
        
        while(!scoreCalculator.gameHasEnded()) {
        	int input = scan.nextInt();
        	switch (input) {
        		case 0 : printCurrentScore(p1, p2);
        			break;
        		case 1 : p1.winPoint();
        			playerWin(p1.getName());
        			break;
        		case 2 : p2.winPoint();
    				playerWin(p2.getName());
        			break;
        		default : System.out.println("Incorrect value");
        	}
        }
        scan.close();
        printCurrentScore(p1, p2);
		System.out.println("The winner is " + scoreCalculator.getTheWinner());
		end();

	}

	private static void printCurrentScore(Player player1, Player player2) {
		StringBuilder sb = new StringBuilder();
		sb.append("| ----- Player 1 :");
		sb.append(player1.getScore().getTennisScore());
		sb.append(" | ");
		sb.append("Player 2 :");
		sb.append(player2.getScore().getTennisScore());
		sb.append(" ----- |");
		System.out.println(sb.toString());
	}
	
	private static void start() {
		System.out.println("----------------------------------------------------------------");
		System.out.println("|                        Game Started                           ");
		System.out.println("----------------------------------------------------------------");
	}
	
	private static void end() {
		System.out.println("----------------------------------------------------------------");
		System.out.println("|                          Game Over                            ");
		System.out.println("----------------------------------------------------------------");
	}
	
	private static void playerWin(String name) {
		System.out.println(" --> " + name + " win !");
	}
}
