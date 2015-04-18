
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class newGameWindow extends JFrame implements MouseListener, ActionListener {

	public newGameWindow(){
		this.setTitle("Santorini");
		this.setSize(300, 300);
		this.setLocation(200, 100);
		setContentPane(new JLabel(new ImageIcon("background2.jpg")));
		this.getContentPane().setLayout(new BorderLayout());
		JPanel singlePlayerPanel = new JPanel();
		singlePlayerPanel.setBackground(Color.BLUE);
		this.add(singlePlayerPanel , BorderLayout.NORTH);
		singlePlayerPanel.setOpaque(false);
		JPanel multiPlayerPanel = new JPanel();
		this.add(multiPlayerPanel , BorderLayout.CENTER);
		multiPlayerPanel.setOpaque(false);
		JPanel backPanel = new JPanel();
		backPanel.setOpaque(false);
		this.add(backPanel , BorderLayout.SOUTH);
		JButton singlePlayerButton = new JButton("single player");
		singlePlayerButton.addActionListener(this);
		singlePlayerPanel.add(singlePlayerButton);
		JButton multiPlayerButton = new JButton("multiplayer");
		multiPlayerButton.addActionListener(this);
		multiPlayerPanel.add(multiPlayerButton);
		JButton backButton = new JButton("back");
		backButton.addActionListener(this);
		backPanel.add(backButton);
		singlePlayerButton.setVisible(true);
		multiPlayerButton.setVisible(true);
		backButton.setVisible(true);
		singlePlayerPanel.setVisible(true);
		multiPlayerPanel.setVisible(true);
		backPanel.setVisible(true);
		this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("back")) {
			MainWindow x = new MainWindow();
			this.setVisible(false);
            this.dispose();
		}else{
			if(e.getActionCommand().equals("single player")||
					e.getActionCommand().equals("multiplayer")){
						gameWindow x = new gameWindow("Player1 choose your pieces");
						this.setVisible(false);
			            this.dispose();
			}
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
	public static void main(String[]args){
		newGameWindow x = new newGameWindow();
	}

	

}
