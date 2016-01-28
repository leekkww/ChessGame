import java.util.*;

public abstract class Piece {

	protected Grid grid;
	protected boolean isWhite;
	protected Location loc;

	public Piece(Location loc, boolean isWhite, Grid grid) {
		this.loc = loc;
		this.isWhite = isWhite;
		this.grid = grid;
	}
	
	public abstract ArrayList<Location> reachable();

	public ArrayList<Location> validMove() {
		ArrayList<Location> locations = new ArrayList<>();
		for(Location loc : reachable()) {
			if(loc == null) continue;
			if(loc.piece() == null) {
				locations.add(loc);
				continue;
			}
			if(loc.piece().isWhite() ^ isWhite()) locations.add(loc);
		}
		return locations;
	}

	public boolean isValidMove(Location loc) {
		return validMove().contains(loc);
	}

	public void moveTo(Location loc) {
		this.loc.put(null);
		this.loc = loc;
		loc.put(this);
	}

	public boolean isWhite() {
		return isWhite;
	}

	public Location getLocation() {
		return loc;
	}

}