package movie.rental.main;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import movie.rental.titles.Title;

/**
*
* @author mrosa
*/
public class Model {
	
	String dbServer = "jdbc:mysql://localhost:3306/UltraVision";
    String user = "root";
    String password = "rootpass";
    Connection conn = null;
    Statement stmt = null;
    
    // Model Constructor
	public Model(){
	        
	        try{
	            // Get a connection to the database
	            conn = DriverManager.getConnection(dbServer, user, password) ;
	
	            // Get a statement from the connection
	            stmt = conn.createStatement() ;
	        }
	        catch( SQLException se){
	            System.out.println("SQL Exception:");
	            
	            // Loop through the SQL Exceptions
	            while( se != null ){
	                System.out.println( "State  : " + se.getSQLState()  ) ;
	                System.out.println( "Message: " + se.getMessage()   ) ;
	                System.out.println( "Error  : " + se.getErrorCode() ) ;
	
	                se = se.getNextException() ;
	            }
	        }
	        catch(Exception e){
	            System.out.println(e);
	        }
	        
	    }
	
	// Using an Inner Class to add and display the possible messages
	class addMessage extends JFrame implements movie.rental.interfaces.Message{
		
		int num = 0;
		
		// Creating options inside constructor to get the most suitable message
		public addMessage(int num) {
			this.num = num;
			if(num == 1) {
				addMessage();
			}
			else if(num == 2) {
				errorMessage();
			}
			else if(num == 3) {
				freeRentAllowed();
			}
			else if(num == 4) {
				limitRental();
			}
			else if(num == 5) {
				titleAlreadyTaken();
			}
			
		}
		// Using Interface Message to get this methods
		@Override
		public void addMessage() {
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        //Setting visible to false in order to show only the JPtioinPane, not the Frame
	        this.setVisible(false);
	        this.setSize(300,300);
	        
	        JOptionPane.showMessageDialog(this, "Operation made successfully!");
	        
	        this.validate();
	        this.repaint();
		}
		@Override
		public void errorMessage() {
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        //Setting visible to false in order to show only the JPtioinPane, not the Frame
	        this.setVisible(false);
	        this.setSize(300,300);
	        
	        JOptionPane.showMessageDialog(this, "You do not supposed to do that! Try again, Right this time");
	        
	        this.validate();
	        this.repaint();
		}
		@Override
		public void freeRentAllowed() {
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        //Setting visible to false in order to show only the JPtioinPane, not the Frame
	        this.setVisible(false);
	        this.setSize(300,300);
	        
	        JOptionPane.showMessageDialog(this, "Congratulations, 100 points! We are giving you a free rent");
	        
	        this.validate();
	        this.repaint();
			
		}
		@Override
		public void limitRental() {
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        //Setting visible to false in order to show only the JPtioinPane, not the Frame
	        this.setVisible(false);
	        this.setSize(300,300);
	        
	        JOptionPane.showMessageDialog(this, "You have already four titles! Take easy... Why do not open a book this time?");
	        
	        this.validate();
	        this.repaint();
			
		}
		@Override
		public void titleAlreadyTaken() {
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        //Setting visible to false in order to show only the JPtioinPane, not the Frame
	        this.setVisible(false);
	        this.setSize(300,300);
	        
	        JOptionPane.showMessageDialog(this, "Title already taken, pick another one");
	        
	        this.validate();
	        this.repaint();
			
		}
		
	}

