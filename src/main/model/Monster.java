package main.model;

/**
The class that holds all the methods relevant to the monster, each of the specific monsters can use these methods with their specific stats
@author Josh Brown
*/
public abstract class Monster {
	
	private String name;
	
	private int maxHealth;
	
	private int damage;
	
	private int healAmount;
	
	private int currentHealth;
	
	private int purchasePrice;
	
	private int sellPrice;

/**
Creates a new instance of a monster with the following attributes; name, maxHealth, damage, healAmout, currentHealth, purchasePrice, sellPrice.
@param name the name of the monster either default or given by the player
@param maxHealth the maximum level of health a specific monster can have
@param damage the amount of damage a monster can inflict on a monster of the opposing team 
@param healAmount the amount the monster can heal after an attack
@param purchasePrice how much the monster is bought for in the shop
@param sellPrice how much a player can sell a monster back for when it wants to buy a new one
@author Josh Brown
*/
	public Monster(String name, int maxHealth, int damage, int healAmount, int purchasePrice, int sellPrice) {
		super();
		this.name = name;
		this.maxHealth = maxHealth;
		this.damage = damage;
		this.healAmount = healAmount;
		this.currentHealth = maxHealth;
		this.purchasePrice = purchasePrice;
		this.sellPrice = sellPrice;
	}

/**
A getter method which returns the purchase price of a specific instance of a monster
@return the purchase price of the monster
@author Josh Brown
*/
	public int getPurchasePrice() {
		return purchasePrice;
	}

/**
A setter method which takes a value for a purchase price and assigns it to purchase price variable in the monster class
@param purchasePrice the amount the monster can be bought for 
@author Josh Brown
*/
	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

/**
A getter method which returns the selling price of a specific instance of a monster
@return the selling price of the monster
@author Josh Brown
*/
	public int getSellPrice() {
		return sellPrice;
	}

/**
A setter method which takes a value for a selling price and assigns it to the sell price variable in the monster class
@param sellPrice the amount a monster can be sold for
@author Josh Brown
*/
	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}


/**
Heals a monster adding its healing amount to its current health. If it is above max health brings it back down to a max of max health
@author Josh Brown
*/
	public void heal() {
		this.currentHealth = this.currentHealth + this.healAmount;
		if (this.currentHealth > this.maxHealth) {
			this.currentHealth = this.maxHealth;
		}
	}

/** 
A getter method which returns the name of a specific instance of a monster
@return the name of the monster
@author Josh Brown
*/
	public String getName() {
		return name;
	}

/**
A setter method that sets the value for the monsters name either the default or chosen by the player if it is within the length restrictions. Returns a Boolean is a successful name assignment is made
@param name the name of the monster
@author Josh Brown 
*/
	public boolean setName(String name) {
		if (name.length() < 3 || name.length() > 15) {
			return false;
		}
		this.name = name;
		return true;
	}

/**
A getter method that returns the maximum health of a specific instance of a monster
@return the maximum health of the monster
@author Josh Brown
*/
	public int getMaxHealth() {
		return maxHealth;
	}

/**
A setter method that takes a value and sets the value for the monsters maximum health 
@param maxHealth the monsters maximum helath 
@author Josh Brown
*/
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

/**
A getter method that returns the damage amount of a specific instance of a monster
@return the damage amount of the monster
@author Josh Brown
*/
	public int getDamage() {
		return damage;
	}

/**
A setter method that takes a value for damage and sets the value for the monster’s damage
@param damage the monsters damage amount
@author Josh Brown
*/
	public void setDamage(int damage) {
		this.damage = damage;
	}

/**
A getter method that returns the healing amount of a specific instance of a monster
@return the healing amount of the monster
@author Josh Brown
*/
	public int getHealAmount() {
		return healAmount;
	}

/**
A setter method that takes a value for heal amount and sets the value for the monster’s heal amount 
@param healAmount the monsters healing amount 
@author Josh Brown
*/
	public void setHealAmount(int healAmount) {
		this.healAmount = healAmount;
	}

/**
A getter method that returns the current health of a specific instance of a monster
@return the current health of the monster
@author Josh Brown 
*/
	public int getCurrentHealth() {
		return currentHealth;
	}

/**
A setter method that takes the current health value and sets the monster’s current health 
@param currentHealth the monsters current health 
@author Josh Brown
*/
	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
		if (this.currentHealth > this.maxHealth) {
			this.currentHealth = this.maxHealth;
		}
	}

}
