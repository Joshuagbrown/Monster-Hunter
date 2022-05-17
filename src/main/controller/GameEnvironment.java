package main.controller;

import java.util.ArrayList;

import main.model.Monster;
import main.model.Party;
import main.model.Player;
import main.view.MainScreen;
import main.view.SetupScreen;

public class GameEnvironment {

	private Player player;
	
	private int difficulty;
	private int totalDays;
	private int day;
	
	private Party party;
	
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

	public boolean canBuy(int cost) {
		if (this.player.getGold() >= cost && this.party.getSize() < 5) {
			this.player.setGold(this.player.getGold() - cost);
			return true;
		}
		return false;
	}
	
	public boolean canSell() {
		if (this.party.getSize() > 1) {
			
		}
		return false;
		
	}

	

	
}


