package main.model;

/**
Class for the item option of a strength potion, it extends the item class as is a specific intance of an item 
@author Josh Brown
*/
public class StrengthPotion extends Item{

	public StrengthPotion() {
		//String description, int itemId, int purchasePrice, int sellPrice
		super("Strength Potion", "Add 25% damage", 1, 300, 150);
	}
	

}