	/**
	 * 
	 * Method String[][] movieList()
	 * @return String[][] with data from DB
	 * 
	 * */
	public String[][] movieList() {
		
		String[][] data = null;
		
		try {
			
			String query = "SELECT * FROM titles;";
			String query_two = "SELECT * FROM titles WHERE memberships_membership_id = 2 AND title_genre != 'Live Concert';"; 
			
			// Using the first query to find out how many lines of content we have in DB
			ResultSet rs = stmt.executeQuery(query);
			
			int line = 0;
			while(rs.next()) {
				line++;
			}
			
			// Using the second query to collect the data and insert into the variable to be returned
			ResultSet rs2 = stmt.executeQuery(query_two);
			
			data = new String[line][9];
			int row = 0;
			
			while(rs2.next()) {
				System.out.println(rs2.getString("title_id") + "\t" + 
									rs2.getString("title_name") + "\t" +
									rs2.getString("title_director") + "\t" +
									rs2.getString("title_genre") + "\t" + 
									rs2.getString("title_duration") + "\t" +
									rs2.getString("title_media") + "\t" +
									rs2.getString("title_year") + "\t" +
									rs2.getString("available") + "\t" +
									rs2.getString("memberships_membership_id"));
				
				// Adding data from DB into Data[][]
				data[row][0] = rs2.getString("title_id");
				data[row][1] = rs2.getString("title_name");
				data[row][2] = rs2.getString("title_director");
				data[row][3] = rs2.getString("title_genre");
				data[row][4] = rs2.getString("title_duration");
				data[row][5] = rs2.getString("title_media");
				data[row][6] = rs2.getString("title_year");
				data[row][7] = rs2.getString("available");
				data[row][8] = rs2.getString("memberships_membership_id");
				row++;
			}
			
		}catch( SQLException se ){
			System.out.println( "SQL Exception:" );
			
			// Looping through the SQL Exceptions
			while( se != null ){
				System.out.println( "State  : " + se.getSQLState()  ) ;
				System.out.println( "Message: " + se.getMessage()   ) ;
				System.out.println( "Error  : " + se.getErrorCode() ) ;

				se = se.getNextException() ;
			}
		}catch( Exception e ){
			System.out.println( e ) ;
		}
		
		return data;
	}

	/**
	 * 
	 * Method String[][] musicList()
	 * @return String[][] with data from DB
	 * 
	 * */
	public String[][] musicList() {
		
		String[][] data = null;
		
		try {
			
			String query = "SELECT * FROM titles;";
			String query_two = "SELECT * FROM titles WHERE memberships_membership_id = 1 AND title_media = 'CD' OR title_genre = 'Live Concert';"; 
			
			// Using the first query to find out how many lines of content we have in DB
			ResultSet rs = stmt.executeQuery(query);
			
			int line = 0;
			while(rs.next()) {
				line++;
			}
			
			// Using the second query to collect the data and insert into the variable to be returned
			ResultSet rs2 = stmt.executeQuery(query_two);
			
			data = new String[line][9];
			int row = 0;
			
			while(rs2.next()) {
				System.out.println(rs2.getString("title_id") + "\t" + 
									rs2.getString("title_name") + "\t" +
									rs2.getString("title_director") + "\t" +
									rs2.getString("title_genre") + "\t" + 
									rs2.getString("title_duration") + "\t" +
									rs2.getString("title_media") + "\t" +
									rs2.getString("title_year") + "\t" + 
									rs2.getString("available") + "\t" + 
									rs2.getString("memberships_membership_id"));
				
				// Adding data from DB into Data[][]
				data[row][0] = rs2.getString("title_id");
				data[row][1] = rs2.getString("title_name");
				data[row][2] = rs2.getString("title_director");
				data[row][3] = rs2.getString("title_genre");
				data[row][4] = rs2.getString("title_duration");
				data[row][5] = rs2.getString("title_media");
				data[row][6] = rs2.getString("title_year");
				data[row][7] = rs2.getString("available");
				data[row][8] = rs2.getString("memberships_membership_id");
				row++;
			}
			
		}catch( SQLException se ){
			System.out.println( "SQL Exception:" );
			
			// Looping through the SQL Exceptions
			while( se != null ){
				System.out.println( "State  : " + se.getSQLState()  ) ;
				System.out.println( "Message: " + se.getMessage()   ) ;
				System.out.println( "Error  : " + se.getErrorCode() ) ;

				se = se.getNextException() ;
			}
		}catch( Exception e ){
			System.out.println( e ) ;
		}
		
		return data;
	}

