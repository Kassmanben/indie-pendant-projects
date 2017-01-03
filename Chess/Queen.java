package ChessGame;

//Chess by Ben Kassman

import java.awt.Color;

public class Queen extends Piece {
	private Color Move = new Color(214, 180, 130);

	// Draw Queen
	public Queen(int x, int y, Color color) {
		if (color.equals(StdDraw.WHITE)) {
			StdDraw.picture(x + .5, y + .5, "Chess" + java.io.File.separator
					+ "WhiteQueen.png", .5, .6);
		}
		if (color.equals(StdDraw.BLACK)) {
			StdDraw.picture(x + .5, y + .5, "Chess" + java.io.File.separator
					+ "BlackQueen.png", .5, .6);
		}
	}

	// Show all possible moves
	public int possibleMoves(int i, int x, int y, int[][] board) {
		int canMove = 0;
		if (i == 15) {
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
			StdDraw.setPenColor(Move);
			for (int j = 1; j < 8; j++) {
				if ((x + j < 8 && y + j < 8) && board[x + j][y + j] > 3) {
					canMove = canMove
							+ possibleAttacks(x + j, y + j, board,
									StdDraw.BLACK);
					break;
				}
				if ((x + j < 8 && y + j < 8) && board[x + j][y + j] < 3) {
					StdDraw.setPenColor(Move);
					StdDraw.filledRectangle(x + j + .5, y + .5 + j, .5, .5);
					StdDraw.setPenColor();
					StdDraw.rectangle(x + .5 + j, y + .5 + j, .5, .5);
					board[x + j][y + j] = 0;
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
					StdDraw.setPenColor(Move);
					StdDraw.filledRectangle(x - j + .5, y + .5 - j, .5, .5);
					StdDraw.setPenColor();
					StdDraw.rectangle(x + .5 - j, y + .5 - j, .5, .5);
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
					StdDraw.setPenColor(Move);
					StdDraw.filledRectangle(x + j + .5, y + .5 - j, .5, .5);
					StdDraw.setPenColor();
					StdDraw.rectangle(x + .5 + j, y + .5 - j, .5, .5);
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
					StdDraw.setPenColor(Move);
					StdDraw.filledRectangle(x - j + .5, y + .5 + j, .5, .5);
					StdDraw.setPenColor();
					StdDraw.rectangle(x + .5 - j, y + .5 + j, .5, .5);
					board[x - j][y + j] = 0;
					canMove++;
				}

			}
			StdDraw.show(30);
			return canMove;
		}

		if (i == 25) {
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
			StdDraw.setPenColor(Move);
			for (int j = 1; j < 8; j++) {
				if ((x + j < 8 && y + j < 8) && board[x + j][y + j] > 3) {
					canMove = canMove
							+ possibleAttacks(x + j, y + j, board,
									StdDraw.WHITE);
					break;
				}
				if ((x + j < 8 && y + j < 8) && board[x + j][y + j] < 3) {
					StdDraw.setPenColor(Move);
					StdDraw.filledRectangle(x + j + .5, y + .5 + j, .5, .5);
					StdDraw.setPenColor();
					StdDraw.rectangle(x + .5 + j, y + .5 + j, .5, .5);
					board[x + j][y + j] = 0;
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
					StdDraw.setPenColor(Move);
					StdDraw.filledRectangle(x - j + .5, y + .5 - j, .5, .5);
					StdDraw.setPenColor();
					StdDraw.rectangle(x + .5 - j, y + .5 - j, .5, .5);
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
					StdDraw.setPenColor(Move);
					StdDraw.filledRectangle(x + j + .5, y + .5 - j, .5, .5);
					StdDraw.setPenColor();
					StdDraw.rectangle(x + .5 + j, y + .5 - j, .5, .5);
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
					StdDraw.setPenColor(Move);
					StdDraw.filledRectangle(x - j + .5, y + .5 + j, .5, .5);
					StdDraw.setPenColor();
					StdDraw.rectangle(x + .5 - j, y + .5 + j, .5, .5);
					board[x - j][y + j] = 0;
					canMove++;
				}

			}
			StdDraw.show(30);
			return canMove;
		} else
			return canMove;
	}

	public int[][] canMove(int i, int x, int y, int[][] board,
			int[][] canWhiteMove, int[][] canBlackMove) {
		int[][] canMove = new int[8][8];
		if (i == 15) {
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

		if (i == 25) {
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
		} else
			return canMove;
	}
}
