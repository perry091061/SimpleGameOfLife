import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 *
 * @author Perry Davies
 *
 * Description : 3 tests are involved:
 * 1. To test the board displays and the glider
 * 2. To test the game loop count
 * 3. To test the start parameter for the game loop
 *
 */


class TestGameOfLife {
	// Test 1
	@Test
	void testDisplayBoardAndGlider() {
		// Initial test of game of life:
		// 1. Displays initial setup of board and glider

		SimpleGameOfLife game = new SimpleGameOfLife(false);
		assertNotNull(game);
		game.displayBoard();
	}

	// Test 2
	@Test
	void testGameLoop() {
		// Initial test of game loop, the loop counts down from
		// 20 to 0. So the expected return value should be 0.

		SimpleGameOfLife game = new SimpleGameOfLife(false);
		assertNotNull(game);
		assertEquals(game.runGame(),0);
	}

	// Test 3
	@Test
	void testGameOfLife() {
		// Initial test of parameter to game of life:
		// 1. Should display life cycle i.e. glider moving across
		//    the board .

		assertNotNull(new SimpleGameOfLife(true));

	}

}
