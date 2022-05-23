package test.item;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.controller.GameEnvironment;
import main.model.Elf;
import main.model.HealthPotion;

class BuyAndSellItemTest {

	@Test
	void buyItemTooLittleGold() {
		GameEnvironment gameEnvironment = new GameEnvironment();
		gameEnvironment.getPlayer().setGold(0);
		boolean result = gameEnvironment.buyItem(new HealthPotion());
		assertFalse(result);
	}
	
	@Test
	void buyItemEnoughGold() {
		GameEnvironment gameEnvironment = new GameEnvironment();
		gameEnvironment.setupGame("aaa", 5, new Elf(), 0);
		gameEnvironment.getPlayer().setGold(1000);
		boolean result = gameEnvironment.buyItem(new HealthPotion());
		assertTrue(result);		
	}
	
	@Test
	void buyItemInventoryFull() {
		GameEnvironment gameEnvironment = new GameEnvironment();
		gameEnvironment.setupGame("aaa", 5, new Elf(), 0);
		gameEnvironment.getPlayer().setGold(1000);
		gameEnvironment.getInventory().addItem(new HealthPotion());
		gameEnvironment.getInventory().addItem(new HealthPotion());
		gameEnvironment.getInventory().addItem(new HealthPotion());
		gameEnvironment.getInventory().addItem(new HealthPotion());
		gameEnvironment.getInventory().addItem(new HealthPotion());
		gameEnvironment.getInventory().addItem(new HealthPotion());
		boolean result = gameEnvironment.buyItem(new HealthPotion());
		assertFalse(result);			
	}
	
	@Test
	void sellItemNoItem() {
		GameEnvironment gameEnvironment = new GameEnvironment();
		gameEnvironment.setupGame("aaa", 5, new Elf(), 0);
		boolean result = gameEnvironment.sellItem(0);
		assertFalse(result);
	}
	
	@Test 
	void sellItemNormalSizeInventory(){
		GameEnvironment gameEnvironment = new GameEnvironment();
		gameEnvironment.setupGame("aaa", 5, new Elf(), 0);
		gameEnvironment.getInventory().addItem(new HealthPotion());
		boolean result = gameEnvironment.sellItem(0);
		assertTrue(result);
	}

}
