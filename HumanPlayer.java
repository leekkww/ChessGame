import java.util.*;
public class HumanPlayer extends Player {

	public HumanPlayer(Grid grid, boolean isWhite) {
		super(grid, isWhite);
	}
	
	public Move next() {
		Scanner scan = new Scanner(System.in);
		Location from = null;
		Location to = null;
		do {
			String next = scan.nextLine();
			String[] r = next.split(" ");

			from = grid().getLocation(Integer.parseInt(r[0]),Integer.parseInt(r[1]));
			to = grid().getLocation(Integer.parseInt(r[2]),Integer.parseInt(r[3]));
		} while (!grid().isValidMove(from,to));
		return new Move(from.piece(),to);
	}
}