import java.awt.HeadlessException;

import javax.swing.JFrame;


public class GameFrame extends JFrame {
	private Board board;
	private SideBoard sideboard;
	
	public GameFrame(){
		
		
	}
	public GameFrame(Board board, SideBoard sideboard) throws HeadlessException {
		super();
		this.board = board;
		this.sideboard = sideboard;
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
}
