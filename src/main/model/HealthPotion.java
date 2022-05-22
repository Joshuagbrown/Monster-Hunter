package main.model;

/**
Class for the item of the health potion, it extends the item class as is a specific instance of an item
@author Josh Brown
*/
public class HealthPotion extends Item{

/**
Method holds the specific characteristics for the health potion item 
@author Josh Brown
*/
	public HealthPotion() {
		//String description, int itemId, int purchasePrice, int sellPrice
		super("Health Potion","Heal 50% of monsters health", 0, 200, 100);
	}
	

}
