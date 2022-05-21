package main.model;

/**
A class which holds details about the player in the specific game being played
@author Josh Brown
*/
public class Player {
	
	private String name;
	private int gold;

/** 
A getter method which gets the players name returns it 
@return the players name 
@author Josh Brown
*/
	public String getName() {
		return name;
	}

/**
A setter method which sets up the game setting the players name to the name variable and the initial level of gold. Returns a Boolean indicating a successful setup or not.
@param name the players entered name
@return Boolean indicating a successful setup of player
@author Josh Brown 
*/
	public boolean setup(String name) {
		
		if (name.length() < 3 || name.length() > 15)
			return false;
		this.name = name;
		this.gold = 10000;
		
		return true;
	}

/**
A getter method that gets the current amount of gold the player holds
@return the amount of gold a player has
*/
	public int getGold() {
		return this.gold;
	}

/**
A setter method that sets the amount of gold to a new value
@param gold the amount of gold to be set to 
@author Josh Brown
*/
	public void setGold(int gold) {
		this.gold = gold;
	}
	
	
}
