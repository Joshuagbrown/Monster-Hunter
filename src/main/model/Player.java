package main.model;

public class Player {
	
	private String name;

	public String getName() {
		return name;
	}

	
	public boolean setup(String name) {
		
		if (name.length() < 3 || name.length() > 15)
			return false;
		this.name = name;
		
		return true;
	}
	
	
}
