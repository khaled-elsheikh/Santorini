import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import eg.edu.guc.santorini.exceptions.InvalidMoveException;
import eg.edu.guc.santorini.exceptions.InvalidPlacementException;
import eg.edu.guc.santorini.players.Player;
import eg.edu.guc.santorini.tiles.Cube;
import eg.edu.guc.santorini.tiles.Pyramid;
import eg.edu.guc.santorini.utilities.Location;

public class BoardWindow extends JFrame implements ActionListener,
		MouseListener {
	JPanel buttonPanel;
	Tile tempTile;
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	boolean flagMove = false;

	public boolean isFlagMove() {
		return flagMove;
	}

	public void setFlagMove(boolean flagMove) {
		this.flagMove = flagMove;
	}
	JPanel gridPanel;
	JPanel Panel;
	Tile[][] m;
	boolean flag = true;
	adapter Adapter;
	public BoardWindow(String N1,int T1,String N2,int T2) {
		m = new Tile[5][5];
		//this.setSize(1500, 1000);
		Adapter = new adapter(new Player(N1,T1),new Player (N2,T2));
		getContentPane().setLayout((new BorderLayout()));
		gridPanel = new JPanel(new GridLayout(5, 5));
		buttonPanel = new JPanel(new GridLayout(5,1));
		buttonPanel.add(new JLabel(N1));
		if(T1 == 1)
		{
		buttonPanel.add(new JLabel(new ImageIcon("Tile0Cube1.png")));
		}
		else
		{
			buttonPanel.add(new JLabel(new ImageIcon("Tile0Pyramid1.png")));
		}
		buttonPanel.add(new JLabel(N2));
		if(T2 == 1)
		{
		buttonPanel.add(new JLabel(new ImageIcon("Tile0Cube2.png")));
		}
		else
		{
			buttonPanel.add(new JLabel(new ImageIcon("Tile0Pyramid2.png")));
		}
		gridPanel.setSize(100, 100);
		WindowDestroyer myListener = new WindowDestroyer();
		addWindowListener(myListener);
		add(gridPanel, BorderLayout.CENTER);
		gridPanel.setOpaque(false);
		Init_board();
		add(buttonPanel,BorderLayout.EAST);

		setSize(1000, 700);
		setVisible(true);

	}
	public void Init_board()
	{
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				Tile x;
				int T ;
				if(Adapter.B1.getBoard()[i][j] == Adapter.B1.getPlayer1().getT1() ||Adapter.B1.getBoard()[i][j] == Adapter.B1.getPlayer1().getT2() )
				{
					T = 1;
				}else
				{
					T = 2;
				}
				if(!(Adapter.B1.getBoard()[i][j] instanceof Cube || Adapter.B1.getBoard()[i][j] instanceof Pyramid))
				 x = new Tile(new ImageIcon("Tile0.png"), i, j);
	
				else if(Adapter.B1.getBoard()[i][j] instanceof Cube)
				{
					x = new Tile(new ImageIcon("Tile0cube" + T + ".png"), i, j);
				}else
				{
					x = new Tile(new ImageIcon("Tile0Pyramid" + T + ".png"), i, j);
				}
				x.setSize(20, 20);
				gridPanel.add(x);
				m[i][j] = x;
				
				x.addMouseListener(this);
				x.setVisible(true);
			}
		}
		
	}
	public void highLight(ArrayList<Location> x) {
		for (int i = 0; i < x.size(); i++) {
			Location y = x.get(i);
			 tempTile = m[y.getX()][y.getY()];
			tempTile.setIcon(new ImageIcon("High" + Adapter.B1.getLevel()[y.getX()][y.getY()]+".png"));
		}
	}
	public void remove_highLight(ArrayList<Location> x) {
		for (int i = 0; i < x.size(); i++) {
			Location y = x.get(i);
		   tempTile = m[y.getX()][y.getY()];
			tempTile.setBorder(BorderFactory.createEmptyBorder());
			
			tempTile.setIcon(new ImageIcon("Tile" + Adapter.B1.getLevel()[y.getX()][y.getY()]+".png"));
		}
	}
	public void change_photo(int x , int y)
	{
		m[x][y].setIcon(new ImageIcon("Tile" + (Adapter.B1.getLevel()[x][y]) + ".png"));
	}
	public void change_piece(int x , int y)
	{ 
		String type = ""; int T;
	if(Adapter.B1.getBoard()[x][y] instanceof Cube)
		type = "Cube";
	else type = "Pyramid";
		
	if(Adapter.B1.getBoard()[x][y] == Adapter.B1.getPlayer1().getT1() ||Adapter.B1.getBoard()[x][y] == Adapter.B1.getPlayer1().getT2())
		 T = 1;
		else 
			T = 2;
			
	   String image = "Tile" + (Adapter.B1.getLevel()[x][y]) + (String)type + (int)T + ".png";
			m[x][y].setIcon(new ImageIcon(image));

	}
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
	  tempTile = (Tile) e.getSource();
		tempTile.setBorder(BorderFactory.createLoweredBevelBorder());
		try {
	
			Adapter.tile(tempTile.getXX(), tempTile.getYY(), this);
		} catch (InvalidMoveException e1){
			ExceptionWindow x = new ExceptionWindow(e1.getMessage());
		}catch( InvalidPlacementException e1) {
			ExceptionWindow x = new ExceptionWindow(e1.getMessage());
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		 tempTile = (Tile) e.getSource();
			tempTile.setBorder(BorderFactory.createEmptyBorder());
	/*		try {
		
				Adapter.tile(tempTile.getXX(), tempTile.getYY(), this);
			} catch (InvalidMoveException e1){
				
				e1.printStackTrace();
			}catch( InvalidPlacementException e1) {
			
			}*/

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		//BoardWindow f = new BoardWindow();
	}
}
