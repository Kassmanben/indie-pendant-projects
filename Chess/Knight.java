package ChessGame;

//Chess by Ben Kassman

import java.awt.Color;

public class Knight extends Piece {
	private Color Move = new Color(214, 180, 130);

	// Draw knight
	public Knight(int x, int y, Color color) {
		if (color.equals(StdDraw.WHITE)) {
			StdDraw.picture(x + .5, y + .5, "Chess" + java.io.File.separator
					+ "WhiteKnight.png", .5, .6);
		}
		if (color.equals(StdDraw.BLACK)) {
			StdDraw.picture(x + .5, y + .5, "Chess" + java.io.File.separator
					+ "BlackKnight.png", .5, .6);
		}
	}

	// Check all avaiable positions for the knight
	public int possibleMoves(int i, int x, int y, int[][] board) {
		int canMove = 0;

		if (i == 12) {
			StdDraw.setPenColor(Move);
			if (((y > 0 && y <= 7) && (x > 1 && x <= 7))
					&& board[x - 2][y - 1] > 3) {
				canMove = canMove
						+ possibleAttacks(x - 2, y - 1, board, StdDraw.BLACK);
			}
			if (((y > 0 && y <= 7) && (x > 1 && x <= 7))
					&& board[x - 2][y - 1] < 3) {
				StdDraw.filledRectangle(x - 1.5, y - .5, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x - 1.5, y - .5, .5, .5);
				board[x - 2][y - 1] = 0;
				canMove++;
			}
			StdDraw.setPenColor(Move);
			if (((y >= 0 && y < 7) && (x > 1 && x <= 7))
					&& board[x - 2][y + 1] > 3) {
				canMove = canMove
						+ possibleAttacks(x - 2, y + 1, board, StdDraw.BLACK);
			}

			if (((y >= 0 && y < 7) && (x > 1 && x <= 7))
					&& board[x - 2][y + 1] < 3) {
				StdDraw.filledRectangle(x - 1.5, y + 1.5, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x - 1.5, y + 1.5, .5, .5);
				board[x - 2][y + 1] = 0;
				canMove++;
			}
			StdDraw.setPenColor(Move);
			if (((y >= 0 && y < 6) && (x > 0 && x <= 7))
					&& board[x - 1][y + 2] > 3) {
				canMove = canMove
						+ possibleAttacks(x - 1, y + 2, board, StdDraw.BLACK);
			}
			if (((y >= 0 && y < 6) && (x > 0 && x <= 7))
					&& board[x - 1][y + 2] < 3) {
				StdDraw.filledRectangle(x - .5, y + 2.5, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x - .5, y + 2.5, .5, .5);
				board[x - 1][y + 2] = 0;
				canMove++;
			}
			StdDraw.setPenColor(Move);
			if (((y >= 0 && y < 6) && (x >= 0 && x < 7))
					&& board[x + 1][y + 2] > 3) {
				canMove = canMove
						+ possibleAttacks(x + 1, y + 2, board, StdDraw.BLACK);
			}
			if (((y >= 0 && y < 6) && (x >= 0 && x < 7))
					&& board[x + 1][y + 2] < 3) {
				StdDraw.filledRectangle(x + 1.5, y + 2.5, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x + 1.5, y + 2.5, .5, .5);
				board[x + 1][y + 2] = 0;
				canMove++;
			}
			StdDraw.setPenColor(Move);
			if (((y >= 0 && y < 7) && (x >= 0 && x < 6))
					&& board[x + 2][y + 1] > 3) {
				canMove = canMove
						+ possibleAttacks(x + 2, y + 1, board, StdDraw.BLACK);
			}
			if (((y >= 0 && y < 7) && (x >= 0 && x < 6))
					&& board[x + 2][y + 1] < 3) {
				StdDraw.filledRectangle(x + 2.5, y + 1.5, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x + 2.5, y + 1.5, .5, .5);
				board[x + 2][y + 1] = 0;
				canMove++;
			}
			StdDraw.setPenColor(Move);
			if (((y > 0 && y <= 7) && (x >= 0 && x < 6))
					&& board[x + 2][y - 1] > 3) {
				canMove = canMove
						+ possibleAttacks(x + 2, y - 1, board, StdDraw.BLACK);
			}
			if (((y > 0 && y <= 7) && (x >= 0 && x < 6))
					&& board[x + 2][y - 1] < 3) {
				StdDraw.filledRectangle(x + 2.5, y - .5, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x + 2.5, y - .5, .5, .5);
				board[x + 2][y - 1] = 0;
				canMove++;
			}
			StdDraw.setPenColor(Move);
			if (((y > 1 && y <= 7) && (x >= 0 && x < 7))
					&& board[x + 1][y - 2] > 3) {
				canMove = canMove
						+ possibleAttacks(x + 1, y - 2, board, StdDraw.BLACK);
			}
			if (((y > 1 && y <= 7) && (x >= 0 && x < 7))
					&& board[x + 1][y - 2] < 3) {
				StdDraw.filledRectangle(x + 1.5, y - 1.5, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x + 1.5, y - 1.5, .5, .5);
				board[x + 1][y - 2] = 0;
				canMove++;
			}
			StdDraw.setPenColor(Move);
			if (((y > 1 && y <= 7) && (x > 0 && x <= 7))
					&& board[x - 1][y - 2] > 3) {
				canMove = canMove
						+ possibleAttacks(x - 1, y - 2, board, StdDraw.BLACK);
			}
			if (((y > 1 && y <= 7) && (x > 0 && x <= 7))
					&& board[x - 1][y - 2] < 3) {
				StdDraw.filledRectangle(x - .5, y - 1.5, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x - .5, y - 1.5, .5, .5);
				board[x - 1][y - 2] = 0;
				canMove++;
			}

			StdDraw.show(30);
			return canMove;
		}

		if (i == 22) {
			StdDraw.setPenColor(Move);
			if (((y > 0 && y <= 7) && (x > 1 && x <= 7))
					&& board[x - 2][y - 1] > 3) {
				canMove = canMove
						+ possibleAttacks(x - 2, y - 1, board, StdDraw.WHITE);
			}
			if (((y > 0 && y <= 7) && (x > 1 && x <= 7))
					&& board[x - 2][y - 1] < 3) {
				StdDraw.filledRectangle(x - 1.5, y - .5, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x - 1.5, y - .5, .5, .5);
				board[x - 2][y - 1] = 0;
				canMove++;
			}
			StdDraw.setPenColor(Move);
			if (((y >= 0 && y < 7) && (x > 1 && x <= 7))
					&& board[x - 2][y + 1] > 3) {
				canMove = canMove
						+ possibleAttacks(x - 2, y + 1, board, StdDraw.WHITE);
			}

			if (((y >= 0 && y < 7) && (x > 1 && x <= 7))
					&& board[x - 2][y + 1] < 3) {
				StdDraw.filledRectangle(x - 1.5, y + 1.5, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x - 1.5, y + 1.5, .5, .5);
				board[x - 2][y + 1] = 0;
				canMove++;
			}
			StdDraw.setPenColor(Move);
			if (((y >= 0 && y < 6) && (x > 0 && x <= 7))
					&& board[x - 1][y + 2] > 3) {
				canMove = canMove
						+ possibleAttacks(x - 1, y + 2, board, StdDraw.WHITE);
			}
			if (((y >= 0 && y < 6) && (x > 0 && x <= 7))
					&& board[x - 1][y + 2] < 3) {
				StdDraw.filledRectangle(x - .5, y + 2.5, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x - .5, y + 2.5, .5, .5);
				board[x - 1][y + 2] = 0;
				canMove++;
			}
			StdDraw.setPenColor(Move);
			if (((y >= 0 && y < 6) && (x >= 0 && x < 7))
					&& board[x + 1][y + 2] > 3) {
				canMove = canMove
						+ possibleAttacks(x + 1, y + 2, board, StdDraw.WHITE);
			}
			if (((y >= 0 && y < 6) && (x >= 0 && x < 7))
					&& board[x + 1][y + 2] < 3) {
				StdDraw.filledRectangle(x + 1.5, y + 2.5, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x + 1.5, y + 2.5, .5, .5);
				board[x + 1][y + 2] = 0;
				canMove++;
			}
			StdDraw.setPenColor(Move);
			if (((y >= 0 && y < 7) && (x >= 0 && x < 6))
					&& board[x + 2][y + 1] > 3) {
				canMove = canMove
						+ possibleAttacks(x + 2, y + 1, board, StdDraw.WHITE);
			}
			if (((y >= 0 && y < 7) && (x >= 0 && x < 6))
					&& board[x + 2][y + 1] < 3) {
				StdDraw.filledRectangle(x + 2.5, y + 1.5, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x + 2.5, y + 1.5, .5, .5);
				board[x + 2][y + 1] = 0;
				canMove++;
			}
			StdDraw.setPenColor(Move);
			if (((y > 0 && y <= 7) && (x >= 0 && x < 6))
					&& board[x + 2][y - 1] > 3) {
				canMove = canMove
						+ possibleAttacks(x + 2, y - 1, board, StdDraw.WHITE);
			}
			if (((y > 0 && y <= 7) && (x >= 0 && x < 6))
					&& board[x + 2][y - 1] < 3) {
				StdDraw.filledRectangle(x + 2.5, y - .5, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x + 2.5, y - .5, .5, .5);
				board[x + 2][y - 1] = 0;
				canMove++;
			}
			StdDraw.setPenColor(Move);
			if (((y > 1 && y <= 7) && (x >= 0 && x < 7))
					&& board[x + 1][y - 2] > 3) {
				canMove = canMove
						+ possibleAttacks(x + 1, y - 2, board, StdDraw.WHITE);
			}
			if (((y > 1 && y <= 7) && (x >= 0 && x < 7))
					&& board[x + 1][y - 2] < 3) {
				StdDraw.filledRectangle(x + 1.5, y - 1.5, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x + 1.5, y - 1.5, .5, .5);
				board[x + 1][y - 2] = 0;
				canMove++;
			}
			StdDraw.setPenColor(Move);
			if (((y > 1 && y <= 7) && (x > 0 && x <= 7))
					&& board[x - 1][y - 2] > 3) {
				canMove = canMove
						+ possibleAttacks(x - 1, y - 2, board, StdDraw.WHITE);
			}
			if (((y > 1 && y <= 7) && (x > 0 && x <= 7))
					&& board[x - 1][y - 2] < 3) {
				StdDraw.filledRectangle(x - .5, y - 1.5, .5, .5);
				StdDraw.setPenColor();
				StdDraw.rectangle(x - .5, y - 1.5, .5, .5);
				board[x - 1][y - 2] = 0;
				canMove++;
			}

			StdDraw.show(30);
			return canMove;
		} else
			return canMove;
	}

