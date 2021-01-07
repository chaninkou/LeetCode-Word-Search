package leetcode79;

public class CheckWordSearchMatrixFunction {
	public boolean exist(char[][] board, String word) {
		if (board.length == 0 || board == null) {
			return false;
		}

		// Go through the grid
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				// Search 4 direction whenever we see the first letter
				if (board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)) {
					return true;
				}
			}
		}

		// This means we couldn't find letters that are adjacent
		return false;
	}

	public boolean dfs(char[][] board, int i, int j, int count, String word) {
		// word.length() since the length will only if exact if all the if statement below passed
		if (count == word.length()) {
			return true;
		}

		// Once current word does not match, false
		if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(count)) {
			return false;
		}

		// Temp
		char temp = board[i][j];
		
		// Mark as visited 
		board[i][j] = ' ';

		// i + 1 check the cell below
		// i - 1 check the ceil above
		// j + 1 check the ceil to the right
		// j - 1 check the ceil to the left
		// If one of them return true, this variable will become true right away
		boolean found = dfs(board, i + 1, j, count + 1, word) || dfs(board, i - 1, j, count + 1, word)
				|| dfs(board, i, j + 1, count + 1, word) || dfs(board, i, j - 1, count + 1, word);

		// Found or not found, replace the character with the original
		board[i][j] = temp;

		return found;
	}
}
