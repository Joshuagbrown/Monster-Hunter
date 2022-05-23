package test.monster;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.controller.GameEnvironment;
import main.model.Elf;
import main.model.Orc;

class BuyAndSellMonsterTest {

	@Test
	void buyMonsterTooLittleGold() {
		GameEnvironment gameEnvironment = new GameEnvironment();
		gameEnvironment.getPlayer().setGold(0);
		boolean result = gameEnvironment.buyMonster(new Orc());
		assertFalse(result);
	}
	
	@Test
	void buyMonsterEnoughGold() {
		GameEnvironment gameEnvironment = new GameEnvironment();
		gameEnvironment.setupGame("aaa", 5, new Elf(), 0);
		gameEnvironment.getPlayer().setGold(1000);
		boolean result = gameEnvironment.buyMonster(new Orc());
		assertTrue(result);		
	}
	
	@Test
	void buyMonsterPartyFull() {
		GameEnvironment gameEnvironment = new GameEnvironment();
		gameEnvironment.setupGame("aaa", 5, new Elf(), 0);
		gameEnvironment.getPlayer().setGold(1000);
		gameEnvironment.getParty().addMonster(new Orc());
		gameEnvironment.getParty().addMonster(new Orc());
		gameEnvironment.getParty().addMonster(new Orc());
		gameEnvironment.getParty().addMonster(new Orc());
		boolean result = gameEnvironment.buyMonster(new Orc());
		assertFalse(result);			
	}
	
	@Test
	void sellMonsterPartyTooSmall() {
		GameEnvironment gameEnvironment = new GameEnvironment();
		gameEnvironment.setupGame("aaa", 5, new Elf(), 0);
		boolean result = gameEnvironment.sellMonster(0);
		assertFalse(result);
	}
	
	@Test 
	void sellMonsterNormalSizeParty(){
		GameEnvironment gameEnvironment = new GameEnvironment();
		gameEnvironment.setupGame("aaa", 5, new Elf(), 0);
		gameEnvironment.getParty().addMonster(new Elf());
		boolean result = gameEnvironment.sellMonster(0);
		assertTrue(result);
	}

}
