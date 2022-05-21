package main.controller;

import java.util.ArrayList;
import java.util.Random;

import main.model.Dragon;
import main.model.Elf;
import main.model.Gremlin;
import main.model.Human;
import main.model.Monster;
import main.model.Orc;
import main.model.Party;
import main.model.Player;
import main.model.Wizard;
import main.view.MainScreen;
import main.view.SetupScreen;

public class GameEnvironment {

	private Player player;
	
	private int difficulty;
	private int totalDays;
	private int day = 1;
	
	private Party party;
	private Party enemyParty = new Party(new Gremlin());
	
	private String randomEventDesc = "";
	
	private boolean easyFightDone = false;
	private boolean normalFightDone = false;
	private boolean hardFightDone = false;
	
	public GameEnvironment() {
		this.player = new Player();
	}
	
	public boolean setupGame(String name, int days, Monster monster, int difficulty) {
		this.party = new Party(monster);
		this.difficulty = difficulty;
		this.totalDays = days;
		return player.setup(name);
	}
	
	public int getDay() {
		return this.day;
	}
	
	public int getTotalDays() {
		return this.totalDays;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}

	public boolean buyMonster(Monster m) {
		if (this.player.getGold() >= m.getPurchasePrice() && this.party.getSize() < 5) {
			this.player.setGold(this.player.getGold() - m.getPurchasePrice());
			this.party.addMonster(m);
			return true;
		}
		return false;
	}
	
	public boolean sellMonster(int index) {
		if (this.party.getSize() > index) {
			Monster m = this.getParty().getMonsterAtIndex(index);
			this.player.setGold(this.player.getGold() + m.getSellPrice());
			this.party.removeMonsterAtIndex(index);
			return true;
		}
		return false;
	}
	
	public void getEnemyMonsters(int battleChoice) {
		
		this.enemyParty.setPartyList(new ArrayList<Monster>());
		this.party.setCurrentFighterIndex(0);
		this.enemyParty.setCurrentFighterIndex(0);

		
		Random random = new Random();
		
		int randomSizeValue = random.nextInt(3) + this.day + battleChoice + this.difficulty;
		
		int enemyPartySize = 0;

		if (randomSizeValue < 5) {
			enemyPartySize += 1;
		} else if (randomSizeValue < 7) {
			enemyPartySize += 2;
		} else if (randomSizeValue < 9) {
			enemyPartySize += 3;
		} else if (randomSizeValue < 11) {
			enemyPartySize += 4;
		} else {
			enemyPartySize += 5;
		}
				
		for (int i = 0; i < enemyPartySize; i++) {
			int randomEnemyTypeValue = random.nextInt(6) + this.day + battleChoice + this.difficulty;
			if (randomEnemyTypeValue < 7) {
				enemyParty.addMonster(new Gremlin());
			} else if (randomEnemyTypeValue < 9) {
				enemyParty.addMonster(new Elf());
			} else if (randomEnemyTypeValue < 11) {
				enemyParty.addMonster(new Human());
			} else if (randomEnemyTypeValue < 13) {
				enemyParty.addMonster(new Orc());
			} else if (randomEnemyTypeValue < 15) {
				enemyParty.addMonster(new Wizard());
			} else {
				enemyParty.addMonster(new Dragon());
			}
		}
				
		
	}
	
	public boolean fight() {
		Monster playerFighter = this.party.getMonsterAtIndex(this.party.getCurrentFighterIndex());
		Monster enemyFighter = this.enemyParty.getMonsterAtIndex(this.enemyParty.getCurrentFighterIndex());
		
		playerFighter.setCurrentHealth(playerFighter.getCurrentHealth() - enemyFighter.getDamage());
		enemyFighter.setCurrentHealth(enemyFighter.getCurrentHealth() - playerFighter.getDamage());
		
		if (playerFighter.getCurrentHealth() <= 0) {
			playerFighter.setCurrentHealth(0);
			if (!this.party.incrementCurrentFighter()) {
				loseFight();
				return true;
			}
		}
		
		if (enemyFighter.getCurrentHealth() <= 0) {
			enemyFighter.setCurrentHealth(0);
			if (!this.enemyParty.incrementCurrentFighter()) {
				winFight();
				return true;
			}
		}
		return false;
		
	}
	
