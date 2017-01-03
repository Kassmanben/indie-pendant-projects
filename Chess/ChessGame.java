package ChessGame;

import java.awt.Font;
//Chess by Ben Kassman

public class ChessGame {
	

	public static void main(String args[]) {
		ChessModel model = new ChessModel();
		Font font = new Font("Futura", Font.PLAIN, 30);

		while (true) {
			double mouseX = 0;
			double mouseY = 0;
			

			// waits for mouse click
			while (!StdDraw.mousePressed()) {
			}
			mouseX = StdDraw.mouseX();
			mouseY = StdDraw.mouseY();
			while (StdDraw.mousePressed()) {
			}

			int game=model.runMove(mouseX, mouseY);
			
			if(game==1){
				StdDraw.setPenColor(model.getBackground());
				StdDraw.filledRectangle(5, 4, 4.6, 1.1);
				StdDraw.setPenColor(model.getWhite());
				StdDraw.filledRectangle(5, 4, 4.5, 1);
				StdDraw.setFont(font);
				StdDraw.setPenColor();
				StdDraw.text(5,4,"GAME OVER");
				StdDraw.show();
				break;
			}
		}
		
	}
}
