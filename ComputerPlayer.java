public class ComputerPlayer extends Player {

	int depth = 1;
	
	public ComputerPlayer(Grid grid, boolean isWhite, int depth) {
		super(grid, isWhite);
		this.depth = 1;
	}
	
	public Move next() {
		for(Location loc : grid.getLocations()) {

		}
		/*
		Scanner scan = new Scanner(System.in);
		Location from = null;
		Location to = null;
		do {
			String next = scan.nextLine();
			String[] r = next.split(" ");

			from = grid().getLocation(Integer.parseInt(r[0]),Integer.parseInt(r[1]));
			to = grid().getLocation(Integer.parseInt(r[2]),Integer.parseInt(r[3]));
		} while (!grid().isValidMove(from,to));
		*/
		return new Move(from.piece(),to);
	}

	public int evaluate(Move move, Grid grid) {

	}
}