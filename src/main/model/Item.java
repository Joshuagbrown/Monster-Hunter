package main.model;

/**
The class for all the different types of items you can buy to assist you in gameplay
@author Josh Brown
*/
public abstract class Item {
	
	private String name;
	
	private String description;
	
	private int itemId;

	private int purchasePrice;
	
	private int sellPrice;

/**
Instantiates all the different attributes of an item 
@param name, the name of an item 
@param description, the description of an item 
@param itemId, the ID number of an item 
@param purchasePrice, the purchase price of an item
@param sellPrice, the sell price of an item 
@author Josh Brown 
*/
	public Item(String name, String description, int itemId, int purchasePrice, int sellPrice) {
		super();
		this.name = name;
		this.description = description;
		this.itemId = itemId;
		this.purchasePrice = purchasePrice;
		this.sellPrice = sellPrice;
	}

/**
A getter method that returns the name of an item 
@return the item name
@author Josh Brown
*/
	public String getName() {
		return name;
	}

/**
A setter method that sets the name of an item
@param name, the name of an item 
@author Josh Brown
*/
	public void setName(String name) {
		this.name = name;
	}

/**
A getter method that returns the description of an item 
@return the items description 
@author Josh Brown
*/
	public String getDescription() {
		return description;
	}

/**
A setter method that sets the description of an item 
@param description, the description of an item 
@author Josh Brown
*/
	public void setDescription(String description) {
		this.description = description;
	}

/**
A getter method that returns the ID of an item 
@return the items ID
@author Josh Brown
*/
	public int getItemId() {
		return itemId;
	}

/**
A setter method that sets the ID of an item 
@param itemId, the ID of an item 
@author Josh Brown
*/
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

/**
A getter method that returns the purchase price of an item 
@return the items purchase price
@author Josh Brown
*/
	public int getPurchasePrice() {
		return purchasePrice;
	}

/**
A setter method that sets the purchase price of an item 
@param purchasePrice, the purchase price of an item 
@author Josh Brown 
*/
	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

/**
A getter method that returns the sell price of an item 
@return the items sell price
@author Josh Brown
*/
	public int getSellPrice() {
		return sellPrice;
	}

/**
A setter method that sets the sell price of an item 
@param sellPrice, the selling price of an item 
@author Josh Brown
*/
	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}
	

	

}
