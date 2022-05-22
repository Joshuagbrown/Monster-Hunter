package main.model;

/** 
Class of a Gremlin which extends the monster class, holds all the values specific to Gremlin
@author Aimée Cloutman
*/
public class Gremlin extends Monster { 

/** 
Holds all the specific statistics relevant to a Gremlin
@author Aimée Cloutman
*/
	 public Gremlin() {
		 //name, maxHealth, damage, healAmount, buyPrice, sellPrice 
		 super("Gremlin", 30, 5, 5, 50, 20);
	 }
}
