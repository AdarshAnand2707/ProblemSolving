package backTrackingAndRecurssion;

public class SodokuSolver {

	public static void solveSodoku(int[][] board) {
		if (board == null || board.length == 0) {
			return;
		}
		BoardChecker checker =  new BoardChecker(board);
		boolean isSuccess = solveSodoku(board, 0, 0, checker);
		if (!isSuccess) {
			throw new IllegalArgumentException("Board has no solution");
		}
	}
	
	public static boolean solveSodoku(int[][] board, int i, int j, BoardChecker checker) {
		if(i == board.length) {
			return true;
		}
		int nextI = j == 8 ? i+1: i;
		int nextJ = j == 8 ? 0: j+1;
		if (board[i][j] != 0) {
			return solveSodoku(board, nextI, nextJ, checker);
		}
		for(int candidate = 1; candidate <=9; candidate++) {
			if(checker.canPlace(i, j, candidate)) {
				checker.place(i, j, candidate);
				board[i][j] = candidate;
				if (solveSodoku(board, nextI, nextJ, checker)) {
					return true;
				}
				checker.remove(i, j, candidate);
				board[i][j] = 0;
			}
		}
		return false;
	}
		
	public static void main(String[] args) {
		int[][] board = {
	            {3, 0, 6, 5, 0, 8, 4, 0, 0},
	            {5, 2, 0, 0, 0, 0, 0, 0, 0},
	            {0, 8, 7, 0, 0, 0, 0, 3, 1},
	            {0, 0, 3, 0, 1, 0, 0, 8, 0},
	            {9, 0, 0, 8, 6, 3, 0, 0, 5},
	            {0, 5, 0, 0, 9, 0, 6, 0, 0},
	            {1, 3, 0, 0, 0, 0, 2, 5, 0},
	            {0, 0, 0, 0, 0, 0, 0, 7, 4},
	            {0, 0, 5, 2, 0, 6, 3, 0, 0}
	        };
		solveSodoku(board);
		for(int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	
	public static class BoardChecker {
		boolean[][] rows;
		boolean[][] columns;
		boolean[][] boxes;
		
		
		public BoardChecker(int[][] board) {
			rows = new boolean[board.length][board.length+1];
			columns = new boolean[board.length][board.length+1];
			boxes = new boolean[board.length][board.length+1];
			for (int i =0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					place(i , j, board[i][j]);
				}
			}
		}
		
		public boolean place (int i, int j, int number) {
			 if (!canPlace(i, j, number)) {
				 return false;
			 }
			 rows[i][number] = true;
			 columns[j][number] = true;
			 boxes[boxNumber(i, j)][number] = true;
			 return true;
		}
		
		public void remove (int i, int j, int number) {
			 rows[i][number] = false;
			 columns[j][number] = false;
			 boxes[boxNumber(i, j)][number] = false;
		}
		
		public boolean canPlace (int i, int j, int number) {
			if (rows[i][number]) {
				return false;
			}
			if (columns[j][number]) {
				return false;
			}
			if (boxes[boxNumber(i, j)][number]) {
				return false;
			}
			return true;
		}
		
		public int boxNumber (int i , int j) {
			return (i/3*3)+(j/3);
		}
	}
}
