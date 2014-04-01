import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class IO_Operations  {
	
	private static InputStream is;
    private static InputStreamReader isr;
    private static BufferedReader br;
    private static int arraySize;
    private static int counter = 0;
    
    
    private static File file;
    private static FileWriter fr;
    private static BufferedWriter bw;

    private String readBoardUrl;
    private String readKnowledgeFileUrl;
    private String writeBoardUrl;
    private String writeKnowledgeFileUrl;
   
	
	
	IO_Operations(String boardUrl, String knowledgeFileUrl, String writeBoardUrl, String writeKnowledgeFileUrl, int arraySize) 
	{
		is = null;
		isr = null;
		br = null;
		file = null;
		fr = null;
		bw = null;
		this.arraySize = arraySize;
		
		
		this.readBoardUrl = boardUrl;
		this.readKnowledgeFileUrl = knowledgeFileUrl;
		this.writeBoardUrl = writeBoardUrl;
		this.writeKnowledgeFileUrl = writeKnowledgeFileUrl;
		
	}
	
	public void closeStream() throws IOException
	{
		
		br.close();
		bw.close();
		is.close();
		isr.close();
		fr.close();
	}
	
	public int arraySize()
	{
		return counter;
	}
	
	
public Piece[] readPieceData(String call) throws IOException{
		
		Piece piece;
		int arrayLength = arraySize * arraySize;
		Piece pieces[] = new Piece[arrayLength];
		int index = 0;
	
		String line;
		
		if (call.equalsIgnoreCase("b"))
		{
			counter = 0;
			is = new FileInputStream(readBoardUrl);
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
		}
		else
		{
			counter = 0;
			is = new FileInputStream(readKnowledgeFileUrl);
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
		}
		
		 try
		 {
			 
			 while ((line = br.readLine()) != null)
			 {
				 StringTokenizer st = new StringTokenizer(line, ":");
				 while(st.hasMoreTokens())
				 {
					 String tokens = st.nextToken();
					 if (call.equalsIgnoreCase("b")) 
					 {
						 piece = splitBoardTokens(tokens); //call board tokens
					 }
					 else
					 {
						 piece = splitKnowledgeFileTokens(tokens); //call knowledge-file tokens
					 }
					 
					 pieces[index] = piece;
					 if (index < arrayLength)
						 index++;
					 
					 
					
				 }
				 System.out.println(); //Prints new line
				 
			 }
			 
		 }catch (Exception e) {
			 e.printStackTrace(); 
		 }finally
		 { }
		return pieces;
	}
	
	

public void writePieceData(PieceButton[][] arrData, String call) throws IOException{
	
	int stop = arrData.length;
	String breakPoint = convertType(stop * stop);
	
	if (call.equals("b"))
	{
		file = new File(writeBoardUrl);
		fr= new FileWriter(file);
		bw = new BufferedWriter(fr);
		StringBuilder str = new StringBuilder();
		
		
		 try
		 {
			 for (int x = 0; x < arrData.length; ++x)
			 {
				 for (int y = 0; y < arrData[x].length; ++y)
				 {
					 PieceButton button = arrData[x][y];
					 String position = convertIntToStr(button.getArrayX(), button.getArrayY());
					 str.append(position);
					 str.append(" ");
					 str.append(convertType(button.getPiece().getType()));
					 if (!position.equals(breakPoint))
						 str.append(" : ");
					 
					 //System.out.println("x: " + x + " " + "y: " + y);
					 
				 }
			 }
				 
			 
			 //System.out.println(str.toString());
			 bw.write(str.toString());
			 bw.flush();
			 
			 
		 }catch (Exception e){
			 e.printStackTrace(); 
		 }finally
		 {
			 
		 }
	}
	else
	{
		file = new File(writeKnowledgeFileUrl);
		fr= new FileWriter(file);
		bw = new BufferedWriter(fr);
		StringBuffer string = new StringBuffer();
		
		try
		 {
			
			for (int x = 0; x < arrData.length; x++)
			 {
				 for (int y = 0; y < arrData[x].length; ++y)
				 {
					 PieceButton button = arrData[x][y];
					 String position = convertIntToStr(button.getArrayX(), button.getArrayY());
					 string.append(position);
					 string.append(" ");
					 string.append(convertType(button.getPiece().getType()));
					 string.append(" ");
					 string.append(convertType(button.getPiece().getHasMoved()));
					 string.append(" ");
					 string.append(convertType(button.getPiece().getIsDiscovered()));
					 if (!position.equals(breakPoint))
						 string.append(" : ");
					
					 
				 }
			 }
			
			
			 //System.out.println(string.toString());
			 bw.write(string.toString());
			 bw.flush();
			
			 
		 }catch (Exception e){
			 e.printStackTrace(); 
		 }finally
		 {
			 
		 }
		
	}	
	
}

	
	public Piece splitBoardTokens(String token){
		
		
		int team = 1; //team parameter might be added to recognize ai team
		StringTokenizer st = new StringTokenizer(token, " ");
		String p = st.nextToken();
		int position = convertStrToInt(p);
		String t = st.nextToken();
		int type = convertStrToInt(t);
		if(type > 13){
			team = 2;
			type = type - 13;
		}
		Piece piece = new Piece(type, team, position);
		return piece;
		
	}
	
public Piece splitKnowledgeFileTokens(String token){
	int team = 1; //team parameter might be added to recognize ai team
		StringTokenizer st = new StringTokenizer(token, " ");
		String p = st.nextToken();
		int position = convertStrToInt(p);
		String t = st.nextToken();
		int type = convertStrToInt(t);
		if(type > 13){
			team = 2;
			type = type - 13;
		}
		int hasMoved  = convertStrToInt(st.nextToken());
		int isDiscovered = convertStrToInt(st.nextToken());
		Piece piece = new Piece(type, team, isDiscovered, hasMoved, position);
		return piece;
		
	}

public int convertStrToInt(String token)
{
	return Integer.valueOf(token);
}

public String convertIntToStr(int x, int y)
{
	return String.valueOf((y * 10) + x + 1);
}

public String convertType(int type)
{
	return String.valueOf(type);
}
	
	
	
}
