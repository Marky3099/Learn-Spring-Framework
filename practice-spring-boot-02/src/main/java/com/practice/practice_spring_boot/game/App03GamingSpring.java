package com.practice.practice_spring_boot.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.practice.practice_spring_boot.game")
public class App03GamingSpring {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(var context = new AnnotationConfigApplicationContext(App03GamingSpring.class);){
			context.getBean(GameConsole.class).up();
			context.getBean(GameRunner.class).run();
		}
	}

}
