import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;


public class GameFrame extends JFrame {
	private Board board;
	private SideBoard sideboard;
	
	public GameFrame(){
		super();
		board = new Board(10, 10);
		sideboard = new SideBoard();
		setup();
		
	}
	
	public GameFrame(Board board, SideBoard sideboard) throws HeadlessException {
		super();
		this.board = board;
		this.sideboard = sideboard;
		setup();
	}
	
	public void setup(){
		this.setTitle("Stratego");
		GridBagConstraints c = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 2;
		c.weighty = 3;
		this.add(board,c);
		c.gridx = 3;
		c.gridy = 0;
		c.weightx = 1;
		this.add(sideboard,c);
		this.setExtendedState(this.getExtendedState()|JFrame.MAXIMIZED_BOTH);
		
		this.setVisible(true);
	}
	
	public Board getBoard() {
		return board;
	}
	
	public void setBoard(Board board) {
		this.board = board;
	}
	
	public SideBoard getSideboard() {
		return sideboard;
	}
	
	public void setSideboard(SideBoard sideboard) {
		this.sideboard = sideboard;
	}
	
	public static void main(String[] args){
		GameFrame frame = new GameFrame();
	}
}
