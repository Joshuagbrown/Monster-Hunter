package main.controller;

import java.util.ArrayList;

import main.model.Elf;
import main.model.Monster;
import main.model.Orc;
import main.view.MainScreen;
import main.view.SetupScreen;

public class GameRunner {
	
	GameEnvironment gameEnvironment;
	
	public static void setup(GameEnvironment gameEnvironment) {
		ArrayList<Monster> startingList = new ArrayList<Monster>();
		startingList.add(new Orc());
		startingList.add(new Elf());
		startingList.add(new Orc());
		SetupScreen setupScreen = new SetupScreen(gameEnvironment, startingList);
	}
	
	public static void launchMainScreen(GameEnvironment gameEnvironment) {
		MainScreen mainScreen = new MainScreen(gameEnvironment);
	}
	
	public static void main(String args[]) {
		GameEnvironment gameEnvironment = new GameEnvironment();
		setup(gameEnvironment);					
	}
}