	/**
	 * Method which returns a Array 2D with data to be displayed by a table
	 * @method tvBoxList
	 * @return String[][] data
	 * */
	public String[][] tvBoxList() {
		
		String[][] data = null;
		
		try {
			
			String query = "SELECT * FROM titles;";
			String query_two = "SELECT * FROM titles WHERE memberships_membership_id = 3;"; 
			
			// Using the first query to find out how many lines of content we have in DB
			ResultSet rs = stmt.executeQuery(query);
			
			int line = 0;
			while(rs.next()) {
				line++;
			}
			
			// Using the second query to collect the data and insert into the variable to be returned
			ResultSet rs2 = stmt.executeQuery(query_two);
			
			data = new String[line][9];
			int row = 0;
			
			while(rs2.next()) {
				System.out.println(rs2.getString("title_id") + "\t" + 
									rs2.getString("title_name") + "\t" +
									rs2.getString("title_director") + "\t" +
									rs2.getString("title_genre") + "\t" + 
									rs2.getString("title_duration") + "\t" +
									rs2.getString("title_media") + "\t" +
									rs2.getString("title_year") + "\t" +
									rs2.getString("available") + "\t" +
									rs2.getString("memberships_membership_id"));
				
				// Adding data from DB into Data[][]
				data[row][0] = rs2.getString("title_id");
				data[row][1] = rs2.getString("title_name");
				data[row][2] = rs2.getString("title_director");
				data[row][3] = rs2.getString("title_genre");
				data[row][4] = rs2.getString("title_duration");
				data[row][5] = rs2.getString("title_media");
				data[row][6] = rs2.getString("title_year");
				data[row][7] = rs2.getString("available");
				data[row][8] = rs2.getString("memberships_membership_id");
				row++;
			}
			
		}catch( SQLException se ){
			System.out.println( "SQL Exception:" );
			
			// Looping through the SQL Exceptions
			while( se != null ){
				System.out.println( "State  : " + se.getSQLState()  ) ;
				System.out.println( "Message: " + se.getMessage()   ) ;
				System.out.println( "Error  : " + se.getErrorCode() ) ;

				se = se.getNextException() ;
			}
		}catch( Exception e ){
			System.out.println( e ) ;
		}
		
		return data;
	}

	/**
	 * Method which returns a Array 2D with data to be displayed by a table
	 * @method liveConcertList
	 * @return String[][] data
	 * */
	public String[][] liveConcertList() {
		
		String[][] data = null;
		
		try {
			
			String query = "SELECT * FROM titles;";
			String query_two = "SELECT * FROM titles WHERE title_genre = 'Live Concert' AND title_media = 'DVD';"; 
			
			// Using the first query to find out how many lines of content we have in DB
			ResultSet rs = stmt.executeQuery(query);
			
			int line = 0;
			while(rs.next()) {
				line++;
			}
			
			// Using the second query to collect the data and insert into the variable to be returned
			ResultSet rs2 = stmt.executeQuery(query_two);
			
			data = new String[line][9];
			int row = 0;
			
			while(rs2.next()) {
				System.out.println(rs2.getString("title_id") + "\t" + 
									rs2.getString("title_name") + "\t" +
									rs2.getString("title_director") + "\t" +
									rs2.getString("title_genre") + "\t" + 
									rs2.getString("title_duration") + "\t" +
									rs2.getString("title_media") + "\t" +
									rs2.getString("title_year") + "\t" +
									rs2.getString("available") + "\t" +
									rs2.getString("memberships_membership_id"));
				
				// Adding data from DB into Data[][]
				data[row][0] = rs2.getString("title_id");
				data[row][1] = rs2.getString("title_name");
				data[row][2] = rs2.getString("title_director");
				data[row][3] = rs2.getString("title_genre");
				data[row][4] = rs2.getString("title_duration");
				data[row][5] = rs2.getString("title_media");
				data[row][6] = rs2.getString("title_year");
				data[row][7] = rs2.getString("available");
				data[row][8] = rs2.getString("memberships_membership_id");
				row++;
			}
			
		}catch( SQLException se ){
			System.out.println( "SQL Exception:" );
			
			// Looping through the SQL Exceptions
			while( se != null ){
				System.out.println( "State  : " + se.getSQLState()  ) ;
				System.out.println( "Message: " + se.getMessage()   ) ;
				System.out.println( "Error  : " + se.getErrorCode() ) ;

				se = se.getNextException() ;
			}
		}catch( Exception e ){
			System.out.println( e ) ;
		}
		
		return data;
	}

