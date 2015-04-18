import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import eg.edu.guc.santorini.Board;
import eg.edu.guc.santorini.exceptions.InvalidMoveException;
import eg.edu.guc.santorini.exceptions.InvalidPlacementException;
import eg.edu.guc.santorini.players.Player;
import eg.edu.guc.santorini.tiles.Cube;
import eg.edu.guc.santorini.tiles.Piece;
import eg.edu.guc.santorini.tiles.Pyramid;
import eg.edu.guc.santorini.utilities.Location;

public class adapter implements ActionListener, MouseListener {
	Board B1;
	Piece toBeMoved;
	ArrayList<Location> out = new ArrayList<Location>();

	public adapter(Player P1, Player P2) {
		B1 = new Board(P1, P2);
	}

	public void tile(int x, int y, BoardWindow h) throws InvalidMoveException,
			InvalidPlacementException {
		Piece[][] f = B1.getBoard();

		Piece w = f[x][y];
		w.setLocation(new Location(x, y));

		if (w instanceof Cube || w instanceof Pyramid) {
			
			if (toBeMoved != null)
				if(toBeMoved != B1.getShould_place())
				h.remove_highLight(out);
			if(B1.isPlace())
			{
				throw new InvalidPlacementException("Please place on one of the highlighted tiles");
			}
			out = new ArrayList<Location>();
			toBeMoved = w;
			if (!w.isMoved()) {
				out = w.possibleMoves();
			} else {
				out = w.possiblePlacements();
			}

			for (int g = 0; g < out.size(); g++) {
				if (!toBeMoved.isMoved()) {
					if (!B1.canMove(toBeMoved, out.get(g))) {
						out.remove(g);
						g = -1;
					}
				} else {
					if (!B1.canPlace(toBeMoved, out.get(g))) {
						out.remove(g);
						g = -1;
					}
				}

			}

			h.highLight(out);

		} else {
			if (!toBeMoved.isMoved()) {
				// out = toBeMoved.possibleMoves();
				move(w.getLocation().getX(), w.getLocation().getY(), h);
			} else {
				// out = toBeMoved.possiblePlacements();


				place(w.getLocation().getX(), w.getLocation().getY(),h);

			}
		}

	}

	public void move(int x, int y, BoardWindow h)
			throws InvalidMoveException {
		Location newLocation = new Location(x, y);
		int x_old = toBeMoved.getLocation().getX();
		int y_old = toBeMoved.getLocation().getY();
		try {
			B1.move(toBeMoved, newLocation);

		} catch (InvalidMoveException e) {

			new ExceptionWindow(e.getMessage());
			return;
		}
		h.change_photo(x_old, y_old);

		for (int i = 0; i < out.size(); i++)
			if (out.get(i).equals(newLocation)) {
				out.remove(i);
				i = -1;
			}
		h.remove_highLight(out);
		out = B1.getBoard()[x][y].possiblePlacements();
		for (int g = 0; g < out.size(); g++) {
			if (!B1.canPlace(toBeMoved, out.get(g))) {
				out.remove(g);
				g = -1;
			}
		}
		h.highLight(out);
		h.change_piece(newLocation.getX(), newLocation.getY());
		if (wins(B1.getPlayer1()) || wins(B1.getPlayer2())) {
			new winnerWindow(h);
		}
	}

	public void place(int x, int y, BoardWindow h)
			throws InvalidMoveException, InvalidPlacementException {
		Location newLocation = new Location(x, y);
		try {
			B1.place(toBeMoved, newLocation);
		} catch (InvalidPlacementException e) {
			ExceptionWindow z = new ExceptionWindow(e.getMessage());
			return;
		}
		h.remove_highLight(out);

		h.change_photo(x, y);
		if (wins(B1.getPlayer1()) || wins(B1.getPlayer2())) {
			new winnerWindow(h);
		}
	}
	public boolean wins(Player player)
	{
		return B1.isWinner(player);
	}
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
