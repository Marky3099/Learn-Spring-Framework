package com.practice.practice_spring_boot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.practice.practice_spring_boot.game.GameConsole;
import com.practice.practice_spring_boot.game.GameRunner;
import com.practice.practice_spring_boot.game.MarioGame;

@Configuration
public class GamingConfiguration {
	
	@Bean
	public GameConsole game() {
		var game = new MarioGame();
		return game;
	}
	
	@Bean
	public GameRunner gameRunner(GameConsole game) {
		var gameRunner = new GameRunner(game);
		return gameRunner;
	}
}
