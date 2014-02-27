import javax.swing.JButton;


public class PieceButton extends JButton {
	private Piece piece;

	public PieceButton(Piece piece) {
		super();
		this.piece = piece;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
}
