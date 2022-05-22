package main.model;

/**
Class of a Dragon which extends the monster class, holds all the values specific to Dragon
@author Aimée Cloutman
*/
public class Dragon extends Monster { 

/** 
Holds all the specific statistics relevant to a Dragon
@author Aimée Cloutman
*/
	 public Dragon() {
		 //name, maxHealth, damage, healAmount, buyPrice, sellPrice 
		 super("Dragon", 120, 35, 20, 1000, 500);
	 }
}
