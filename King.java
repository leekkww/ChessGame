import java.util.*;

public class King extends Piece {

	public King(Location loc, boolean isWhite, Grid grid) {
		super(loc,isWhite,grid);
	}
	
	@Override
	public ArrayList<Location> reachable() {
		ArrayList<Location> locations = new ArrayList<>();
		int c = getLocation().getC();
		int r = getLocation().getR();
		locations.add(grid.getLocation(c,r+1));
		locations.add(grid.getLocation(c+1,r+1));
		locations.add(grid.getLocation(c+1,r));
		locations.add(grid.getLocation(c-1,r+1));
		locations.add(grid.getLocation(c+1,r-1));
		locations.add(grid.getLocation(c-1,r-1));
		locations.add(grid.getLocation(c-1,r));
		locations.add(grid.getLocation(c,r-1));
		return locations;
	}

	@Override
	public String toString() {
		return isWhite() ? "K" : "k";
	}
}