package main.model;

public class Player {
	
	private String name;
	private int gold;

	public String getName() {
		return name;
	}

	public boolean setup(String name) {
		
		if (name.length() < 3 || name.length() > 15)
			return false;
		this.name = name;
		this.gold = 10000;
		
		return true;
	}

	public int getGold() {
		return this.gold;
	}
	
	public void setGold(int gold) {
		this.gold = gold;
	}
	
	
}
