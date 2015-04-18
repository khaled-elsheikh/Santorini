package eg.edu.guc.santorini;

import eg.edu.guc.santorini.exceptions.InvalidMoveException;
import eg.edu.guc.santorini.exceptions.InvalidPlacementException;
import eg.edu.guc.santorini.players.Player;
import eg.edu.guc.santorini.tiles.Cube;
import eg.edu.guc.santorini.tiles.Piece;
import eg.edu.guc.santorini.tiles.Pyramid;
import eg.edu.guc.santorini.tiles.Tile;
import eg.edu.guc.santorini.utilities.Location;

public class Board implements BoardInterface {
	private int[][] level = new int[SIDE][SIDE];

	private Player player1;
	private Player player2;
	private int plays = 0;
	private Piece[][] board = new Piece[SIDE][SIDE];
	Piece should_place;
	boolean place;
	public Board(Player player1, Player player2) {

		this.player1 = player1;
		this.player2 = player2;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				board[i][j] = new Tile();
				board[i][j].setLocation(new Location(i, j));
			}
		}
		player1.getT1().setLocation(new Location(0, 0));
		player1.getT2().setLocation(new Location(4, 1));
		board[0][0] = player1.getT1();
		board[4][1] = player1.getT2();
		player2.getT1().setLocation(new Location(0, 3));
		player2.getT2().setLocation(new Location(4, 4));
		board[0][3] = player2.getT1();
		board[4][4] = player2.getT2();
		plays = 0;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				level[i][j] = 0;
			}
		}
	}

	public Piece[][] getBoard() {
		return board;
	}

	public void setBoard(Piece[][] board) {
		this.board = board;
	}

	public int[][] getLevel() {
		return level;
	}

	public int getPlays() {
		return plays;
	}

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public boolean canMove(Piece piece, Location location) {
		int x = piece.getLocation().getX();
		int y = piece.getLocation().getY();
		int x1 = location.getX();
		int y1 = location.getY();
		for (int i = 0; i < piece.possibleMoves().size(); i++) {
			if (location.equals(piece.possibleMoves().get(i))) {
				if (!(level[x1][y1] - level[x][y] > 1 || level[x1][y1] > 3
						|| board[x1][y1] instanceof Cube || board[x1][y1] instanceof Pyramid)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean canPlace(Piece piece, Location location)  {
		if(piece != should_place) {
				return false;
			}
		int x1 = location.getX();
		int y1 = location.getY();
		for (int i = 0; i < piece.possiblePlacements().size(); i++) {
			if (location.equals(piece.possiblePlacements().get(i))) {
				if (!(level[x1][y1] == 4 || board[x1][y1] instanceof Cube || board[x1][y1] instanceof Pyramid)) {
					return true;
				}
			}
		}
		return false;
	}

	public Piece getShould_place() {
		return should_place;
	}

	public void setShould_place(Piece should_place) {
		this.should_place = should_place;
	}

	public void move(Piece piece, Location newLocation)
			throws InvalidMoveException {
		if (getTurn().getT1() != piece && getTurn().getT2() != piece) {
			throw new InvalidMoveException("This is not your turn!");
		} else {
			if (piece.isMoved()) {
				throw new InvalidMoveException("Your piece has been moved!");
			} else {
				if (!canMove(piece, newLocation)) {
					throw new InvalidMoveException("You cannot move here!");
				} else {
					if (isGameOver()) {
						throw new InvalidMoveException("Game Over!");
					} else {
						if (isWinner(player1)) {
							throw new InvalidMoveException(player1.getName()
									+ "wins");
						} else {
							if (isWinner(player2)) {
								throw new InvalidMoveException(
										player2.getName() + "wins");
							}
						}

					}
				}
			}
		}
		int x1 = newLocation.getX();
		int y1 = newLocation.getY();
		board[piece.getLocation().getX()][piece.getLocation().getY()] = new Tile();
		piece.setLocation(newLocation);
		board[x1][y1] = piece;
		if (level[x1][y1] == 3) {
			if (player1.getT1() == piece || player1.getT2() == piece) {
				player1.setWin(true);
			} else {
				player2.setWin(true);
			}

		}
		if (piece == player1.getT1() || piece == player1.getT2()) {
			player1.getT1().setMoved(true);
			player1.getT2().setMoved(true);
		} else {

			player2.getT1().setMoved(true);
			player2.getT2().setMoved(true);
		}
		should_place = piece;
		place = !place;
	}

	public boolean isPlace() {
		return place;
	}

	public void setPlace(boolean place) {
		this.place = place;
	}

	public Player getTurn() {
		if (plays % 2 == 0) {
			return player1;
		} else {
			return player2;
		}
	}

	public boolean hasNoMoves(Player player) {
		for (int i = 0; i < player.getT1().possibleMoves().size(); i++) {
			if (canMove(player.getT1(), player.getT1().possibleMoves().get(i))) {
				return false;
			}
		}
		for (int i = 0; i < player.getT2().possibleMoves().size(); i++) {
			if (canMove(player.getT2(), player.getT2().possibleMoves().get(i))) {
				return false;
			}
		}
		return true;
	}

	public boolean isWinner(Player player) {
		if (player == player1) {
			return player1.isWin()
					|| (hasNoMoves(player2) && getTurn() == player2);
		}
		return player2.isWin() || (hasNoMoves(player1) && getTurn() == player1);

	}

	public void place(Piece piece, Location newLocation)
			throws InvalidPlacementException {
		if (!piece.isMoved()) {
			throw new InvalidPlacementException(
					"Move your piece before placing!");
		} else {
			if (!canPlace(piece, newLocation) ||  piece != should_place) {
				throw new InvalidPlacementException(
						"Place on the hilghted tiles!");
			}
		}
		int x1 = newLocation.getX();
		int y1 = newLocation.getY();

		if (piece == player1.getT1() || piece == player1.getT2()) {
			player1.getT1().setMoved(false);
			player1.getT2().setMoved(false);
		} else {

			player2.getT1().setMoved(false);
			player2.getT2().setMoved(false);
		}		board[x1][y1] = new Tile();
		level[x1][y1]++;
		plays++;
		place = !place;

	}

	public boolean isGameOver() {
		return isWinner(player1) || isWinner(player2);
	}

	public Player getWinner() {
		if (isWinner(player1)) {
			return player1;
		} else if (isWinner(player2)) {
			return player2;
		}
		return null;
	}

	public String[][] display() {
		String[][] out = new String[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				String x = "" + level[i][j];

				if (board[i][j] instanceof Pyramid) {
					x += "P";
				}
				if (board[i][j] instanceof Cube) {
					x += "C";
				}
				if (player1.getT1() == board[i][j]
						|| player1.getT2() == board[i][j]) {
					x += "1";
				}
				if (player2.getT1() == board[i][j]
						|| player2.getT2() == board[i][j]) {
					x += "2";
				}
				out[i][j] = x;
			}
		}

		return out;
	}

}
