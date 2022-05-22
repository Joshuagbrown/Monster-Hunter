package main.controller;

import java.util.ArrayList;
import java.util.Random;

import main.model.Dragon;
import main.model.Elf;
import main.model.Gremlin;
import main.model.Human;
import main.model.Inventory;
import main.model.Item;
import main.model.Monster;
import main.model.Orc;
import main.model.Party;
import main.model.Player;
import main.model.Wizard;

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
	private Inventory inventory;
	
	private String randomEventDesc = "";
	
	private boolean easyFightDone = false;
	private boolean normalFightDone = false;
	private boolean hardFightDone = false;
	
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
		this.inventory = new Inventory();
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
@param battleChoice the battle the player has chosen with the select group of monsters
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
Displays the loss screen
@author Josh Brown
*/
	public void loseFight() {
		
		//TODO - add some stuff here
		
		GameRunner.displayLoss();

	}
/**
Displays the win screen and increases the gold by $100
@author Josh Brown
*/	
	public void winFight() {

		//TODO - add some stuff here
		
		this.player.setGold(this.player.getGold() + 100);
		
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
	public boolean endDay() {
		this.day++;
		if (this.getTotalDays() < this.day) {
			return true;
		}
		nightRandomEvent();
		healMonsters();
		this.easyFightDone = false;
		this.normalFightDone = false;
		this.hardFightDone = false;
		return false;
	}

	public boolean isEasyFightDone() {
		return easyFightDone;
	}

	public void setEasyFightDone(boolean easyFightDone) {
		this.easyFightDone = easyFightDone;
	}

	public boolean isNormalFightDone() {
		return normalFightDone;
	}

	public void setNormalFightDone(boolean normalFightDone) {
		this.normalFightDone = normalFightDone;
	}

	public boolean isHardFightDone() {
		return hardFightDone;
	}

	public void setHardFightDone(boolean hardFightDone) {
		this.hardFightDone = hardFightDone;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public void setDay(int day) {
		this.day = day;
	}

/**
Creates a random value, that dictates the random events occuring overnight. 
@author Josh Brown
*/
	private void nightRandomEvent() {
		Random random = new Random();
		
		int randomValue = random.nextInt(10 - this.difficulty);
		
		if (randomValue <= 2 ) {
			this.randomEventDesc = "";
			return;
		} else if (randomValue <= 3) {
			if (this.party.getSize() > 1) {
				monsterLeaves();
				return;
			}
		} else if (randomValue <= 4) {
			if (this.party.getSize() < 5) {
				monsterJoins();
				return;
			}
		} else {
			monsterLevels();
			return;
		}
	}
	
/**
A getter method that returns the value of randomEventDesc. 
@return randomEventDesc
@author Josh Brown
*/
	public String getRandomEventDesc() {
		return randomEventDesc;
	}

/**
A setter method which sets the string for randomEventDesc
@param randomEventDesc a string
@author Josh Brown
*/
	public void setRandomEventDesc(String randomEventDesc) {
		this.randomEventDesc = randomEventDesc;
	}

/**
Gets the lowest health monster in the party and prints a message indicating it has left the party and removes the monster at the given index
@author Josh Brown
*/
	public void monsterLeaves() {
		int lowestHealthIndex = this.party.getLowestHealthMonster();
		this.randomEventDesc = String.format("Monster %s left due to its injuries from the last battle", this.party.getMonsterAtIndex(lowestHealthIndex).getName());
		this.party.removeMonsterAtIndex(lowestHealthIndex);
	}

/**
Produces a random value which decides what random events occur overnight, relating to monsters joining your party. 
@author Josh Brown 
*/	
	public void monsterJoins() {
		Random random = new Random();
		int randomValue = random.nextInt(60);
		if (randomValue < 3) {
			this.party.addMonster(new Dragon());
			this.randomEventDesc = "A Dragon joined your party overnight!";
		} else if (randomValue <10) {
			this.party.addMonster(new Wizard());
			this.randomEventDesc = "A Wizard joined your party overnight!";
		} else if (randomValue < 20) {
			this.party.addMonster(new Orc());
			this.randomEventDesc = "An Orc joined your party overnight!";
		} else if (randomValue < 30) {
			this.party.addMonster(new Elf());
			this.randomEventDesc = "An Elf joined your party overnight!";
		} else {
			this.party.addMonster(new Gremlin());
			this.randomEventDesc = "A Gremlin joined your party overnight!";
		}
	}

/**
Levels up the oldest monster in your party to have increased max health, damage, and healing.
@author Josh Brown 
*/
	public void monsterLevels() {
		this.randomEventDesc = String.format("Your Oldest Monster %s Leveled Up! Stats have increased", this.party.getMonsterAtIndex(0).getName());
		this.party.getMonsterAtIndex(0).setMaxHealth((int)(this.party.getMonsterAtIndex(0).getMaxHealth() * 1.5));
		this.party.getMonsterAtIndex(0).setDamage((int)(this.party.getMonsterAtIndex(0).getDamage() * 1.5));;
		this.party.getMonsterAtIndex(0).setHealAmount((int)(this.party.getMonsterAtIndex(0).getHealAmount() * 1.5));;
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
	
	public boolean buyItem(Item i) {
		if (this.player.getGold() >= i.getPurchasePrice() && this.inventory.getSize() < 6) {
			this.player.setGold(this.player.getGold() - i.getPurchasePrice());
			this.inventory.addItem(i);
			return true;
		}
		return false;
	}
	
	public boolean sellItem(int index) {
		if (this.inventory.getSize() > index) {
			Item i = this.inventory.getItemAtIndex(index);
			this.player.setGold(this.player.getGold() + i.getSellPrice());
			this.inventory.removeItemAtIndex(index);
			return true;
		}
		return false;
	}
	
	public void useItem(int index, int monsterIndex) {
		int itemId = this.inventory.getItemId(index);
		if (itemId == 0){
			int currentHealth = this.party.getMonsterAtIndex(monsterIndex).getCurrentHealth();
			int maxHealth = this.party.getMonsterAtIndex(monsterIndex).getMaxHealth();
			this.party.getMonsterAtIndex(monsterIndex).setCurrentHealth(currentHealth + (maxHealth / 2));	
		} else if (itemId == 1) {
			int damage = this.party.getMonsterAtIndex(monsterIndex).getDamage();
			this.party.getMonsterAtIndex(monsterIndex).setDamage(damage + (damage / 4));
		} else if (itemId == 2) {
			int healAmount = this.party.getMonsterAtIndex(monsterIndex).getHealAmount();
			this.party.getMonsterAtIndex(monsterIndex).setHealAmount(healAmount + (healAmount / 2));
		}
		this.inventory.removeItemAtIndex(index);
	}	
	
	public Inventory getInventory() {
		return inventory;
	}
}


