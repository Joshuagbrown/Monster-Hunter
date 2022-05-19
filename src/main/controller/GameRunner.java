package main.controller;

import java.util.ArrayList;

import main.model.Elf;
import main.model.Human;
import main.model.Monster;
import main.model.Orc;
import main.view.BattleScreen;
import main.view.LossScreen;
import main.view.MainScreen;
import main.view.SetupScreen;
import main.view.ShopScreen;
import main.view.WinScreen;

public class GameRunner {
	
	GameEnvironment gameEnvironment;
	
	public static void setup(GameEnvironment gameEnvironment) {
		ArrayList<Monster> startingList = new ArrayList<Monster>();
		startingList.add(new Orc());
		startingList.add(new Elf());
		startingList.add(new Human());
		SetupScreen setupScreen = new SetupScreen(gameEnvironment, startingList);
	}
	
	public static void launchMainScreen(GameEnvironment gameEnvironment) {
		MainScreen mainScreen = new MainScreen(gameEnvironment);
	}
	
	public static void launchShopScreen(GameEnvironment gameEnvironment) {
		ShopScreen shopScreen = new ShopScreen(gameEnvironment);
	}
	
	public static void launchBattleScreen(GameEnvironment gameEnvironment) {
		BattleScreen battleScreen = new BattleScreen(gameEnvironment);	
	}
	
	public static void displayWin() {
		WinScreen WinScreen = new WinScreen();	

	}
	
	public static void displayLoss() {
		LossScreen lossScreen = new LossScreen();	

	}
	
	public static void main(String args[]) {
		GameEnvironment gameEnvironment = new GameEnvironment();
		setup(gameEnvironment);					
	}



	
}
