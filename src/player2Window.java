import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class player2Window extends gameWindow {
	String P11;
	int P12;
	public player2Window(String s,String x,int y) {
		super(s);
		P11 = x;
		P12 = y;
	}
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("back")) {
			newGameWindow x = new newGameWindow();
			this.setVisible(false);
            this.dispose();
		}else 
		{

			if (  name == null || name.equals("") ) {
				missingNameExceptionWindow x = new missingNameExceptionWindow();
			} else {
			if(e.getActionCommand().equals("cube"))
			{
				BoardWindow x = new BoardWindow(P11,P12,this.name,1);
				this.dispose();
			}else{
				if(e.getActionCommand().equals("pyramid")){
					BoardWindow x = new BoardWindow(P11,P12,this.name,2);
					this.dispose();
				}
			}
		}
		}
		
	}
}
