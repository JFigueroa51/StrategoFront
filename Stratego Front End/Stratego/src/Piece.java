
public class Piece {
	private int type;
	private boolean alive;
	private String imageLink;
	
	public Piece(int type){
		this.alive = false;
		this.type = type;
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

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	
	
	
	
}