	/**
	 * @method addNewTitle
	 * @param String name
	 * @param String director
	 * @param String genre
	 * @param int duration
	 * @param String media
	 * @param int year
	 * @param int membership
	 * 
	 * */
	public void addNewTitle(String name, String director, String genre, int duration, String media, int year, int membership) {
		
		try {
			String query = "INSERT INTO titles (title_name, title_director, title_genre, title_duration, title_media, title_year, memberships_membership_id)"
					+ " VALUES ('"+ name +"', '"+ director +"', '"+ genre +"', '"+ duration +"', '"+ media +"'"
							+ ", '"+ year +"', '"+ membership +"')" ;
			
			stmt.execute(query);
			new addMessage(1);
			
		}catch( SQLException se) {
			System.out.println("SQL Exception:");
			
			// Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
		}catch( Exception e ){
            System.out.println( e ) ;
    }
		
	}

	/**
	 * @method findTitle
	 * @param String title from JTextField on items/archives Dash Board
	 * @return Array string with data from DB
	 * */
	public String[][] findTitle(String title) {
		
		String[][] data = null;
		
		try {
			
			String query = "SELECT * FROM titles;";
			String query_two = "SELECT * FROM titles WHERE title_name LIKE '%"+ title +"%' OR "
					+ " title_director LIKE '%"+ title +"%' OR "
					+ " title_genre LIKE '%"+ title +"%' OR "
					+ " title_duration LIKE '%"+ title +"%' OR "
					+ " title_media LIKE '%"+ title +"%' OR "
					+ " title_year LIKE '%"+ title +"%' OR "
					+ " memberships_membership_id LIKE '%"+ title +"%';"; 
			
			// Using the first query to find out how many lines of content we have in DB
			ResultSet rs = stmt.executeQuery(query);
			
			int line = 0;
			while(rs.next()) {
				line++;
			}
			
			// Using the second query to collect the data and insert into the variable to be returned
			ResultSet rs2 = stmt.executeQuery(query_two);
			
			data = new String[line][9];
			int row = 0;
			
			while(rs2.next()) {
				System.out.println(rs2.getString("title_id") + "\t" + 
									rs2.getString("title_name") + "\t" +
									rs2.getString("title_director") + "\t" +
									rs2.getString("title_genre") + "\t" + 
									rs2.getString("title_duration") + "\t" +
									rs2.getString("title_media") + "\t" +
									rs2.getString("title_year") + "\t" + 
									rs2.getString("available") + "\t" + 
									rs2.getString("memberships_membership_id"));
				
				// Adding data from DB into Data[][]
				data[row][0] = rs2.getString("title_id");
				data[row][1] = rs2.getString("title_name");
				data[row][2] = rs2.getString("title_director");
				data[row][3] = rs2.getString("title_genre");
				data[row][4] = rs2.getString("title_duration");
				data[row][5] = rs2.getString("title_media");
				data[row][6] = rs2.getString("title_year");
				data[row][7] = rs2.getString("available");
				data[row][8] = rs2.getString("memberships_membership_id");
				row++;
			}
			
		}catch( SQLException se ){
			System.out.println( "SQL Exception:" );
			
			// Looping through the SQL Exceptions
			while( se != null ){
				System.out.println( "State  : " + se.getSQLState()  ) ;
				System.out.println( "Message: " + se.getMessage()   ) ;
				System.out.println( "Error  : " + se.getErrorCode() ) ;

				se = se.getNextException() ;
			}
		}catch( Exception e ){
			System.out.println( e ) ;
		}
		
		return data;
	}

	/**
	 * @method addNewCustomer
	 * @param String name
	 * @param String phone
	 * @param String email
	 * @param String address
	 * @param int subscription
	 * 
	 * */
	public void addNewCustomer(String name, String phone, String email, String address, int subscription) {
		
		try {
			String query = "INSERT INTO customers (cust_name, cust_phone_no, cust_email, cust_address)"
					+ " VALUES ('"+ name +"', '"+ phone +"', '"+ email +"', '"+ address +"');" ;
			
			String query2 = "SELECT cust_id FROM customers;";
			
			ResultSet rs = stmt.executeQuery(query2);
			ArrayList<String> result = new ArrayList<>();
			int row = 0;
			while(rs.next()) {
				System.out.println(rs.getString("cust_id"));
				result.add(rs.getString("cust_id"));
				row++;
			}
			System.out.println(result.size() + 1);
			int id = result.size() + 1;
			
			String query3 = "INSERT INTO subscriptions (memberships_membership_id, customers_cust_id) VALUES ('"+ subscription +"', '"+ id +"');";
			
			stmt.execute(query);
			
			stmt.execute(query3);
			new addMessage(1);
			
		}catch( SQLException se) {
			System.out.println("SQL Exception:");
			
			// Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
		}catch( Exception e ){
            System.out.println( e ) ;
    }
	}

