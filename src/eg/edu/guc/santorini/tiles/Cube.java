package eg.edu.guc.santorini.tiles;

import java.util.ArrayList;
import eg.edu.guc.santorini.utilities.Location;

public class Cube extends Piece {

	public Cube() {
		int[] dx = {0, 0, 1, -1 };
		int[] dy = {1, -1, 0, 0 };
		setDx(dx);
		setDy(dy);
	}

	public Cube(int x, int y) {
		super(x, y);
		int[] dx = {0, 0, 1, -1 };
		int[] dy = {1, -1, 0, 0 };
		setDx(dx);
		setDy(dy);
	}

	public Cube(Location location) {
		super(location);
		int[] dx = {1, -1, 0, 0 };
		int[] dy = {0, 0, 1, -1 };
		setDx(dx);
		setDy(dy);
	}

	@Override
	public ArrayList<Location> possibleMoves() {
		ArrayList<Location> out = new ArrayList<Location>();
		int x = this.getLocation().getX();
		int y = this.getLocation().getY();
		for (int i = 0; i < getDx().length; i++) {
			int x1 = x + getDx()[i];
			int y1 = y + getDy()[i];
			if (x1 < 0 || x1 >= 5 || y1 < 0 || y1 >= 5) {
				continue;
			}
			out.add(new Location(x1, y1));
		}
		return out;
	}

	@Override
	public ArrayList<Location> possiblePlacements() {
		ArrayList<Location> out = new ArrayList<Location>();

		int x = this.getLocation().getX();
		int y = this.getLocation().getY();
		for (int i = 0; i < new Tile().getDx().length; i++) {
			int x1 = x + new Tile().getDx()[i];
			int y1 = y + new Tile().getDy()[i];
			if (x1 < 0 || x1 >= 5 || y1 < 0 || y1 >= 5) {
				continue;
			}
			out.add(new Location(x1, y1));
		}
		return out;
	}

}
