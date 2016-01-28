import java.util.*;

public class Bishop extends Piece {

	public Bishop(Location loc, boolean isWhite, Grid grid) {
		super(loc,isWhite,grid);
	}
	
	@Override
	public ArrayList<Location> reachable() {
		ArrayList<Location> locations = new ArrayList<>();
		for(int i = -7; i < 8; i++) {
			if(i == 0) continue;
			locations.add(grid.getLocation(getLocation().getC()+i,getLocation().getR()+i));
			locations.add(grid.getLocation(getLocation().getC()-i,getLocation().getR()+i));
		}
		return locations;
	}

	@Override
	public String toString() {
		return isWhite() ? "B" : "b";
	}
}