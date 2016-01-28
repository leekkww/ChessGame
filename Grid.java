import java.util.*;

public class Grid {

	//private ArrayList<Piece> pieces = new ArrayList<>();
	private TreeMap<Integer,Location> grid = new TreeMap<>();
	private boolean whiteTurn = true;
	private Player white;
	private Player black;

	public Grid() {
		this(null,null);
	}

	public Grid(Player white, Player black) {
		this.white = white;
		this.black = black;

		for(Location loc : Location.getAllLocations()) {
			grid.put(getIndex(loc.getC(),loc.getR()), loc);
			if(loc.getR() == 2 || loc.getR() == 7) loc.put(new Pawn(loc,loc.getR() == 2,this));
			if(loc.getR() == 1 || loc.getR() == 8) {
				if(loc.getC() == 1 || loc.getC() == 8) loc.put(new Rook(loc,loc.getR() == 1,this));
				if(loc.getC() == 2 || loc.getC() == 7) loc.put(new Knight(loc,loc.getR() == 1,this));
				if(loc.getC() == 3 || loc.getC() == 6) loc.put(new Bishop(loc,loc.getR() == 1,this));
				if(loc.getC() == 4) loc.put(new Queen(loc,loc.getR() == 1,this));
				if(loc.getC() == 5) loc.put(new King(loc,loc.getR() == 1,this));
			}
		}
		//pieces.add();
	}

	public void setPlayers(Player white, Player black) {
		this.white = white;
		this.black = black;
	}

	public void start() {
		while(true) { //end game is not real
			(whiteTurn ? white : black).play();
			System.out.println(this);
		}
	}

	public boolean isValidMove(Location from, Location to) {
		if(from.piece() == null) {
			System.out.println("no piece to move");
			return false;
		}
		if(from.piece().isWhite() ^ whiteTurn) {
			System.out.println("out of turn!");
			return false;
		}
		if(!from.piece().isValidMove(to)) {
			System.out.println("not valid move");
			return false;
		}
		return true;
	}

	public Piece move(Move move) {
		Piece captured = move.execute();

		whiteTurn = !whiteTurn;		
		return captured;
	}

	public double evaluate() {
		return 
	}

	public void endTurn() {
		//check for king
		//check for promotion
	}

	public Collection<Location> getLocations() {
		return grid.values();
	}

	public Location getLocation(int c, int r) {
		return grid.get(getIndex(c,r));
	}

	public int getIndex(int c, int r) {
		if(c > 8 || c < 1 || r > 8 || r < 1) {
			return -1;
		}
		return (8-r) * 8 + (c-1) % 8;
	}

	public String toString() {
		String response = "";
		for(int i = 0; i < 64; i++) {
			Location loc = grid.get(i);
			if(i % 8 == 0 && i != 0) response += "\n";
			response += loc.piece() == null ? " " : loc.piece();
		}
		return response + "\n";
	}
}