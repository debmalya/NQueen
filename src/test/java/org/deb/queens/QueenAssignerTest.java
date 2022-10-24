package org.deb.queens;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueenAssignerTest {

	QueenAssigner queenAssigner = new QueenAssigner();

	int[][] board = null;

	@BeforeEach
	void setBoard() {
		board = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 } };
	}

	@Test
	void testSolve() {
		assertTrue(queenAssigner.solve(board, 0));
		assertFalse(queenAssigner.solve(board, 1));
	}

	@Test
	void testSolveWithOneQueen() {

		board = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1 } };
		assertTrue(queenAssigner.solve(board, 0));
		printBoard(board);
	}

	@Test
	void testPlaceQueen() {
		queenAssigner.placeQueen(board, 0, 0);
		assertEquals(1, board[0][0]);
	}

	@Test
	void testRemoveQueen() {
		queenAssigner.placeQueen(board, 0, 0);
		assertEquals(1, board[0][0]);
		queenAssigner.removeQueen(board, 0, 0);
		assertEquals(0, board[0][0]);
	}

	@Test
	void testIsRowClear() {
		assertTrue(queenAssigner.isRowClear(board, 0, 0));
	}

	@Test
	void testIsUpperDiagClear() {
		assertTrue(queenAssigner.isUpperDiagClear(board, 3, 3));
		board = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1 } };
		assertFalse(queenAssigner.isUpperDiagClear(board, 0, 0));
	}

	@Test
	void testIsLowerDiagClear() {
		assertTrue(queenAssigner.isLowerDiagClear(board, 3, 3));
		board = new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1 } };
		assertTrue(queenAssigner.isLowerDiagClear(board, 0, 0));
	}

	@Test
	void testIsSafe() {
		assertTrue(queenAssigner.isSafe(board, 0, 0));
	}

	@Test
	void testClearBoard() {
		board = new int[][] { { 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1 } };
		queenAssigner.clearBoard(board);
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board.length; col++) {
				assertEquals(0, board[row][col]);
			}
		}
	}

	private void printBoard(int[][] board) {
		for (int[] eachRow : board) {
			System.out.println(Arrays.toString(eachRow));
		}
	}

}
