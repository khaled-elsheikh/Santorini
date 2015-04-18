
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InvalidPlacementExceptionWindow extends JFrame implements ActionListener {

	public InvalidPlacementExceptionWindow(){
		this.setTitle("Santorini");
		this.setSize(600, 600);
		this.setLocation(200, 100);
		ImageIcon x = new ImageIcon("image.png");
		this.setContentPane(new JLabel(x));
		this.getContentPane().setLayout(new BorderLayout());
		//WindowDestroyer myListener = new WindowDestroyer();
		//addWindowListener(myListener);
		JPanel exceptionPanel = new JPanel();
		exceptionPanel.setOpaque(false);
		
		
		JLabel exception = new JLabel("cannot place the tile here");
		exceptionPanel.add(exception);
		
		JButton ok = new JButton("ok");
		ok.addActionListener(this);
		exceptionPanel.add(ok);
		this.add(exceptionPanel,BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("ok")) {
			this.setVisible(false);
            this.dispose();
		}
		
	}

}
