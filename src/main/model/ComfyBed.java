package main.model;
/**
Class for the item option of a comfy bed, it extends the item class as is a specific intance of an item 
@author Josh Brown
*/
public class ComfyBed extends Item{

/**
Method holds all the specific characteristics of a Comfy Bed
@author Josh Brown
*/
	public ComfyBed() {
		//String description, int itemId, int purchasePrice, int sellPrice
		super("Comfy Bed", "Monster will heal 50% more overnight", 2, 300, 150);
	}
	

}
