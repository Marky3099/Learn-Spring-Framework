package com.practice.practice_spring_boot;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.practice.practice_spring_boot.game.GameRunner;
import com.practice.practice_spring_boot.game.MarioGame;

@SpringBootApplication
public class App01GamingBasic {

	public static void main(String[] args) {
//		SpringApplication.run(PracticeSpringBootApplication.class, args);
		var game = new MarioGame();
		var gameRunner = new GameRunner(game);
		gameRunner.run();
		
	}

}
