package main.model;

import java.util.ArrayList;

/**
The class which holds the methods relevant to the party of monsters, being able to get certain monster characteristics for each monster in the party.
@author Josh Brown
*/
public class Party {
	
	private ArrayList<Monster> partyList;
	private int currentFighterIndex = 0;
	
/**
A getter method which returns the current fighter in the monster party
@return the current fighter 
@author Josh Brown
*/	
	public int getCurrentFighterIndex() {
		return currentFighterIndex;
	}

/**
A setter method that takes the current fighter index and sets the party’s current fighter
@param currentFigherIndex the index in the party array list of the current fighter
@author Josh Brown
*/
	public void setCurrentFighterIndex(int currentFighterIndex) {
		this.currentFighterIndex = currentFighterIndex;
	}

/**
Creates an array list which takes monsters items of the monster class for the party and adds the monster to the array list
@param monster the monster being added to the array list
@author Josh Brown
*/
	public Party(Monster monster) {
		ArrayList<Monster> partyList = new ArrayList<Monster>();
		partyList.add(monster);
		this.partyList = partyList;
	}
	
/**
A getter method which returns the list of monsters in the party
@return party list of monsters
@author Josh Brown
*/
	public ArrayList<Monster> getPartyList() {
		return partyList;
	}

/**
A setter method that takes the current array list of the party of monsters and sets it to the party list
@param partyList the list of mosnters in the players party
@author Josh Brown
*/
	public void setPartyList(ArrayList<Monster> partyList) {
		this.partyList = partyList;
	}

/** 
A getter method which returns the name of the monster in the party at a specified index
@returns the name of the monster of the message empty slot if the party is not filled
@author Josh Brown
*/
	public String getName(int i) {
		if (i < this.partyList.size()) {
			if (this.partyList.get(i).getCurrentHealth() <= 0) {
				return this.partyList.get(i).getName() + " (Faint)";
			}
			return this.partyList.get(i).getName();
		} else {
			return "Empty Slot";
		}
	}

/**
A getter method which returns the current health of a monster in the party at a specified index
@returns the current health of the monster or a blank message if the party is not filled
@author Josh Brown
*/
	public String getHealth(int i) {
		if (i < this.partyList.size()) {
			return Integer.toString(this.partyList.get(i).getCurrentHealth());
		} else {
			return "";
		}
	}

/**
A getter method which returns the damage of a monster in the party at a specified index
@returns the damage of the monster or a blank message if the party is not filled 
@author Josh Brown
*/
	public String getDamage(int i) {
		if (i < this.partyList.size()) {
			return Integer.toString(this.partyList.get(i).getDamage());
		} else {
			return "";
		}
	}

/**
A getter method which returns the healing amount of a monster in the party at a specified index
@returns the healing amount of the monster or a blank message if the party is not filled 
@author Josh Brown
*/	
	public String getHeal(int i) {
		if (i < this.partyList.size()) {
			return Integer.toString(this.partyList.get(i).getHealAmount());
		} else {
			return "";
		}
	}

/** 
A method which changes the index of the monster in the party from the current index to the next and returns a Boolean for if the increment has been successful or we are at the end of the list
@return Boolean of whether the increment was successful
@author Josh Brown
*/
	public boolean incrementCurrentFighter() {
		this.currentFighterIndex++;
		
		if (this.currentFighterIndex >= this.getSize()) {
			return false;
		}
		return true;
	}

/**
Gets the index of the monster with the lowest health in a party of monsters
@return the index of the monster with the lowest heatlh as an integer
@author Josh Brown
*/
	public int getLowestHealthMonster() {
		int index = 0;
		int currentLowestIndex = 0;
		while (index < this.getSize()){
			if (this.getMonsterAtIndex(currentLowestIndex).getCurrentHealth() < this.getMonsterAtIndex(index).getCurrentHealth()) {
				currentLowestIndex = index;
			}
			index ++;
		}
		return currentLowestIndex;
	}

/**
Adds a monster to the party list
@param m a monster which is to be added to party
@author Josh Brown
*/
	public void addMonster(Monster m) {
		this.getPartyList().add(m);
	}

/**
Returns a monster at a given index in the party list
@param index the index at which we are looking for the monster in the party list
@author Josh Brown 
*/
	public Monster getMonsterAtIndex(int index) {
		return this.partyList.get(index);
	}
	
/**
Removes a monster at a given index
@param index the index at which the monster needs to be removed
@author Josh Brown 
*/
	public void removeMonsterAtIndex(int index) {
		this.partyList.remove(index);
	}

/** 
Returns the size of the monster party
@return a length of the monster party size
@author Josh Brown
*/
	public int getSize() {
		return this.partyList.size();
	}
}
