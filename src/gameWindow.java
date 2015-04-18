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
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class gameWindow extends JFrame implements MouseListener, ActionListener {

	JTextField textBox;
	String name;

	public gameWindow(String s) {
		this.setTitle("Santorini");
		this.setSize(600, 600);
		this.setLocation(200, 100);
		ImageIcon x = new ImageIcon("background4.jpg");
		this.setContentPane(new JLabel(x));
		this.getContentPane().setLayout(new BorderLayout());
		WindowDestroyer myListener = new WindowDestroyer();
		addWindowListener(myListener);
		JPanel textPanel = new JPanel();
		textPanel.setOpaque(false);
		this.add(textPanel, BorderLayout.NORTH);
		//name = null;

		JPanel textBoxPanel = new JPanel();
		textBoxPanel.setOpaque(false);
		textBoxPanel.setForeground(Color.WHITE);
		this.add(textBoxPanel, BorderLayout.CENTER);
		JLabel hobba = new JLabel(s);
		textBox = new JTextField(30);
		
		hobba.setForeground(Color.WHITE);
		textBoxPanel.add(hobba);
		textBoxPanel.add(textBox);
		textBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				name = textBox.getText();

			}
		});
		textBoxPanel.setForeground(Color.WHITE);
		JPanel pyramidPanel = new JPanel();
		pyramidPanel.setOpaque(false);
		pyramidPanel.setLayout(new BorderLayout());
		this.add(pyramidPanel, BorderLayout.EAST);
		ImageIcon w = new ImageIcon("images (1).jpg");
		JLabel wi = new JLabel(w);
		pyramidPanel.add(wi, BorderLayout.CENTER);
		JButton pyramidButton = new JButton("pyramid");
		pyramidButton.setActionCommand("pyramid");
		pyramidButton.addActionListener(this);
		pyramidPanel.add(pyramidButton, BorderLayout.SOUTH);

		JPanel cubePanel = new JPanel();
		cubePanel.setOpaque(false);
		this.add(cubePanel, BorderLayout.WEST);
		cubePanel.setLayout(new BorderLayout());
		ImageIcon z = new ImageIcon("images.jpg");
		JLabel zi = new JLabel(z);
		cubePanel.add(zi, BorderLayout.CENTER);
		JButton cubeButton = new JButton("cube");
		cubeButton.addActionListener(this);
		cubeButton.setActionCommand("cube");
		cubePanel.add(cubeButton, BorderLayout.SOUTH);

		JPanel backPanel = new JPanel();
		backPanel.setOpaque(false);
		this.add(backPanel, BorderLayout.SOUTH);
		JButton backButton = new JButton("back");
		backButton.addActionListener(this);
		backPanel.add(backButton);
		backPanel.setVisible(true);
		textPanel.setVisible(true);
		pyramidPanel.setVisible(true);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		gameWindow x = new gameWindow("enter the name of player 1. Press enter after typing");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	

		if (e.getActionCommand().equals("back")) {
			newGameWindow x = new newGameWindow();
			this.setVisible(false);
			this.dispose();
		} else {
			if (  name == null || name.equals("") ) {
				missingNameExceptionWindow x = new missingNameExceptionWindow();
			} else {
				if (e.getActionCommand().equals("cube")) {

					player2Window x = new player2Window(
							"enter the name of player 2. Press enter after typing", name, 1);
					this.dispose();

				} else {
					if (e.getActionCommand().equals("pyramid")) {

						player2Window x = new player2Window(
								"enter the name of player 2. Press enter after typing", name, 2);
						this.dispose();
					}
				}
			}
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
