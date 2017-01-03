package ChessGame;

//Chess by Ben Kassman

import java.awt.Color;

public class Bishop extends Piece {
	private Color Move = new Color(214, 180, 130);

	// Draw bishop
	public Bishop(int x, int y, Color color) {
		if (color.equals(StdDraw.WHITE)) {
			StdDraw.picture(x + .5, y + .5, "Chess" + java.io.File.separator
					+ "WhiteBishop.png", .5, .6);
		}
		if (color.equals(StdDraw.BLACK)) {
			StdDraw.picture(x + .5, y + .5, "Chess" + java.io.File.separator
					+ "BlackBishop.png", .5, .6);
		}
	}

	// Show all possible moves
	public int possibleMoves(int i, int x, int y, int[][] board) {
		int canMove = 0;
		if (i == 13) {
			StdDraw.setPenColor(Move);
			for (int j = 1; j < 8; j++) {
				if ((x + j < 8 && y + j < 8) && board[x + j][y + j] > 3) {
					canMove = canMove
							+ possibleAttacks(x + j, y + j, board,
									StdDraw.BLACK);
					break;
				}
				if ((x + j < 8 && y + j < 8) && board[x + j][y + j] < 3) {
					StdDraw.filledRectangle(x + j + .5, y + .5 + j, .5, .5);
					board[x + j][y + j] = 00;
					canMove++;
				}

			}
			for (int j = 1; j < 8; j++) {
				if ((x - j >= 0 && y - j >= 0) && board[x - j][y - j] > 3) {
					canMove = canMove
							+ possibleAttacks(x - j, y - j, board,
									StdDraw.BLACK);
					break;
				}
				if ((x - j >= 0 && y - j >= 0) && board[x - j][y - j] < 3) {
					StdDraw.filledRectangle(x - j + .5, y + .5 - j, .5, .5);
					board[x - j][y - j] = 0;
					canMove++;
				}

			}
			for (int j = 1; j < 8; j++) {
				if ((x + j < 8 && y - j >= 0) && board[x + j][y - j] > 3) {
					canMove = canMove
							+ possibleAttacks(x + j, y - j, board,
									StdDraw.BLACK);
					break;
				}
				if ((x + j < 8 && y - j >= 0) && board[x + j][y - j] < 3) {
					StdDraw.filledRectangle(x + j + .5, y + .5 - j, .5, .5);
					board[x + j][y - j] = 0;
					canMove++;
				}

			}
			for (int j = 1; j < 8; j++) {
				if ((x - j >= 0 && y + j < 8) && board[x - j][y + j] > 3) {
					canMove = canMove
							+ possibleAttacks(x - j, y + j, board,
									StdDraw.BLACK);
					break;
				}
				if ((x - j >= 0 && y + j < 8) && board[x - j][y + j] < 3) {
					StdDraw.filledRectangle(x - j + .5, y + .5 + j, .5, .5);
					board[x - j][y + j] = 0;
					canMove++;
				}

			}
			StdDraw.show(30);
			return canMove;
		}

		if (i == 23) {
			StdDraw.setPenColor(Move);
			for (int j = 1; j < 8; j++) {
				if ((x + j < 8 && y + j < 8) && board[x + j][y + j] > 3) {
					canMove = canMove
							+ possibleAttacks(x + j, y + j, board,
									StdDraw.WHITE);
					break;
				}
				if ((x + j < 8 && y + j < 8) && board[x + j][y + j] < 3) {
					StdDraw.filledRectangle(x + j + .5, y + .5 + j, .5, .5);
					board[x + j][y + j] = 00;
					canMove++;
				}

			}
			for (int j = 1; j < 8; j++) {
				if ((x - j >= 0 && y - j >= 0) && board[x - j][y - j] > 3) {
					canMove = canMove
							+ possibleAttacks(x - j, y - j, board,
									StdDraw.WHITE);
					break;
				}
				if ((x - j >= 0 && y - j >= 0) && board[x - j][y - j] < 3) {
					StdDraw.filledRectangle(x - j + .5, y + .5 - j, .5, .5);
					board[x - j][y - j] = 0;
					canMove++;
				}

			}
			for (int j = 1; j < 8; j++) {
				if ((x + j < 8 && y - j >= 0) && board[x + j][y - j] > 3) {
					canMove = canMove
							+ possibleAttacks(x + j, y - j, board,
									StdDraw.WHITE);
					break;
				}
				if ((x + j < 8 && y - j >= 0) && board[x + j][y - j] < 3) {
					StdDraw.filledRectangle(x + j + .5, y + .5 - j, .5, .5);
					board[x + j][y - j] = 0;
					canMove++;
				}

			}
			for (int j = 1; j < 8; j++) {
				if ((x - j >= 0 && y + j < 8) && board[x - j][y + j] > 3) {
					canMove = canMove
							+ possibleAttacks(x - j, y + j, board,
									StdDraw.WHITE);
					break;
				}
				if ((x - j >= 0 && y + j < 8) && board[x - j][y + j] < 3) {
					StdDraw.filledRectangle(x - j + .5, y + .5 + j, .5, .5);
					board[x - j][y + j] = 0;
					canMove++;
				}

			}
			StdDraw.show(30);
			return canMove;
		}
		return canMove;
	}

