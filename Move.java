public class Move {

	Location to;
	Piece p;
	Grid grid; 
	
	public Move(Piece p, Location to) {
		this.p = p;
		this.to = to;
	}

	public Piece execute() {
		Piece captured = to.piece();
		p.moveTo(to);
		return captured;
	}
}