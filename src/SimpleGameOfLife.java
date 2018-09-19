
/**
 * Description: A demo to show the way the Game of life can be implemented with
 * just the print statement. The board displays a glider that crosses the board.
 * 
 * Author Perry Davies
 */

public class SimpleGameOfLife {

	// Board contains points for glider in game of life
	int board[][] = { 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
			{ 0, 1, 0, 1, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

	public SimpleGameOfLife(boolean run) {
		if (run)
			runGame();
	}

	// Packaged access so we can test it in JUnit
	int runGame() {
		// number of iterations to show the glider moving
		int count = 20;
		do {
			displayBoard();
			board = NewGenaration().clone();
		} while (--count > 0);
		return count;
	}

	// Packaged access so we can test it in JUnit
	void displayBoard() {
		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 10; col++) {
				if (board[row][col] == 0) {
					System.out.print(".");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}

	int[][] NewGenaration() {
		// moving across the board.
		int newgrid[][] = new int[10][10];
		for (int row = 1; row < 10 - 1; row++) {
			for (int col = 1; col < 10 - 1; col++) {
				int sum = 0;
				for (int r = -1; r <= 1; r++) {
					for (int c = -1; c <= 1; c++) {
						sum += board[row + r][col + c];
					}
				}
				sum -= board[row][col];
				// State alive == 1, 0 is dead
				int state = board[row][col];
				if (state == 1 && sum < 2) {
					newgrid[row][col] = 0;
				} else if (state == 1 && sum > 3) {
					newgrid[row][col] = 0;
				} else if (state == 0 && sum == 3) {
					newgrid[row][col] = 1;
				} else {
					newgrid[row][col] = board[row][col];
				}

			}

		}
		return newgrid;
	}

	public static void main(String[] args) {
		new SimpleGameOfLife(true);

	}

}
