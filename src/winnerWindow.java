import java.awt.BorderLayout;
import java.awt.Dimension;
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
public class winnerWindow extends JFrame implements ActionListener,
MouseListener {
	BoardWindow y ;
	public winnerWindow(BoardWindow f){
		y = f;
		this.setTitle("Santorini");
		this.setSize(400, 70);
		this.setLocation(200, 100);
		//ImageIcon x = new ImageIcon("image.png");
		//this.setContentPane(new JLabel(x));
		this.getContentPane().setLayout(new BorderLayout());
		WindowDestroyer myListener = new WindowDestroyer();
		addWindowListener(myListener);
		
		JPanel donePanel = new JPanel();
		//donePanel.setLayout(new BorderLayout());
		donePanel.setOpaque(false);
		this.add(donePanel,BorderLayout.CENTER);
		
		JLabel winnerLabel = new JLabel();
		winnerLabel.setText("the winner is : " + f.Adapter.B1.getWinner().getName());
		donePanel.add(winnerLabel,BorderLayout.NORTH);
		
		JButton newGameButton = new JButton("new game");
		newGameButton.addActionListener(this);
		donePanel.add(newGameButton,BorderLayout.WEST);
		JButton exitButton = new JButton("exit");

		exitButton.addActionListener(this);
		donePanel.add(exitButton ,BorderLayout.EAST);
		//add(exitButton);
		//add(newGameButton);
		//exitButton.setSize(new Dimension(60,60));
		//newGameButton.setSize(new Dimension(50,60));
		//exitButton.setLocation(300, 100);
		//newGameButton.setLocation(300,300);
		this.setVisible(true);
		

	}
	
	
	public static void main(String[] args) {
		

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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("exit")) {
			y.dispose();
			this.setVisible(false);
            this.dispose();
		}else{
			if(e.getActionCommand().equals("new game")){
						gameWindow x = new gameWindow("Player1 choose your pieces");
						this.setVisible(false);
			            this.dispose();
			}
		}
		
	}

}
