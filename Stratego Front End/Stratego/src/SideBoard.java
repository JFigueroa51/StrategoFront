import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
	private JButton[] buttons;
	
	private Piece[] pieces;
	
	public SideBoard(boolean setup, Piece[] pcs, JButton[] bts){
		this.setup = setup;
		this.pieces = pcs;
		this.buttons = bts;
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
		start = buttons[0];
		this.add(start,c);
		c.gridx = 1;
		randomize = buttons[3];
		this.add(randomize,c);
		c.gridx = 2;
		reset = buttons[1];
		this.add(reset,c);
		c.gridx = 3;
		load = buttons[2];
		this.add(load,c);
	}
	private void initialSetup() {
		int k = 0;
		for(int j = 0; j< height; j++){
			for(int i = 0;i<width; i++){
				this.setupPieces[i][j] = new PieceButton(pieces[k++], i , j);
				setupPieces[i][j].addMouseListener( new MouseListener(){

					@Override
					public void mouseClicked(MouseEvent e) {
						PieceButton clickedButton = ((PieceButton) e.getSource());
						if(clickedButton.getBackground() != Color.BLACK){
							clickedButton.getPiece().setClicked(true);
							clickedButton.setBackground(Color.GREEN);
						}
						
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
				});
				c.gridx = i;
				c.gridy = j+ 1;
				this.add(setupPieces[i][j], c);
			}
		}
		
	}
}

