public abstract class Player {
	
	//iswhite not needed
	private boolean isWhite;
	private Grid grid;

	public Player(Grid grid, boolean isWhite) {
		this.grid = grid;
		this.isWhite = isWhite;
	}

	public abstract Move next();

	public void play(){
		grid.move(next());
	}

	public boolean isWhite() {
		return isWhite;
	}

	public Grid grid() {
		return grid;
	}

}