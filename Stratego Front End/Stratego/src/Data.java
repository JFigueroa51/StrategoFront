
public class Data {
	
	private int position;
	private int type;
	private boolean hasMoved;
	private boolean isDiscovered;
	
	private String p;
	private String t;
	private String h;
	private String i;
	
	Data(int position, int type){
		
		this.position = position;
		this.type = type;
		this.hasMoved = false;
		this.isDiscovered = false;
	}
	
	Data(int position, int type, boolean hasMoved, boolean isDiscovered){
		
		this.position = position;
		this.type = type;
		this.hasMoved = hasMoved;
		this.isDiscovered = isDiscovered;	
		
	}
	
	public void setPosition(int position){
		this.position = position;
		p = convertIntToString(position);
	}
	
	public void setType(int type){
		this.type = type;
		t = convertIntToString(type);
	}
	
	public void setHasMoved(boolean hasMoved){
		this.hasMoved = hasMoved;
		h = convertBooleanToString(hasMoved);
	}
	
	public void setIsDiscovered(boolean isDiscovered){
		this.isDiscovered = isDiscovered;
		i = convertBooleanToString(isDiscovered);
	}
	
	public int getPosition(){
		return position;
	}
	
	public int getType(){
		return type;
	}
	
	public boolean getHasMoved(){
		return hasMoved;
	}
	
	public boolean getIsDiscovered(){
		return isDiscovered;
	}
	
	public String getP(){
		return p;	
	}
	
	public String getT(){
		return t;
	}
	
	public String getH(){
		return h;
	}
	
	public String getI(){
		return i;
	}
	
	public void setBoardData(String p, String t)
	{
		this.p = p;
		this.t = t;
	}
	
	public void setKnowledgeFileData(String p, String t, String h, String i)
	{
		this.p = p;
		this.t = t;
		this.h = h;
		this.i = i;
	}
	
	public String convertIntToString(int token){
		return String.valueOf(token);
	}
	
	public String convertBooleanToString(boolean token)
	{
		if (token)
			return "1";
		else
			return "0";
		
	}
	
}
