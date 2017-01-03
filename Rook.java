package ChessGame;

//Chess by Ben Kassman

import java.awt.Color;
import java.util.Arrays;

public class Rook extends Piece {
	private Color Move = new Color(214, 180, 130);

	// Draw rook
	public Rook(int x, int y, Color color) {
		if (color.equals(StdDraw.WHITE)) {
			StdDraw.picture(x + .5, y + .5, "Chess" + java.io.File.separator
					+ "WhiteRook.png", .5, .6);
		}
		if (color.equals(StdDraw.BLACK)) {
			StdDraw.picture(x + .5, y + .5, "Chess" + java.io.File.separator
					+ "BlackRook.png", .5, .6);
		}
	}

	// Check all possible moves
	public int possibleMoves(int i, int x, int y, int[][] board) {
		int canMove = 0;
		if (i == 14) {
			for (int j = 1; j + y < 8; j++) {
				if (board[x][y + j] > 3) {
					canMove = canMove
							+ possibleAttacks(x, y + j, board, StdDraw.BLACK);
					break;
				}
				if (board[x][y + j] < 3) {
					StdDraw.setPenColor(Move);
					StdDraw.filledRectangle(x + .5, y + .5 + j, .5, .5);
					StdDraw.setPenColor();
					StdDraw.rectangle(x + .5, y + .5 + j, .5, .5);
					board[x][y + j] = 00;
					StdDraw.show(30);
					canMove++;
				}

			}
			for (int j = 1; y - j >= 0; j++) {
				if (board[x][y - j] > 3) {
					canMove = canMove
							+ possibleAttacks(x, y - j, board, StdDraw.BLACK);
					break;
				}
				if (board[x][y - j] < 3) {
					StdDraw.setPenColor(Move);
					StdDraw.filledRectangle(x + .5, y - j + .5, .5, .5);
					StdDraw.setPenColor();
					StdDraw.rectangle(x + .5, y - j + .5, .5, .5);
					board[x][y - j] = 00;
					StdDraw.show(30);
					canMove++;
				}

			}
			for (int j = 1; x - j >= 0; j++) {
				if (board[x - j][y] > 3) {
					canMove = canMove
							+ possibleAttacks(x - j, y, board, StdDraw.BLACK);
					break;
				}
				if (board[x - j][y] < 3) {
					StdDraw.setPenColor(Move);
					StdDraw.filledRectangle(x - j + .5, y + .5, .5, .5);
					StdDraw.setPenColor();
					StdDraw.rectangle(x - j + .5, y + .5, .5, .5);
					board[x - j][y] = 00;
					StdDraw.show(30);
					canMove++;
				}

			}
			for (int j = 1; x + j < 8; j++) {
				if (board[x + j][y] > 3) {
					canMove = canMove
							+ possibleAttacks(x + j, y, board, StdDraw.BLACK);
					break;
				}
				if (board[x + j][y] < 3) {
					StdDraw.setPenColor(Move);
					StdDraw.filledRectangle(x + .5 + j, y + .5, .5, .5);
					StdDraw.setPenColor();
					StdDraw.rectangle(x + .5 + j, y + .5, .5, .5);
					board[x + j][y] = 00;
					StdDraw.show(30);
					canMove++;
				}
			}
			return canMove;
		}

		if (i == 24) {
			for (int j = 1; j + y < 8; j++) {
				if (board[x][y + j] > 3) {
					canMove = canMove
							+ possibleAttacks(x, y + j, board, StdDraw.WHITE);
					break;
				}
				if (board[x][y + j] < 3) {
					StdDraw.setPenColor(Move);
					StdDraw.filledRectangle(x + .5, y + .5 + j, .5, .5);
					StdDraw.setPenColor();
					StdDraw.rectangle(x + .5, y + .5 + j, .5, .5);
					board[x][y + j] = 00;
					StdDraw.show(30);
					canMove++;
				}

			}
			for (int j = 1; y - j >= 0; j++) {
				if (board[x][y - j] > 3) {
					canMove = canMove
							+ possibleAttacks(x, y - j, board, StdDraw.WHITE);
					break;
				}
				if (board[x][y - j] < 3) {
					StdDraw.setPenColor(Move);
					StdDraw.filledRectangle(x + .5, y - j + .5, .5, .5);
					StdDraw.setPenColor();
					StdDraw.rectangle(x + .5, y - j + .5, .5, .5);
					board[x][y - j] = 00;
					StdDraw.show(30);
					canMove++;
				}

			}
			for (int j = 1; x - j >= 0; j++) {
				if (board[x - j][y] > 3) {
					canMove = canMove
							+ possibleAttacks(x - j, y, board, StdDraw.WHITE);
					break;
				}
				if (board[x - j][y] < 3) {
					StdDraw.setPenColor(Move);
					StdDraw.filledRectangle(x - j + .5, y + .5, .5, .5);
					StdDraw.setPenColor();
					StdDraw.rectangle(x - j + .5, y + .5, .5, .5);
					board[x - j][y] = 00;
					StdDraw.show(30);
					canMove++;
				}

			}
			for (int j = 1; x + j < 8; j++) {
				if (board[x + j][y] > 3) {
					canMove = canMove
							+ possibleAttacks(x + j, y, board, StdDraw.WHITE);
					break;
				}
				if (board[x + j][y] < 3) {
					StdDraw.setPenColor(Move);
					StdDraw.filledRectangle(x + .5 + j, y + .5, .5, .5);
					StdDraw.setPenColor();
					StdDraw.rectangle(x + .5 + j, y + .5, .5, .5);
					board[x + j][y] = 00;
					StdDraw.show(30);
					canMove++;
				}
			}
			return canMove;
		} else
			return canMove;
	}

