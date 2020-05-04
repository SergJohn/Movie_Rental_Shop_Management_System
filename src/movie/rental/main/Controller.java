package movie.rental.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import movie.rental.titles.AddNewTitle;
import movie.rental.titles.LiveConcertList;
import movie.rental.titles.MovieList;
import movie.rental.titles.MusicList;
import movie.rental.titles.TVBoxList;

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
	MusicList musicList;
	TVBoxList tvBoxList;
	LiveConcertList liveConcertList;
	AddNewTitle addNewTitleView;
	TitleFound titleFound;
	
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
		
		/*
		 * Movie's list
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
		
		/*
		 * Music's list
		 * */
		
		else if(e.getActionCommand().equals("music_list")) {
			System.out.println("Going to music list");
			itemsOptions.setVisible(false);
			musicList = new MusicList(this);	
		}
		// Going back to archive's view
		else if(e.getActionCommand().equals("go_back_archive_from_music")) {
			System.out.println("Going to Titles Dash");
			itemsOptions.setVisible(true);
			musicList.dispose();	
		}
		
		/*
		 * TVBox's list
		 * */
		
		else if(e.getActionCommand().equals("tv_box_list")) {
			System.out.println("Going to TV Box list");
			itemsOptions.setVisible(false);
			tvBoxList = new TVBoxList(this);	
		}
		// Going back to archive's view
		else if(e.getActionCommand().equals("go_back_archive_from_TVBox")) {
			System.out.println("Going to Titles Dash");
			itemsOptions.setVisible(true);
			tvBoxList.dispose();	
		}
		
		/*
		 * LiveConcert's list
		 * */
		
		else if(e.getActionCommand().equals("live_concert_list")) {
			System.out.println("Going to Live Concert's list");
			itemsOptions.setVisible(false);
			liveConcertList = new LiveConcertList(this);	
		}
		// Going back to archive's view
		else if(e.getActionCommand().equals("go_back_archive_from_live_concert_list")) {
			System.out.println("Going to Titles Dash");
			itemsOptions.setVisible(true);
			liveConcertList.dispose();	
		}
		
		/*
		 * Adding new title
		 * */
		
		// View to get new title's information
		else if(e.getActionCommand().equals("add_new_title_view")) {
			System.out.println("Opening view of adding new title");
			addNewTitleView = new AddNewTitle(this);
			itemsOptions.setVisible(false);
		}
		// Going back to archive's view
		else if(e.getActionCommand().equals("go_back_archive_from_add_new_title")) {
			System.out.println("Going to Titles Dash");
			itemsOptions.setVisible(true);
			addNewTitleView.dispose();	
		}
		// Sending title's information to model to proceed with db registration
		else if(e.getActionCommand().equals("add_new_title")) {
			
			// Getting data from JTextFields
			String name = addNewTitleView.name.getText();
			String director = addNewTitleView.director.getText();
			String genre = addNewTitleView.genre.getText();
			int duration = Integer.parseInt(addNewTitleView.duration.getText());
			String media = addNewTitleView.media.getText();
			int year = Integer.parseInt(addNewTitleView.year.getText());
			int membership = Integer.parseInt(addNewTitleView.membership.getText());
			// Calling model and passing arguments
			model.addNewTitle(name, director, genre, duration, media, year, membership);
		}
		
		/*
		 * Finding a title
		 * */
		
		// Opening view to display found title
		else if(e.getActionCommand().equals("find_title")) {
			
			String title = itemsOptions.findTitleTxt.getText();
			itemsOptions.setVisible(false);
			titleFound = new TitleFound(this, title);
		}
		// Going back title's Dash from found title
		else if(e.getActionCommand().equals("go_back_archive_from_found_title")) {
			titleFound.dispose();
			itemsOptions.setVisible(true);
		}
		
		
		
	}

}
