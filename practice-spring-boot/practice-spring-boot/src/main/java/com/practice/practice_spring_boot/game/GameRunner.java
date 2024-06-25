package com.practice.practice_spring_boot.game;

public class GameRunner {
	private GameConsole game;
	
	public GameRunner(GameConsole game) {
		this.game = game;
	}
	
	public void run() {
		System.out.println("Running Game: "+game);
		game.up();
		game.down();
		game.left();
		game.right();
	}
}
