
public class Piece {
	private int type;
	//private boolean alive;
	private boolean clicked;
	private String imageLink;
	private PieceButton button;
	private int team;// 1 for player 1, 2 for AI, 0 for non-player (environment or obstacles)
	private int hasMoved;
	private int isDiscovered;
	
	public Piece(int type){
		//this.alive = false;
		this.type = type;
		this.isDiscovered = 0;
		this.hasMoved = 0;
		this.clicked = false;
		if(type != 0 ){
			team = 1;
		}else{
			team = 0;
		}
		
	}
	
	public Piece(int type, int team){
		//this.alive = false;
		this.type = type;
		this.clicked = false;
		this.team = team;
		this.isDiscovered = 0;
		this.hasMoved = 0;
	}
	public int getHasMoved(){
		return this.hasMoved;
	}
	
	public int getIsDiscovered(){
		return this.isDiscovered;
	}
	
	public void setHasMoved(boolean m){
		if (m ){
			this.hasMoved = 1;
			return;
		}
		this.hasMoved = 0;
	}
	
	public void setIsDiscovered(boolean d){
		if (d){
			this.isDiscovered = 1;
			return;
		}
		this.isDiscovered = 0;
	}
	
	public int getTeam(){
		return team;
	}
	public Piece(int type, String link){
		this(type);
		this.imageLink = link;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public boolean isClicked() {
		return clicked;
	}

	public void setClicked(boolean c) {
		this.clicked = c;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	
	public void setButton(PieceButton b){
		this.button = b;
	}
	
	PieceButton getButton(){
		return button;
	}
	public void setTeam(int i) {
		team = i;
		
	}
	
	
}
