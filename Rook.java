import java.util.*;

public class Rook extends Piece {

	public Rook(Location loc, boolean isWhite, Grid grid) {
		super(loc,isWhite,grid);
	}

	@Override
	public ArrayList<Location> reachable() {
		ArrayList<Location> locations = new ArrayList<>();
		for(int i = 1; i < 8; i++) {
			locations.add(grid.getLocation(getLocation().getC(),(getLocation().getR() + i) % 8));
			locations.add(grid.getLocation((getLocation().getC() + i) % 8,getLocation().getR()));
		}
		return locations;
	}
	
	@Override
	public String toString() {
		return isWhite() ? "R" : "r";
	}
}