	public int[][] canMove(int i, int x, int y, int[][] board, int[][] canWhiteMove, int[][]canBlackMove) {
		int[][] canMove = new int[8][8];
		if (i == 12) {
			if (((y > 0 && y <= 7) && (x > 1 && x <= 7))
					&& board[x - 2][y - 1] > 3) {
				canWhiteMove[x - 2][y - 1]= canWhiteMove[x - 2][y - 1]+canAttack(x - 2, y - 1, board, StdDraw.BLACK);
			}
			if (((y > 0 && y <= 7) && (x > 1 && x <= 7))
					&& board[x - 2][y - 1] < 3) {
				canWhiteMove[x - 2][y - 1]++;
			}
			if (((y >= 0 && y < 7) && (x > 1 && x <= 7))
					&& board[x - 2][y + 1] > 3) {
				canWhiteMove[x - 2][y + 1] = canWhiteMove[x - 2][y + 1]+canAttack(x - 2, y + 1, board, StdDraw.BLACK);
			}

			if (((y >= 0 && y < 7) && (x > 1 && x <= 7))
					&& board[x - 2][y + 1] < 3) {
				canWhiteMove[x - 2][y + 1]++;
			}
			if (((y >= 0 && y < 6) && (x > 0 && x <= 7))
					&& board[x - 1][y + 2] > 3) {
				canWhiteMove[x - 1][y + 2] =canWhiteMove[x - 1][y + 2] + canAttack(x - 1, y + 2, board, StdDraw.BLACK);
			}
			if (((y >= 0 && y < 6) && (x > 0 && x <= 7))
					&& board[x - 1][y + 2] < 3) {
				canWhiteMove[x - 1][y + 2]++;
			}
			if (((y >= 0 && y < 6) && (x >= 0 && x < 7))
					&& board[x + 1][y + 2] > 3) {
				canWhiteMove[x + 1][y + 2] =canWhiteMove[x + 1][y + 2] + canAttack(x + 1, y + 2, board, StdDraw.BLACK);
			}
			if (((y >= 0 && y < 6) && (x >= 0 && x < 7))
					&& board[x + 1][y + 2] < 3) {
				canWhiteMove[x + 1][y + 2]++;
			}
			if (((y >= 0 && y < 7) && (x >= 0 && x < 6))
					&& board[x + 2][y + 1] > 3) {
				canWhiteMove[x + 2][y + 1] =canWhiteMove[x + 2][y + 1] +canAttack(x + 2, y + 1, board, StdDraw.BLACK);
			}
			if (((y >= 0 && y < 7) && (x >= 0 && x < 6))
					&& board[x + 2][y + 1] < 3) {
				canWhiteMove[x + 2][y + 1]++;
			}
			if (((y > 0 && y <= 7) && (x >= 0 && x < 6))
					&& board[x + 2][y - 1] > 3) {
				canWhiteMove[x + 2][y - 1]=canWhiteMove[x + 2][y - 1]+ canAttack(x + 2, y - 1, board, StdDraw.BLACK);
			}
			if (((y > 0 && y <= 7) && (x >= 0 && x < 6))
					&& board[x + 2][y - 1] < 3) {
				canWhiteMove[x + 2][y - 1]++;
			}
			if (((y > 1 && y <= 7) && (x >= 0 && x < 7))
					&& board[x + 1][y - 2] > 3) {
				canWhiteMove[x + 1][y - 2] =canWhiteMove[x + 1][y - 2] + canAttack(x + 1, y - 2, board, StdDraw.BLACK);
			}
			if (((y > 1 && y <= 7) && (x >= 0 && x < 7))
					&& board[x + 1][y - 2] < 3) {
				canWhiteMove[x + 1][y - 2]++;
			}
			if (((y > 1 && y <= 7) && (x > 0 && x <= 7))
					&& board[x - 1][y - 2] > 3) {
				canWhiteMove[x - 1][y - 2] = canWhiteMove[x - 1][y - 2] + canAttack(x - 1, y - 2, board, StdDraw.BLACK);
			}
			if (((y > 1 && y <= 7) && (x > 0 && x <= 7))
					&& board[x - 1][y - 2] < 3) {
				canWhiteMove[x - 1][y - 2]++;
			}
			return canWhiteMove;
		}

		if (i == 22) {
			if (((y > 0 && y <= 7) && (x > 1 && x <= 7))
					&& board[x - 2][y - 1] > 3) {
				canBlackMove[x - 2][y - 1]= canBlackMove[x - 2][y - 1]+canAttack(x - 2, y - 1, board, StdDraw.WHITE);
			}
			if (((y > 0 && y <= 7) && (x > 1 && x <= 7))
					&& board[x - 2][y - 1] < 3) {
				canBlackMove[x - 2][y - 1]++;
			}
			if (((y >= 0 && y < 7) && (x > 1 && x <= 7))
					&& board[x - 2][y + 1] > 3) {
				canBlackMove[x - 2][y + 1] = canBlackMove[x - 2][y + 1]+canAttack(x - 2, y + 1, board, StdDraw.WHITE);
			}

			if (((y >= 0 && y < 7) && (x > 1 && x <= 7))
					&& board[x - 2][y + 1] < 3) {
				canBlackMove[x - 2][y + 1]++;
			}
			if (((y >= 0 && y < 6) && (x > 0 && x <= 7))
					&& board[x - 1][y + 2] > 3) {
				canBlackMove[x - 1][y + 2] =canBlackMove[x - 1][y + 2] + canAttack(x - 1, y + 2, board, StdDraw.WHITE);
			}
			if (((y >= 0 && y < 6) && (x > 0 && x <= 7))
					&& board[x - 1][y + 2] < 3) {
				canBlackMove[x - 1][y + 2]++;
			}
			if (((y >= 0 && y < 6) && (x >= 0 && x < 7))
					&& board[x + 1][y + 2] > 3) {
				canBlackMove[x + 1][y + 2] =canBlackMove[x + 1][y + 2] + canAttack(x + 1, y + 2, board, StdDraw.WHITE);
			}
			if (((y >= 0 && y < 6) && (x >= 0 && x < 7))
					&& board[x + 1][y + 2] < 3) {
				canBlackMove[x + 1][y + 2]++;
			}
			if (((y >= 0 && y < 7) && (x >= 0 && x < 6))
					&& board[x + 2][y + 1] > 3) {
				canBlackMove[x + 2][y + 1] =canBlackMove[x + 2][y + 1] +canAttack(x + 2, y + 1, board, StdDraw.WHITE);
			}
			if (((y >= 0 && y < 7) && (x >= 0 && x < 6))
					&& board[x + 2][y + 1] < 3) {
				canBlackMove[x + 2][y + 1]++;
			}
			if (((y > 0 && y <= 7) && (x >= 0 && x < 6))
					&& board[x + 2][y - 1] > 3) {
				canBlackMove[x + 2][y - 1]=canBlackMove[x + 2][y - 1]+ canAttack(x + 2, y - 1, board, StdDraw.WHITE);
			}
			if (((y > 0 && y <= 7) && (x >= 0 && x < 6))
					&& board[x + 2][y - 1] < 3) {
				canBlackMove[x + 2][y - 1]++;
			}
			if (((y > 1 && y <= 7) && (x >= 0 && x < 7))
					&& board[x + 1][y - 2] > 3) {
				canBlackMove[x + 1][y - 2] =canBlackMove[x + 1][y - 2] + canAttack(x + 1, y - 2, board, StdDraw.WHITE);
			}
			if (((y > 1 && y <= 7) && (x >= 0 && x < 7))
					&& board[x + 1][y - 2] < 3) {
				canBlackMove[x + 1][y - 2]++;
			}
			if (((y > 1 && y <= 7) && (x > 0 && x <= 7))
					&& board[x - 1][y - 2] > 3) {
				canBlackMove[x - 1][y - 2] = canBlackMove[x - 1][y - 2] + canAttack(x - 1, y - 2, board, StdDraw.WHITE);
			}
			if (((y > 1 && y <= 7) && (x > 0 && x <= 7))
					&& board[x - 1][y - 2] < 3) {
				canBlackMove[x - 1][y - 2]++;
			}

			return canBlackMove;
		}	
			return canMove;
	}

}
