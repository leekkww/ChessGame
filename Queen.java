import java.util.*;

public class Queen extends Piece {
	
	public Queen(Location loc, boolean isWhite, Grid grid) {
		super(loc,isWhite,grid);
	}

	@Override
	public ArrayList<Location> reachable() {
		ArrayList<Location> locations = new ArrayList<>();
		for(int i = 1; i < 8; i++) {
			locations.add(grid.getLocation(getLocation().getC(),(getLocation().getR() + i) % 8));
			locations.add(grid.getLocation((getLocation().getC() + i) % 8,getLocation().getR()));
		}
		for(int i = -7; i < 8; i++) {
			if(i == 0) continue;
			locations.add(grid.getLocation(getLocation().getC()+i,getLocation().getR()+i));
			locations.add(grid.getLocation(getLocation().getC()-i,getLocation().getR()+i));
		}
		return locations;
	}

	@Override
	public String toString() {
		return isWhite() ? "Q" : "q";
	}
}