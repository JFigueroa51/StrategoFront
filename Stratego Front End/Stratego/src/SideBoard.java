import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;


public class SideBoard extends JPanel{
	
	private boolean setup;
	private PieceButton[][] setupPieces;
	private PieceButton[][] deadPieces;
	private GridBagConstraints c;
	private int width = 4;
	private int height = 10;
	private JButton start;
	private JButton randomize;
	private JButton reset;
	private JButton load;
	private int[] pieces = {1, 2,2,2,2,2,2,2,2};
	
	public SideBoard(boolean setup){
		this.setup = setup;
		c = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		if(this.setup = true){
			this.setupPieces = new PieceButton[width][height];
			c.gridx = 0;
			c.gridy = 0;
			c.fill = GridBagConstraints.BOTH;
			c.weightx = 1;
			c.weighty = 1;
			addButtons();
			initialSetup();
		}
	}
	private void addButtons(){
		start = new JButton("start");
		this.add(start,c);
		c.gridx = 1;
		randomize = new JButton("randomize");
		this.add(randomize,c);
		c.gridx = 2;
		reset = new JButton("reset");
		this.add(reset,c);
		c.gridx = 3;
		load = new JButton("load");
		this.add(load,c);
	}
	private void initialSetup() {
		for(int j = 0; j< height; j++){
			for(int i = 0;i<width; i++){
				this.setupPieces[i][j] = new PieceButton(new Piece(0));
				c.gridx = i;
				c.gridy = j+ 1;
				this.add(setupPieces[i][j], c);
			}
		}
		
	}
}

