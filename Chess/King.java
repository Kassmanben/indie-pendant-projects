package ChessGame;

//Chess by Ben Kassman

import java.awt.Color;

public class King extends Piece {
	private Color Move = new Color(214, 180, 130);
	private int moves;

	public int getMoves() {
		return moves;
	}

	public void setMoves(int moves) {
		this.moves = moves;
	}

	// Draw king
	public King(int x, int y, Color color) {
		if (color.equals(StdDraw.WHITE)) {
			StdDraw.picture(x + .5, y + .5, "Chess" + java.io.File.separator
					+ "WhiteKing.png", .5, .6);
		}
		if (color.equals(StdDraw.BLACK)) {
			StdDraw.picture(x + .5, y + .5, "Chess" + java.io.File.separator
					+ "BlackKing.png", .5, .6);
		}

	}

	// // Show all possible moves
	public int possibleMoves(int i, int x, int y, int[][] board, int kingMoves,
			int rook1Moves, int rook2Moves, int inCheck) {
		int canMove = 0;
		if (i == 16) {
			if ((y == 0 && x == 4)
					&& (board[x - 1][y] < 3 && board[x - 2][y] < 3)
					&& (board[x - 3][y] < 3 && kingMoves == 0)
					&& (rook1Moves == 0 && inCheck == 0)) {
				StdDraw.setPenColor(Move);
				StdDraw.filledRectangle(x - 2.5, y + .5, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x - 2.5, y + .5, .5, .5);
				board[x - 3][y] = 0;
				canMove++;
				StdDraw.show(30);
			}
			if ((y == 0 && x == 4)
					&& (board[x + 1][y] < 3 && board[x + 2][y] < 3)
					&& (kingMoves == 0 && rook2Moves == 0) && inCheck == 0) {
				StdDraw.setPenColor(Move);
				StdDraw.filledRectangle(x + 2.5, y + .5, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x + 2.5, y + .5, .5, .5);
				board[x + 2][y] = 0;
				canMove++;
				StdDraw.show(30);
			}
			if (y < 7 && board[x][y + 1] > 3) {
				canMove = canMove
						+ possibleAttacks(x, y + 1, board, StdDraw.BLACK);
			}
			if (y < 7 && board[x][y + 1] < 3) {
				StdDraw.setPenColor(Move);
				StdDraw.filledRectangle(x + .5, y + .5 + 1, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x + .5, y + .5 + 1, .5, .5);
				board[x][y + 1] = 0;
				canMove++;
				StdDraw.show(30);
			}

			if (y > 0 && board[x][y - 1] > 3) {
				canMove = canMove
						+ possibleAttacks(x, y - 1, board, StdDraw.BLACK);
			}
			if (y > 0 && board[x][y - 1] < 3) {
				StdDraw.setPenColor(Move);
				StdDraw.filledRectangle(x + .5, y - 1 + .5, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x + .5, y - 1 + .5, .5, .5);
				board[x][y - 1] = 0;
				canMove++;
				StdDraw.show(30);
			}

			if (x > 0 && board[x - 1][y] > 3) {
				canMove = canMove
						+ possibleAttacks(x - 1, y, board, StdDraw.BLACK);
			}
			if (x > 0 && board[x - 1][y] < 3) {
				StdDraw.setPenColor(Move);
				StdDraw.filledRectangle(x - 1 + .5, y + .5, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x - 1 + .5, y + .5, .5, .5);
				board[x - 1][y] = 0;
				canMove++;
				StdDraw.show(30);
			}

			if (x < 7 && board[x + 1][y] > 3) {
				canMove = canMove
						+ possibleAttacks(x + 1, y, board, StdDraw.BLACK);
			}
			if (x < 7 && board[x + 1][y] < 3) {
				StdDraw.setPenColor(Move);
				StdDraw.filledRectangle(x + .5 + 1, y + .5, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x + .5 + 1, y + .5, .5, .5);
				board[x + 1][y] = 0;
				canMove++;
				StdDraw.show(30);
			}
			StdDraw.setPenColor(Move);
			if ((x + 1 < 8 && y + 1 < 8) && board[x + 1][y + 1] > 3) {
				canMove = canMove
						+ possibleAttacks(x + 1, y + 1, board, StdDraw.BLACK);
			}
			if ((x + 1 < 8 && y + 1 < 8) && board[x + 1][y + 1] < 3) {
				StdDraw.setPenColor(Move);
				StdDraw.filledRectangle(x + 1 + .5, y + .5 + 1, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x + .5 + 1, y + .5 + 1, .5, .5);
				board[x + 1][y + 1] = 0;
				canMove++;
			}

			if ((x - 1 >= 0 && y - 1 >= 0) && board[x - 1][y - 1] > 3) {
				canMove = canMove
						+ possibleAttacks(x - 1, y - 1, board, StdDraw.BLACK);
			}
			if ((x - 1 >= 0 && y - 1 >= 0) && board[x - 1][y - 1] < 3) {
				StdDraw.setPenColor(Move);
				StdDraw.filledRectangle(x - 1 + .5, y + .5 - 1, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x + .5 - 1, y + .5 - 1, .5, .5);
				board[x - 1][y - 1] = 0;
				canMove++;
			}
			if ((x + 1 < 8 && y - 1 >= 0) && board[x + 1][y - 1] > 3) {
				canMove = canMove
						+ possibleAttacks(x + 1, y - 1, board, StdDraw.BLACK);
			}
			if ((x + 1 < 8 && y - 1 >= 0) && board[x + 1][y - 1] < 3) {
				StdDraw.setPenColor(Move);
				StdDraw.filledRectangle(x + 1 + .5, y + .5 - 1, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x + .5 + 1, y + .5 - 1, .5, .5);
				board[x + 1][y - 1] = 0;
				canMove++;
			}

			if ((x - 1 >= 0 && y + 1 < 8) && board[x - 1][y + 1] > 3) {
				canMove = canMove
						+ possibleAttacks(x - 1, y + 1, board, StdDraw.BLACK);
			}
			if ((x - 1 >= 0 && y + 1 < 8) && board[x - 1][y + 1] < 3) {
				StdDraw.setPenColor(Move);
				StdDraw.filledRectangle(x - 1 + .5, y + .5 + 1, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x + .5 - 1, y + .5 + 1, .5, .5);
				board[x - 1][y + 1] = 0;
				canMove++;
			}
			StdDraw.show(30);
			return canMove;
		}

		if (i == 26) {
			if ((y == 7 && x == 4)
					&& (board[x - 1][y] < 3 && board[x - 2][y] < 3)
					&& (board[x - 3][y] < 3 && kingMoves == 0)
					&& (rook1Moves == 0 && inCheck == 0)) {
				StdDraw.setPenColor(Move);
				StdDraw.filledRectangle(x - 2.5, y + .5, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x - 2.5, y + .5, .5, .5);
				board[x - 3][y] = 0;
				canMove++;
				StdDraw.show(30);
			}
			if ((y == 7 && x == 4)
					&& (board[x + 1][y] < 3 && board[x + 2][y] < 3)
					&& (kingMoves == 0 && rook2Moves == 0) && inCheck == 0) {
				StdDraw.setPenColor(Move);
				StdDraw.filledRectangle(x + 2.5, y + .5, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x + 2.5, y + .5, .5, .5);
				board[x + 2][y] = 0;
				canMove++;
				StdDraw.show(30);
			}
			if (y < 7 && board[x][y + 1] > 3) {
				canMove = canMove
						+ possibleAttacks(x, y + 1, board, StdDraw.WHITE);
			}
			if (y < 7 && board[x][y + 1] < 3) {
				StdDraw.setPenColor(Move);
				StdDraw.filledRectangle(x + .5, y + .5 + 1, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x + .5, y + .5 + 1, .5, .5);
				board[x][y + 1] = 0;
				canMove++;
				StdDraw.show(30);
			}

			if (y > 0 && board[x][y - 1] > 3) {
				canMove = canMove
						+ possibleAttacks(x, y - 1, board, StdDraw.WHITE);
			}
			if (y > 0 && board[x][y - 1] < 3) {
				StdDraw.setPenColor(Move);
				StdDraw.filledRectangle(x + .5, y - 1 + .5, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x + .5, y - 1 + .5, .5, .5);
				board[x][y - 1] = 0;
				canMove++;
				StdDraw.show(30);
			}

			if (x > 0 && board[x - 1][y] > 3) {
				canMove = canMove
						+ possibleAttacks(x - 1, y, board, StdDraw.WHITE);
			}
			if (x > 0 && board[x - 1][y] < 3) {
				StdDraw.setPenColor(Move);
				StdDraw.filledRectangle(x - 1 + .5, y + .5, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x - 1 + .5, y + .5, .5, .5);
				board[x - 1][y] = 0;
				canMove++;
				StdDraw.show(30);
			}

			if (x < 7 && board[x + 1][y] > 3) {
				canMove = canMove
						+ possibleAttacks(x + 1, y, board, StdDraw.WHITE);
			}
			if (x < 7 && board[x + 1][y] < 3) {
				StdDraw.setPenColor(Move);
				StdDraw.filledRectangle(x + .5 + 1, y + .5, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x + .5 + 1, y + .5, .5, .5);
				board[x + 1][y] = 0;
				canMove++;
				StdDraw.show(30);
			}
			StdDraw.setPenColor(Move);
			if ((x + 1 < 8 && y + 1 < 8) && board[x + 1][y + 1] > 3) {
				canMove = canMove
						+ possibleAttacks(x + 1, y + 1, board, StdDraw.WHITE);
			}
			if ((x + 1 < 8 && y + 1 < 8) && board[x + 1][y + 1] < 3) {
				StdDraw.setPenColor(Move);
				StdDraw.filledRectangle(x + 1 + .5, y + .5 + 1, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x + .5 + 1, y + .5 + 1, .5, .5);
				board[x + 1][y + 1] = 0;
				canMove++;
			}

			if ((x - 1 >= 0 && y - 1 >= 0) && board[x - 1][y - 1] > 3) {
				canMove = canMove
						+ possibleAttacks(x - 1, y - 1, board, StdDraw.WHITE);
			}
			if ((x - 1 >= 0 && y - 1 >= 0) && board[x - 1][y - 1] < 3) {
				StdDraw.setPenColor(Move);
				StdDraw.filledRectangle(x - 1 + .5, y + .5 - 1, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x + .5 - 1, y + .5 - 1, .5, .5);
				board[x - 1][y - 1] = 0;
				canMove++;
			}
			if ((x + 1 < 8 && y - 1 >= 0) && board[x + 1][y - 1] > 3) {
				canMove = canMove
						+ possibleAttacks(x + 1, y - 1, board, StdDraw.WHITE);
			}
			if ((x + 1 < 8 && y - 1 >= 0) && board[x + 1][y - 1] < 3) {
				StdDraw.setPenColor(Move);
				StdDraw.filledRectangle(x + 1 + .5, y + .5 - 1, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x + .5 + 1, y + .5 - 1, .5, .5);
				board[x + 1][y - 1] = 0;
				canMove++;
			}

			if ((x - 1 >= 0 && y + 1 < 8) && board[x - 1][y + 1] > 3) {
				canMove = canMove
						+ possibleAttacks(x - 1, y + 1, board, StdDraw.WHITE);
			}
			if ((x - 1 >= 0 && y + 1 < 8) && board[x - 1][y + 1] < 3) {
				StdDraw.setPenColor(Move);
				StdDraw.filledRectangle(x - 1 + .5, y + .5 + 1, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x + .5 - 1, y + .5 + 1, .5, .5);
				board[x - 1][y + 1] = 0;
				canMove++;
			}
			StdDraw.show(30);
			return canMove;

		} else
			return canMove;
	}

