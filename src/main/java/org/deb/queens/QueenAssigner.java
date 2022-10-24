package org.deb.queens;

public class QueenAssigner implements Queens {

	/**
	 * Function: Solve --------------- This function is the main entry in solving
	 * the N queens problem. It takes the partially filled board and the column we
	 * are trying to place queen in. It will return a boolean value which indicates
	 * whether or not we found a successful arrangement starting from this
	 * configuration.
	 *
	 * Base case: if there are no more queens to place, we have succeeded!
	 *
	 * Otherwise, we find a safe row in this column, place a queen at (row,col)
	 * recursively call Solve starting at the next column using this new board
	 * configuration. If that Solve call fails, we remove that queen from (row,col)
	 * and try again with the next safe row within the column. If we have tried all
	 * rows in this column and haven't found a solution, we return false from this
	 * invocation, which will force backtracking from this unsolvable configuration.
	 *
	 * The starting call to Solve has an empty board and places a queen in col 0:
	 * Solve(board, 0);
	 */
	@Override
	public boolean solve(int[][] board, int col) {
		if (col >= board.length) {
			return true;
		}

		for (int rowToTry = 0; rowToTry < board.length; rowToTry++) {
			if (isSafe(board, rowToTry, col)) {
				placeQueen(board, rowToTry, col);
				if (solve(board, col + 1)) {
					return true;
				}
				removeQueen(board, rowToTry, col);
			}
		}
		return false;
	}

	@Override
	public void placeQueen(int[][] board, int row, int col) {
		board[row][col] = 1;

	}

	@Override
	public void removeQueen(int[][] board, int row, int col) {
		board[row][col] = 0;

	}

	@Override
	public boolean isRowClear(int[][] board, int queenRow, int queenCol) {
		for (int col = 0; col < queenCol; col++) {
			if (board[queenRow][col] == 1) {
				return false;
			}

		}
		return true;
	}

	@Override
	public boolean isUpperDiagClear(int[][] board, int queenRow, int queenCol) {
		int row, col;
		for (row = queenRow, col = queenCol; col < board.length && row < board.length; row++, col++) {
			if (board[row][col] == 1) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isLowerDiagClear(int[][] board, int queenRow, int queenCol) {
		int row, col;
		for (row = queenRow, col = queenCol; col >= 0 && row >= 0; row--, col--) {
			if (board[row][col] == 1) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isSafe(int[][] board, int row, int col) {
		return isLowerDiagClear(board, row, col) && isRowClear(board, row, col) && isUpperDiagClear(board, row, col);
	}

	@Override
	public void clearBoard(int[][] board) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board.length; col++) {
				board[row][col] = 0;
			}
		}

	}

}
