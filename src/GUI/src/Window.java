package GUI.src;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

@SuppressWarnings("serial")
public class Window extends JFrame implements ActionListener, MouseListener {

	Tile[] labels;
	Tile tempTile;
	JPanel gridPanel, buttonPanel;

	public Window(int rows, int columns) {
		super();
		setTitle("CSEN401 - GUI Lab");
		setSize(1000, 700);
		setLocation(200, 100);
		Container content = getContentPane();
		content.setBackground(Color.orange);
		content.setLayout(new BorderLayout());

		labels = new Tile[rows * columns];

		InitPanels(rows, columns);
		InitGridTiles();
		CreateButtons();
		setVisible(true);

		WindowDestroyer wd = new WindowDestroyer();
		addWindowListener(wd);
	}

	public void InitPanels(int row, int column) {
		// Create Panel for the tiles grid
		gridPanel = new JPanel(new GridLayout(row, column));
		gridPanel.setBackground(Color.orange);
		add(gridPanel, BorderLayout.CENTER);

		// Create panel for the buttons vertical bar
		buttonPanel = new JPanel(new GridLayout(10, 1));
		buttonPanel.setBackground(Color.orange);
		add(buttonPanel, BorderLayout.EAST);
	}

	public void InitGridTiles() {
		// ImageIcon icon = new
		// ImageIcon("C:/Users/Mohamed/Downloads/GUI/Assets/Layer1.png");

		for (int i = 0; i < labels.length; i++) {
			// labels[i] = new Tile(icon);
			labels[i].addMouseListener(this);
			gridPanel.add(labels[i]);
		}
	}

	public void CreateButtons() {
		JLabel label = new JLabel("Build");
		label.setHorizontalAlignment(JLabel.CENTER);
		buttonPanel.add(label);

		ImageIcon icon = new ImageIcon(
				"C:/Users/Mohamed/Downloads/GUI/Assets/Hammer.png");
		Button button1 = new Button(icon, "Build", this);
		buttonPanel.add(button1);

		JLabel gap = new JLabel("");
		buttonPanel.add(gap);

		JLabel label2 = new JLabel("Destroy");
		label2.setHorizontalAlignment(JLabel.CENTER);
		buttonPanel.add(label2);

		ImageIcon icon2 = new ImageIcon(
				"C:/Users/Mohamed/Downloads/GUI/Assets/Destroy.png");
		Button button2 = new Button(icon2, "Destroy", this);
		buttonPanel.add(button2);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Build")) {
			if (tempTile != null) {
				if (tempTile.getLayer() >= 3)
					return;
				tempTile.setLayer(tempTile.getLayer() + 1);
				tempTile.setIcon(new ImageIcon(
						"C:/Users/Mohamed/Downloads/GUI/Assets/Layer"
								+ tempTile.getLayer() + ".png"));
			}
		} else if (e.getActionCommand().equals("Destroy")) {
			if (tempTile != null) {
				if (tempTile.getLayer() <= 1)
					return;
				tempTile.setLayer(tempTile.getLayer() - 1);
				tempTile.setIcon(new ImageIcon(
						"C:/Users/Mohamed/Downloads/GUI/Assets/Layer"
								+ tempTile.getLayer() + ".png"));
			}
		}
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
		tempTile.setBorder(BorderFactory.createLoweredSoftBevelBorder());

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		tempTile.setBorder(BorderFactory.createEmptyBorder());

	}

}