	public int[][] canMove(int i, int x, int y, int[][] board, int kingMoves,
			int rook1Moves, int rook2Moves, int inCheck, int[][] canWhiteMove,
			int[][] canBlackMove) {
		int canMove[][] = new int[8][8];
		if (i == 16) {
			if ((y == 0 && x == 4)
					&& (board[x - 1][y] < 3 && board[x - 2][y] < 3)
					&& (board[x - 3][y] < 3 && kingMoves == 0)
					&& (rook1Moves == 0 && inCheck == 0)) {
				canWhiteMove[x - 3][y]++;
			}
			if ((y == 0 && x == 4)
					&& (board[x + 1][y] < 3 && board[x + 2][y] < 3)
					&& (kingMoves == 0 && rook2Moves == 0) && inCheck == 0) {
				canWhiteMove[x + 2][y]++;
			}
			if (y < 7 && board[x][y + 1] > 3) {
				canWhiteMove[x][y + 1] = canWhiteMove[x][y + 1]
						+ canAttack(x, y + 1, board, StdDraw.BLACK);
			}
			if (y < 7 && board[x][y + 1] < 3) {
				canWhiteMove[x][y + 1]++;
			}

			if (y > 0 && board[x][y - 1] > 3) {
				canWhiteMove[x][y - 1] = canWhiteMove[x][y - 1]
						+ canAttack(x, y - 1, board, StdDraw.BLACK);
			}
			if (y > 0 && board[x][y - 1] < 3) {
				canWhiteMove[x][y - 1]++;
			}

			if (x > 0 && board[x - 1][y] > 3) {
				canWhiteMove[x - 1][y] = canWhiteMove[x - 1][y]
						+ canAttack(x - 1, y, board, StdDraw.BLACK);
			}
			if (x > 0 && board[x - 1][y] < 3) {
				canWhiteMove[x - 1][y]++;
			}

			if (x < 7 && board[x + 1][y] > 3) {
				canWhiteMove[x + 1][y] = canWhiteMove[x + 1][y]
						+ canAttack(x + 1, y, board, StdDraw.BLACK);
			}
			if (x < 7 && board[x + 1][y] < 3) {
				canWhiteMove[x + 1][y]++;
			}
			if ((x + 1 < 8 && y + 1 < 8) && board[x + 1][y + 1] > 3) {
				canWhiteMove[x + 1][y + 1] = canWhiteMove[x + 1][y + 1]
						+ canAttack(x + 1, y + 1, board, StdDraw.BLACK);
			}
			if ((x + 1 < 8 && y + 1 < 8) && board[x + 1][y + 1] < 3) {
				canWhiteMove[x + 1][y + 1]++;
			}

			if ((x - 1 >= 0 && y - 1 >= 0) && board[x - 1][y - 1] > 3) {
				canWhiteMove[x - 1][y - 1] = canWhiteMove[x - 1][y - 1]
						+ canAttack(x - 1, y - 1, board, StdDraw.BLACK);
			}
			if ((x - 1 >= 0 && y - 1 >= 0) && board[x - 1][y - 1] < 3) {
				canWhiteMove[x - 1][y - 1]++;
			}
			if ((x + 1 < 8 && y - 1 >= 0) && board[x + 1][y - 1] > 3) {
				canWhiteMove[x + 1][y - 1] = canWhiteMove[x + 1][y - 1]
						+ canAttack(x + 1, y - 1, board, StdDraw.BLACK);
			}
			if ((x + 1 < 8 && y - 1 >= 0) && board[x + 1][y - 1] < 3) {
				canWhiteMove[x + 1][y - 1]++;
			}

			if ((x - 1 >= 0 && y + 1 < 8) && board[x - 1][y + 1] > 3) {
				canWhiteMove[x - 1][y + 1] = canWhiteMove[x - 1][y + 1]
						+ canAttack(x - 1, y + 1, board, StdDraw.BLACK);
			}
			if ((x - 1 >= 0 && y + 1 < 8) && board[x - 1][y + 1] < 3) {
				canWhiteMove[x - 1][y + 1]++;
			}
			return canWhiteMove;
		}

		if (i == 26) {
			if ((y == 7 && x == 4)
					&& (board[x - 1][y] < 3 && board[x - 2][y] < 3)
					&& (board[x - 3][y] < 3 && kingMoves == 0)
					&& (rook1Moves == 0 && inCheck == 0)) {
				canBlackMove[x - 3][y]++;
			}
			if ((y == 7 && x == 4)
					&& (board[x + 1][y] < 3 && board[x + 2][y] < 3)
					&& (kingMoves == 0 && rook2Moves == 0) && inCheck == 0) {
				canBlackMove[x + 2][y]++;
			}
			if (y < 7 && board[x][y + 1] > 3) {
				canBlackMove[x][y + 1] = canBlackMove[x][y + 1]
						+ canAttack(x, y + 1, board, StdDraw.WHITE);
			}
			if (y < 7 && board[x][y + 1] < 3) {
				canBlackMove[x][y + 1]++;
			}

			if (y > 0 && board[x][y - 1] > 3) {
				canBlackMove[x][y - 1] = canBlackMove[x][y - 1]
						+ canAttack(x, y - 1, board, StdDraw.WHITE);
			}
			if (y > 0 && board[x][y - 1] < 3) {
				canBlackMove[x][y - 1]++;
			}

			if (x > 0 && board[x - 1][y] > 3) {
				canBlackMove[x - 1][y] = canBlackMove[x - 1][y]
						+ canAttack(x - 1, y, board, StdDraw.WHITE);
			}
			if (x > 0 && board[x - 1][y] < 3) {
				canBlackMove[x - 1][y]++;
			}

			if (x < 7 && board[x + 1][y] > 3) {
				canBlackMove[x + 1][y] = canBlackMove[x + 1][y]
						+ canAttack(x + 1, y, board, StdDraw.WHITE);
			}
			if (x < 7 && board[x + 1][y] < 3) {
				canBlackMove[x + 1][y]++;
			}
			if ((x + 1 < 8 && y + 1 < 8) && board[x + 1][y + 1] > 3) {
				canBlackMove[x + 1][y + 1] = canBlackMove[x + 1][y + 1]
						+ canAttack(x + 1, y + 1, board, StdDraw.WHITE);
			}
			if ((x + 1 < 8 && y + 1 < 8) && board[x + 1][y + 1] < 3) {
				canBlackMove[x + 1][y + 1]++;
			}

			if ((x - 1 >= 0 && y - 1 >= 0) && board[x - 1][y - 1] > 3) {
				canBlackMove[x - 1][y - 1] = canBlackMove[x - 1][y - 1]
						+ canAttack(x - 1, y - 1, board, StdDraw.WHITE);
			}
			if ((x - 1 >= 0 && y - 1 >= 0) && board[x - 1][y - 1] < 3) {
				canBlackMove[x - 1][y - 1]++;
			}
			if ((x + 1 < 8 && y - 1 >= 0) && board[x + 1][y - 1] > 3) {
				canBlackMove[x + 1][y - 1] = canBlackMove[x + 1][y - 1]
						+ canAttack(x + 1, y - 1, board, StdDraw.WHITE);
			}
			if ((x + 1 < 8 && y - 1 >= 0) && board[x + 1][y - 1] < 3) {
				canBlackMove[x + 1][y - 1]++;
			}

			if ((x - 1 >= 0 && y + 1 < 8) && board[x - 1][y + 1] > 3) {
				canBlackMove[x - 1][y + 1] = canBlackMove[x - 1][y + 1]
						+ canAttack(x - 1, y + 1, board, StdDraw.WHITE);
			}
			if ((x - 1 >= 0 && y + 1 < 8) && board[x - 1][y + 1] < 3) {
				canBlackMove[x - 1][y + 1]++;
			}
			return canBlackMove;
		} else
			return canMove;
	}

}
