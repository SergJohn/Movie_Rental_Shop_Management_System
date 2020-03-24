package movie.rental.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
*
* @author mrosa
*/
public class Controller implements ActionListener {
	
	public Model model;
	Dashboard view;
	
	public Controller() {
		
		view = new Dashboard(this);
		model = new Model();
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
	}

}
