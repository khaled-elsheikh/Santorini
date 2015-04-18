package eg.edu.guc.santorini.tiles;

import java.util.ArrayList;

import eg.edu.guc.santorini.utilities.Location;

public class Tile extends Piece {

	public Tile() {
		int []dx = {1, 1, 1, 0, 0, -1, -1, -1 };
		int []dy = {0, 1, -1, 1, -1, 0, 1, -1 };
		setDx(dx);
		setDy(dy);
	}

	@Override
	public ArrayList<Location> possibleMoves() {
		
		return null;
	}

	@Override
	public ArrayList<Location> possiblePlacements() {
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
}
