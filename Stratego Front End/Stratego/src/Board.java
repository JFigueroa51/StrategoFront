import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class Board extends JPanel {
	private PieceButton[][] buttonArray;
	private int width;
	private int height;

	public Board(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		this.buttonArray = new PieceButton[width][height];
		this.setLayout(new GridLayout(width, height));
		this.setBorder(BorderFactory.createEtchedBorder(1));
		populateBoard();
	}

	private void populateBoard() {
		for(int i = 0 ; i < width; i++){
			for(int j = 0; j < height; j++){
				buttonArray[i][j] = new PieceButton(new Piece(0));
				this.add(buttonArray[i][j]);
			}
		}
		
	}
	
}