	/**
	 * @method update subscription plan
	 * @param String email
	 * @param String subscription
	 * */
	public void updateSubscription(String email, String subscription) {
		
		try {
			
			String query = "SELECT cust_id FROM customers WHERE cust_email = '"+ email +"';";
			
			ResultSet rs = stmt.executeQuery(query);
			ArrayList<String> result = new ArrayList<>();
			int row = 0;
			while(rs.next()) {
				System.out.println(rs.getString("cust_id"));
				result.add(rs.getString("cust_id"));
				row++;
			}
			System.out.println(result.get(0));
			int id = Integer.parseInt(result.get(0));
			
			String query3 = "UPDATE subscriptions SET memberships_membership_id = '"+ Integer.parseInt(subscription) +"' WHERE "
					+ " customers_cust_id = '"+ id +"';";
			
			stmt.execute(query3);
			new addMessage(1);
			
		}catch( SQLException se) {
			System.out.println("SQL Exception:");
			
			// Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
		}catch( Exception e ){
            System.out.println( e ) ;
		}
	}

	/**
	 * @method findCustomer
	 * @param String customer from JTextField on customer Options/Dash Board
	 * @return Array string with data from DB
	 * */
	public String[][] findCustomer(String customer) {
		
		String[][] data = null;
		
		try {
			
			String query = "SELECT * FROM customers;";
			String query_two = "SELECT membership_name, cust_id, cust_name, cust_phone_no, cust_email, " 
					+ " cust_address, cust_points, cust_rents FROM customers "
					+ " INNER JOIN subscriptions "
					+ " ON subscriptions.customers_cust_id = customers.cust_id " 
					+ " INNER JOIN memberships " 
					+ " ON subscriptions.memberships_membership_id = memberships.membership_id "
					+ " WHERE cust_id LIKE '%"+customer+"%' OR "
					+ " cust_name LIKE '%"+customer+"%' OR "
					+ " cust_phone_no LIKE '%"+customer+"%' OR "
					+ " cust_email LIKE '%"+customer+"%' OR "
					+ " cust_address LIKE '%"+customer+"%';"; 
			
			// Using the first query to find out how many lines of content we have in DB
			ResultSet rs = stmt.executeQuery(query);
			
			int line = 0;
			while(rs.next()) {
				line++;
			}
			
			// Using the second query to collect the data and insert into the variable to be returned
			ResultSet rs2 = stmt.executeQuery(query_two);
			
			data = new String[line][8];
			int row = 0;
			
			while(rs2.next()) {
				System.out.println(rs2.getString("membership_name") + "\t" +
									rs2.getString("cust_id") + "\t" + 
									rs2.getString("cust_name") + "\t" +
									rs2.getString("cust_phone_no") + "\t" +
									rs2.getString("cust_email") + "\t" + 
									rs2.getString("cust_address") + "\t" + 
									rs2.getString("cust_points") + "\t" +
									rs2.getString("cust_rents"));
				
				// Adding data from DB into Data[][]
				data[row][0] = rs2.getString("membership_name");
				data[row][1] = rs2.getString("cust_id");
				data[row][2] = rs2.getString("cust_name");
				data[row][3] = rs2.getString("cust_phone_no");
				data[row][4] = rs2.getString("cust_email");
				data[row][5] = rs2.getString("cust_address");
				data[row][6] = rs2.getString("cust_points");
				data[row][7] = rs2.getString("cust_rents");
				row++;
			}
			
		}catch( SQLException se ){
			System.out.println( "SQL Exception:" );
			
			// Looping through the SQL Exceptions
			while( se != null ){
				System.out.println( "State  : " + se.getSQLState()  ) ;
				System.out.println( "Message: " + se.getMessage()   ) ;
				System.out.println( "Error  : " + se.getErrorCode() ) ;

				se = se.getNextException() ;
			}
		}catch( Exception e ){
			System.out.println( e ) ;
		}
		
		return data;
	}

