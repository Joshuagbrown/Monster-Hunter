package main.model;

/***
*The class for all the different types of items you can buy to assist you in gameplay
*@author Josh Brown
*/
public abstract class Item {
	
	private String name;
	
	private String description;
	
	private int itemId;

	private int purchasePrice;
	
	private int sellPrice;
	
	public Item(String name, String description, int itemId, int purchasePrice, int sellPrice) {
		super();
		this.name = name;
		this.description = description;
		this.itemId = itemId;
		this.purchasePrice = purchasePrice;
		this.sellPrice = sellPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public int getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(int sellPrice) {
		this.sellPrice = sellPrice;
	}
	

	

}