	public int[][] canMove(int i, int x, int y, int[][] board,
			int[][] canWhiteMove, int[][] canBlackMove) {
		int[][] canMove = new int[8][8];
		if (i == 13) {
			for (int j = 1; j < 8; j++) {
				if ((x + j < 8 && y + j < 8) && board[x + j][y + j] > 3) {
					canWhiteMove[x + j][y + j] = canWhiteMove[x + j][y + j]
							+ canAttack(x + j, y + j, board, StdDraw.BLACK);
					break;
				}
				if ((x + j < 8 && y + j < 8) && board[x + j][y + j] < 3) {
					canWhiteMove[x + j][y + j]++;
				}

			}
			for (int j = 1; j < 8; j++) {
				if ((x - j >= 0 && y - j >= 0) && board[x - j][y - j] > 3) {
					canWhiteMove[x - j][y - j] = canWhiteMove[x - j][y - j]
							+ canAttack(x - j, y - j, board, StdDraw.BLACK);
					break;
				}
				if ((x - j >= 0 && y - j >= 0) && board[x - j][y - j] < 3) {
					canWhiteMove[x - j][y - j]++;
				}

			}
			for (int j = 1; j < 8; j++) {
				if ((x + j < 8 && y - j >= 0) && board[x + j][y - j] > 3) {
					canWhiteMove[x + j][y - j] = canWhiteMove[x + j][y - j]
							+ canAttack(x + j, y - j, board, StdDraw.BLACK);
					break;
				}
				if ((x + j < 8 && y - j >= 0) && board[x + j][y - j] < 3) {
					canWhiteMove[x + j][y - j]++;
				}

			}
			for (int j = 1; j < 8; j++) {
				if ((x - j >= 0 && y + j < 8) && board[x - j][y + j] > 3) {
					canWhiteMove[x - j][y + j] = canWhiteMove[x - j][y + j]
							+ canAttack(x - j, y + j, board, StdDraw.BLACK);
					break;
				}
				if ((x - j >= 0 && y + j < 8) && board[x - j][y + j] < 3) {
					canWhiteMove[x - j][y + j]++;
				}

			}
			return canWhiteMove;
		}

		if (i == 23) {

			for (int j = 1; j < 8; j++) {
				if ((x + j < 8 && y + j < 8) && board[x + j][y + j] > 3) {
					canBlackMove[x + j][y + j] = canBlackMove[x + j][y + j]
							+ canAttack(x + j, y + j, board, StdDraw.WHITE);
					break;
				}
				if ((x + j < 8 && y + j < 8) && board[x + j][y + j] < 3) {
					canBlackMove[x + j][y + j]++;
				}

			}
			for (int j = 1; j < 8; j++) {
				if ((x - j >= 0 && y - j >= 0) && board[x - j][y - j] > 3) {
					canBlackMove[x - j][y - j] = canBlackMove[x - j][y - j]
							+ canAttack(x - j, y - j, board, StdDraw.WHITE);
					break;
				}
				if ((x - j >= 0 && y - j >= 0) && board[x - j][y - j] < 3) {
					canBlackMove[x - j][y - j]++;
				}

			}
			for (int j = 1; j < 8; j++) {
				if ((x + j < 8 && y - j >= 0) && board[x + j][y - j] > 3) {
					canBlackMove[x + j][y - j] = canBlackMove[x + j][y - j]
							+ canAttack(x + j, y - j, board, StdDraw.WHITE);
					break;
				}
				if ((x + j < 8 && y - j >= 0) && board[x + j][y - j] < 3) {
					canBlackMove[x + j][y - j]++;
				}

			}
			for (int j = 1; j < 8; j++) {
				if ((x - j >= 0 && y + j < 8) && board[x - j][y + j] > 3) {
					canBlackMove[x - j][y + j] = canBlackMove[x - j][y + j]
							+ canAttack(x - j, y + j, board, StdDraw.WHITE);
					break;
				}
				if ((x - j >= 0 && y + j < 8) && board[x - j][y + j] < 3) {
					canBlackMove[x - j][y + j]++;
				}

			}
			return canBlackMove;
		}
		return canMove;
	}

}
