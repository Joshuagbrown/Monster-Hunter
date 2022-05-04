package main.controller;

import java.util.ArrayList;

import main.model.Monster;
import main.model.Player;
import main.view.SetupScreen;

public class GameEnvironment {

	private Player player;
	
	private ArrayList<Monster> party = new ArrayList<Monster>();
	
	public GameEnvironment() {
		this.player = new Player();
		this.party = new ArrayList<Monster>();
	}
	
	public boolean setupPlayer(String name) {
		return player.setup(name);
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


