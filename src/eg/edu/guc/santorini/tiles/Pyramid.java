package eg.edu.guc.santorini.tiles;

import java.util.ArrayList;

import eg.edu.guc.santorini.utilities.Location;

public class Pyramid extends Piece {

	public Pyramid() {
		int []dx = {1, 1, -1, -1 };
		int []dy = {1, -1, 1, -1 };
		setDx(dx);
		setDy(dy);
	}

	public Pyramid(int x, int y) {
		super(x, y);
		int []dx = {1, 1, -1, -1 };
		int []dy = {1, -1, 1, -1 };
		setDx(dx);
		setDy(dy);
	}

	public Pyramid(Location location) {
		super(location);
		int []dx = {1, 1, -1, -1 };
		int []dy = {1, -1, 1, -1 };
		setDx(dx);
		setDy(dy);
	}

	public ArrayList<Location> possibleMoves() {
		ArrayList<Location> out = new ArrayList<Location>();
		int x = this.getLocation().getX();
		int y = this.getLocation().getY();
		for (int i = 0; i < getDx().length; i++) {
			int x1 = x + getDx()[i];
			int y1 = y + getDy()[i];
			if (x1 < 0 || x1 >= 5 || y1 < 0 || y1 >= 5)
			{
				continue;
			}
			out.add(new Location(x1, y1));
		}
		return out;
	}

	public ArrayList<Location> possiblePlacements() {
		ArrayList<Location> out = new ArrayList<Location>();

		int x = this.getLocation().getX();
		int y = this.getLocation().getY();
		for (int i = 0; i < new Tile().getDx().length; i++) {
			int x1 = x + new Tile().getDx()[i];
			int y1 = y + new Tile().getDy()[i];
			if (x1 < 0 || x1 >= 5 || y1 < 0 || y1 >= 5)
			{
				continue;
			}
			out.add(new Location(x1, y1));
		}
		return out;
	}

}
