import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;


public class GameFrame extends JFrame {
	
	private Board board;
	private SideBoard sideboard;
	public Piece[] pieces;
	private int[] pcs = {1,2,2,2,2,2,2,2,2,3,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,8,8,9,10,11,11,11,11,11,11,12};
	private int[] pcs2 = {1,2,2,2,2,2,2,2,2,3,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,8,8,9,10,11,11,11,11,11,11,12};
	private JButton[] bts;
	private static final String aiString = "C:\\Users\\Jorge\\Desktop\\aiStart.txt";
	private static final String ppString = "C:\\Users\\Jorge\\Desktop\\PlayerStart.txt";
	
	
	public GameFrame(){
		super();
		makePieces();
		bts = new JButton[4];
		makeButtons();
		setup();
		
	}
	
	private void makeButtons() {
		bts[0] = new JButton("Start");
		bts[0].addMouseListener(new MouseListener(){


			@Override
			public void mouseClicked(MouseEvent arg0) {
				board.setSetup(false);
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		bts[1] = new JButton("Reset");
		bts[1].addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				remove(board);
				remove(sideboard);
				setup();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		bts[2] = new JButton("Load");
		bts[2].addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				loadSetup(true);
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		bts[3] = new JButton("Save");
		bts[3].addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				saveSetup();
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

	private void makePieces() {
		
		pieces = new Piece[pcs.length];
		for(int i = 0; i< pcs.length; i++){
			pieces[i] = new Piece( pcs[i]);
		}
	}

	public GameFrame(Board board, SideBoard sideboard) throws HeadlessException {
		super();
		this.board = board;
		this.sideboard = sideboard;
		setup();
	}
	
	public void setup(){
		board = new Board(10, 10, pieces);
		sideboard = new SideBoard(true , pieces, bts);
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
		loadSetup(false);
		//randomizePieces(false);
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
	
	public void loadSetup(boolean side){
		try{	
			
			if(side){//player 1
				Scanner input = new Scanner(new File(ppString));
				setupFile(input, 1);
			}else{//AI Player	
				Scanner input = new Scanner(new File(aiString));
				setupFile(input, 0);
			}
		}catch(Exception e){
			System.out.println("Problem loading the setup");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	private void setupFile(Scanner input, int player) throws IOException{
		int j = 6*player;
		int k = 0;
		while(input.hasNext()){
			for(int i = 0; i<10; i++){
				int p = input.nextInt();
				
				if(player == 1){
					pieces[k] = new Piece(p);
					board.setPiece(j, i, pieces[k]);
					k++;
					
				}else{
					board.setPiece(j, i, new Piece(p, 2));
				}
					
			}
			j++;
		}
	}
	public void randomizePieces(boolean side){
		if(side){//player 1 
			
		}else{
			//TODO
			/*
			int k = 0;
			for(int i = 0; i < 4 ; i++){
				for(int j = 0; j < 10; j++ , k++){
					board.setPiece(i, j, new Piece(pcs2[k]));
				}
			}
			*/
		}
	}
	
	public void saveSetup(){
		Writer writer = null;
		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream(ppString), "utf-8"));
		    for(int i = 6; i < 10 ; i++){
		    	for(int j = 0; j< 10; j++){
		    		writer.write(Integer.toString(board.getPieceAt(i, j).getType()));
		    		writer.write(" ");
		    	}
		    	writer.write('\n');
		    	
		    }
		} catch (IOException ex) {
		  // report
		} finally {
		   try {writer.close();} catch (Exception ex) {}
		}
	}
	public static void main(String[] args){
		GameFrame frame = new GameFrame();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
