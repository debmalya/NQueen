package org.deb.queens;

public interface Queens {
	boolean solve(int[][] board, int col);

	void placeQueen(int[][] board, int row, int col);

	void removeQueen(int[][] board, int row, int col);

	boolean isRowClear(int[][] board, int queenRow, int queenCol);

	boolean isUpperDiagClear(int[][] board, int queenRow, int queenCol);

	boolean isLowerDiagClear(int[][] board, int queenRow, int queenCol);

	boolean isSafe(int[][] board, int row, int col);

	void clearBoard(int[][] board);

}

