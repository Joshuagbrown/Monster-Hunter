package main.model;

/**
Class of an Elf which extends the monster class, holds all the values specific to Elf
@author Josh Brown
*/
public class Elf extends Monster {

/**
Holds all the specific statistics relevant to an Elf
@author Josh Brown
*/
	public Elf() {
		 //name, maxHealth, damage, healAmount, buyPrice, sellPrice 
		super("Elf", 50, 10, 25, 100, 50);
	}


}