	/**
	 * Method with a few steps inside to collect necessary data and proceed with rent
	 * @method rent
	 * @param String customer_email
	 * @param title1
	 * @param rentDate
	 * */
	public void rent(String customer_email, String title1, String rentDate) {
		
		// Variable declaration
		String rent_return = rentDate.substring(0, 5); //2020-xx-xx
		String middle = "-";
		String cust_id;
		String subscription;
		String type;
		int points;
		
		// Simple validation to calculate return date
		int day = Integer.parseInt(rentDate.substring(8, 10));
		int month = Integer.parseInt(rentDate.substring(4, 7));
		
		if(day > 28) {
			day = day - 27;
			month = month - 1;
			rent_return = rent_return.concat(Integer.toString(month)).concat(middle).concat(Integer.toString(day));
		}else {
			day = day + 3;
			rent_return = rent_return.concat(Integer.toString(month)).concat(middle).concat(Integer.toString(day));
		}
		
		//rent_return = rent_return.concat(Integer.toString(day));
		
		
		try {
			// Step 1
			// finding out customer's id from customer email
			String query = "SELECT cust_id FROM customers WHERE cust_email = '"+ customer_email +"';";
			
			ResultSet rs = stmt.executeQuery(query);
			ArrayList<String> result = new ArrayList<>();
			int row = 0;
			while(rs.next()) {
				System.out.println(rs.getString("cust_id"));
				result.add(rs.getString("cust_id"));
				row++;
			}
			
			cust_id = result.get(0);
			System.out.println(cust_id);
			System.out.println(rent_return);
			
			// Step 2
			// Query the Subscription entity to check if this customer can rent that specific title
			String query_sub = "SELECT memberships_membership_id FROM subscriptions WHERE customers_cust_id = '"+ cust_id +"';";
			
			ResultSet rs_sub = stmt.executeQuery(query_sub);
			ArrayList<String> result_sub = new ArrayList<>();
			while(rs_sub.next()) {
				result_sub.add(rs_sub.getString("memberships_membership_id"));
			}
			subscription = result_sub.get(0);
			System.out.println("subscription: " + subscription);
			//System.out.println(result_sub);
						
			// Step 3
			// Query the titles to find out the kind of membership the title is included
			String query_type = "SELECT memberships_membership_id FROM titles WHERE title_id = '"+ title1 +"';";
				
			ResultSet rs_type = stmt.executeQuery(query_type);
			ArrayList<String> result_type = new ArrayList<>();
			while(rs_type.next()) {
				result_type.add(rs_type.getString("memberships_membership_id"));
			}
			type = result_type.get(0);
			
			// Step 4
			// Check if title is available
			if(!checkTitleAvailability(title1)) {
				// Message in case the title was already taken
				new addMessage(5);
			}
			else {
				// Step 5
				// Check total of customer rents per time
				if(!checkCustomerRents(cust_id)) {
					// Message in case customer has already taken their four rents limit per time
					new addMessage(4);
				}else {
					// Step 6
					// Check customer points and in step 7 give a free rent in case points > 99
					String check_points = "SELECT cust_points FROM customers WHERE cust_id = '"+ cust_id +"';";
					ResultSet rs_points = stmt.executeQuery(check_points);
					ArrayList<String> result_points = new ArrayList<>();
					while(rs_points.next()) {
						result_points.add(rs_points.getString("cust_points"));
					}
					points = Integer.parseInt(result_points.get(0));
					
					// Step 7
					// Query to add the proceed with the RENT and include it to DB
					String query1 = "INSERT INTO rents (rent_return, rent_date, customers_cust_id, titles_title_id)"
							+ " VALUES ('"+ rent_return +"', '"+ rentDate +"', '"+ cust_id +"', '"+ title1 +"');" ;
					
					String query2 = "UPDATE titles SET available = 'false' WHERE title_id = '"+ title1 +"'";
					
							
					if(subscription.equals("4") || subscription.equals(type)) {
						
						if(points > 99) {
							// Message to inform that user got 100 points and delivery a free rent
							new addMessage(3);
							// reset points to zero
							points = 0;
							String query3 = "UPDATE customers SET cust_points = '"+ points +"' WHERE cust_id = '"+ cust_id +"'";
							stmt.execute(query1);
							stmt.execute(query2);
							stmt.execute(query3);
							
						}else {
							// Add 10 points for each rent
							points = points + 10;
							String query3 = "UPDATE customers SET cust_points = '"+ points +"' WHERE cust_id = '"+ cust_id +"'";
							stmt.execute(query1);
							stmt.execute(query2);
							stmt.execute(query3);
						}
						
						// Message when everything goes right		
						new addMessage(1);
				
					}else {
						
						// Message when user made a mistake or something that the system does not allows
						new addMessage(2);
					}
				}

			}
				
		}catch( SQLException se) {
			System.out.println("SQL Exception:");
			
			// Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
                new addMessage(2);
            }
		}catch( Exception e ){
            System.out.println( e ) ;
            new addMessage(2);
		}
		
	}

	/**
	 * This method checks the limit of 4 rents per time of a customer was reached or not
	 * @method checkCustomerRents
	 * @param String cust_id
	 * @return boolean
	 * */
	private boolean checkCustomerRents(String cust_id) {
		
		boolean limitRent = true;
		
		try {
			String check_limit = "SELECT cust_rents FROM customers WHERE cust_id = '"+ cust_id +"'";
			ResultSet rs_limit = stmt.executeQuery(check_limit);
			ArrayList<String> result_limit = new ArrayList<>();
			while(rs_limit.next()) {
				result_limit.add(rs_limit.getString("cust_rents"));
			}
			
			if(result_limit.get(0).equals("0") || result_limit.get(0).equals("1") || result_limit.get(0).equals("2") || result_limit.get(0).equals("3")) {
				int rent = Integer.parseInt(result_limit.get(0)) + 1;
				String set_rent = "UPDATE customers SET cust_rents = '"+ rent +"' WHERE cust_id = '"+ cust_id +"'";
				stmt.execute(set_rent);
				limitRent = true;
			}else {
				limitRent = false;
			}
			
		}catch( SQLException se) {
			System.out.println("SQL Exception:");
			
			// Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
		}catch( Exception e ){
            System.out.println( e ) ;
		}
		
		if(limitRent) {
			return true;
		}else {
			return false;
		}
		
	}
	
	/**
	 * This method will check the availability of a specific title
	 *@method checkTitleAvailability
	 *@param String title1 
	 * */
	private boolean checkTitleAvailability(String title1) {
		
		boolean available = true;
		
		try {
			String check_available = "SELECT available FROM titles WHERE title_id = '"+ title1 +"'";
			ResultSet rs_av = stmt.executeQuery(check_available);
			ArrayList<String> result_av = new ArrayList<>();
			while(rs_av.next()) {
				result_av.add(rs_av.getString("available"));
			}
			
			if(result_av.get(0).equals("true")) {
				available = true;
			}else {
				available = false;
			}
			
		}catch( SQLException se) {
			System.out.println("SQL Exception:");
			
			// Loop through the SQL Exceptions
            while( se != null ){
                System.out.println( "State  : " + se.getSQLState()  ) ;
                System.out.println( "Message: " + se.getMessage()   ) ;
                System.out.println( "Error  : " + se.getErrorCode() ) ;

                se = se.getNextException() ;
            }
		}catch( Exception e ){
            System.out.println( e ) ;
		}
		
		if(available) {
			return true;
		}else {
			return false;
		}
		
	}

	/**
	 * This method will get the email of the customer
	 * Query the DB to find out the titles with this customer
	 * Proceed the return of the titles
	 * 
	 * @method returnTitle
	 * @param String email
	 * 
	 * */
	public void returnTitle(String email) {
		
		if(email == null) {
			new addMessage(2);
		}else {
			
			try {
				
				// Step 1 -> find out customer ID using customer's email
				String find_id = "SELECT cust_id FROM customers WHERE cust_email = '"+ email +"';";
				
				ResultSet rs = stmt.executeQuery(find_id);
				ArrayList<String> result = new ArrayList<>();
				int row = 0;
				while(rs.next()) {
					System.out.println(rs.getString("cust_id"));
					result.add(rs.getString("cust_id"));
					row++;
				}
				System.out.println(result.get(0));
				int id = Integer.parseInt(result.get(0));
				
				// Step 2 -> find out title's ID
				String titles_id = "SELECT titles_title_id FROM rents WHERE customers_cust_id = '"+ id +"'";
				
				ResultSet rs_titles_id = stmt.executeQuery(titles_id);
				ArrayList<String> result_titles_id = new ArrayList<>();
				int row2 = 0;
				while(rs_titles_id.next()) {
					System.out.println(rs_titles_id.getString("titles_title_id"));
					result_titles_id.add(rs_titles_id.getString("titles_title_id"));
					row2++;
				}
				System.out.println(result_titles_id);
				
				// Step 3 -> turn titles returned back to available
				// If the customer have got just one title
				if(result_titles_id.size() == 1) {
					int id_titles = Integer.parseInt(result_titles_id.get(0));
					String set_available = "UPDATE titles SET available = 'true' WHERE title_id = '"+ id_titles +"'";
					stmt.execute(set_available);
				}
				// If the customer have got two titles
				if(result_titles_id.size() == 2) {
					int id_titles = Integer.parseInt(result_titles_id.get(0));
					String set_available = "UPDATE titles SET available = 'true' WHERE title_id = '"+ id_titles +"'";
					stmt.execute(set_available);
					
					int id_titles1 = Integer.parseInt(result_titles_id.get(1));
					String set_available1 = "UPDATE titles SET available = 'true' WHERE title_id = '"+ id_titles1 +"'";
					stmt.execute(set_available1);
				}
				// If the customer have got three titles
				if(result_titles_id.size() == 3) {
					int id_titles = Integer.parseInt(result_titles_id.get(0));
					String set_available = "UPDATE titles SET available = 'true' WHERE title_id = '"+ id_titles +"'";
					stmt.execute(set_available);
					
					int id_titles1 = Integer.parseInt(result_titles_id.get(1));
					String set_available1 = "UPDATE titles SET available = 'true' WHERE title_id = '"+ id_titles1 +"'";
					stmt.execute(set_available1);
					
					int id_titles2 = Integer.parseInt(result_titles_id.get(2));
					String set_available2 = "UPDATE titles SET available = 'true' WHERE title_id = '"+ id_titles2 +"'";
					stmt.execute(set_available2);
				}
				// If the customer have got four titles
				if(result_titles_id.size() == 4) {
					int id_titles = Integer.parseInt(result_titles_id.get(0));
					String set_available = "UPDATE titles SET available = 'true' WHERE title_id = '"+ id_titles +"'";
					stmt.execute(set_available);
					
					int id_titles1 = Integer.parseInt(result_titles_id.get(1));
					String set_available1 = "UPDATE titles SET available = 'true' WHERE title_id = '"+ id_titles1 +"'";
					stmt.execute(set_available1);
					
					int id_titles2 = Integer.parseInt(result_titles_id.get(2));
					String set_available2 = "UPDATE titles SET available = 'true' WHERE title_id = '"+ id_titles2 +"'";
					stmt.execute(set_available2);
					
					int id_titles3 = Integer.parseInt(result_titles_id.get(3));
					String set_available3 = "UPDATE titles SET available = 'true' WHERE title_id = '"+ id_titles3 +"'";
					stmt.execute(set_available3);
				}
				
				// Step 4 -> delete the rents made by customer
				String del_rent = "DELETE FROM rents WHERE customers_cust_id = '"+ id +"'";
				
				stmt.execute(del_rent);
				
				// Step 5 -> reset the number on column: cust_rents which can be max 4 (rents per time) 
				int zero = 0;
				String reset_num_rents = "UPDATE customers SET cust_rents = '"+ zero +"' WHERE cust_id = '"+ id +"'";
				
				stmt.execute(reset_num_rents);
				
				// Pop up message saying it's all done
				new addMessage(1);
				
				
			}catch( SQLException se) {
				System.out.println("SQL Exception:");
				
				// Loop through the SQL Exceptions
	            while( se != null ){
	                System.out.println( "State  : " + se.getSQLState()  ) ;
	                System.out.println( "Message: " + se.getMessage()   ) ;
	                System.out.println( "Error  : " + se.getErrorCode() ) ;

	                se = se.getNextException() ;
	            }
			}catch( Exception e ){
	            System.out.println( e ) ;
			}
		}
	}

}
