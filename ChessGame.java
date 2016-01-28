import java.util.*;
public class ChessGame {

	public static void main(String[] args) {
		Grid grid = new Grid();
		HumanPlayer white = new HumanPlayer(grid, true);
		HumanPlayer black = new HumanPlayer(grid,false);
		grid.setPlayers(white,black);
		System.out.println(grid);
		grid.start();
		/*

		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()) {
			String next = scan.nextLine();
			String[] r = next.split(" ");
			grid.move(Integer.parseInt(r[0]),Integer.parseInt(r[1]),Integer.parseInt(r[2]),Integer.parseInt(r[3]));
			System.out.println(grid);
		}

		grid.move(2,1,3,3);
		grid.move(3,3,3,6);
		System.out.println(grid.getLocation(3,2).piece().validMove());
		*/
	}
}