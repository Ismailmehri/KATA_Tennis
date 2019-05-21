package com.kata.tennis;

import java.util.Scanner;

import com.kata.tennis.core.ScoreCalculator;
import com.kata.tennis.core.SetScoreCalculator;
import com.kata.tennis.domain.Player;

public class Application {

	public static void main(String[] args) {

		Player p1 = new Player("Player 1");
		Player p2 = new Player("Player 2");

		start();
		ScoreCalculator scoreCalculator = new ScoreCalculator(p1, p2);
		SetScoreCalculator setScoreCalculator = new SetScoreCalculator(p1, p2);
		Scanner scan = new Scanner(System.in);
        
		help();
		while (!setScoreCalculator.gameHasEnded()) {
	        while(!scoreCalculator.gameHasEnded()) {
	        	int input = scan.nextInt();
	        	switch (input) {
	        		case 0 : printCurrentScore(p1, p2, scoreCalculator);
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
	        scoreCalculator.getTheWinner().winSet();
	        p1.getScore().initCurrentScore();
	        p2.getScore().initCurrentScore();
	        printCurrentScore(p1, p2, scoreCalculator);
        }
        scan.close();
		end(setScoreCalculator.getTheWinner().getName());

	}

	private static void printCurrentScore(Player player1, Player player2, ScoreCalculator calculator) {
		calculator.updateGameScore();
		StringBuilder sb = new StringBuilder();
		sb.append("| ----- Player 1 :  ");
		sb.append(player1.getScore().getGameScore());
		sb.append(" | ");
		sb.append(player1.getScore().getSetScore());
		sb.append(" ----- |");
		sb.append("\n");
		sb.append("| ----- Player 2 :  ");
		sb.append(player2.getScore().getGameScore());
		sb.append(" | ");
		sb.append(player2.getScore().getSetScore());
		sb.append(" ----- |");
		System.out.println(sb.toString());
	}
	
	private static void start() {
		System.out.println("----------------------------------------------------------------");
		System.out.println("|                        Game Started                           ");
		System.out.println("----------------------------------------------------------------");
	}
	
	private static void end(String palyer) {
		System.out.println("----------------------------------------------------------------");
		System.out.println("|                      The winner is " + palyer + "                    |");
		System.out.println("----------------------------------------------------------------");
		System.out.println("|                          Game Over                           |");
		System.out.println("----------------------------------------------------------------");
	}
	
	private static void playerWin(String name) {
		System.out.println(" --> " + name + " wins 1 point !");
	}
	
	private static void help() {
		System.out.println(" Push '0' to display the current Game score ");
		System.out.println(" Push '1' if you want that the player 1 win point ");
		System.out.println(" Push '2' if you want that the player 2 win point ");


	}
}
