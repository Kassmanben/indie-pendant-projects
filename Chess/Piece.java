package ChessGame;

import java.awt.Color;

public class Piece {
	private Color Check = new Color(196, 29, 24);
	private Color Move = new Color(214, 180, 130);
	private Color Attack = new Color(184, 157, 80);

	public int possibleAttacks(int x, int y, int[][] board, Color color) {
		int canAttack = 0;
		if ((board[x][y] == 0 || board[x][y] == 01) || board[x][y] == 02) {
			return 0;
		}
		char piece = String.valueOf(board[x][y]).charAt(1);
		char pieceColor = String.valueOf(board[x][y]).charAt(0);
		if ((piece != '6' && pieceColor == '2') && color.equals(StdDraw.BLACK)) {
			StdDraw.setPenColor(Attack);
			StdDraw.filledRectangle(x + .5, y + .5, .5, .5);
			StdDraw.setPenColor();
			StdDraw.rectangle(x + .5, y + .5, .5, .5);
			if (piece == '1') {
				StdDraw.picture(x + .5, y + .5, "Chess"
						+ java.io.File.separator + "BlackPawn.png", .5, .6);
				board[x][y] = 72;
				canAttack++;
			}
			if (piece == '2') {
				StdDraw.picture(x + .5, y + .5, "Chess"
						+ java.io.File.separator + "BlackKnight.png", .5, .6);
				board[x][y] = 82;
				canAttack++;
			}
			if (piece == '3') {
				StdDraw.picture(x + .5, y + .5, "Chess"
						+ java.io.File.separator + "BlackBishop.png", .5, .6);
				board[x][y] = 92;
				canAttack++;
			}
			if (piece == '4') {
				StdDraw.picture(x + .5, y + .5, "Chess"
						+ java.io.File.separator + "BlackRook.png", .5, .6);
				board[x][y] = 102;
				canAttack++;
			}
			if (piece == '5') {
				StdDraw.picture(x + .5, y + .5, "Chess"
						+ java.io.File.separator + "BlackQueen.png", .5, .6);
				board[x][y] = 112;
				canAttack++;
			}
			StdDraw.show(30);
		}
		if ((piece != '6' && pieceColor == '1') && color.equals(StdDraw.WHITE)) {
			StdDraw.setPenColor(Attack);
			StdDraw.filledRectangle(x + .5, y + .5, .5, .5);
			StdDraw.setPenColor();
			StdDraw.rectangle(x + .5, y + .5, .5, .5);
			if (piece == '1') {
				StdDraw.picture(x + .5, y + .5, "Chess"
						+ java.io.File.separator + "WhitePawn.png", .5, .6);
				board[x][y] = 71;
				canAttack++;

			}
			if (piece == '2') {
				StdDraw.picture(x + .5, y + .5, "Chess"
						+ java.io.File.separator + "WhiteKnight.png", .5, .6);
				board[x][y] = 81;
				canAttack++;

			}
			if (piece == '3') {
				StdDraw.picture(x + .5, y + .5, "Chess"
						+ java.io.File.separator + "WhiteBishop.png", .5, .6);
				board[x][y] = 91;
				canAttack++;
			}
			if (piece == '4') {
				StdDraw.picture(x + .5, y + .5, "Chess"
						+ java.io.File.separator + "WhiteRook.png", .5, .6);
				board[x][y] = 101;
			}
			if (piece == '5') {
				StdDraw.picture(x + .5, y + .5, "Chess"
						+ java.io.File.separator + "WhiteQueen.png", .5, .6);
				board[x][y] = 111;
				canAttack++;
			}
			StdDraw.show(30);
		}
		StdDraw.setPenColor(Move);
		return canAttack;
	}

	public int canAttack(int x, int y, int[][] board, Color color) {
		int canAttack = 0;
		if ((board[x][y] == 0 || board[x][y] == 01) || board[x][y] == 02) {
			return 0;
		}
		char piece = String.valueOf(board[x][y]).charAt(1);
		char pieceColor = String.valueOf(board[x][y]).charAt(0);
		if ((piece != '6' && pieceColor == '2') && color.equals(StdDraw.BLACK)) {

			if (piece == '1') {
				canAttack++;
			}
			if (piece == '2') {
				canAttack++;
			}
			if (piece == '3') {
				canAttack++;
			}
			if (piece == '4') {
				canAttack++;
			}
			if (piece == '5') {
				canAttack++;
			}
		}
		if ((piece != '6' && pieceColor == '1') && color.equals(StdDraw.WHITE)) {
			if (piece == '1') {
				canAttack++;

			}
			if (piece == '2') {
				canAttack++;

			}
			if (piece == '3') {
				canAttack++;
			}
			if (piece == '4') {
			}
			if (piece == '5') {
				canAttack++;
			}
		}
		return canAttack;
	}

