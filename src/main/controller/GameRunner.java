package main.controller;

import main.view.SetupScreen;

public class GameRunner {
	
	GameEnvironment gameEnvironment;
	
	public static void setup(GameEnvironment gameEnvironment) {
		SetupScreen setupScreen = new SetupScreen(gameEnvironment);
	}
	
	public static void main(String args[]) {
		System.out.println("test");
		GameEnvironment gameEnvironment = new GameEnvironment();
		System.out.println("test");
		setup(gameEnvironment);
		
				
	}
}
