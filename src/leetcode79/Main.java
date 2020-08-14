package leetcode79;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'} , 
				          {'S','F','C','S'} ,
				          {'A','D','E','E'}};
		
		String word = "SEEC";
		
		System.out.println("Board: " + Arrays.deepToString(board));
		
		CheckWordSearchMatrixFunction solution = new CheckWordSearchMatrixFunction();
		
		System.out.println("Is there word in board?: " + solution.exist(board, word));
	}
}
