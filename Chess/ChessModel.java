package ChessGame;

//Chess by Ben Kassman

import java.awt.Color;
import java.util.Arrays;
import java.awt.Font;

@SuppressWarnings("unused")
public class ChessModel {
	private Color Black = new Color(114, 47, 55);
	private Color BlackButton = new Color(94, 27, 35);
	private Color White = new Color(255, 255, 200);
	private Color WhiteButton = new Color(225, 225, 180);
	private Color BlackBackground = new Color(69, 69, 71);
	private Color WhiteBackground = new Color(161, 160, 161);
	private Color Background = new Color(41, 29, 28);
	private Color Velvet = new Color(70, 30, 31);
	private Color Text = new Color(95, 90, 84);
	private Font font = new Font("Futura", Font.PLAIN, 16);

	private int whiteRook1Moves;
	private int whiteRook2Moves;
	private int blackRook1Moves;
	private int blackRook2Moves;
	private int whiteKingMoves;
	private int blackKingMoves;

	private int isWhiteCheck = 0;
	private int isBlackCheck = 0;
	private int isWhiteCheckmate = 0;
	private int isBlackCheckmate = 0;
	private int whiteKingMovesCheck = 0;
	private int blackKingMovesCheck = 0;

	private Pawn pawn;
	private Knight knight;
	private Bishop bishop;
	private Rook whiteRook1;
	private Rook blackRook1;
	private Rook whiteRook2;
	private Rook blackRook2;
	private Queen queen;
	private King whiteKing;
	private King blackKing;

	private int[][] board = new int[8][8];
	private int[][] whiteMoves = new int[8][8];
	private int[][] blackMoves = new int[8][8];
	private char[][] whitePieces = new char[8][8];
	private char[][] blackPieces = new char[8][8];
	int[][] whiteInDanger = new int[8][8];
	int[][] blackInDanger = new int[8][8];
	int[] whiteTakenPieces = new int[5];
	int[] blackTakenPieces = new int[5];

	private int whoseTurn = 0;
	private String[] clicks = new String[100000];
	private int clickNumber = 0;

	/**
	 * Board[Row][Column][CurrentPiece] CurrentPiece: ab a: 0=empty space 1=Pawn
	 * 2=Knight 3=Bishop 4=Rook 5=Queen 6=King
	 * 
	 * b: 0=empty 1=White 2=Black
	 * 
	 * if a>70, piece is in danger. Find piece name by subtracting 60
	 */

	// Create game
	public ChessModel() {
		drawBoard();
	}

	// Draw initial chessboard
	public void drawBoard() {
		StdDraw.setCanvasSize(650, 512);
		StdDraw.setXscale(-.2, 10);
		StdDraw.setYscale(-.2, 8.2);
		StdDraw.setPenColor(getBackground());
		StdDraw.filledRectangle(4, 4, 6, 6);
		StdDraw.setPenColor(getWhite());
		StdDraw.filledRectangle(4, 4, 4.15, 4.15);
		StdDraw.setPenColor(Black);
		StdDraw.filledRectangle(4, 4, 4.1, 4.1);

		StdDraw.setPenColor(getBackground());
		StdDraw.filledRectangle(4, 4, 4.05, 4.05);
		StdDraw.setPenColor(Velvet);
		StdDraw.filledRectangle(9.1, 4, .9, 1);
		StdDraw.setPenColor(getBackground());
		StdDraw.filledRectangle(9.1, 4, .85, .95);
		StdDraw.setPenColor(Velvet);
		StdDraw.filledRectangle(9.1, 4, .8, .9);

		StdDraw.setPenColor(getText());
		StdDraw.filledRectangle(9.1, 7.95, .9, .2);
		StdDraw.setPenColor(getBackground());
		StdDraw.filledRectangle(9.1, 7.95, .87, .18);
		StdDraw.setPenColor(getText());
		StdDraw.filledRectangle(9.1, 7.95, .84, .14);

		StdDraw.setPenColor(getText());
		StdDraw.filledRectangle(9.1, 0, .9, .2);
		StdDraw.setPenColor(getBackground());
		StdDraw.filledRectangle(9.1, 0, .87, .18);
		StdDraw.setPenColor(getText());
		StdDraw.filledRectangle(9.1, 0, .84, .14);

		StdDraw.setPenColor(getText());
		StdDraw.filledRectangle(9.1, 5.2, .9, .2);
		StdDraw.setPenColor(getBackground());
		StdDraw.filledRectangle(9.1, 5.2, .87, .18);
		StdDraw.setPenColor(getText());
		StdDraw.filledRectangle(9.1, 5.2, .84, .14);

		StdDraw.setPenColor(getText());
		StdDraw.filledRectangle(9.1, 2.8, .9, .2);
		StdDraw.setPenColor(getBackground());
		StdDraw.filledRectangle(9.1, 2.8, .87, .18);
		StdDraw.setPenColor(getText());
		StdDraw.filledRectangle(9.1, 2.8, .84, .14);

		StdDraw.setPenColor(WhiteBackground);
		StdDraw.filledRectangle(9.1, 1.38, .9, 1.17);
		StdDraw.setPenColor(getBackground());
		StdDraw.filledRectangle(9.1, 1.38, .87, 1.12);
		StdDraw.setPenColor(WhiteBackground);
		StdDraw.filledRectangle(9.1, 1.38, .84, 1.07);

		StdDraw.setPenColor(BlackBackground);
		StdDraw.filledRectangle(9.1, 6.58, .9, 1.13);
		StdDraw.setPenColor(getBackground());
		StdDraw.filledRectangle(9.1, 6.58, .87, 1.08);
		StdDraw.setPenColor(BlackBackground);
		StdDraw.filledRectangle(9.1, 6.58, .84, 1.03);

		StdDraw.setPenColor(getText());
		StdDraw.filledRectangle(9.1, 4, .7, .25);
		StdDraw.setPenColor(getBackground());
		StdDraw.filledRectangle(9.1, 4, .65, .23);
		StdDraw.setPenColor(getText());
		StdDraw.filledRectangle(9.1, 4, .6, .2);
		StdDraw.setPenColor();
		StdDraw.setFont(getFont());
		StdDraw.text(9.1, 3.99, "FORFEIT");

		for (int x = 0, i = 0; x < 8; x++, i++) {
			for (int y = 0; y < 8; y++, i++) {
				if (Math.floor(i % 2) == 0) {
					StdDraw.setPenColor(Black);
					StdDraw.filledRectangle(x + .5, y + .5, .5, .5);
					board[x][y] = 02;
				}
				if (Math.floor(i % 2) != 0) {
					StdDraw.setPenColor(getWhite());
					StdDraw.filledRectangle(x + .5, y + .5, .5, .5);
					board[x][y] = 01;
				}
			}
		}
		whitePieces();
		blackPieces();
		addPieces();
	}

	// Draw initial piece setup
	public void addPieces() {
		StdDraw.setPenColor();
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {

				// Draw pawns
				if (y == 1) {
					this.pawn = new Pawn(x, y, StdDraw.WHITE);
					board[x][y] = 11;
				}
				if (y == 6) {
					this.pawn = new Pawn(x, y, StdDraw.BLACK);
					board[x][y] = 21;
				}

				// Draw knights
				if ((y == 0 && x == 1) || (y == 0 && x == 6)) {
					this.knight = new Knight(x, y, StdDraw.WHITE);
					board[x][y] = 12;
				}
				if ((y == 7 && x == 1) || (y == 7 && x == 6)) {
					this.knight = new Knight(x, y, StdDraw.BLACK);
					board[x][y] = 22;
				}

				// Draw bishops
				if ((y == 0 && x == 2) || (y == 0 && x == 5)) {
					this.bishop = new Bishop(x, y, StdDraw.WHITE);
					board[x][y] = 13;
				}
				if ((y == 7 && x == 2) || (y == 7 && x == 5)) {
					this.bishop = new Bishop(x, y, StdDraw.BLACK);
					board[x][y] = 23;
				}

				// Draw rooks
				if (y == 0 && x == 0) {
					this.whiteRook1 = new Rook(x, y, StdDraw.WHITE);
					board[x][y] = 14;
					this.setWhiteRook1Moves(0);
				}
				if (y == 0 && x == 7) {
					this.whiteRook2 = new Rook(x, y, StdDraw.WHITE);
					board[x][y] = 14;
					this.setWhiteRook2Moves(0);
				}
				if (y == 7 && x == 0) {
					this.blackRook1 = new Rook(x, y, StdDraw.BLACK);
					board[x][y] = 24;
					this.setBlackRook1Moves(0);

				}
				if (y == 7 && x == 7) {
					this.blackRook2 = new Rook(x, y, StdDraw.BLACK);
					board[x][y] = 24;
					this.setBlackRook2Moves(0);
				}

				// Draw queens
				if (y == 0 && x == 3) {
					this.queen = new Queen(x, y, StdDraw.WHITE);
					board[x][y] = 15;
				}
				if (y == 7 && x == 3) {
					this.queen = new Queen(x, y, StdDraw.BLACK);
					board[x][y] = 25;
				}

				// Draw kings
				if (y == 0 && x == 4) {
					this.whiteKing = new King(x, y, StdDraw.WHITE);
					board[x][y] = 16;
					this.setWhiteKingMoves(0);
				}
				if (y == 7 && x == 4) {
					this.blackKing = new King(x, y, StdDraw.BLACK);
					board[x][y] = 26;
					this.setBlackKingMoves(0);
				}

				else
					continue;
			}
		}

