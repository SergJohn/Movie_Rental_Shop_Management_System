package movie.rental.main;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
*
* @author mrosa
*/
public class Dashboard extends JFrame {
	
	private Controller controller;
	
	public Dashboard(Controller controller) {
		
		this.controller = controller;
		
		attributesSetter();
        components();
        validation();
        
	}

	private void attributesSetter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(300,400);
        this.setTitle("Dashboard");
		
	}
	
	private void components() {
		
		
		
	}
	
	private void validation() {
		this.validate();
        this.repaint();
	}

}
