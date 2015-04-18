package eg.edu.guc.santorini.players;

import eg.edu.guc.santorini.tiles.Cube;
import eg.edu.guc.santorini.tiles.Piece;
import eg.edu.guc.santorini.tiles.Pyramid;

public class Player {

	private String name;
	private int type;
	private Piece t1;
	private Piece t2;
	private boolean win;

	public boolean isWin() {
		return win;
	}

	public void setWin(boolean win) {
		this.win = win;
	}

	public Piece getT1() {
		return t1;
	}

	public Piece getT2() {
		return t2;
	}

	public Player() {
		// TODO Auto-generated constructor stub
		win = false;

	}

	public Player(String name, int type) {
		this.name = name;
		this.type = type;
		if (type == 1) {
			t1 = new Cube();
			t2 = new Cube();
		} else if (type == 2) {
			t1 = new Pyramid();
			t2 = new Pyramid();

		}
		win = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
