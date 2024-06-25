package com.practice.practice_spring_boot.game;

public class MarioGame implements GameConsole{
	
	public void up() {
		System.out.println("Jump");
	}
	public void down() {
		System.out.println("Go to a Hole");
	}
	public void left() {
		System.out.println("Go Back");
	}
	public void right() {
		System.out.println("Accelerate");
	}
}
