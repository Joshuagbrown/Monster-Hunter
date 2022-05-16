package main.controller;

import java.util.ArrayList;

import main.model.Monster;
import main.model.Player;
import main.view.MainScreen;
import main.view.SetupScreen;

public class GameEnvironment {

	private Player player;
	
	private int difficulty;
	private int totalDays;
	public int day;
	
	private ArrayList<Monster> party = new ArrayList<Monster>();
	
	public GameEnvironment() {
		this.player = new Player();
		this.party = new ArrayList<Monster>();
	}
	
	public boolean setupGame(String name, int days, Monster monster, int difficulty) {
		this.party.add(monster);
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

	public ArrayList<Monster> getParty() {
		return party;
	}

	public void setParty(ArrayList<Monster> party) {
		this.party = party;
	}
	

	
}


