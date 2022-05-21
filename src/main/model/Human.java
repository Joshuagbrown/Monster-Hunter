package main.model;

/** 
Class of a Human which extends the monster class, holds all the values specific to Human
@author Josh Brown
*/
public class Human extends Monster {

/** 
Holds all the specific statistics relevant to a Human
@author Josh Brown
*/
	public Human() {
		 //name, maxHealth, damage, healAmount, buyPrice, sellPrice 

		super("Human", 75, 4, 5, 100, 80);
	}
	
}
