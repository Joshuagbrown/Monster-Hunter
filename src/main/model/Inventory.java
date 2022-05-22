package main.model;

import java.util.ArrayList;

public class Inventory {
	
	private ArrayList<Item> inventory;
	
	public Inventory() {
		ArrayList<Item> inventory = new ArrayList<Item>();
		this.inventory = inventory;
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}
	
	public Item getItemAtIndex(int index) {
		return(this.inventory.get(index));		
	}

	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}
	
	public void addItem(Item i) {
		this.getInventory().add(i);
	}
	
	public void removeItemAtIndex(int index) {
		this.getInventory().remove(index);
	}
	
	public int getItemId(int index) {
		return(this.getInventory().get(index).getItemId());
	}
	
	public String getDescription(int index) {
		return(this.getInventory().get(index).getDescription());
	}
	
	public String getName(int index) {
		if (index < this.inventory.size()) {
			return this.inventory.get(index).getName();
		} else {
			return "Empty Slot";
		}
	}
	
	public int getPurchasePrice(int index) {
		return(this.getInventory().get(index).getPurchasePrice());
	}
	
	public int getSellPrice(int index) {
		return(this.getInventory().get(index).getSellPrice());
	}

	public int getSize() {
		return(this.getInventory().size());
	}


	

}
