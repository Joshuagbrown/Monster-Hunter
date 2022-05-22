package main.model;

/** 
Class of a Wizard which extends the monster class, holds all the values specific to Wizard
@author Aimée Cloutman
*/
public class Wizard extends Monster { 

/** 
Holds all the specific statistics relevant to a Wizard
@author Aimée Cloutman
*/
	 public Wizard() {
		 //name, maxHealth, damage, healAmount, buyPrice, sellPrice 

		 super("Wizard", 50, 25, 25, 250, 125) ;
	 }
}
