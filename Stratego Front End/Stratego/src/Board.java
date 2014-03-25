import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;


public class Board extends JPanel {
	private PieceButton[][] buttonArray;
	private int width;
	private int height;
	private Piece[] pieces;
	private boolean setup;

	public Board(int width, int height, Piece[] pieces) {
		super();
		setup = true;
		this.pieces = pieces;
		this.width = width;
		this.height = height;
		this.buttonArray = new PieceButton[width][height];
		this.setLayout(new GridLayout(width, height));
		this.setBorder(BorderFactory.createEtchedBorder(1));
		populateBoard();
	}
	public void setSetup(boolean s){
		this.setup = s;
	}
	public void setPiece(int i, int j, Piece p){
		buttonArray[i][j].setPiece(p);
		p.setButton(buttonArray[i][j]);
	}
	
	public Piece getPieceAt(int i, int j){
		return buttonArray[i][j].getPiece();
	}
	public boolean getSetup(){
		return setup;
	}
	private void populateBoard() {
		for(int i = 0 ; i < width; i++){
			for(int j = 0; j < height; j++){
				this.buttonArray[i][j] = new PieceButton(new Piece(0), i, j);
				buttonArray[i][j].addMouseListener(new MouseListener(){

					@Override
					public void mouseClicked(MouseEvent e) {
						PieceButton clickedButton = ((PieceButton)e.getSource());
						for(Piece p: pieces){
							if (p.isClicked() && setup){
								if(!validSetupPlacement(clickedButton)){
									return;
								}
								p.setClicked(false);
								Piece temp = new Piece(clickedButton.getPiece().getType());
								clickedButton.setPiece(p);
								p.getButton().setPiece(temp);
								p.getButton().setBackground(Color.BLACK);
								temp.setButton(p.getButton());
								p.setButton(clickedButton);
								return;
								
							}
							else if(p.isClicked() && isLegalMove(p, clickedButton.getPiece())){
								
								p.setClicked(false);
								//p.getButton().setBackground(clickedButton.getBackground());
								Piece temp = new Piece(clickedButton.getPiece().getType());
								clickedButton.setPiece(p);
								p.getButton().setPiece(temp);
								temp.setButton(p.getButton());
								p.setButton(clickedButton);	
								
								return;
							}
								
						}
						if(!setup){
							
							//clickedButton.setBackground(Color.blue);
							clickedButton.getPiece().setClicked(true);
						}
					}

					private boolean isLegalMove(Piece source, Piece dest) {
						if(source.getTeam() == dest.getTeam())
							return false;
						if(dest.getTeam() == 2){
							//TODO
							combat(source, dest);
							return true;
						}
						int sourceX = source.getButton().getArrayX();
						int sourceY = source.getButton().getArrayY();
						int destX = dest.getButton().getArrayX();
						int destY = dest.getButton().getArrayY();
						if(source.getType() != 2){
							if(Math.abs(sourceX-destX) + Math.abs(sourceY-destY) <= 1){
								return true;
							}
							return false;
						}else{
							if(sourceX - destX == 0 ||sourceY-destY == 0)
								return true;
							return false;
						}
						
						
					}
					private void combat(Piece source, Piece dest){
						
					}

					private boolean validSetupPlacement(
							PieceButton b) {
						if(b.getArrayX()<6 || b.getPiece().getTeam() != 0)
							return false;
						return true;
					}

					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
				});
				this.add(buttonArray[i][j]);
			}
		}
		
	}

	
}
