package main.model;

import java.util.ArrayList;

public class Party {
	
	private ArrayList<Monster> partyList;
	
	public Party(Monster monster) {
		ArrayList<Monster> partyList = new ArrayList<Monster>();
		partyList.add(monster);
		this.partyList = partyList;
	}
	

	public ArrayList<Monster> getPartyList() {
		return partyList;
	}

	public void setPartyList(ArrayList<Monster> partyList) {
		this.partyList = partyList;
	}

	public String getName(int i) {
		if (i < this.partyList.size()) {
			return this.partyList.get(i).getName();
		} else {
			return "Empty Slot";
		}
	}
	
	public String getHealth(int i) {
		if (i < this.partyList.size()) {
			return Integer.toString(this.partyList.get(i).getCurrentHealth());
		} else {
			return "";
		}
	}
	
	public String getDamage(int i) {
		if (i < this.partyList.size()) {
			return Integer.toString(this.partyList.get(i).getDamage());
		} else {
			return "";
		}
	}
	
	public String getHeal(int i) {
		if (i < this.partyList.size()) {
			return Integer.toString(this.partyList.get(i).getHealAmount());
		} else {
			return "";
		}
	}

	public void addMonster(Monster m) {
		this.getPartyList().add(m);
	}
	
	public Monster getMonsterAtIndex(int index) {
		return this.partyList.get(index);
	}
	
	public void removeMonsterAtIndex(int index) {
		this.partyList.remove(index);
	}
	
	public int getSize() {
		return this.partyList.size();
	}
}
