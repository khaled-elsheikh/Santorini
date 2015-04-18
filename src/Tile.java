import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class Tile extends JLabel {
	private int xx;
	private int yy;
	public Tile(ImageIcon icon, int x, int y){
		super(icon);
		this.xx = x;
		this.yy = y;
	}

	public Tile(ImageIcon icon){
		super(icon);

	}
	public int getXX() {
		return xx;
	}
	public void setXX(int x) {
		this.xx = x;
	}
	public int getYY() {
		return yy;
	}
	public void setYY(int y) {
		this.yy = y;
	}
	

}