	public void checkDanger(int x, int y, char[][] attackingPieces,
			char defendingPieces[][], int[][] inDanger, int whiteOrBlack) {
		char piece = attackingPieces[x][y];
		if (piece == ' ') {
			return;
		}
		if (piece == '1') {
			if ((y < 7 && x < 7) && defendingPieces[x + 1][y + 1] != ' ') {
				char defendingPiece = defendingPieces[x + 1][y + 1];
				inDanger[x + 1][y + 1] = (int) defendingPiece - 48;
				if (defendingPiece == '6') {
					this.lightUpCheck(x, y, x + 1, y + 1, piece, whiteOrBlack);
					inDanger[x][y] = 9;
				}
			}
			if ((y < 7 && x > 0) && defendingPieces[x - 1][y + 1] != ' ') {
				char defendingPiece = defendingPieces[x - 1][y + 1];
				inDanger[x - 1][y + 1] = (int) defendingPiece - 48;
				if (defendingPiece == '6') {
					this.lightUpCheck(x, y, x - 1, y + 1, piece, whiteOrBlack);
					inDanger[x][y] = 9;
				}
			}

		}
		if (piece == '/') {
			if ((y > 0 && x < 7) && defendingPieces[x + 1][y - 1] != ' ') {
				char defendingPiece = defendingPieces[x + 1][y - 1];
				inDanger[x + 1][y - 1] = (int) defendingPiece - 48;
				if (defendingPiece == '6') {
					this.lightUpCheck(x, y, x + 1, y - 1, piece, whiteOrBlack);
					inDanger[x][y] = 9;
				}
			}
			if ((y > 0 && x > 0) && defendingPieces[x - 1][y - 1] != ' ') {
				char defendingPiece = defendingPieces[x - 1][y - 1];
				inDanger[x - 1][y - 1] = (int) defendingPiece - 48;
				if (defendingPiece == '6') {
					this.lightUpCheck(x, y, x - 1, y - 1, piece, whiteOrBlack);
					inDanger[x][y] = 9;
				}
			}

		}
		if (piece == '2') {
			if (((y > 0 && y <= 7) && (x > 1 && x <= 7))
					&& defendingPieces[x - 2][y - 1] != ' ') {
				char defendingPiece = defendingPieces[x - 2][y - 1];
				inDanger[x - 2][y - 1] = (int) defendingPiece - 48;
				if (defendingPiece == '6') {
					this.lightUpCheck(x, y, x - 2, y - 1, piece, whiteOrBlack);
					inDanger[x][y] = 9;
				}
			}
			if (((y >= 0 && y < 7) && (x > 1 && x <= 7))
					&& defendingPieces[x - 2][y + 1] != ' ') {
				char defendingPiece = defendingPieces[x - 2][y + 1];
				inDanger[x - 2][y + 1] = (int) defendingPiece - 48;
				if (defendingPiece == '6') {
					this.lightUpCheck(x, y, x - 2, y + 1, piece, whiteOrBlack);
					inDanger[x][y] = 9;
				}
			}
			if (((y >= 0 && y < 6) && (x > 0 && x <= 7))
					&& defendingPieces[x - 1][y + 2] != ' ') {
				char defendingPiece = defendingPieces[x - 1][y + 2];
				inDanger[x - 1][y + 2] = (int) defendingPiece - 48;
				if (defendingPiece == '6') {
					this.lightUpCheck(x, y, x - 1, y + 2, piece, whiteOrBlack);
					inDanger[x][y] = 9;
				}
			}
			if (((y >= 0 && y < 6) && (x >= 0 && x < 7))
					&& defendingPieces[x + 1][y + 2] != ' ') {
				char defendingPiece = defendingPieces[x + 1][y + 2];
				inDanger[x + 1][y + 2] = (int) defendingPiece - 48;
				if (defendingPiece == '6') {
					this.lightUpCheck(x, y, x + 1, y + 2, piece, whiteOrBlack);
					inDanger[x][y] = 9;
				}
			}
			if (((y >= 0 && y < 7) && (x >= 0 && x < 6))
					&& defendingPieces[x + 2][y + 1] != ' ') {
				char defendingPiece = defendingPieces[x + 2][y + 1];
				inDanger[x + 2][y + 1] = (int) defendingPiece - 48;
				if (defendingPiece == '6') {
					this.lightUpCheck(x, y, x + 2, y + 1, piece, whiteOrBlack);
					inDanger[x][y] = 9;
				}
			}
			if (((y > 0 && y <= 7) && (x >= 0 && x < 6))
					&& defendingPieces[x + 2][y - 1] != ' ') {
				char defendingPiece = defendingPieces[x + 2][y - 1];
				inDanger[x + 2][y - 1] = (int) defendingPiece - 48;
				if (defendingPiece == '6') {
					this.lightUpCheck(x, y, x + 2, y - 1, piece, whiteOrBlack);
					inDanger[x][y] = 9;
				}
			}
			if (((y > 1 && y <= 7) && (x >= 0 && x < 7))
					&& defendingPieces[x + 1][y - 2] != ' ') {
				char defendingPiece = defendingPieces[x + 1][y - 2];
				inDanger[x + 1][y - 2] = (int) defendingPiece - 48;
				if (defendingPiece == '6') {
					this.lightUpCheck(x, y, x + 1, y - 2, piece, whiteOrBlack);
					inDanger[x][y] = 9;
				}
			}
			if (((y > 1 && y <= 7) && (x > 0 && x <= 7))
					&& defendingPieces[x - 1][y - 2] != ' ') {
				char defendingPiece = defendingPieces[x - 1][y - 2];
				inDanger[x - 1][y - 2] = (int) defendingPiece - 48;
				if (defendingPiece == '6') {
					this.lightUpCheck(x, y, x - 1, y - 2, piece, whiteOrBlack);
					inDanger[x][y] = 9;
				}

			}
		}

		if (piece == '3' || piece == '5') {
			for (int j = 1; j < 8; j++) {
				if ((x + j < 8 && y + j < 8)
						&& attackingPieces[x + j][y + j] != ' ') {
					break;
				}
				if ((x + j < 8 && y + j < 8)
						&& defendingPieces[x + j][y + j] != ' ') {
					char defendingPiece = defendingPieces[x + j][y + j];
					inDanger[x + j][y + j] = (int) defendingPiece - 48;
					if (defendingPiece == '6') {
						this.lightUpCheck(x, y, x + j, y + j, piece,
								whiteOrBlack);
						inDanger[x][y] = 9;
					}
					break;
				}
			}
			for (int j = 1; j < 8; j++) {
				if ((x - j >= 0 && y - j >= 0)
						&& attackingPieces[x - j][y - j] != ' ') {
					break;
				}

				if ((x - j >= 0 && y - j >= 0)
						&& defendingPieces[x - j][y - j] != ' ') {
					char defendingPiece = defendingPieces[x - j][y - j];
					inDanger[x - j][y - j] = (int) defendingPiece - 48;
					if (defendingPiece == '6') {
						this.lightUpCheck(x, y, x - j, y - j, piece,
								whiteOrBlack);
						inDanger[x][y] = 9;
					}
					break;
				}
			}
			for (int j = 1; j < 8; j++) {
				if ((x + j < 8 && y - j >= 0)
						&& attackingPieces[x + j][y - j] != ' ') {
					break;
				}

				if ((x + j < 8 && y - j >= 0)
						&& defendingPieces[x + j][y - j] != ' ') {
					char defendingPiece = defendingPieces[x + j][y - j];
					inDanger[x + j][y - j] = (int) defendingPiece - 48;
					if (defendingPiece == '6') {
						this.lightUpCheck(x, y, x + j, y - j, piece,
								whiteOrBlack);
						inDanger[x][y] = 9;
					}
					break;
				}
			}
			for (int j = 1; j < 8; j++) {
				if ((x - j >= 0 && y + j < 8)
						&& attackingPieces[x - j][y + j] != ' ') {
					break;
				}
				if ((x - j >= 0 && y + j < 8)
						&& defendingPieces[x - j][y + j] != ' ') {
					char defendingPiece = defendingPieces[x - j][y + j];
					inDanger[x - j][y + j] = (int) defendingPiece - 48;
					if (defendingPiece == '6') {
						this.lightUpCheck(x, y, x - j, y + j, piece,
								whiteOrBlack);
						inDanger[x][y] = 9;
					}
					break;
				}
			}
		}

		if (piece == '4' || piece == '5') {
			for (int j = 1; j + y < 8; j++) {
				if (attackingPieces[x][y + j] != ' ') {
					break;
				}
				if (defendingPieces[x][y + j] != ' ') {
					char defendingPiece = defendingPieces[x][y + j];
					inDanger[x][y + j] = (int) defendingPiece - 48;
					if (defendingPiece == '6') {
						this.lightUpCheck(x, y, x, y + j, piece, whiteOrBlack);
						inDanger[x][y] = 9;
					}
					break;
				}
			}
			for (int j = 1; y - j >= 0; j++) {
				if (attackingPieces[x][y - j] != ' ') {
					break;
				}
				if (defendingPieces[x][y - j] != ' ') {
					char defendingPiece = defendingPieces[x][y - j];
					inDanger[x][y - j] = (int) defendingPiece - 48;
					if (defendingPiece == '6') {
						this.lightUpCheck(x, y, x, y - j, piece, whiteOrBlack);
						inDanger[x][y] = 9;
					}
					break;
				}
			}
			for (int j = 1; x - j >= 0; j++) {
				if (attackingPieces[x - j][y] != ' ') {
					break;
				}
				if (defendingPieces[x - j][y] != ' ') {
					char defendingPiece = defendingPieces[x - j][y];
					inDanger[x - j][y] = (int) defendingPiece - 48;
					if (defendingPiece == '6') {
						this.lightUpCheck(x, y, x - j, y, piece, whiteOrBlack);
						inDanger[x][y] = 9;
					}
					break;
				}
			}
			for (int j = 1; x + j < 8; j++) {
				if (attackingPieces[x + j][y] != ' ') {
					break;
				}
				if (defendingPieces[x + j][y] != ' ') {
					char defendingPiece = defendingPieces[x + j][y];
					inDanger[x + j][y] = (int) defendingPiece - 48;
					if (defendingPiece == '6') {
						this.lightUpCheck(x, y, x + j, y, piece, whiteOrBlack);
						inDanger[x][y] = 9;
					}
					break;
				}
			}
		}

		if (piece == '6') {

			if (y < 7 && defendingPieces[x][y + 1] != ' ') {
				char defendingPiece = defendingPieces[x][y + 1];
				inDanger[x][y + 1] = (int) defendingPiece - 48;
			}
			if (y > 0 && defendingPieces[x][y - 1] != ' ') {
				char defendingPiece = defendingPieces[x][y - 1];
				inDanger[x][y - 1] = (int) defendingPiece - 48;
			}
			if (x > 0 && defendingPieces[x - 1][y] != ' ') {
				char defendingPiece = defendingPieces[x - 1][y];
				inDanger[x - 1][y] = (int) defendingPiece - 48;
			}
			if (x < 7 && defendingPieces[x + 1][y] != ' ') {
				char defendingPiece = defendingPieces[x + 1][y];
				inDanger[x + 1][y] = (int) defendingPiece - 48;
			}
			if ((x + 1 < 8 && y + 1 < 8)
					&& defendingPieces[x + 1][y + 1] != ' ') {
				char defendingPiece = defendingPieces[x + 1][y + 1];
				inDanger[x + 1][y + 1] = (int) defendingPiece - 48;
			}
			if ((x - 1 >= 0 && y - 1 >= 0)
					&& defendingPieces[x - 1][y - 1] != ' ') {
				char defendingPiece = defendingPieces[x - 1][y - 1];
				inDanger[x - 1][y - 1] = (int) defendingPiece - 48;
			}
			if ((x + 1 < 8 && y - 1 >= 0)
					&& defendingPieces[x + 1][y - 1] != ' ') {
				char defendingPiece = defendingPieces[x + 1][y - 1];
				inDanger[x + 1][y - 1] = (int) defendingPiece - 48;
			}
			if ((x - 1 >= 0 && y + 1 < 8)
					&& defendingPieces[x - 1][y + 1] != ' ') {
				char defendingPiece = defendingPieces[x - 1][y + 1];
				inDanger[x - 1][y + 1] = (int) defendingPiece - 48;
			}
		}
	}

