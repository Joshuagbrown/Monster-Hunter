package main.model;

import java.util.ArrayList;

/**
The class which holds the methods relevant to a players inventory of items, being able to get certain item characteristics for each item in the inventory.
@author Josh Brown
*/
public class Inventory {
	
	private ArrayList<Item> inventory;
	
/**
Creates a new array list for the inventory and instantiates the inventory
@author Josh Brown
*/
	public Inventory() {
		ArrayList<Item> inventory = new ArrayList<Item>();
		this.inventory = inventory;
	}

/**
A getter method that returns the array list of the inventory
@return inventory, the array list holding all the items in the inventory
@author Josh Brown
*/
	public ArrayList<Item> getInventory() {
		return inventory;
	}

/**
Gets an item at a specific index in the inventory
@return an item in the inventory of class Item 
@author Josh Brown
*/
	public Item getItemAtIndex(int index) {
		return(this.inventory.get(index));		
	}

/**
A setter method which sets the inventory list
@param inventory, an array list of items
@author Josh Brown
*/
	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}

/**
Adds an item of class item to the inventory list
@param i an item 
@author Josh Brown 
*/
	public void addItem(Item i) {
		this.getInventory().add(i);
	}
	
/**
Removes at item at a specified index
@param index, the index of the item in the inventory to be removed
*/
	public void removeItemAtIndex(int index) {
		this.getInventory().remove(index);
	}

/**
Gets the item ID of an item at a specified index
@param index, the index of the item in the inventory to find ID of 
@return the Item ID
@author Josh Brown
*/
	public int getItemId(int index) {
		return(this.getInventory().get(index).getItemId());
	}

/**
Gets the desciption of an item at a specified index
@param index, the index of the item in the inventory to get description of 
@return the item description
@author Josh Brown 
*/	
	public String getDescription(int index) {
		return(this.getInventory().get(index).getDescription());
	}

/**
Gets the name of an item at a specified index
@param index, the index of the item in the inventory to get the name of
@return the item name or "Empty Slot" message
@author Josh Brown
*/	
	public String getName(int index) {
		if (index < this.inventory.size()) {
			return this.inventory.get(index).getName();
		} else {
			return "Empty Slot";
		}
	}
	
/**
Gets the purchase price of an item at a specified index
@param index, the index of the item in the inventory to get the purchase price of 
@return the items purchase price
@author Josh Brown
*/
	public int getPurchasePrice(int index) {
		return(this.getInventory().get(index).getPurchasePrice());
	}
	
/**
Gets the sell price of an item at a specified index
@param index, the index of the item in the inventory to get the sell price of 
@return the items sell price
@author Josh Brown
*/
	public int getSellPrice(int index) {
		return(this.getInventory().get(index).getSellPrice());
	}

/**
Gets the size of the inventory
@return the inventory size
@author Josh Brown
*/
	public int getSize() {
		return(this.getInventory().size());
	}


	

}
