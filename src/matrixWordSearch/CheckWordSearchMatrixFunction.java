package matrixWordSearch;

public class CheckWordSearchMatrixFunction {
	 public boolean exist(char[][] board, String word) {
	        // Go through the grid
	        for(int i = 0; i < board.length; i++){
	            for(int j = 0; j < board[i].length; j++){
	                // If we get the first letter of the word
	                // And if we could find the reminder of the word by dfs
	                // Pass in the board, row currently on, column currently on, 
	                // how many time it appear which is 0 cause first letter is the same, and the word
	                if(board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)){
	                    return true;
	                }
	            }
	        }
	        
	        // This means we couldn't find letters that are adjacent
	        return false;
	    }
	    
	    public boolean dfs(char[][] board, int i, int j, int count, String word){
	        // If we find the reminder of the word, the count will be the same as word.length
	        if(count == word.length()){
	            return true;
	        }
	        
	        // If we checking outside the grid, return false
	        // i < 0 going out of bound above the board, >= board.length going out of bound below
	        // j < 0 going out of bound to the left, >= board.length going out of bound to the right
	        // board[i][j] != word.charAt(count), if the cell we are on is not equal to the character we trying to look
	        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(count)){
	            return false;
	        }
	        
	        // The same letter cell may not be used more than once,
	        // Mark the current cell with the empty space, and remember what the value is to add it back later
	        char temp = board[i][j];
	        board[i][j] = ' ';
	        
	        // i + 1 check the cell below
	        // i - 1 check the ceil above
	        // j + 1 check the ceil to the right
	        // j - 1 check the ceil to the left
	        boolean found = dfs(board, i + 1, j, count + 1, word) 
	            || dfs(board, i - 1, j, count + 1, word)  
	            || dfs(board, i, j + 1, count + 1, word) 
	            || dfs(board, i, j - 1, count + 1, word);
	        
	        // Put the used value back in the grid instead of empty string
	        board[i][j] = temp;
	        
	        return found;
	    }
}
