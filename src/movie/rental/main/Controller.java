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
	CustomerDash customerOptions;
	ArchiveDash itemsOptions;
	RentDash rentDash;
	
	public Controller() {
		
		view = new Dashboard(this);
		model = new Model();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Customer_menu
		if(e.getActionCommand().equals("customer_menu")) {
			System.out.println("Open view with customer options");
			customerOptions = new CustomerDash(this);
			view.dispose();
		}
		// Archive_menu
		else if(e.getActionCommand().equals("archive_menu")) {
			System.out.println("Open view with achive options");
			itemsOptions = new ArchiveDash(this);
			view.dispose();
		}
		// Renting_menu
		else if(e.getActionCommand().equals("rent_menu")) {
			System.out.println("Open view with Renting options");
			rentDash = new RentDash(this);
			view.dispose();
		}
	}

}
