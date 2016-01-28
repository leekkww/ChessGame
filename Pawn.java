import java.util.*;
public class Pawn extends Piece {

	public Pawn(Location loc, boolean isWhite, Grid grid) {
		super(loc,isWhite,grid);
	}
	
	@Override
	public ArrayList<Location> reachable() {
		ArrayList<Location> locations = new ArrayList<>();
		int r = getLocation().getR();
		int c = getLocation().getC();
		int mult = isWhite() ? 1 : -1;
		locations.add(grid.getLocation(c,r + mult));
		if((mult * 2 + 9) % 9 == r && grid.getLocation(c,(mult * 3 + 9) % 9).piece()==null) {
			locations.add(grid.getLocation(c,(r + mult * 2 + 9) % 9));
		}
		for(int i = -1; i < 2; i += 2) {
			Location loc = grid.getLocation(c + i,r + mult);
			if(loc.piece() != null) {
				if(loc.piece().isWhite() ^ isWhite()) {
					locations.add(loc);
				}
			}
		}		
		//add en passant
		//add promotion
		return locations;
	}

	@Override
	public String toString() {
		return isWhite() ? "P" : "p";
	}
}