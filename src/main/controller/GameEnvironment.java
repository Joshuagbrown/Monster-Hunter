package main.controller;

import java.util.ArrayList;
import java.util.Random;

import main.model.Dragon;
import main.model.Elf;
import main.model.Gremlin;
import main.model.Human;
import main.model.Monster;
import main.model.Orc;
import main.model.Party;
import main.model.Player;
import main.model.Wizard;
import main.view.MainScreen;
import main.view.SetupScreen;

/**
Game environment holds the current status of the game
@author Josh Brown
*/
public class GameEnvironment {

	private Player player;
	
	private int difficulty;
	private int totalDays;
	private int day = 1;
	
	private Party party;
	private Party enemyParty = new Party(new Gremlin());
	
/**
Creates a new player in the game environment
@author Josh Brown
*/
	public GameEnvironment() {
		this.player = new Player();
	}
	
/**
Takes the players entered name, days, chosen Monster and difficulty level and sets up the game. Setting player stats in player class. 
@param name the player’s game name
@param days the amount of days the player has selected to play
@param monster the players initial monster for their team 
@param difficulty the difficulty level the player has chosen to play
@return a Boolean of whether the chosen name is acceptable
@author Josh Brown 
*/

	public boolean setupGame(String name, int days, Monster monster, int difficulty) {
		this.party = new Party(monster);
		this.difficulty = difficulty;
		this.totalDays = days;
		return player.setup(name);
	}


/**
A getter for the current day it is in the game
@return the current day in the game
@author Josh Brown
*/
	public int getDay() {
		return this.day;
	}

/**
A getter for the total amount of days the player has selected for this game
@return the total number of days in the game
@author Josh Brown
*/
	public int getTotalDays() {
		return this.totalDays;
	}

/**
A getter that gets the player object from player class and all the relevant stats of the player
@return a player object from the player class (the player for that particular game)
@author Josh Brown
*/
	public Player getPlayer() {
		return player;
	}

/**
A setter method that sets the player to be an object player
@author Josh Brown
*/
	public void setPlayer(Player player) {
		this.player = player;
	}

/** 
A getter method that gets the current party of monsters a player holds
@return the current party of monsters
@author Josh Brown
*/
	public Party getParty() {
		return party;
	}

/**
A setter method which takes a party as a parameter and sets the party to this instance of party
@param party and instance of the class party 
@author Josh Brown
*/
	public void setParty(Party party) {
		this.party = party;
	}

/**
Adds a monster to the players party is they have enough room in their party and enough money. Takes the gold down by the purchase price of the monster. Returns True is a successful purchase and False otherwise. 
@param m a monster object from the monster class one of the creature options
@ return a Boolean indicating a successful purchase or not
@author Josh Brown
*/
	public boolean buyMonster(Monster m) {
		if (this.player.getGold() >= m.getPurchasePrice() && this.party.getSize() < 5) {
			this.player.setGold(this.player.getGold() - m.getPurchasePrice());
			this.party.addMonster(m);
			return true;
		}
		return false;
	}

/**
Sells a monster by deleting it form the monster party and increasing the gold by the relevant amount
@index takes the index of the monster to be sold 
@return a Boolean indicating a successful sale or not
@author Josh Brown
*/
	public boolean sellMonster(int index) {
		if (this.party.getSize() > index) {
			Monster m = this.getParty().getMonsterAtIndex(index);
			this.player.setGold(this.player.getGold() + m.getSellPrice());
			this.party.removeMonsterAtIndex(index);
			return true;
		}
		return false;
	}

/**
Gets the monsters in the enemy party from the battle the player is playing. Sets the party size using random numbers and creates the monsters in it based on this factor. 
@param battlehChoice the battle the player has chosen with the select group of monsters
@author Josh Brown
*/
	public void getEnemyMonsters(int battleChoice) {
		
		this.enemyParty.setPartyList(new ArrayList<Monster>());
		this.party.setCurrentFighterIndex(0);
		this.enemyParty.setCurrentFighterIndex(0);

		
		Random random = new Random();
		
		int randomSizeValue = random.nextInt(3) + this.day + battleChoice + this.difficulty;
		
		int enemyPartySize = 0;

		if (randomSizeValue < 5) {
			enemyPartySize += 1;
		} else if (randomSizeValue < 7) {
			enemyPartySize += 2;
		} else if (randomSizeValue < 9) {
			enemyPartySize += 3;
		} else if (randomSizeValue < 11) {
			enemyPartySize += 4;
		} else {
			enemyPartySize += 5;
		}
				
		for (int i = 0; i < enemyPartySize; i++) {
			int randomEnemyTypeValue = random.nextInt(6) + this.day + battleChoice + this.difficulty;
			if (randomEnemyTypeValue < 7) {
				enemyParty.addMonster(new Gremlin());
			} else if (randomEnemyTypeValue < 9) {
				enemyParty.addMonster(new Elf());
			} else if (randomEnemyTypeValue < 11) {
				enemyParty.addMonster(new Human());
			} else if (randomEnemyTypeValue < 13) {
				enemyParty.addMonster(new Orc());
			} else if (randomEnemyTypeValue < 15) {
				enemyParty.addMonster(new Wizard());
			} else {
				enemyParty.addMonster(new Dragon());
			}
		}
				
		
	}

/**
Creates a fight between 2 monsters, showing if your monster wins or loses and depletes current health by the relevant value. 
@return a Boolean indicating a successful fight or not 
@ author Josh Brown
*/
	public boolean fight() {
		Monster playerFighter = this.party.getMonsterAtIndex(this.party.getCurrentFighterIndex());
		Monster enemyFighter = this.enemyParty.getMonsterAtIndex(this.enemyParty.getCurrentFighterIndex());
		
		playerFighter.setCurrentHealth(playerFighter.getCurrentHealth() - enemyFighter.getDamage());
		enemyFighter.setCurrentHealth(enemyFighter.getCurrentHealth() - playerFighter.getDamage());
		
		if (playerFighter.getCurrentHealth() <= 0) {
			playerFighter.setCurrentHealth(0);
			if (!this.party.incrementCurrentFighter()) {
				loseFight();
				return true;
			}
		}
		
		if (enemyFighter.getCurrentHealth() <= 0) {
			enemyFighter.setCurrentHealth(0);
			if (!this.enemyParty.incrementCurrentFighter()) {
				winFight();
				return true;
			}
		}
		return false;
		
	}

/**
*/
	public void loseFight() {
		
		//TODO - add some stuff here
		
		endDay();
		GameRunner.displayLoss();

	}
/**
*/	
	public void winFight() {

		//TODO - add some stuff here
		
		this.player.setGold(this.player.getGold() + 100);
		
		endDay();
		GameRunner.displayWin();

	}

/**
Sets the current health of a monster to increase by the heal amount
@author Josh Brown
*/
	public void healMonsters() {
		for (Monster m : this.party.getPartyList()) {
			m.setCurrentHealth(m.getCurrentHealth() + m.getHealAmount());
		}
	}
	

/**
Adds another day to the game, runs the overnight even where monsters are healed to max health and the random night events
@author Josh Brown
*/
	public void endDay() {
		this.day++;
		if (this.getTotalDays() < this.day) {
//			gameOver();
		}
		nightRandomEvent();
		healMonsters();
	}

/**
*/
	private void nightRandomEvent() {
		Random random = new Random();
		
		int randomValue = random.nextInt(3);
	}

/**
A getter method that returns the monster party of the enemy team 
@return the enemy party
@author Josh Brown
*/
	public Party getEnemyParty() {
		return enemyParty;
	}

/**
A setter method that sets the party of monsters for the enemy team
@param enemyParty is the enemy party
@author Josh Brown
*/
	public void setEnemyParty(Party enemyParty) {
		this.enemyParty = enemyParty;
	}

	

	
}


