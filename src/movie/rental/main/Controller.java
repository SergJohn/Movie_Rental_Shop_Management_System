package movie.rental.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import movie.rental.titles.MovieList;

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
	MovieList movieList;
	
	public Controller() {
		
		view = new Dashboard(this);
		model = new Model();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		/*
		 * The three main views:
		 * Customer
		 * Items -> also known as Titles or Archives
		 * and Rent
		 * 
		 * */
		
		// Customer_menu
		if(e.getActionCommand().equals("customer_menu")) {
			System.out.println("Open view with customer options");
			customerOptions = new CustomerDash(this);
			view.setVisible(false);
		}
		
		// Archive_menu
		else if(e.getActionCommand().equals("archive_menu")) {
			System.out.println("Open view with achive options");
			itemsOptions = new ArchiveDash(this);
			view.setVisible(false);
		}
		
		// Renting_menu
		else if(e.getActionCommand().equals("rent_menu")) {
			System.out.println("Open view with Renting options");
			rentDash = new RentDash(this);
			view.setVisible(false);
		}
		
		/*
		 * Go back from the 3 main views
		 * Customer
		 * Items -> also known as archive or titles
		 * and Rent
		 * 
		 * */
		
		// Go_back_customers
		else if(e.getActionCommand().equals("go_back_customer")) {
			System.out.println("back to Main Dashboard");
			customerOptions.dispose();
			view.setVisible(true);
		}
		// Go_back_items
		else if(e.getActionCommand().equals("go_back_items")) {
			System.out.println("back to Main Dashboard");
			itemsOptions.dispose();
			view.setVisible(true);
		}
		// Go_back_rent
		else if(e.getActionCommand().equals("go_back_rent")) {
			System.out.println("back to Main Dashboard");
			rentDash.dispose();
			view.setVisible(true);
		}
		
		/*
		 * Displaying lists and its go_back buttons
		 * */
		
		// Opening movie_list view
		else if(e.getActionCommand().equals("movie_list")) {
			System.out.println("Going to movie list");
			itemsOptions.setVisible(false);
			movieList = new MovieList(this);
			
		}
		// Going back to archive's view
		else if(e.getActionCommand().equals("go_back_archive")) {
			System.out.println("Going to Titles Dash");
			itemsOptions.setVisible(true);
			movieList.dispose();
			
		}
		
	}

}
