package ChessGame;

//Chess by Ben Kassman

import java.awt.Color;

public class Pawn extends Piece {
	private Color Move = new Color(214, 180, 130);

	// Draw pawn
	public Pawn(int x, int y, Color color) {
		if (color.equals(StdDraw.WHITE)) {
			StdDraw.picture(x + .5, y + .5, "Chess" + java.io.File.separator
					+ "WhitePawn.png", .5, .6);
		}
		if (color.equals(StdDraw.BLACK)) {
			StdDraw.picture(x + .5, y + .5, "Chess" + java.io.File.separator
					+ "BlackPawn.png", .5, .6);
		}
	}

	// Show all possible moves
	public int possibleMoves(int i, int x, int y, int[][] board) {
		int canMove = 0;
		if (i == 11) {
			if (y < 7 && board[x][y + 1] < 3) {
				StdDraw.setPenColor(Move);
				StdDraw.filledRectangle(x + .5, y + 1.5, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x + .5, y + 1.5, .5, .5);
				board[x][y + 1] = 0;
				canMove++;
				StdDraw.show(30);
				if (y == 1 && board[x][y + 2] < 3) {
					StdDraw.setPenColor(Move);
					StdDraw.filledRectangle(x + .5, y + 2.5, .5, .5);
					StdDraw.setPenColor();
					StdDraw.rectangle(x + .5, y + 2.5, .5, .5);
					board[x][y + 2] = 0;
					canMove++;
				}
			}
			if ((y < 7 && x < 7) && board[x + 1][y + 1] > 3) {
				canMove = canMove
						+ possibleAttacks(x + 1, y + 1, board, StdDraw.BLACK);
			}
			if ((y < 7 && x > 0) && board[x - 1][y + 1] > 3) {
				canMove = canMove
						+ possibleAttacks(x - 1, y + 1, board, StdDraw.BLACK);
			}
			StdDraw.show(30);
			return canMove;
		}

		if (i == 21) {
			if (y > 0 && board[x][y - 1] < 3) {
				StdDraw.setPenColor(Move);
				StdDraw.filledRectangle(x + .5, y - .5, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x + .5, y - .5, .5, .5);
				board[x][y - 1] = 0;
				canMove++;
				StdDraw.show(30);
				if (y == 6 && board[x][y - 2] < 3) {
					StdDraw.setPenColor(Move);
					StdDraw.filledRectangle(x + .5, y - 1.5, .5, .5);
					StdDraw.setPenColor();
					StdDraw.rectangle(x + .5, y - 1.5, .5, .5);
					board[x][y - 2] = 0;
					canMove++;
					StdDraw.show(30);
				}
			}
			if ((y > 0 && x < 7) && board[x + 1][y - 1] > 3) {
				canMove = canMove
						+ possibleAttacks(x + 1, y - 1, board, StdDraw.WHITE);
			}
			if ((y > 0 && x > 0) && board[x - 1][y - 1] > 3) {
				canMove = canMove
						+ possibleAttacks(x - 1, y - 1, board, StdDraw.WHITE);
			}
			return canMove;
		} else
			return canMove;
	}

	public int[][] canMove(int i, int x, int y, int[][] board,
			int[][] canWhiteMove, int[][] canBlackMove) {
		int[][] canMove = new int[8][8];
		if (i == 11) {
			if (y < 7 && board[x][y + 1] < 3) {
				canWhiteMove[x][y + 1]++;
				if (y == 1 && board[x][y + 2] < 3) {
					canWhiteMove[x][y + 2]++;
				}
			}
			if ((y < 7 && x < 7) && board[x + 1][y + 1] > 3) {
				canWhiteMove[x + 1][y + 1] = canWhiteMove[x + 1][y + 1]
						+ canAttack(x + 1, y + 1, board, StdDraw.BLACK);
			}
			if ((y < 7 && x > 0) && board[x - 1][y + 1] > 3) {
				canWhiteMove[x - 1][y + 1] = canWhiteMove[x - 1][y + 1]
						+ canAttack(x - 1, y + 1, board, StdDraw.BLACK);
			}
			return canWhiteMove;
		}

		if (i == 21) {
			if (y > 0 && board[x][y - 1] < 3) {
				canBlackMove[x][y - 1]++;
				if (y == 6 && board[x][y - 2] < 3) {
					canBlackMove[x][y - 2]++;
				}
			}
			if ((y > 0 && x < 7) && board[x + 1][y - 1] > 3) {
				canBlackMove[x + 1][y - 1] = canBlackMove[x + 1][y - 1]
						+ canAttack(x + 1, y + 1, board, StdDraw.WHITE);
			}
			if ((y > 0 && x > 0) && board[x - 1][y - 1] > 3) {
				canBlackMove[x - 1][y - 1] = canBlackMove[x - 1][y - 1]
						+ canAttack(x - 1, y + 1, board, StdDraw.WHITE);
			}
			return canBlackMove;
		} else
			return canMove;
	}
}
