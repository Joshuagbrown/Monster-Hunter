package main.controller;

import java.util.ArrayList;

import main.model.Elf;
import main.model.Human;
import main.model.Monster;
import main.model.Orc;
import main.view.BattleScreen;
import main.view.EndScreen;
import main.view.LossScreen;
import main.view.MainScreen;
import main.view.SetupScreen;
import main.view.ShopScreen;
import main.view.WinScreen;

/**
Runs the main screens in the game, as well as connecting to the game environment
@author Josh Brown
*/
public class GameRunner {
	
	GameEnvironment gameEnvironment;

/**
Sets up a new game environment and adds the starting game available monsters to an array list
@param gameEnvironment a new object of the game environment class
@author Josh Brown
*/
	public static void setup(GameEnvironment gameEnvironment) {
		ArrayList<Monster> startingList = new ArrayList<Monster>();
		startingList.add(new Orc());
		startingList.add(new Elf());
		startingList.add(new Human());
		@SuppressWarnings("unused")
		SetupScreen setupScreen = new SetupScreen(gameEnvironment, startingList);
	}

/**
Takes the current game environment and launches the main screen of the game for the player to view
@param gameEnvironment the current state of the game environment 
@author Josh Brown
*/
	public static void launchMainScreen(GameEnvironment gameEnvironment) {
		@SuppressWarnings("unused")
		MainScreen mainScreen = new MainScreen(gameEnvironment);
	}
	
/** 
Takes the current game environment information and launches the shop screen for the player to view
@param gameEnvironment the current state of the game environment
@author Josh Brown
*/
	public static void launchShopScreen(GameEnvironment gameEnvironment) {
		@SuppressWarnings("unused")
		ShopScreen shopScreen = new ShopScreen(gameEnvironment);
	}

/** 
Takes the current game environment information and launches the battle screen for the player to view
@param gameEnvironment the current state of the game environment
@author Josh Brown
*/
	public static void launchBattleScreen(GameEnvironment gameEnvironment) {
		@SuppressWarnings("unused")
		BattleScreen battleScreen = new BattleScreen(gameEnvironment);	
	}

/**
Displays the win screen for when a player wins a battle
@author Josh Brown
*/
	public static void displayWin() {
		@SuppressWarnings("unused")
		WinScreen WinScreen = new WinScreen();	

	}
	
/**
Displays the loss screen for when a player loses a battle
@author Josh Brown
*/
	public static void displayLoss() {
		@SuppressWarnings("unused")
		LossScreen lossScreen = new LossScreen();	

	}

/**
Displays the ending screen for when the game is over
@author Josh Brown
*/
	public static void launchEndScreen(GameEnvironment gameEnvironment) {
		@SuppressWarnings("unused")
		EndScreen endScreen = new EndScreen(gameEnvironment);	

	}
	
/**
Main method, sets up a new gameEnvironment
*/
	public static void main(String args[]) {
		GameEnvironment gameEnvironment = new GameEnvironment();
		setup(gameEnvironment);					
	}



	
}
