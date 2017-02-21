package bbc.codingtests.gameoflife;

import bbc.codingtests.gameoflife.gamestate.GameState;
import bbc.codingtests.gameoflife.gamestate.GameStateImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class LifeTest {

	//TODO make this test pass
	@Test
	public void testEmptyGrid() {
		String emptyStateInput = "...\n...\n...";

		Life testLife = new LifeImpl();
		GameState emptyState = new GameStateImpl(emptyStateInput);
		assertEquals("An empty grid should stay the same", emptyStateInput, testLife.evolve(emptyState).toString());
	}

	//TODO implement further tests for the other cases in the instructions
	@Test
	public void testValidGrid() {
		String newStateInput = "...\n***\n...";

		Life testLife = new LifeImpl();
		GameState newState = new GameStateImpl(newStateInput);
		assertEquals("This grid should be valid", ".*.\n.*.\n.*.", testLife.evolve(newState).toString());
	}
	@Test
	public void testBlockedGrid() {
		String blockedStateInput = "....\n.**.\n.**.\n....";

		Life testLife = new LifeImpl();
		GameState blockedState = new GameStateImpl(blockedStateInput);
		assertEquals("This grid should be blocked", "....\n.**.\n.**.\n....", testLife.evolve(blockedState).toString());
	}
	@Test
	public void testBeehiveGrid() {
		String beehiveStateInput = "......\n..**..\n.*..*.\n..**..\n......";

		Life testLife = new LifeImpl();
		GameState beehiveState = new GameStateImpl(beehiveStateInput);
		assertEquals("This grid should be beehive", "......\n..**..\n.*..*.\n..**..\n......", testLife.evolve(beehiveState).toString());
	}
	@Test
	public void testLoafGrid() {
		String loafStateInput = "......\n..**..\n.*..*.\n..*.*.\n...*..\n......";

		Life testLife = new LifeImpl();
		GameState loafState = new GameStateImpl(loafStateInput);
		assertEquals("This grid should be loaf", "......\n..**..\n.*..*.\n..*.*.\n...*..\n......", testLife.evolve(loafState).toString());
	}
	@Test
	public void testToadGrid() {
		String toadStateInput = "......\n......\n..***.\n.***..\n......\n......";

		Life testLife = new LifeImpl();
		GameState toadState = new GameStateImpl(toadStateInput);
		assertEquals("This grid should be toad", "......\n...*..\n.*..*.\n.*..*.\n..*...\n......", testLife.evolve(toadState).toString());
	}
	
	
}
