import java.util.*;
public class Location {

	private int col;
	private int row;
	private Piece p = null;

	public Location(int col, int row) {
		this.col = col;
		this.row = row;
	}

	public int getC() {
		return col;
	}

	public int getR() {
		return row;
	}

	public void put(Piece p) {
		this.p = p;
	}

	public Piece piece() {
		return p;
	}

	@Override
	public boolean equals(Object o) {
		return getClass() == o.getClass() && ((Location)o).getC() == getC() && ((Location)o).getR() == getR();
	}

	@Override 
	public String toString() {
		return (char)(col + 'A' - 1) + "" + row;
	}

	public static ArrayList<Location> getAllLocations() {
		ArrayList<Location> locations = new ArrayList<Location>();
		for(int i = 1; i < 9; i++) {
			for (int j = 1; j < 9; j++) {
				locations.add(new Location(i,j));
			}
		}
		return locations;
	}

	public static boolean isValid(Location loc) {
		return loc.getR() < 9 && loc.getR() > 0 && loc.getC() > 0 && loc.getC() < 9;
	}
}