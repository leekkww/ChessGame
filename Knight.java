import java.util.*;
public class Knight extends Piece {

	public Knight(Location loc, boolean isWhite, Grid grid) {
		super(loc,isWhite,grid);
	}
	
	@Override
	public ArrayList<Location> reachable() {
		ArrayList<Location> locations = new ArrayList<>();
		int[] n = {1,-1};
		for(int i : n) {
			for(int j : n) {
				for(int k = 1; k < 3; k++) {
					locations.add(grid.getLocation(k*i + getLocation().getC(), (3-k)*j + getLocation().getR()));
				}
			}
		}
		return locations;
	}

	@Override
	public String toString() {
		return isWhite() ? "N" : "n";
	}
}