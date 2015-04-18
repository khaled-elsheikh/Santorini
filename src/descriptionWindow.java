

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class descriptionWindow extends JFrame implements MouseListener, ActionListener {
	
	JLabel description1 = new JLabel("The game starts with each player having 2 pieces placed on the board.");
	JLabel description2 = new JLabel("After moving a piece, a player should place a tile next to the new location of the just moved piece.");
	JLabel description3 = new JLabel("Pieces can jump on tiles according to some rules.");
	JLabel description4 = new JLabel("The player who succeeds in bringing one of their tiles on top of a 3 tiles tower wins.");
	
	
	
	public descriptionWindow(){
		this.setSize(1920, 1200);
		this.setLocation(200, 100);
		ImageIcon x = new ImageIcon("blue_lights-wide.jpg");
		this.setContentPane(new JLabel(x));
		this.getContentPane().setLayout(new BorderLayout());
		WindowDestroyer myListener = new WindowDestroyer();
		addWindowListener(myListener);
		JPanel descriptionPanel = new JPanel();
		descriptionPanel.setOpaque(false);
		descriptionPanel.setLayout(new BorderLayout());
		this.add(descriptionPanel , BorderLayout.NORTH);
		//URL mediaURL = :"www.youtube.com/watch?v=JmPzVjdweYI";
		//Player mediaPlayer = Manager.createRealizedPlayer(mediaURL);
		//Component video = mediaPlayer.getVisualComponent();
        //Component controls = mediaPlayer.getControlPanelComponent();
        //descriptionPanel.add(video,BorderLayout.CENTER);
        //descriptionPanel.add(controls,BorderLayout.SOUTH);
		
		JPanel center = new JPanel();
		center.setOpaque(false);
		center.setLayout(new FlowLayout(3));
		JLabel cube = new JLabel(new ImageIcon("Tile0Cube1.png"));
		JLabel cubeText = new JLabel("the cube is piece number one and it can move vertically and horizontally");
		cubeText.setForeground(Color.WHITE);
		JLabel pyramid = new JLabel(new ImageIcon("Tile0Pyramid1"));
		JLabel pyramidText = new JLabel("the pyramid is piece number two and it can move diagonally");
		pyramidText.setForeground(Color.WHITE);
		center.add(cube);
		center.add(cubeText);
		center.add(pyramid);
		center.add(pyramidText);
		this.add(center,BorderLayout.CENTER);
		
		//cube.add(new ImageIcon("TILE0CUBE1.png"));
		
		JPanel backPanel = new JPanel();
		backPanel.setOpaque(false);
		this.add(backPanel , BorderLayout.SOUTH);
		JButton backButton = new JButton("back");
		backButton.addActionListener(this);
		backPanel.add(backButton);
		description1.setForeground(Color.WHITE);
		description2.setForeground(Color.WHITE);
		description3.setForeground(Color.WHITE);
		description4.setForeground(Color.WHITE);
		descriptionPanel.add(description1,BorderLayout.NORTH);
		descriptionPanel.add(description2,BorderLayout.EAST);
		descriptionPanel.add(description3,BorderLayout.WEST);
		descriptionPanel.add(description4,BorderLayout.SOUTH);
		backButton.setVisible(true);
		description1.setVisible(true);
		description2.setVisible(true);
		description3.setVisible(true);
		description4.setVisible(true);
		descriptionPanel.setVisible(true);
		backPanel.setVisible(true);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("back")) {
			MainWindow x = new MainWindow();
			this.setVisible(false);
            this.dispose();
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