		whitePieces();
		blackPieces();
	}

	// Check each array element for piece and color, redraw pieces in correct
	// spot
	public void redrawBoard() {
		StdDraw.setPenColor(getBackground());
		StdDraw.filledRectangle(4, 4, 6, 6);
		StdDraw.setPenColor(getWhite());
		StdDraw.filledRectangle(4, 4, 4.15, 4.15);
		StdDraw.setPenColor(Black);
		StdDraw.filledRectangle(4, 4, 4.1, 4.1);

		StdDraw.setPenColor(getBackground());
		StdDraw.filledRectangle(4, 4, 4.05, 4.05);
		StdDraw.setPenColor(Velvet);
		StdDraw.filledRectangle(9.1, 4, .9, 1);
		StdDraw.setPenColor(getBackground());
		StdDraw.filledRectangle(9.1, 4, .85, .95);
		StdDraw.setPenColor(Velvet);
		StdDraw.filledRectangle(9.1, 4, .8, .9);

		StdDraw.setPenColor(getText());
		StdDraw.filledRectangle(9.1, 7.95, .9, .2);
		StdDraw.setPenColor(getBackground());
		StdDraw.filledRectangle(9.1, 7.95, .87, .18);
		StdDraw.setPenColor(getText());
		StdDraw.filledRectangle(9.1, 7.95, .84, .14);

		StdDraw.setPenColor(getText());
		StdDraw.filledRectangle(9.1, 0, .9, .2);
		StdDraw.setPenColor(getBackground());
		StdDraw.filledRectangle(9.1, 0, .87, .18);
		StdDraw.setPenColor(getText());
		StdDraw.filledRectangle(9.1, 0, .84, .14);

		StdDraw.setPenColor(getText());
		StdDraw.filledRectangle(9.1, 5.2, .9, .2);
		StdDraw.setPenColor(getBackground());
		StdDraw.filledRectangle(9.1, 5.2, .87, .18);
		StdDraw.setPenColor(getText());
		StdDraw.filledRectangle(9.1, 5.2, .84, .14);

		StdDraw.setPenColor(getText());
		StdDraw.filledRectangle(9.1, 2.8, .9, .2);
		StdDraw.setPenColor(getBackground());
		StdDraw.filledRectangle(9.1, 2.8, .87, .18);
		StdDraw.setPenColor(getText());
		StdDraw.filledRectangle(9.1, 2.8, .84, .14);

		StdDraw.setPenColor(WhiteBackground);
		StdDraw.filledRectangle(9.1, 1.38, .9, 1.17);
		StdDraw.setPenColor(getBackground());
		StdDraw.filledRectangle(9.1, 1.38, .87, 1.12);
		StdDraw.setPenColor(WhiteBackground);
		StdDraw.filledRectangle(9.1, 1.38, .84, 1.07);

		StdDraw.setPenColor(BlackBackground);
		StdDraw.filledRectangle(9.1, 6.58, .9, 1.13);
		StdDraw.setPenColor(getBackground());
		StdDraw.filledRectangle(9.1, 6.58, .87, 1.08);
		StdDraw.setPenColor(BlackBackground);
		StdDraw.filledRectangle(9.1, 6.58, .84, 1.03);

		StdDraw.setPenColor(getText());
		StdDraw.filledRectangle(9.1, 4, .7, .25);
		StdDraw.setPenColor(getBackground());
		StdDraw.filledRectangle(9.1, 4, .65, .23);
		StdDraw.setPenColor(getText());
		StdDraw.filledRectangle(9.1, 4, .6, .2);
		StdDraw.setPenColor();
		StdDraw.setFont(getFont());
		StdDraw.text(9.1, 3.99, "FORFEIT");

		for (int x = 0, i = 0; x < 8; x++, i++) {
			for (int y = 0; y < 8; y++, i++) {
				if (board[x][y] == 00) {
					if (Math.floor(i % 2) == 0) {
						board[x][y] = 02;
					}
					if (Math.floor(i % 2) != 0) {
						board[x][y] = 01;
					}
				}
				if (board[x][y] == 01) {
					StdDraw.setPenColor(getWhite());
					StdDraw.filledRectangle(x + .5, y + .5, .5, .5);
				}
				if (board[x][y] == 02) {
					StdDraw.setPenColor(Black);
					StdDraw.filledRectangle(x + .5, y + .5, .5, .5);
				}
				if ((board[x][y] != 01 && board[x][y] != 02)
						&& (Math.floor(i % 2) == 0)) {
					StdDraw.setPenColor(Black);
					StdDraw.filledRectangle(x + .5, y + .5, .5, .5);
					if (board[x][y] == 11 || board[x][y] == 71) {
						this.pawn = new Pawn(x, y, StdDraw.WHITE);
						board[x][y] = 11;
					}
					if (board[x][y] == 21 || board[x][y] == 72) {
						this.pawn = new Pawn(x, y, StdDraw.BLACK);
						board[x][y] = 21;
					}
					if (board[x][y] == 12 || board[x][y] == 81) {
						this.knight = new Knight(x, y, StdDraw.WHITE);
						board[x][y] = 12;
					}
					if (board[x][y] == 22 || board[x][y] == 82) {
						this.knight = new Knight(x, y, StdDraw.BLACK);
						board[x][y] = 22;
					}
					if (board[x][y] == 13 || board[x][y] == 91) {
						this.bishop = new Bishop(x, y, StdDraw.WHITE);
						board[x][y] = 13;
					}
					if (board[x][y] == 23 || board[x][y] == 92) {
						this.bishop = new Bishop(x, y, StdDraw.BLACK);
						board[x][y] = 23;
					}
					if (board[x][y] == 14 || board[x][y] == 101) {
						this.whiteRook1 = new Rook(x, y, StdDraw.WHITE);
						board[x][y] = 14;
					}
					if (board[x][y] == 24 || board[x][y] == 102) {
						this.blackRook1 = new Rook(x, y, StdDraw.BLACK);
						board[x][y] = 24;
					}
					if (board[x][y] == 15 || board[x][y] == 111) {
						this.queen = new Queen(x, y, StdDraw.WHITE);
						board[x][y] = 15;
					}
					if (board[x][y] == 25 || board[x][y] == 112) {
						this.queen = new Queen(x, y, StdDraw.BLACK);
						board[x][y] = 25;
					}
					if (board[x][y] == 16) {
						this.whiteKing = new King(x, y, StdDraw.WHITE);
						board[x][y] = 16;
					}
					if (board[x][y] == 121) {
						this.whiteKing = new King(x, y, StdDraw.WHITE);
						this.setIsWhiteCheck(1);
						board[x][y] = 121;
					}
					if (board[x][y] == 26) {
						this.blackKing = new King(x, y, StdDraw.BLACK);
						board[x][y] = 26;
					}
					if (board[x][y] == 122) {
						this.blackKing = new King(x, y, StdDraw.BLACK);
						this.setIsBlackCheck(1);
						board[x][y] = 122;
					}

				}
				if ((board[x][y] != 01 && board[x][y] != 02)
						&& (Math.floor(i % 2) != 0)) {
					StdDraw.setPenColor(getWhite());
					StdDraw.filledRectangle(x + .5, y + .5, .5, .5);
					if (board[x][y] == 11 || board[x][y] == 71) {
						this.pawn = new Pawn(x, y, StdDraw.WHITE);
						board[x][y] = 11;
					}
					if (board[x][y] == 21 || board[x][y] == 72) {
						this.pawn = new Pawn(x, y, StdDraw.BLACK);
						board[x][y] = 21;
					}
					if (board[x][y] == 12 || board[x][y] == 81) {
						this.knight = new Knight(x, y, StdDraw.WHITE);
						board[x][y] = 12;
					}
					if (board[x][y] == 22 || board[x][y] == 82) {
						this.knight = new Knight(x, y, StdDraw.BLACK);
						board[x][y] = 22;
					}
					if (board[x][y] == 13 || board[x][y] == 91) {
						this.bishop = new Bishop(x, y, StdDraw.WHITE);
						board[x][y] = 13;
					}
					if (board[x][y] == 23 || board[x][y] == 92) {
						this.bishop = new Bishop(x, y, StdDraw.BLACK);
						board[x][y] = 23;
					}
					if (board[x][y] == 14 || board[x][y] == 101) {
						this.whiteRook1 = new Rook(x, y, StdDraw.WHITE);
						board[x][y] = 14;
					}
					if (board[x][y] == 24 || board[x][y] == 102) {
						this.blackRook1 = new Rook(x, y, StdDraw.BLACK);
						board[x][y] = 24;
					}
					if (board[x][y] == 15 || board[x][y] == 111) {
						this.queen = new Queen(x, y, StdDraw.WHITE);
						board[x][y] = 15;
					}
					if (board[x][y] == 25 || board[x][y] == 112) {
						this.queen = new Queen(x, y, StdDraw.BLACK);
						board[x][y] = 25;
					}
					if (board[x][y] == 16) {
						this.whiteKing = new King(x, y, StdDraw.WHITE);
						board[x][y] = 16;
					}
					if (board[x][y] == 121) {
						this.whiteKing = new King(x, y, StdDraw.WHITE);
						this.setIsWhiteCheck(1);
						board[x][y] = 121;
					}
					if (board[x][y] == 26) {
						this.blackKing = new King(x, y, StdDraw.BLACK);
						board[x][y] = 26;
					}
					if (board[x][y] == 122) {
						this.blackKing = new King(x, y, StdDraw.BLACK);
						this.setIsBlackCheck(1);
						board[x][y] = 122;
					}

				}
			}
		}
		whitePieces();
		blackPieces();
		StdDraw.show(70);
		drawTakenPieces();
	}

	// For running simulations
	public void redrawBoardWithoutShowing() {
		for (int x = 0, i = 0; x < 8; x++, i++) {
			for (int y = 0; y < 8; y++, i++) {
				if (board[x][y] == 00) {
					if (Math.floor(i % 2) == 0) {
						board[x][y] = 02;
					}
					if (Math.floor(i % 2) != 0) {
						board[x][y] = 01;
					}
				}
				if (board[x][y] == 01) {
					StdDraw.setPenColor(getWhite());
					StdDraw.filledRectangle(x + .5, y + .5, .5, .5);
				}
				if (board[x][y] == 02) {
					StdDraw.setPenColor(Black);
					StdDraw.filledRectangle(x + .5, y + .5, .5, .5);
				}
				if ((board[x][y] != 01 && board[x][y] != 02)
						&& (Math.floor(i % 2) == 0)) {
					StdDraw.setPenColor(Black);
					StdDraw.filledRectangle(x + .5, y + .5, .5, .5);
					if (board[x][y] == 11 || board[x][y] == 71) {
						// this.pawn = new Pawn(x, y, StdDraw.WHITE);
						board[x][y] = 11;
					}
					if (board[x][y] == 21 || board[x][y] == 72) {
						// this.pawn = new Pawn(x, y, StdDraw.BLACK);
						board[x][y] = 21;
					}
					if (board[x][y] == 12 || board[x][y] == 81) {
						// this.knight = new Knight(x, y, StdDraw.WHITE);
						board[x][y] = 12;
					}
					if (board[x][y] == 22 || board[x][y] == 82) {
						// this.knight = new Knight(x, y, StdDraw.BLACK);
						board[x][y] = 22;
					}
					if (board[x][y] == 13 || board[x][y] == 91) {
						// this.bishop = new Bishop(x, y, StdDraw.WHITE);
						board[x][y] = 13;
					}
					if (board[x][y] == 23 || board[x][y] == 92) {
						// this.bishop = new Bishop(x, y, StdDraw.BLACK);
						board[x][y] = 23;
					}
					if (board[x][y] == 14 || board[x][y] == 101) {
						// this.whiteRook1 = new Rook(x, y, StdDraw.WHITE);
						board[x][y] = 14;
					}
					if (board[x][y] == 24 || board[x][y] == 102) {
						// this.blackRook1 = new Rook(x, y, StdDraw.BLACK);
						board[x][y] = 24;
					}
					if (board[x][y] == 15 || board[x][y] == 111) {
						// this.queen = new Queen(x, y, StdDraw.WHITE);
						board[x][y] = 15;
					}
					if (board[x][y] == 25 || board[x][y] == 112) {
						// this.queen = new Queen(x, y, StdDraw.BLACK);
						board[x][y] = 25;
					}
					if (board[x][y] == 16) {
						// this.whiteKing = new King(x, y, StdDraw.WHITE);
						board[x][y] = 16;
					}
					if (board[x][y] == 121) {
						// this.whiteKing = new King(x, y, StdDraw.WHITE);
						this.setIsWhiteCheck(1);
						board[x][y] = 121;
					}
					if (board[x][y] == 26) {
						// this.blackKing = new King(x, y, StdDraw.BLACK);
						board[x][y] = 26;
					}
					if (board[x][y] == 122) {
						// this.blackKing = new King(x, y, StdDraw.BLACK);
						this.setIsBlackCheck(1);
						board[x][y] = 122;
					}

				}
				if ((board[x][y] != 01 && board[x][y] != 02)
						&& (Math.floor(i % 2) != 0)) {
					StdDraw.setPenColor(getWhite());
					StdDraw.filledRectangle(x + .5, y + .5, .5, .5);
					if (board[x][y] == 11 || board[x][y] == 71) {
						// this.pawn = new Pawn(x, y, StdDraw.WHITE);
						board[x][y] = 11;
					}
					if (board[x][y] == 21 || board[x][y] == 72) {
						// this.pawn = new Pawn(x, y, StdDraw.BLACK);
						board[x][y] = 21;
					}
					if (board[x][y] == 12 || board[x][y] == 81) {
						// this.knight = new Knight(x, y, StdDraw.WHITE);
						board[x][y] = 12;
					}
					if (board[x][y] == 22 || board[x][y] == 82) {
						// this.knight = new Knight(x, y, StdDraw.BLACK);
						board[x][y] = 22;
					}
					if (board[x][y] == 13 || board[x][y] == 91) {
						// this.bishop = new Bishop(x, y, StdDraw.WHITE);
						board[x][y] = 13;
					}
					if (board[x][y] == 23 || board[x][y] == 92) {
						// this.bishop = new Bishop(x, y, StdDraw.BLACK);
						board[x][y] = 23;
					}
					if (board[x][y] == 14 || board[x][y] == 101) {
						// this.whiteRook1 = new Rook(x, y, StdDraw.WHITE);
						board[x][y] = 14;
					}
					if (board[x][y] == 24 || board[x][y] == 102) {
						// this.blackRook1 = new Rook(x, y, StdDraw.BLACK);
						board[x][y] = 24;
					}
					if (board[x][y] == 15 || board[x][y] == 111) {
						// this.queen = new Queen(x, y, StdDraw.WHITE);
						board[x][y] = 15;
					}
					if (board[x][y] == 25 || board[x][y] == 112) {
						// this.queen = new Queen(x, y, StdDraw.BLACK);
						board[x][y] = 25;
					}
					if (board[x][y] == 16) {
						// this.whiteKing = new King(x, y, StdDraw.WHITE);
						board[x][y] = 16;
					}
					if (board[x][y] == 121) {
						// this.whiteKing = new King(x, y, StdDraw.WHITE);
						this.setIsWhiteCheck(1);
						board[x][y] = 121;
					}
					if (board[x][y] == 26) {
						// this.blackKing = new King(x, y, StdDraw.BLACK);
						board[x][y] = 26;
					}
					if (board[x][y] == 122) {
						// this.blackKing = new King(x, y, StdDraw.BLACK);
						this.setIsBlackCheck(1);
						board[x][y] = 122;
					}

				}
			}
		}
		whitePieces();
		blackPieces();
	}

	// Based on the stored value in the board array, return the piece that sits
	// in that location
	public String getPieceNameAtSquare(int i, int whoseTurn) {
		if (i == 00 || i > 70) {
			return "Move";
		}

		if (i == 00 || i > 70) {
			return "Move";
		}

		if (i == 01 || i == 02) {
			return "Empty";
		}
		if (i == 11) {
			return "White Pawn";
		}
		if (i == 21) {
			return "Black Pawn";
		}
		if (i == 12) {
			return "White Knight";
		}
		if (i == 22) {
			return "Black Knight";
		}
		if (i == 13) {
			return "White Bishop";
		}
		if (i == 23) {
			return "Black Bishop";
		}
		if (i == 14) {
			return "White Rook";
		}
		if (i == 24) {
			return "Black Rook";
		}
		if (i == 15) {
			return "White Queen";
		}
		if (i == 25) {
			return "Black Queen";
		}
		if (i == 16) {
			return "White King";
		}
		if (i == 26) {
			return "Black King";
		} else
			return null;
	}

	// Essentially the run function
	public int runMove(double mouseX, double mouseY) {
		// Find mouse location, floor to the bottom righthand corner of the
		// square
		int gameOn = 0;
		int x = (int) Math.floor(mouseX);
		int y = (int) Math.floor(mouseY);

		if (x >= 8 || y >= 8) {
			if ((mouseX > 8.2 && mouseX < 9.8)
					&& (mouseY > 3.75 && mouseY < 4.25)) {
				return 1;
			}
			return 0;
		}

		// Add to the number of clicks
		String clicks = String.valueOf(x) + String.valueOf(y);
		this.clicks[clickNumber] = clicks;

		// If it is white's turn
		if (whoseTurn == 0) {
			this.setWhiteKingMovesCheck(0);
			this.setBlackKingMovesCheck(0);
			isInCheck(whiteInDanger, blackInDanger);
			isInCheckmate(0);
			// if (isDraw() == 1 && this.isWhiteCheckmate == 0) {
			// return 1;
			// }
			// If a piece is double clicked, turn it off
			if (this.clickNumber != 0
					&& this.clicks[this.clickNumber]
							.equals(this.clicks[clickNumber - 1])) {
				redrawBoard();
			}
			piecesInDanger();

			// If an invalid board space is clicked, turn off any lines showing
			// possible moves
			if (!getPieceNameAtSquare(board[x][y], whoseTurn).equals("Move")) {
				redrawBoard();
			}
			// Only allowed to click on white pieces
			if (board[x][y] < 20 || board[x][y] == 121) {
				showPossibleMoves(board[x][y], x, y);
			}

			// If that piece is allowed to move there
			if (getPieceNameAtSquare(board[x][y], whoseTurn).equals("Move")) {
				isInCheck(whiteInDanger, blackInDanger);
				// Determine the piece from the previous click
				String pieceXY = this.clicks[clickNumber - 1];
				int pieceX = (int) pieceXY.charAt(0) - 48;
				int pieceY = (int) pieceXY.charAt(1) - 48;
				int pieceName = board[pieceX][pieceY];
				int boardName = board[x][y];
				// These if statements only apply to castling
				// A king can only castle if neither it nor the rook has
				// moved before
				if ((pieceX == 0 && pieceY == 0) && board[pieceX][pieceY] == 14) {
					this.setWhiteRook1Moves(1);
				}
				if ((pieceX == 7 && pieceY == 0) && board[pieceX][pieceY] == 14) {
					this.setWhiteRook2Moves(1);
				}
				if ((pieceX == 4 && pieceY == 0) && board[pieceX][pieceY] == 16) {
					this.setWhiteKingMoves(1);
					if (x == 6) {
						board[5][0] = 14;
						board[7][0] = 0;
					}
					if (x == 1) {
						board[2][0] = 14;
						board[0][0] = 0;
					}
				}
				// Switch array elements
				board[x][y] = board[pieceX][pieceY];
				board[pieceX][pieceY] = 0;
				if (board[0][7] == pieceName) {
					this.setBlackRook1Moves(1);
				}
				if (board[7][7] == pieceName) {
					this.setBlackRook2Moves(1);
				}
				redrawBoardWithoutShowing();
				piecesInDanger();

				if (this.isWhiteCheck == 1) {
					board[x][y] = boardName;
					board[pieceX][pieceY] = pieceName;
					redrawBoard();
					piecesInDanger();
					return gameOn;
				}
				if (this.isWhiteCheck != 1) {
					whoseTurn = 1;
					redrawBoard();
					piecesInDanger();
					if (this.isBlackCheck == 1) {
						int kingMoves = isInCheckmate(0);
						System.out.println("King Moves" + kingMoves);
						if (kingMoves != 0) {
							gameOn = 0;
						}
						if (kingMoves == 0) {
							gameOn = 1;
						}
					}
					if (pieceName == 11 && y == 7) {
						pawnPromotion();
					}
					if (boardName > 70) {
						setTakenPieces(boardName);
						drawTakenPieces();
					}
					return gameOn;
				}
			}

			this.clickNumber++;
			return gameOn;
		}
		if (whoseTurn == 1) {
			this.setWhiteKingMovesCheck(0);
			this.setBlackKingMovesCheck(0);
			isInCheck(whiteInDanger, blackInDanger);
			isInCheckmate(1);
			// if (isDraw() == 1 && this.isBlackCheckmate == 0) {
			// return 1;
			// }
			if (this.clickNumber != 0
					&& this.clicks[this.clickNumber]
							.equals(this.clicks[clickNumber - 1])) {
				redrawBoard();
			}
			piecesInDanger();

			if (!getPieceNameAtSquare(board[x][y], whoseTurn).equals("Move")) {
				redrawBoard();
			}
			if ((board[x][y] > 20 && board[x][y] < 30) || board[x][y] == 122) {
				showPossibleMoves(board[x][y], x, y);
			}
			if (getPieceNameAtSquare(board[x][y], whoseTurn).equals("Move")) {
				isInCheck(whiteInDanger, blackInDanger);
				String pieceXY = this.clicks[clickNumber - 1];
				int pieceX = (int) pieceXY.charAt(0) - 48;
				int pieceY = (int) pieceXY.charAt(1) - 48;
				int pieceName = board[pieceX][pieceY];
				int boardName = board[x][y];

				if ((pieceX == 0 && pieceY == 7) && board[pieceX][pieceY] == 24) {
					this.setBlackRook1Moves(1);
				}
				if ((pieceX == 7 && pieceY == 7) && board[pieceX][pieceY] == 24) {
					this.setBlackRook2Moves(1);
				}
				if ((pieceX == 4 && pieceY == 7) && board[pieceX][pieceY] == 26) {
					this.setBlackKingMoves(1);
					if (x == 6) {
						board[5][7] = 24;
						board[7][7] = 0;
					}
					if (x == 1) {
						board[2][7] = 24;
						board[0][7] = 0;
					}
				}
				board[x][y] = board[pieceX][pieceY];
				board[pieceX][pieceY] = 0;
				if (board[0][0] == pieceName) {
					this.setWhiteRook1Moves(1);
				}
				if (board[7][0] == pieceName) {
					this.setWhiteRook2Moves(1);
				}
				redrawBoardWithoutShowing();
				piecesInDanger();

				if (this.isBlackCheck == 1) {
					board[x][y] = boardName;
					board[pieceX][pieceY] = pieceName;
					redrawBoard();
					piecesInDanger();
					return gameOn;
				}
				if (this.isBlackCheck != 1) {
					whoseTurn = 0;
					redrawBoard();
					piecesInDanger();
					if (this.isWhiteCheck == 1) {
						int kingMoves = isInCheckmate(1);
						System.out.println("King Moves" + kingMoves);
						if (kingMoves != 0) {
							gameOn = 0;
						}
						if (kingMoves == 0) {
							gameOn = 1;
						}
					}
					if (pieceName == 21 && y == 0) {
						pawnPromotion();
					}
					if (boardName > 70) {
						setTakenPieces(boardName);
						drawTakenPieces();
					}
					return gameOn;
				}
			}
			this.clickNumber++;
		}
		return gameOn;
	}

	private void setTakenPieces(int takenPiece) {
		if (takenPiece == 71) {
			whiteTakenPieces[0]++;
		}
		if (takenPiece == 81) {
			whiteTakenPieces[1]++;
		}
		if (takenPiece == 91) {
			whiteTakenPieces[2]++;
		}
		if (takenPiece == 101) {
			whiteTakenPieces[3]++;
		}
		if (takenPiece == 111) {
			whiteTakenPieces[4]++;
		}
		if (takenPiece == 72) {
			blackTakenPieces[0]++;
		}
		if (takenPiece == 82) {
			blackTakenPieces[1]++;
		}
		if (takenPiece == 92) {
			blackTakenPieces[2]++;
		}
		if (takenPiece == 102) {
			blackTakenPieces[3]++;
		}
		if (takenPiece == 112) {
			blackTakenPieces[4]++;
		}

	}

	private void drawTakenPieces() {
		if (whiteTakenPieces[0] == 1) {
			StdDraw.picture(8.5, 2.2, "Chess" + java.io.File.separator
					+ "WhitePawn.png", .25, .35);
			StdDraw.show(1);
		}
		if (whiteTakenPieces[0] > 1) {
			StdDraw.picture(8.5, 2.2, "Chess" + java.io.File.separator
					+ "WhitePawn.png", .25, .35);
			StdDraw.setPenColor();
			StdDraw.text(9, 2.2, "x" + whiteTakenPieces[0]);
			StdDraw.show(1);
		}
		if (whiteTakenPieces[1] == 1) {
			StdDraw.picture(8.5, 1.85, "Chess" + java.io.File.separator
					+ "WhiteKnight.png", .25, .35);
			StdDraw.show(1);
		}
		if (whiteTakenPieces[1] > 1) {
			StdDraw.picture(8.5, 1.85, "Chess" + java.io.File.separator
					+ "WhiteKnight.png", .25, .35);
			StdDraw.setPenColor();
			StdDraw.text(9, 1.85, "x" + whiteTakenPieces[1]);
			StdDraw.show(1);
		}
		if (whiteTakenPieces[2] == 1) {
			StdDraw.picture(8.5, 1.5, "Chess" + java.io.File.separator
					+ "WhiteBishop.png", .25, .35);
			StdDraw.show(1);
		}
		if (whiteTakenPieces[2] > 1) {
			StdDraw.picture(8.5, 1.5, "Chess" + java.io.File.separator
					+ "WhiteBishop.png", .25, .35);
			StdDraw.setPenColor();
			StdDraw.text(9, 1.5, "x" + whiteTakenPieces[2]);
			StdDraw.show(1);
		}
		if (whiteTakenPieces[3] == 1) {
			StdDraw.picture(8.5, 1.15, "Chess" + java.io.File.separator
					+ "WhiteRook.png", .25, .35);
			StdDraw.show(1);
		}
		if (whiteTakenPieces[3] > 1) {
			StdDraw.picture(8.5, 1.15, "Chess" + java.io.File.separator
					+ "WhiteRook.png", .25, .35);
			StdDraw.setPenColor();
			StdDraw.text(9, 1.15, "x" + whiteTakenPieces[3]);
			StdDraw.show(1);
		}
		if (whiteTakenPieces[4] == 1) {
			StdDraw.picture(8.5, .7, "Chess" + java.io.File.separator
					+ "WhiteQueen.png", .2, .4);
			StdDraw.show(1);
		}
		if (whiteTakenPieces[4] > 1) {
			StdDraw.picture(8.5, .8, "Chess" + java.io.File.separator
					+ "WhiteQueen.png", .2, .4);
			StdDraw.setPenColor();
			StdDraw.text(9, .8, "x" + whiteTakenPieces[4]);
			StdDraw.show(1);
		}
		if (blackTakenPieces[0] == 1) {
			StdDraw.picture(8.5, 7.4, "Chess" + java.io.File.separator
					+ "BlackPawn.png", .25, .35);
			StdDraw.show(1);
		}
		if (blackTakenPieces[0] > 1) {
			StdDraw.picture(8.5, 7.4, "Chess" + java.io.File.separator
					+ "BlackPawn.png", .25, .35);
			StdDraw.setPenColor();
			StdDraw.text(9, 7.4, "x" + blackTakenPieces[0]);
			StdDraw.show(1);
		}
		if (blackTakenPieces[1] == 1) {
			StdDraw.picture(8.5, 7.05, "Chess" + java.io.File.separator
					+ "BlackKnight.png", .25, .35);
			StdDraw.show(1);
		}
		if (blackTakenPieces[1] > 1) {
			StdDraw.picture(8.5, 7.05, "Chess" + java.io.File.separator
					+ "BlackKnight.png", .25, .35);
			StdDraw.setPenColor();
			StdDraw.text(9, 6.9, "x" + blackTakenPieces[1]);
			StdDraw.show(1);
		}
		if (blackTakenPieces[2] == 1) {
			StdDraw.picture(8.5, 6.7, "Chess" + java.io.File.separator
					+ "BlackBishop.png", .25, .35);
			StdDraw.show(1);
		}
		if (blackTakenPieces[2] > 1) {
			StdDraw.picture(8.5, 6.7, "Chess" + java.io.File.separator
					+ "BlackBishop.png", .25, .35);
			StdDraw.setPenColor();
			StdDraw.text(9, 6.7, "x" + blackTakenPieces[2]);
			StdDraw.show(1);
		}
		if (blackTakenPieces[3] == 1) {
			StdDraw.picture(8.5, 6.35, "Chess" + java.io.File.separator
					+ "BlackRook.png", .25, .35);
			StdDraw.show(1);
		}
		if (blackTakenPieces[3] > 1) {
			StdDraw.picture(8.5, 6.35, "Chess" + java.io.File.separator
					+ "BlackRook.png", .25, .35);
			StdDraw.setPenColor();
			StdDraw.text(9, 6.35, "x" + blackTakenPieces[3]);
			StdDraw.show(1);
		}
		if (blackTakenPieces[4] == 1) {
			StdDraw.picture(8.5, 6, "Chess" + java.io.File.separator
					+ "BlackQueen.png", .25, .35);
			StdDraw.show(1);
		}
		if (blackTakenPieces[4] > 1) {
			StdDraw.picture(8.5, 6, "Chess" + java.io.File.separator
					+ "BlackQueen.png", .25, .35);
			StdDraw.setPenColor();
			StdDraw.text(9, 6, "x" + blackTakenPieces[4]);
			StdDraw.show(1);
		}
	}

	// Directs show move function to correct piece
	public void showPossibleMoves(int i, int x, int y) {
		// Send out values to the various objects to return possible moves
		if (i == 01 || i == 02) {
			return;
		}
		if (i == 11 || i == 21) {
			this.pawn.possibleMoves(i, x, y, board);
		}
		if (i == 12 || i == 22) {
			this.knight.possibleMoves(i, x, y, board);
		}
		if (i == 13 || i == 23) {
			this.bishop.possibleMoves(i, x, y, board);
		}
		if (i == 14 || i == 24) {
			this.whiteRook1.possibleMoves(i, x, y, board);
		}
		if (i == 15 || i == 25) {
			this.queen.possibleMoves(i, x, y, board);
		}
		if (i == 16) {
			isInCheck(whiteInDanger, blackInDanger);
			this.whiteKing.possibleMoves(i, x, y, board,
					this.getWhiteKingMoves(), this.getWhiteRook1Moves(),
					this.getWhiteRook2Moves(), getIsWhiteCheck());
			System.out.println(getIsWhiteCheck());
		}
		if (i == 26) {
			isInCheck(whiteInDanger, blackInDanger);
			this.blackKing.possibleMoves(i, x, y, board,
					this.getBlackKingMoves(), this.getBlackRook1Moves(),
					this.getBlackRook2Moves(), getIsBlackCheck());
			System.out.println(getIsBlackCheck());

		} else
			return;
	}

	// records current position of white pieces
	public void whitePieces() {
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				if (board[x][y] < 3 || (board[x][y] > 20 && board[x][y] < 30)) {
					whitePieces[x][y] = ' ';
				}
				if (board[x][y] > 10 && board[x][y] < 20) {
					char piece = String.valueOf(board[x][y]).charAt(1);
					whitePieces[x][y] = piece;

				}
			}
		}
		 System.out.println("White");
		 System.out.println(Arrays.deepToString(whitePieces).replaceAll("],",
		 "]," + System.getProperty("line.separator")));
	}

	// records current position of black pieces
	public void blackPieces() {
		for (int y = 0; y < 8; y++) {
			for (int x = 0; x < 8; x++) {
				if (board[x][y] < 3 || (board[x][y] > 10 && board[x][y] < 20)) {
					blackPieces[x][y] = ' ';
				}
				if (board[x][y] > 20 && board[x][y] < 30) {
					char piece = String.valueOf(board[x][y]).charAt(1);
					if (piece != '1') {
						blackPieces[x][y] = piece;
					}
					if (piece == '1') {
						blackPieces[x][y] = '/';
					}
				}
			}
		}
		 System.out.println("Black");
		 System.out.println(Arrays.deepToString(blackPieces).replaceAll("],",
		 "]" + System.getProperty("line.separator")));
	}

	// Checks which pieces are in danger
	public void piecesInDanger() {
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				whiteInDanger[x][y] = 0;
				blackInDanger[x][y] = 0;
			}
		}
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				// Check which white pieces are in danger from which black
				// pieces
				this.blackKing.checkDanger(x, y, blackPieces, whitePieces,
						whiteInDanger, 0);
				this.blackKing.checkDanger(x, y, whitePieces, blackPieces,
						blackInDanger, 1);
			}
		}
		// Check for check
		isInCheck(whiteInDanger, blackInDanger);
		 System.out.println("Board");
		 System.out.println(Arrays.deepToString(board).replaceAll("],",
		 "]" + System.getProperty("line.separator")));
		 System.out.println("White Pieces In Danger");
		 System.out.println(Arrays.deepToString(whiteInDanger).replaceAll("],",
		 "]" + System.getProperty("line.separator")));
		
		 System.out.println("Black Pieces In Danger");
		 System.out.println(Arrays.deepToString(blackInDanger).replaceAll("],",
		 "]" + System.getProperty("line.separator")));

	}

	// Checks if king is in check
	public int isInCheck(int[][] whiteInDanger, int[][] blackInDanger) {
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				whiteInDanger[x][y] = 0;
				blackInDanger[x][y] = 0;
			}
		}
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				// Check which white pieces are in danger from which black
				// pieces
				this.whiteKing.checkDanger(x, y, blackPieces, whitePieces,
						whiteInDanger, 0);
				this.whiteKing.checkDanger(x, y, whitePieces, blackPieces,
						blackInDanger, 1);
			}
		}
		for (int x = 0, i = 0, j = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				if (whiteInDanger[x][y] == 6) {
					i++;
				}
				if (blackInDanger[x][y] == 6) {
					j++;
				}
				if (i > 0) {
					this.setIsWhiteCheck(1);
				} else {
					this.setIsWhiteCheck(0);
				}
				if (j > 0) {
					this.setIsBlackCheck(1);
				} else {
					this.setIsBlackCheck(0);
				}

			}
		}
		if (this.getIsWhiteCheck() == 1) {
			return 1;
			// System.out.println("White in Check");
		}
		if (this.getIsBlackCheck() == 1) {
			return 1;
			// System.out.println("Black in Check");
		}
		return 0;
	}

	// Checks if king is in checkmate
	public int isInCheckmate(int whoseTurn) {
		if (whoseTurn == 1 && this.getIsWhiteCheck() == 0) {
			return 8;
		}
		if (whoseTurn == 0 && this.getIsBlackCheck() == 0) {
			return 8;
		}

		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				whiteInDanger[x][y] = 0;
				blackInDanger[x][y] = 0;
			}
		}
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				// Check which white pieces are in danger from which black
				// pieces
				this.whiteKing.checkDanger(x, y, blackPieces, whitePieces,
						whiteInDanger, 0);
				this.whiteKing.checkDanger(x, y, whitePieces, blackPieces,
						blackInDanger, 1);
			}
		}
		int i = 0;
		int j = 0;
		for (int x = 0, k = 0; x < 8; x++, k++) {
			for (int y = 0; y < 8; y++, k++) {
				if (whiteInDanger[x][y] == 9 && blackInDanger[x][y] > 0) {
					i++;
				}
				if (blackInDanger[x][y] == 9 && whiteInDanger[x][y] > 0) {
					j++;
				}
				if (board[x][y] == 16 && whoseTurn == 1) {
					if (y < 7
							&& (board[x][y + 1] < 3 || (board[x][y + 1] > 20 && board[x][y + 1] < 30))) {
						int piece = board[x][y + 1];
						board[x][y + 1] = 16;
						board[x][y] = 0;
						redrawBoardWithoutShowing();
						piecesInDanger();

						if (this.isWhiteCheck == 1) {
							board[x][y] = 16;
							board[x][y + 1] = piece;
							redrawBoard();
							piecesInDanger();
						}
						if (this.isWhiteCheck != 1) {
							board[x][y] = 16;
							board[x][y + 1] = piece;
							redrawBoard();
							piecesInDanger();
							i++;
						}
					}
					if (y > 0
							&& (board[x][y - 1] < 3 || (board[x][y - 1] > 20 && board[x][y - 1] < 30))) {
						int piece = board[x][y - 1];
						board[x][y - 1] = 16;
						board[x][y] = 0;
						redrawBoardWithoutShowing();
						piecesInDanger();

						if (this.isWhiteCheck == 1) {
							board[x][y] = 16;
							board[x][y - 1] = piece;
							redrawBoard();
							piecesInDanger();
						}
						if (this.isWhiteCheck != 1) {
							board[x][y] = 16;
							board[x][y - 1] = piece;
							redrawBoard();
							piecesInDanger();
							i++;
						}
					}
					if (x > 0
							&& (board[x - 1][y] < 3 || (board[x - 1][y] > 20 && board[x - 1][y] < 30))) {
						int piece = board[x - 1][y];
						board[x - 1][y] = 16;
						board[x][y] = 0;
						redrawBoardWithoutShowing();
						piecesInDanger();

						if (this.isWhiteCheck == 1) {
							board[x][y] = 16;
							board[x - 1][y] = piece;
							redrawBoard();
							piecesInDanger();
						}
						if (this.isWhiteCheck != 1) {
							board[x][y] = 16;
							board[x - 1][y] = piece;
							redrawBoard();
							piecesInDanger();
							i++;
						}
					}
					if (x < 7
							&& (board[x + 1][y] < 3 || (board[x + 1][y] > 20 && board[x + 1][y] < 30))) {
						int piece = board[x + 1][y];
						board[x + 1][y] = 16;
						board[x][y] = 0;
						redrawBoardWithoutShowing();
						piecesInDanger();

						if (this.isWhiteCheck == 1) {
							board[x][y] = 16;
							board[x + 1][y] = piece;
							redrawBoard();
							piecesInDanger();
						}
						if (this.isWhiteCheck != 1) {
							board[x][y] = 16;
							board[x + 1][y] = piece;
							redrawBoard();
							piecesInDanger();
							i++;
						}
					}
					if ((x + 1 < 8 && y + 1 < 8)
							&& (board[x + 1][y + 1] < 3 || (board[x + 1][y + 1] > 20 && board[x + 1][y + 1] < 30))) {
						int piece = board[x + 1][y + 1];
						board[x + 1][y + 1] = 16;
						board[x][y] = 0;
						redrawBoardWithoutShowing();
						piecesInDanger();

						if (this.isWhiteCheck == 1) {
							board[x][y] = 16;
							board[x + 1][y + 1] = piece;
							redrawBoard();
							piecesInDanger();
						}
						if (this.isWhiteCheck != 1) {
							board[x][y] = 16;
							board[x + 1][y + 1] = piece;
							redrawBoard();
							piecesInDanger();
							i++;
						}
					}
					if ((x - 1 >= 0 && y - 1 >= 0)
							&& (board[x - 1][y - 1] < 3 || (board[x - 1][y - 1] > 20 && board[x - 1][y - 1] < 30))) {
						int piece = board[x - 1][y - 1];
						board[x - 1][y - 1] = 16;
						board[x][y] = 0;
						redrawBoardWithoutShowing();
						piecesInDanger();

						if (this.isWhiteCheck == 1) {
							board[x][y] = 16;
							board[x - 1][y - 1] = piece;
							redrawBoard();
							piecesInDanger();
						}
						if (this.isWhiteCheck != 1) {
							board[x][y] = 16;
							board[x - 1][y - 1] = piece;
							redrawBoard();
							piecesInDanger();
							i++;
						}
					}
					if ((x + 1 < 8 && y - 1 >= 0)
							&& (board[x + 1][y - 1] < 3 || (board[x + 1][y - 1] > 20 && board[x + 1][y - 1] < 30))) {
						int piece = board[x + 1][y - 1];
						board[x + 1][y - 1] = 16;
						board[x][y] = 0;
						redrawBoardWithoutShowing();
						piecesInDanger();

						if (this.isWhiteCheck == 1) {
							board[x][y] = 16;
							board[x + 1][y - 1] = piece;
							redrawBoard();
							piecesInDanger();
						}
						if (this.isWhiteCheck != 1) {
							board[x][y] = 16;
							board[x + 1][y - 1] = piece;
							redrawBoard();
							piecesInDanger();
							i++;
						}
					}
					if ((x - 1 >= 0 && y + 1 < 8)
							&& (board[x - 1][y + 1] < 3 || (board[x - 1][y + 1] > 20 && board[x - 1][y + 1] < 30))) {
						int piece = board[x - 1][y + 1];
						board[x - 1][y + 1] = 16;
						board[x][y] = 0;
						redrawBoardWithoutShowing();
						piecesInDanger();

						if (this.isWhiteCheck == 1) {
							board[x][y] = 16;
							board[x - 1][y + 1] = piece;
							redrawBoard();
							piecesInDanger();
						}
						if (this.isWhiteCheck != 1) {
							board[x][y] = 16;
							board[x - 1][y + 1] = piece;
							redrawBoard();
							piecesInDanger();
							i++;
						}
					}
				}
				if (board[x][y] == 26 && whoseTurn == 0) {
					if (y < 7
							&& (board[x][y + 1] < 3 || (board[x][y + 1] > 10 && board[x][y + 1] < 20))) {
						int piece = board[x][y + 1];
						board[x][y + 1] = 26;
						board[x][y] = 0;
						redrawBoardWithoutShowing();
						piecesInDanger();

						if (this.isBlackCheck == 1) {
							board[x][y] = 26;
							board[x][y + 1] = piece;
							redrawBoard();
							piecesInDanger();
						}
						if (this.isBlackCheck != 1) {
							board[x][y] = 26;
							board[x][y + 1] = piece;
							redrawBoard();
							piecesInDanger();
							j++;
						}
					}
					if (y > 0
							&& (board[x][y - 1] < 3 || (board[x][y - 1] > 10 && board[x][y - 1] < 20))) {
						int piece = board[x][y - 1];
						board[x][y - 1] = 26;
						board[x][y] = 0;
						redrawBoardWithoutShowing();
						piecesInDanger();

						if (this.isBlackCheck == 1) {
							board[x][y] = 26;
							board[x][y - 1] = piece;
							redrawBoard();
							piecesInDanger();
						}
						if (this.isBlackCheck != 1) {
							board[x][y] = 26;
							board[x][y - 1] = piece;
							redrawBoard();
							piecesInDanger();
							j++;
						}
					}
					if (x > 0
							&& (board[x - 1][y] < 3 || (board[x - 1][y] > 10 && board[x - 1][y] < 20))) {
						int piece = board[x - 1][y];
						board[x - 1][y] = 26;
						board[x][y] = 0;
						redrawBoardWithoutShowing();
						piecesInDanger();

						if (this.isBlackCheck == 1) {
							board[x][y] = 26;
							board[x - 1][y] = piece;
							redrawBoard();
							piecesInDanger();
						}
						if (this.isBlackCheck != 1) {
							board[x][y] = 26;
							board[x - 1][y] = piece;
							redrawBoard();
							piecesInDanger();
							j++;
						}
					}
					if (x < 7
							&& (board[x + 1][y] < 3 || (board[x + 1][y] > 10 && board[x + 1][y] < 20))) {
						int piece = board[x + 1][y];
						board[x + 1][y] = 26;
						board[x][y] = 0;
						redrawBoardWithoutShowing();
						piecesInDanger();

						if (this.isBlackCheck == 1) {
							board[x][y] = 26;
							board[x + 1][y] = piece;
							redrawBoard();
							piecesInDanger();
						}
						if (this.isBlackCheck != 1) {
							board[x][y] = 26;
							board[x + 1][y] = piece;
							redrawBoard();
							piecesInDanger();
							j++;
						}
					}
					if ((x + 1 < 8 && y + 1 < 8)
							&& (board[x + 1][y + 1] < 3 || (board[x + 1][y + 1] > 10 && board[x + 1][y + 1] < 20))) {
						int piece = board[x + 1][y + 1];
						board[x + 1][y + 1] = 26;
						board[x][y] = 0;
						redrawBoardWithoutShowing();
						piecesInDanger();

						if (this.isBlackCheck == 1) {
							board[x][y] = 26;
							board[x + 1][y + 1] = piece;
							redrawBoard();
							piecesInDanger();
						}
						if (this.isBlackCheck != 1) {
							board[x][y] = 26;
							board[x + 1][y + 1] = piece;
							redrawBoard();
							piecesInDanger();
							j++;
						}
					}
					if ((x - 1 >= 0 && y - 1 >= 0)
							&& (board[x - 1][y - 1] < 3 || (board[x - 1][y - 1] > 10 && board[x - 1][y - 1] < 20))) {
						int piece = board[x - 1][y - 1];
						board[x - 1][y - 1] = 26;
						board[x][y] = 0;
						redrawBoardWithoutShowing();
						piecesInDanger();

						if (this.isBlackCheck == 1) {
							board[x][y] = 26;
							board[x - 1][y - 1] = piece;
							redrawBoard();
							piecesInDanger();
						}
						if (this.isBlackCheck != 1) {
							board[x][y] = 26;
							board[x - 1][y - 1] = piece;
							redrawBoard();
							piecesInDanger();
							j++;
						}
					}
					if ((x + 1 < 8 && y - 1 >= 0)
							&& (board[x + 1][y - 1] < 3 || (board[x + 1][y - 1] > 10 && board[x + 1][y - 1] < 20))) {
						int piece = board[x + 1][y - 1];
						board[x][y] = 0;
						redrawBoardWithoutShowing();
						piecesInDanger();

						if (this.isBlackCheck == 1) {
							board[x][y] = 26;
							board[x + 1][y - 1] = piece;
							redrawBoard();
							piecesInDanger();
						}
						if (this.isBlackCheck != 1) {
							board[x][y] = 26;
							board[x + 1][y - 1] = piece;
							redrawBoard();

							piecesInDanger();
							j++;
						}
					}
					if ((x - 1 >= 0 && y + 1 < 8)
							&& (board[x - 1][y + 1] < 3 || (board[x - 1][y + 1] > 10 && board[x - 1][y + 1] < 20))) {
						int piece = board[x - 1][y + 1];
						board[x - 1][y + 1] = 26;
						board[x][y] = 0;
						redrawBoardWithoutShowing();
						piecesInDanger();

						if (this.isBlackCheck == 1) {
							board[x][y] = 26;
							board[x - 1][y + 1] = piece;
							redrawBoard();
							piecesInDanger();
						}
						if (this.isBlackCheck != 1) {
							board[x][y] = 26;
							board[x - 1][y + 1] = piece;
							redrawBoard();
							piecesInDanger();
							j++;
						}
					}
				}
			}
		}
		if (whoseTurn == 1) {
			if (i > 0) {
				System.out.println("i:" + i);
				this.setIsWhiteCheckmate(0);
				System.out.println("White Not Checkmate");
				this.setWhiteKingMovesCheck(i);
				return i;
			}
			if (i == 0) {
				System.out.println("i:" + i);
				this.setIsWhiteCheckmate(1);
				System.out.println("White Checkmate");
				StdDraw.setPenColor(StdDraw.WHITE);
				StdDraw.setFont(getFont());
				StdDraw.text(9.1, 4, "BLACK WINS");
				StdDraw.show(1);
				this.setWhiteKingMovesCheck(i);
				return i;
			}
		}
		if (whoseTurn == 0) {
			if (j > 0) {
				System.out.println("j:" + j);
				this.setIsBlackCheckmate(0);
				System.out.println("Black Not Checkmate");
				this.setWhiteKingMovesCheck(j);
				return j;
			}
			if (j == 0) {
				System.out.println("j:" + j);
				this.setIsWhiteCheckmate(1);
				System.out.println("Black Checkmate");
				StdDraw.setPenColor(StdDraw.WHITE);
				StdDraw.setFont(getFont());
				StdDraw.text(9.1, 4, "White Wins");
				StdDraw.show(1);
				this.setWhiteKingMovesCheck(j);
				return j;
			}
		}
		return 0;
	}

	public void pawnPromotion() {
		for (int x = 0, y = 0; x < 8; x++) {
			if (board[x][y] == 21) {
				StdDraw.setPenColor(getBackground());
				StdDraw.filledRectangle(5, 4, 4.6, 1.1);
				StdDraw.setPenColor(Black);
				StdDraw.filledRectangle(5, 4, 4.5, 1);

				StdDraw.setPenColor(getBackground());
				StdDraw.filledRectangle(1.65, 4, .7, .7);
				StdDraw.setPenColor(BlackButton);
				StdDraw.filledRectangle(1.65, 4, .6, .6);
				StdDraw.picture(1.65, 4, "Chess" + java.io.File.separator
						+ "BlackPawn.png", .8, .9);

				StdDraw.setPenColor(getBackground());
				StdDraw.filledRectangle(3.3, 4, .7, .7);
				StdDraw.setPenColor(BlackButton);
				StdDraw.filledRectangle(3.3, 4, .6, .6);
				StdDraw.picture(3.3, 4, "Chess" + java.io.File.separator
						+ "BlackKnight.png", .8, .9);

				StdDraw.setPenColor(getBackground());
				StdDraw.filledRectangle(4.95, 4, .7, .7);
				StdDraw.setPenColor(BlackButton);
				StdDraw.filledRectangle(4.95, 4, .6, .6);
				StdDraw.picture(4.95, 4, "Chess" + java.io.File.separator
						+ "BlackBishop.png", .8, .9);

				StdDraw.setPenColor(getBackground());
				StdDraw.filledRectangle(6.6, 4, .7, .7);
				StdDraw.setPenColor(BlackButton);
				StdDraw.filledRectangle(6.6, 4, .6, .6);
				StdDraw.picture(6.6, 4, "Chess" + java.io.File.separator
						+ "BlackRook.png", .8, .9);

				StdDraw.setPenColor(getBackground());
				StdDraw.filledRectangle(8.25, 4, .7, .7);
				StdDraw.setPenColor(BlackButton);
				StdDraw.filledRectangle(8.25, 4, .6, .6);
				StdDraw.picture(8.25, 4, "Chess" + java.io.File.separator
						+ "BlackQueen.png", .8, .9);
				StdDraw.show(50);

				while (!StdDraw.mousePressed()) {
				}
				double mouseX = StdDraw.mouseX();
				double mouseY = StdDraw.mouseY();
				while (StdDraw.mousePressed()) {
				}

				if ((mouseX > 0.95 && mouseX < 2.35)
						&& (mouseY > 3.3 && mouseY < 4.7)) {
					board[x][y] = 21;
					redrawBoard();
					return;
				}
				if ((mouseX > 2.6 && mouseX < 4)
						&& (mouseY > 3.3 && mouseY < 4.7)) {
					board[x][y] = 22;
					redrawBoard();
					return;
				}
				if ((mouseX > 4.25 && mouseX < 5.65)
						&& (mouseY > 3.3 && mouseY < 4.7)) {
					board[x][y] = 23;
					redrawBoard();
					return;
				}
				if ((mouseX > 5.9 && mouseX < 7.3)
						&& (mouseY > 3.3 && mouseY < 4.7)) {
					board[x][y] = 24;
					redrawBoard();
					return;
				}
				if ((mouseX > 7.55 && mouseX < 8.95)
						&& (mouseY > 3.3 && mouseY < 4.7)) {
					board[x][y] = 25;
					redrawBoard();
					return;
				} else {
					pawnPromotion();
				}

				return;
			}
		}
		for (int x = 0, y = 7; x < 8; x++) {
			if (board[x][y] == 11) {
				StdDraw.setPenColor(getBackground());
				StdDraw.filledRectangle(5, 4, 4.6, 1.1);
				StdDraw.setPenColor(getWhite());
				StdDraw.filledRectangle(5, 4, 4.5, 1);

				StdDraw.setPenColor(getBackground());
				StdDraw.filledRectangle(1.65, 4, .7, .7);
				StdDraw.setPenColor(WhiteButton);
				StdDraw.filledRectangle(1.65, 4, .6, .6);
				StdDraw.picture(1.65, 4, "Chess" + java.io.File.separator
						+ "WhitePawn.png", .8, .9);

				StdDraw.setPenColor(getBackground());
				StdDraw.filledRectangle(3.3, 4, .7, .7);
				StdDraw.setPenColor(WhiteButton);
				StdDraw.filledRectangle(3.3, 4, .6, .6);
				StdDraw.picture(3.3, 4, "Chess" + java.io.File.separator
						+ "WhiteKnight.png", .8, .9);

				StdDraw.setPenColor(getBackground());
				StdDraw.filledRectangle(4.95, 4, .7, .7);
				StdDraw.setPenColor(WhiteButton);
				StdDraw.filledRectangle(4.95, 4, .6, .6);
				StdDraw.picture(4.95, 4, "Chess" + java.io.File.separator
						+ "WhiteBishop.png", .8, .9);

				StdDraw.setPenColor(getBackground());
				StdDraw.filledRectangle(6.6, 4, .7, .7);
				StdDraw.setPenColor(WhiteButton);
				StdDraw.filledRectangle(6.6, 4, .6, .6);
				StdDraw.picture(6.6, 4, "Chess" + java.io.File.separator
						+ "WhiteRook.png", .8, .9);

				StdDraw.setPenColor(getBackground());
				StdDraw.filledRectangle(8.25, 4, .7, .7);
				StdDraw.setPenColor(WhiteButton);
				StdDraw.filledRectangle(8.25, 4, .6, .6);
				StdDraw.picture(8.25, 4, "Chess" + java.io.File.separator
						+ "WhiteQueen.png", .8, .9);
				StdDraw.show(50);
				while (!StdDraw.mousePressed()) {
				}
				double mouseX = StdDraw.mouseX();
				double mouseY = StdDraw.mouseY();
				while (StdDraw.mousePressed()) {
				}

				if ((mouseX > 0.95 && mouseX < 2.35)
						&& (mouseY > 3.3 && mouseY < 4.7)) {
					board[x][y] = 11;
					redrawBoard();
					return;
				}
				if ((mouseX > 2.6 && mouseX < 4)
						&& (mouseY > 3.3 && mouseY < 4.7)) {
					board[x][y] = 12;
					redrawBoard();
					return;
				}
				if ((mouseX > 4.25 && mouseX < 5.65)
						&& (mouseY > 3.3 && mouseY < 4.7)) {
					board[x][y] = 13;
					redrawBoard();
					return;
				}
				if ((mouseX > 5.9 && mouseX < 7.3)
						&& (mouseY > 3.3 && mouseY < 4.7)) {
					board[x][y] = 14;
					redrawBoard();
					return;
				}
				if ((mouseX > 7.55 && mouseX < 8.95)
						&& (mouseY > 3.3 && mouseY < 4.7)) {
					board[x][y] = 15;
					redrawBoard();
					return;
				} else {
					pawnPromotion();
				}
				return;
			}
		}
	}

	// public void fillAllMoves() {
	// for (int x = 0; x < 8; x++) {
	// for (int y = 0; y < 8; y++) {
	// whiteMoves[x][y] = 0;
	// blackMoves[x][y] = 0;
	// }
	// }
	// //
	// // System.out.println("Board");
	// // System.out.println(Arrays.deepToString(board).replaceAll("],",
	// // "]" + System.getProperty("line.separator")));
	//
	// for (int x = 0; x < 8; x++) {
	// for (int y = 0; y < 8; y++) {
	// if (board[x][y] > 3) {
	// if (board[x][y] == 11) {
	// whiteMoves = this.pawn.canMove(board[x][y], x, y,
	// board, whiteMoves, blackMoves);
	// }
	// if (board[x][y] == 12) {
	// whiteMoves = this.knight.canMove(board[x][y], x, y,
	// board, whiteMoves, blackMoves);
	// }
	// if (board[x][y] == 13) {
	// whiteMoves = this.bishop.canMove(board[x][y], x, y,
	// board, whiteMoves, blackMoves);
	// }
	// if (board[x][y] == 14) {
	// whiteMoves = this.whiteRook1.canMove(board[x][y], x, y,
	// board, whiteMoves, blackMoves);
	// }
	// if (board[x][y] == 15) {
	// whiteMoves = this.queen.canMove(board[x][y], x, y,
	// board, whiteMoves, blackMoves);
	// }
	// if (board[x][y] == 16) {
	// whiteMoves = this.whiteKing.canMove(board[x][y], x, y,
	// board, this.getWhiteKingMoves(),
	// this.getWhiteRook1Moves(),
	// this.getWhiteRook2Moves(),
	// this.getIsWhiteCheck(), whiteMoves, blackMoves);
	// }
	//
	// if (board[x][y] == 21) {
	// blackMoves = this.pawn.canMove(board[x][y], x, y,
	// board, whiteMoves, blackMoves);
	// }
	// if (board[x][y] == 22) {
	// blackMoves = this.knight.canMove(board[x][y], x, y,
	// board, whiteMoves, blackMoves);
	// }
	// if (board[x][y] == 23) {
	// blackMoves = this.bishop.canMove(board[x][y], x, y,
	// board, whiteMoves, blackMoves);
	// }
	// if (board[x][y] == 24) {
	// blackMoves = this.blackRook1.canMove(board[x][y], x, y,
	// board, whiteMoves, blackMoves);
	//
	// }
	// if (board[x][y] == 25) {
	// blackMoves = this.queen.canMove(board[x][y], x, y,
	// board, whiteMoves, blackMoves);
	// }
	// if (board[x][y] == 26) {
	// blackMoves = this.blackKing.canMove(board[x][y], x, y,
	// board, this.getBlackKingMoves(),
	// this.getBlackRook1Moves(),
	// this.getBlackRook2Moves(),
	// this.getIsBlackCheck(), whiteMoves, blackMoves);
	// }
	// }
	// }
	// }
	// }

	// public int isDraw() {
	// fillAllMoves();
	// int canWhiteMove = 0;
	// int canBlackMove = 0;
	// for (int x = 0, i = 0; x < 8; x++, i++) {
	// for (int y = 0; y < 8; y++, i++) {
	// if (board[x][y] == 16 && this.getIsWhiteCheck()==1) {
	// if (y > 0 && blackMoves[x][y - 1] > 0) {
	// whiteMoves[x][y - 1]--;
	// }
	// if ((y > 0 && x > 0) && blackMoves[x - 1][y - 1] > 0) {
	// whiteMoves[x - 1][y - 1]--;
	// }
	// if ((y > 0 && x < 7) && blackMoves[x + 1][y - 1] > 0) {
	// whiteMoves[x + 1][y - 1]--;
	// }
	// if (x > 0 && blackMoves[x - 1][y] > 0) {
	// whiteMoves[x - 1][y]--;
	// }
	// if ((y < 7 && x > 0) && blackMoves[x - 1][y + 1] > 0) {
	// whiteMoves[x - 1][y + 1]--;
	// }
	// if (y < 7 && blackMoves[x][y + 1] > 0) {
	// whiteMoves[x][y + 1]--;
	// }
	// if ((y < 7 && x < 7) && blackMoves[x + 1][y + 1] > 0) {
	// whiteMoves[x + 1][y + 1]--;
	// }
	// if (x < 7 && blackMoves[x + 1][y] > 0) {
	// whiteMoves[x + 1][y]--;
	// }
	// }
	// if (board[x][y] == 26 && this.getIsBlackCheck()==1) {
	// if (y > 0 && whiteMoves[x][y - 1] > 0) {
	// blackMoves[x][y - 1]--;
	// }
	// if ((y > 0 && x > 0) && whiteMoves[x - 1][y - 1] > 0) {
	// blackMoves[x - 1][y - 1]--;
	// }
	// if ((y > 0 && x < 7) && whiteMoves[x + 1][y - 1] > 0) {
	// blackMoves[x + 1][y - 1]--;
	// }
	// if (x > 0 && whiteMoves[x - 1][y] > 0) {
	// blackMoves[x - 1][y]--;
	// }
	// if ((y < 7 && x > 0) && whiteMoves[x - 1][y + 1] > 0) {
	// blackMoves[x - 1][y + 1]--;
	// }
	// if (y < 7 && whiteMoves[x][y + 1] > 0) {
	// blackMoves[x][y + 1]--;
	// }
	// if ((y < 7 && x < 7) && whiteMoves[x + 1][y + 1] > 0) {
	// blackMoves[x + 1][y + 1]--;
	// }
	// if (x < 7 && whiteMoves[x + 1][y] > 0) {
	// blackMoves[x + 1][y]--;
	// }
	// }
	// }
	// }
	// for (int x = 0, i = 0; x < 8; x++, i++) {
	// for (int y = 0; y < 8; y++, i++) {
	// canWhiteMove += whiteMoves[x][y];
	// canBlackMove += blackMoves[x][y];
	// }
	// }
	// System.out.println("White Can Move:");
	// System.out.println(Arrays.deepToString(whiteMoves).replaceAll("],",
	// "]" + System.getProperty("line.separator")));
	// System.out.println("Black Can Move:");
	// System.out.println(Arrays.deepToString(blackMoves).replaceAll("],",
	// "]" + System.getProperty("line.separator")));
	//
	// if (canWhiteMove > 0 && canBlackMove > 0) {
	// System.out.println("White: " + canWhiteMove);
	// System.out.println("Black: " + canBlackMove);
	// return 0;
	// } else
	// System.out.println("White: " + canWhiteMove);
	// System.out.println("Black: " + canBlackMove);
	// return 1;
	// }

	public int getWhiteKingMoves() {
		return whiteKingMoves;
	}

	public void setWhiteKingMoves(int whiteKingMoves) {
		this.whiteKingMoves = whiteKingMoves;
	}

	public int getBlackKingMoves() {
		return blackKingMoves;
	}

	public void setBlackKingMoves(int blackKingMoves) {
		this.blackKingMoves = blackKingMoves;
	}

	public int getWhiteRook1Moves() {
		return whiteRook1Moves;
	}

	public void setWhiteRook1Moves(int whiteRook1moves) {
		this.whiteRook1Moves = whiteRook1moves;
	}

	public int getWhiteRook2Moves() {
		return whiteRook2Moves;
	}

	public void setWhiteRook2Moves(int whiteRook2moves) {
		this.whiteRook2Moves = whiteRook2moves;
	}

	public int getBlackRook1Moves() {
		return blackRook1Moves;
	}

	public void setBlackRook1Moves(int blackRook1moves) {
		this.blackRook1Moves = blackRook1moves;
	}

	public int getBlackRook2Moves() {
		return blackRook2Moves;
	}

	public void setBlackRook2Moves(int blackRook2moves) {
		this.blackRook2Moves = blackRook2moves;
	}

	public int getIsWhiteCheck() {
		return isWhiteCheck;
	}

	public void setIsWhiteCheck(int isCheck) {
		this.isWhiteCheck = isCheck;
	}

	public int getIsBlackCheck() {
		return isBlackCheck;
	}

	public void setIsBlackCheck(int isCheck) {
		this.isBlackCheck = isCheck;
	}

	public int getIsWhiteCheckmate() {
		return isWhiteCheckmate;
	}

	public void setIsWhiteCheckmate(int isWhiteCheckmate) {
		this.isWhiteCheckmate = isWhiteCheckmate;
	}

	public int getIsBlackCheckmate() {
		return isBlackCheckmate;
	}

	public void setIsBlackCheckmate(int isBlackCheckmate) {
		this.isBlackCheckmate = isBlackCheckmate;
	}

	public Color getText() {
		return Text;
	}

	public void setText(Color text) {
		Text = text;
	}

	public Color getBackground() {
		return Background;
	}

	public void setBackground(Color background) {
		Background = background;
	}

	public Color getWhite() {
		return White;
	}

	public void setWhite(Color white) {
		White = white;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		this.font = font;
	}

	public int getWhiteKingMovesCheck() {
		return whiteKingMovesCheck;
	}

	public void setWhiteKingMovesCheck(int whiteKingMovesCheck) {
		this.whiteKingMovesCheck = whiteKingMovesCheck;
	}

	public int getBlackKingMovesCheck() {
		return blackKingMovesCheck;
	}

	public void setBlackKingMovesCheck(int blackKingMovesCheck) {
		this.blackKingMovesCheck = blackKingMovesCheck;
	}
}