	public void lightUpCheck(int attackingX, int attackingY, int kingX,
			int kingY, char piece, int whiteOrBlack) {

		// 0=whiteKing
		// 1=blackKing
		if (piece == '/') {
			StdDraw.setPenColor();
			StdDraw.rectangle(attackingX + .5, attackingY + .5, .5, .5);
			StdDraw.setPenColor(Check);
			;
			StdDraw.filledRectangle(attackingX + .5, attackingY + .5, .5, .5);
			StdDraw.picture(attackingX + .5, attackingY + .5, "Chess"
					+ java.io.File.separator + "BlackPawn.png", .5, .6);
			StdDraw.setPenColor();
			StdDraw.rectangle(kingX + .5, kingY + .5, .5, .5);
			StdDraw.setPenColor(Check);
			StdDraw.filledRectangle(kingX + .5, kingY + .5, .5, .5);
			StdDraw.picture(kingX + .5, kingY + .5, "Chess"
					+ java.io.File.separator + "WhiteKing.png", .5, .6);
		}

		if (piece == '1') {
			StdDraw.setPenColor();
			StdDraw.rectangle(attackingX + .5, attackingY + .5, .5, .5);
			StdDraw.setPenColor(Check);
			StdDraw.filledRectangle(attackingX + .5, attackingY + .5, .5, .5);
			StdDraw.picture(attackingX + .5, attackingY + .5, "Chess"
					+ java.io.File.separator + "WhitePawn.png", .5, .6);
			StdDraw.setPenColor();
			StdDraw.rectangle(kingX + .5, kingY + .5, .5, .5);
			StdDraw.setPenColor(Check);
			StdDraw.filledRectangle(kingX + .5, kingY + .5, .5, .5);
			StdDraw.picture(kingX + .5, kingY + .5, "Chess"
					+ java.io.File.separator + "BlackKing.png", .5, .6);
		}

		if (piece == '2' && whiteOrBlack == 0) {
			StdDraw.setPenColor();
			StdDraw.rectangle(attackingX + .5, attackingY + .5, .5, .5);
			StdDraw.setPenColor(Check);
			StdDraw.filledRectangle(attackingX + .5, attackingY + .5, .5, .5);
			StdDraw.picture(attackingX + .5, attackingY + .5, "Chess"
					+ java.io.File.separator + "BlackKnight.png", .5, .6);
			StdDraw.setPenColor();
			StdDraw.rectangle(kingX + .5, kingY + .5, .5, .5);
			StdDraw.setPenColor(Check);
			StdDraw.filledRectangle(kingX + .5, kingY + .5, .5, .5);
			StdDraw.picture(kingX + .5, kingY + .5, "Chess"
					+ java.io.File.separator + "WhiteKing.png", .5, .6);
		}
		if (piece == '2' && whiteOrBlack == 1) {
			StdDraw.setPenColor();
			StdDraw.rectangle(attackingX + .5, attackingY + .5, .5, .5);
			StdDraw.setPenColor(Check);
			StdDraw.filledRectangle(attackingX + .5, attackingY + .5, .5, .5);
			StdDraw.picture(attackingX + .5, attackingY + .5, "Chess"
					+ java.io.File.separator + "WhiteKnight.png", .5, .6);
			StdDraw.setPenColor();
			StdDraw.rectangle(kingX + .5, kingY + .5, .5, .5);
			StdDraw.setPenColor(Check);
			StdDraw.filledRectangle(kingX + .5, kingY + .5, .5, .5);
			StdDraw.picture(kingX + .5, kingY + .5, "Chess"
					+ java.io.File.separator + "BlackKing.png", .5, .6);
		}
		if (piece == '3' && whiteOrBlack == 0) {
			StdDraw.setPenColor();
			StdDraw.rectangle(attackingX + .5, attackingY + .5, .5, .5);
			StdDraw.setPenColor(Check);
			StdDraw.filledRectangle(attackingX + .5, attackingY + .5, .5, .5);
			StdDraw.picture(attackingX + .5, attackingY + .5, "Chess"
					+ java.io.File.separator + "BlackBishop.png", .5, .6);
			StdDraw.setPenColor();
			StdDraw.rectangle(kingX + .5, kingY + .5, .5, .5);
			StdDraw.setPenColor(Check);
			StdDraw.filledRectangle(kingX + .5, kingY + .5, .5, .5);
			StdDraw.picture(kingX + .5, kingY + .5, "Chess"
					+ java.io.File.separator + "WhiteKing.png", .5, .6);
		}
		if (piece == '3' && whiteOrBlack == 1) {
			StdDraw.setPenColor();
			StdDraw.rectangle(attackingX + .5, attackingY + .5, .5, .5);
			StdDraw.setPenColor(Check);
			StdDraw.filledRectangle(attackingX + .5, attackingY + .5, .5, .5);
			StdDraw.picture(attackingX + .5, attackingY + .5, "Chess"
					+ java.io.File.separator + "WhiteBishop.png", .5, .6);
			StdDraw.setPenColor();
			StdDraw.rectangle(kingX + .5, kingY + .5, .5, .5);
			StdDraw.setPenColor(Check);
			StdDraw.filledRectangle(kingX + .5, kingY + .5, .5, .5);
			StdDraw.picture(kingX + .5, kingY + .5, "Chess"
					+ java.io.File.separator + "BlackKing.png", .5, .6);
		}
		if (piece == '4' && whiteOrBlack == 0) {
			StdDraw.setPenColor();
			StdDraw.rectangle(attackingX + .5, attackingY + .5, .5, .5);
			StdDraw.setPenColor(Check);
			StdDraw.filledRectangle(attackingX + .5, attackingY + .5, .5, .5);
			StdDraw.picture(attackingX + .5, attackingY + .5, "Chess"
					+ java.io.File.separator + "BlackRook.png", .5, .6);
			StdDraw.setPenColor();
			StdDraw.rectangle(kingX + .5, kingY + .5, .5, .5);
			StdDraw.setPenColor(Check);
			StdDraw.filledRectangle(kingX + .5, kingY + .5, .5, .5);
			StdDraw.picture(kingX + .5, kingY + .5, "Chess"
					+ java.io.File.separator + "WhiteKing.png", .5, .6);
		}
		if (piece == '4' && whiteOrBlack == 1) {
			StdDraw.setPenColor();
			StdDraw.rectangle(attackingX + .5, attackingY + .5, .5, .5);
			StdDraw.setPenColor(Check);
			StdDraw.filledRectangle(attackingX + .5, attackingY + .5, .5, .5);
			StdDraw.picture(attackingX + .5, attackingY + .5, "Chess"
					+ java.io.File.separator + "WhiteRook.png", .5, .6);
			StdDraw.setPenColor();
			StdDraw.rectangle(kingX + .5, kingY + .5, .5, .5);
			StdDraw.setPenColor(Check);
			StdDraw.filledRectangle(kingX + .5, kingY + .5, .5, .5);
			StdDraw.picture(kingX + .5, kingY + .5, "Chess"
					+ java.io.File.separator + "BlackKing.png", .5, .6);
		}
		if (piece == '5' && whiteOrBlack == 0) {
			StdDraw.setPenColor();
			StdDraw.rectangle(attackingX + .5, attackingY + .5, .5, .5);
			StdDraw.setPenColor(Check);
			StdDraw.filledRectangle(attackingX + .5, attackingY + .5, .5, .5);
			StdDraw.picture(attackingX + .5, attackingY + .5, "Chess"
					+ java.io.File.separator + "BlackQueen.png", .5, .6);
			StdDraw.setPenColor();
			StdDraw.rectangle(kingX + .5, kingY + .5, .5, .5);
			StdDraw.setPenColor(Check);
			StdDraw.filledRectangle(kingX + .5, kingY + .5, .5, .5);
			StdDraw.picture(kingX + .5, kingY + .5, "Chess"
					+ java.io.File.separator + "WhiteKing.png", .5, .6);
		}
		if (piece == '5' && whiteOrBlack == 1) {
			StdDraw.setPenColor();
			StdDraw.rectangle(attackingX + .5, attackingY + .5, .5, .5);
			StdDraw.setPenColor(Check);
			StdDraw.filledRectangle(attackingX + .5, attackingY + .5, .5, .5);
			StdDraw.picture(attackingX + .5, attackingY + .5, "Chess"
					+ java.io.File.separator + "WhiteQueen.png", .5, .6);
			StdDraw.setPenColor();
			StdDraw.rectangle(kingX + .5, kingY + .5, .5, .5);
			StdDraw.setPenColor(Check);
			StdDraw.filledRectangle(kingX + .5, kingY + .5, .5, .5);
			StdDraw.picture(kingX + .5, kingY + .5, "Chess"
					+ java.io.File.separator + "BlackKing.png", .5, .6);
		}
		StdDraw.show(30);
	}

}
