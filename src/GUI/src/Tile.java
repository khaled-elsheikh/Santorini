package GUI.src;

import javax.swing.Icon;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class Tile extends JLabel{
	
	private int layer;
	
	public Tile() { }
	
	public Tile(Icon ico)
	{
		super(ico);
		layer = 1; 
	}

	public void setLayer(int layer) {
		this.layer = layer;
	}

	public int getLayer() {
		return layer;
	}

}
