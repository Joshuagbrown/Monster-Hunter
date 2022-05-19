package main.model;

public abstract class Monster {
	
	private String name;
	
	private int maxHealth;
	
	private int damage;
	
	private int healAmount;
	
	private int currentHealth;
	
	private int purchasePrice;
	
	private int sellPrice;

	public Monster(String name, int maxHealth, int damage, int healAmount, int purchasePrice, int sellPrice) {
		super();
		this.name = name;
		this.maxHealth = maxHealth;
		this.damage = damage;
		this.healAmount = healAmount;
		this.currentHealth = maxHealth;
		this.purchasePrice = purchasePrice;
		this.sellPrice = sellPrice;
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

	public void attack() {
		
	}
	
	public void useAbility() {
		
	}
	
	public void heal() {
		this.currentHealth = this.currentHealth + this.healAmount;
		if (this.currentHealth > this.maxHealth) {
			this.currentHealth = this.maxHealth;
		}
	}

	public String getName() {
		return name;
	}

	public boolean setName(String name) {
		if (name.length() < 3 || name.length() > 15) {
			return false;
		}
		this.name = name;
		return true;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealAmount() {
		return healAmount;
	}

	public void setHealAmount(int healAmount) {
		this.healAmount = healAmount;
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}

}
