package test.player;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.model.Player;

class SetupPlayerTest {
	
	@Test
	void playerNameTooShort() {
		Player player = new Player();
		boolean result = player.setup("J");
		assertFalse(result);
	}
	
	@Test
	void playerNameTooLong() {
		Player player = new Player();
		boolean result = player.setup("J".repeat(20));
		assertFalse(result);
	}

	@Test
	void playerNameMinLengthBoundary() {
		Player player = new Player();
		boolean result = player.setup("J".repeat(2));
		assertFalse(result);
	}
	
	@Test
	void playerNameMaxLengthBoundary() {
		Player player = new Player();
		boolean result = player.setup("J".repeat(16));
		assertFalse(result);
	}
	
	@Test
	void playerNameValidLength() {
		Player player = new Player();
		boolean result = player.setup("J".repeat(10));
		assertTrue(result);
	}
	
}
