package eg.edu.guc.santorini.tiles;

import java.util.ArrayList;

import eg.edu.guc.santorini.utilities.Location;

public abstract class Piece implements PieceInterface {
	private Location location;
	private int[] dx;
	private int[] dy;

	public void setMoved(boolean moved) {
		this.moved = moved;
	}

	private boolean moved = false;

	public boolean isMoved() {
		return moved;
	}

	public int[] getDx() {
		return dx;
	}

	public void setDx(int[] dx) {
		this.dx = dx;
	}

	public int[] getDy() {
		return dy;
	}

	public void setDy(int[] dy) {
		this.dy = dy;
	}

	public Piece() {
		// TODO Auto-generated constructor stub
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Piece(Location location) {
		this.location = location;
	}

	public Piece(int x, int y) {
		location = new Location(x, y);
	}

	

}