	public int[][] canMove(int i, int x, int y, int[][] board,
			int[][] canWhiteMove, int[][] canBlackMove) {
		int[][] canMove = new int[8][8];
		if (i == 14) {
			for (int j = 1; j + y < 8; j++) {
				if (board[x][y + j] > 3) {
					canWhiteMove[x][y + j] = canWhiteMove[x][y + j]
							+ canAttack(x, y + j, board, StdDraw.BLACK);
					break;
				}
				if (board[x][y + j] < 3) {
					canWhiteMove[x][y + j]++;
				}

			}
			for (int j = 1; y - j >= 0; j++) {
				if (board[x][y - j] > 3) {
					canWhiteMove[x][y - j] = canWhiteMove[x][y - j]
							+ canAttack(x, y - j, board, StdDraw.BLACK);
					break;
				}
				if (board[x][y - j] < 3) {
					canWhiteMove[x][y - j]++;
				}

			}
			for (int j = 1; x - j >= 0; j++) {
				if (board[x - j][y] > 3) {
					canWhiteMove[x - j][y] = canWhiteMove[x - j][y]
							+ canAttack(x - j, y, board, StdDraw.BLACK);
					break;
				}
				if (board[x - j][y] < 3) {
					canWhiteMove[x - j][y]++;
				}

			}
			for (int j = 1; x + j < 8; j++) {
				if (board[x + j][y] > 3) {
					canWhiteMove[x + j][y] = canWhiteMove[x + j][y]
							+ canAttack(x + j, y, board, StdDraw.BLACK);
					break;
				}
				if (board[x + j][y] < 3) {
					canWhiteMove[x + j][y]++;
				}
			}
			return canWhiteMove;
		}

		if (i == 24) {
			for (int j = 1; j + y < 8; j++) {
				if (board[x][y + j] > 3) {
					canBlackMove[x][y + j] = canBlackMove[x][y + j]
							+ canAttack(x, y + j, board, StdDraw.WHITE);
					break;
				}
				if (board[x][y + j] < 3) {
					canBlackMove[x][y + j]++;
				}

			}
			for (int j = 1; y - j >= 0; j++) {
				if (board[x][y - j] > 3) {
					canBlackMove[x][y - j] = canBlackMove[x][y - j]
							+ canAttack(x, y - j, board, StdDraw.WHITE);
					break;
				}
				if (board[x][y - j] < 3) {
					canBlackMove[x][y - j]++;
				}

			}
			for (int j = 1; x - j >= 0; j++) {
				if (board[x - j][y] > 3) {
					canBlackMove[x - j][y] = canBlackMove[x - j][y]
							+ canAttack(x - j, y, board, StdDraw.WHITE);
					break;
				}
				if (board[x - j][y] < 3) {
					canBlackMove[x - j][y]++;
				}

			}
			for (int j = 1; x + j < 8; j++) {
				if (board[x + j][y] > 3) {
					canBlackMove[x + j][y] = canBlackMove[x + j][y]
							+ canAttack(x + j, y, board, StdDraw.WHITE);
					break;
				}
				if (board[x + j][y] < 3) {
					canBlackMove[x + j][y]++;
				}
			}

			return canBlackMove;
		} else
			return canMove;
	}
}
