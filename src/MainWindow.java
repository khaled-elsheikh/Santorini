

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
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
public class MainWindow extends JFrame implements MouseListener, ActionListener {
	
	
	public MainWindow(){
		this.setTitle("Santorini");
		this.setSize(300, 300);
		this.setLocation(200, 100);
		ImageIcon x = new ImageIcon("background2.jpg");
		this.setContentPane(new JLabel(x));
		this.getContentPane().setLayout(new BorderLayout());
		WindowDestroyer myListener = new WindowDestroyer();
		addWindowListener(myListener);
		JPanel newGamePanel = new JPanel();
		newGamePanel.setOpaque(false);
		JPanel optionsPanel = new JPanel();
		optionsPanel.setOpaque(false);
		JPanel exitPanel = new JPanel();
		exitPanel.setOpaque(false);
		JButton newGameButton = new JButton("new game");
		newGameButton.setPreferredSize(new Dimension(100,20));
		newGameButton.addActionListener(this);
		newGamePanel.add(newGameButton);
		JButton descriptionButton = new JButton("description");
		descriptionButton.addActionListener(this);
		optionsPanel.add(descriptionButton);
		JButton exitButton = new JButton("exit");
		exitButton.addActionListener(this);
		exitPanel.add(exitButton);
		this.add(optionsPanel , BorderLayout.CENTER);
		this.add(exitPanel , BorderLayout.SOUTH);
		this.add(newGamePanel , BorderLayout.NORTH);

		newGameButton.setVisible(true);
		descriptionButton.setVisible(true);
		exitButton.setVisible(true);
		exitPanel.setOpaque(false);
		newGamePanel.setVisible(true);
		optionsPanel.setVisible(true);
		
		exitPanel.setVisible(true);
		
		this.setVisible(true);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("new game")) {
			newGameWindow y = new newGameWindow();
			this.setVisible(false);
            this.dispose();
		}else{
			if(e.getActionCommand().equals("exit")){
				this.setVisible(false);
                this.dispose();
			}else{
				if(e.getActionCommand().equals("description")){
					descriptionWindow y = new descriptionWindow();
					this.setVisible(false);
		            this.dispose();
				}
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
	public static void main (String[]args){
		MainWindow x = new MainWindow();
	}
	
	
}