	public void loseFight() {
		
		//TODO - add some stuff here
		
		GameRunner.displayLoss();

	}
	
	public void winFight() {

		//TODO - add some stuff here
		
		this.player.setGold(this.player.getGold() + 100);
		
		GameRunner.displayWin();

	}
	
	public void healMonsters() {
		for (Monster m : this.party.getPartyList()) {
			m.setCurrentHealth(m.getCurrentHealth() + m.getHealAmount());
		}
	}
	
	public boolean endDay() {
		this.day++;
		if (this.getTotalDays() < this.day) {
			return true;
		}
		nightRandomEvent();
		healMonsters();
		this.easyFightDone = false;
		this.normalFightDone = false;
		this.hardFightDone = false;
		return false;
	}

	public boolean isEasyFightDone() {
		return easyFightDone;
	}

	public void setEasyFightDone(boolean easyFightDone) {
		this.easyFightDone = easyFightDone;
	}

	public boolean isNormalFightDone() {
		return normalFightDone;
	}

	public void setNormalFightDone(boolean normalFightDone) {
		this.normalFightDone = normalFightDone;
	}

	public boolean isHardFightDone() {
		return hardFightDone;
	}

	public void setHardFightDone(boolean hardFightDone) {
		this.hardFightDone = hardFightDone;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public void setDay(int day) {
		this.day = day;
	}

	private void nightRandomEvent() {
		Random random = new Random();
		
		int randomValue = random.nextInt(10 - this.difficulty);
		
		if (randomValue <= 2 ) {
			this.randomEventDesc = "";
			return;
		} else if (randomValue <= 3) {
			if (this.party.getSize() > 1) {
				monsterLeaves();
				return;
			}
		} else if (randomValue <= 4) {
			if (this.party.getSize() < 5) {
				monsterJoins();
				return;
			}
		} else {
			monsterLevels();
			return;
		}
	}
	
	
	public String getRandomEventDesc() {
		return randomEventDesc;
	}

	public void setRandomEventDesc(String randomEventDesc) {
		this.randomEventDesc = randomEventDesc;
	}

	public void monsterLeaves() {
		int lowestHealthIndex = this.party.getLowestHealthMonster();
		this.randomEventDesc = String.format("Monster %s left due to its injuries from the last battle", this.party.getMonsterAtIndex(lowestHealthIndex).getName());
		this.party.removeMonsterAtIndex(lowestHealthIndex);
	}
	
	public void monsterJoins() {
		Random random = new Random();
		int randomValue = random.nextInt(60);
		if (randomValue < 3) {
			this.party.addMonster(new Dragon());
			this.randomEventDesc = "A Dragon joined your party overnight!";
		} else if (randomValue <10) {
			this.party.addMonster(new Wizard());
			this.randomEventDesc = "A Wizard joined your party overnight!";
		} else if (randomValue < 20) {
			this.party.addMonster(new Orc());
			this.randomEventDesc = "An Orc joined your party overnight!";
		} else if (randomValue < 30) {
			this.party.addMonster(new Elf());
			this.randomEventDesc = "An Elf joined your party overnight!";
		} else {
			this.party.addMonster(new Gremlin());
			this.randomEventDesc = "A Gremlin joined your party overnight!";
		}
	}
	
	public void monsterLevels() {
		this.randomEventDesc = String.format("Your Oldest Monster %s Leveled Up! Stats have increased", this.party.getMonsterAtIndex(0).getName());
		this.party.getMonsterAtIndex(0).setMaxHealth((int)(this.party.getMonsterAtIndex(0).getMaxHealth() * 1.5));
		this.party.getMonsterAtIndex(0).setDamage((int)(this.party.getMonsterAtIndex(0).getDamage() * 1.5));;
		this.party.getMonsterAtIndex(0).setHealAmount((int)(this.party.getMonsterAtIndex(0).getHealAmount() * 1.5));;
	}
	

	public Party getEnemyParty() {
		return enemyParty;
	}

	public void setEnemyParty(Party enemyParty) {
		this.enemyParty = enemyParty;
	}

	

	
}


