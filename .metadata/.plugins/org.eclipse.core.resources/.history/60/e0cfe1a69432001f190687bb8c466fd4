package com.practice.practice_spring_boot;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.practice.practice_spring_boot.game.GameConsole;
import com.practice.practice_spring_boot.game.GameRunner;

public class App03GamingSpring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(var context = new AnnotationConfigApplicationContext(GamingConfiguration.class);){
			context.getBean(GameConsole.class).up();
			context.getBean(GameRunner.class).run();
		}
	}

}
