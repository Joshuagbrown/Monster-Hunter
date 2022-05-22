package main.model;

/** 
Class of an Orc which extends the monster class, holds all the values specific to Orc
@author Josh Brown
*/
public class Orc extends Monster {

/** 
Holds all the specific statistics relevant to a Orc
@author Josh Brown
*/
	public Orc() {
		 //name, maxHealth, damage, healAmount, buyPrice, sellPrice 

		super("Orc", 100, 5, 25, 100, 50);
	}
	
}
