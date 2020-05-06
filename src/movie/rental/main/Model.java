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
	 * return String[][] with data from DB
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
			
			data = new String[line][8];
			int row = 0;
			
			while(rs2.next()) {
				System.out.println(rs2.getString("title_id") + "\t" + 
									rs2.getString("title_name") + "\t" +
									rs2.getString("title_director") + "\t" +
									rs2.getString("title_genre") + "\t" + 
									rs2.getString("title_duration") + "\t" +
									rs2.getString("title_media") + "\t" +
									rs2.getString("title_year") + "\t" + 
									rs2.getString("memberships_membership_id"));
				
				// Adding data from DB into Data[][]
				data[row][0] = rs2.getString("title_id");
				data[row][1] = rs2.getString("title_name");
				data[row][2] = rs2.getString("title_director");
				data[row][3] = rs2.getString("title_genre");
				data[row][4] = rs2.getString("title_duration");
				data[row][5] = rs2.getString("title_media");
				data[row][6] = rs2.getString("title_year");
				data[row][7] = rs2.getString("memberships_membership_id");
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
	 * return String[][] with data from DB
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
			
			data = new String[line][8];
			int row = 0;
			
			while(rs2.next()) {
				System.out.println(rs2.getString("title_id") + "\t" + 
									rs2.getString("title_name") + "\t" +
									rs2.getString("title_director") + "\t" +
									rs2.getString("title_genre") + "\t" + 
									rs2.getString("title_duration") + "\t" +
									rs2.getString("title_media") + "\t" +
									rs2.getString("title_year") + "\t" + 
									rs2.getString("memberships_membership_id"));
				
				// Adding data from DB into Data[][]
				data[row][0] = rs2.getString("title_id");
				data[row][1] = rs2.getString("title_name");
				data[row][2] = rs2.getString("title_director");
				data[row][3] = rs2.getString("title_genre");
				data[row][4] = rs2.getString("title_duration");
				data[row][5] = rs2.getString("title_media");
				data[row][6] = rs2.getString("title_year");
				data[row][7] = rs2.getString("memberships_membership_id");
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
			
			data = new String[line][8];
			int row = 0;
			
			while(rs2.next()) {
				System.out.println(rs2.getString("title_id") + "\t" + 
									rs2.getString("title_name") + "\t" +
									rs2.getString("title_director") + "\t" +
									rs2.getString("title_genre") + "\t" + 
									rs2.getString("title_duration") + "\t" +
									rs2.getString("title_media") + "\t" +
									rs2.getString("title_year") + "\t" + 
									rs2.getString("memberships_membership_id"));
				
				// Adding data from DB into Data[][]
				data[row][0] = rs2.getString("title_id");
				data[row][1] = rs2.getString("title_name");
				data[row][2] = rs2.getString("title_director");
				data[row][3] = rs2.getString("title_genre");
				data[row][4] = rs2.getString("title_duration");
				data[row][5] = rs2.getString("title_media");
				data[row][6] = rs2.getString("title_year");
				data[row][7] = rs2.getString("memberships_membership_id");
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
			
			data = new String[line][8];
			int row = 0;
			
			while(rs2.next()) {
				System.out.println(rs2.getString("title_id") + "\t" + 
									rs2.getString("title_name") + "\t" +
									rs2.getString("title_director") + "\t" +
									rs2.getString("title_genre") + "\t" + 
									rs2.getString("title_duration") + "\t" +
									rs2.getString("title_media") + "\t" +
									rs2.getString("title_year") + "\t" + 
									rs2.getString("memberships_membership_id"));
				
				// Adding data from DB into Data[][]
				data[row][0] = rs2.getString("title_id");
				data[row][1] = rs2.getString("title_name");
				data[row][2] = rs2.getString("title_director");
				data[row][3] = rs2.getString("title_genre");
				data[row][4] = rs2.getString("title_duration");
				data[row][5] = rs2.getString("title_media");
				data[row][6] = rs2.getString("title_year");
				data[row][7] = rs2.getString("memberships_membership_id");
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
			
			data = new String[line][8];
			int row = 0;
			
			while(rs2.next()) {
				System.out.println(rs2.getString("title_id") + "\t" + 
									rs2.getString("title_name") + "\t" +
									rs2.getString("title_director") + "\t" +
									rs2.getString("title_genre") + "\t" + 
									rs2.getString("title_duration") + "\t" +
									rs2.getString("title_media") + "\t" +
									rs2.getString("title_year") + "\t" + 
									rs2.getString("memberships_membership_id"));
				
				// Adding data from DB into Data[][]
				data[row][0] = rs2.getString("title_id");
				data[row][1] = rs2.getString("title_name");
				data[row][2] = rs2.getString("title_director");
				data[row][3] = rs2.getString("title_genre");
				data[row][4] = rs2.getString("title_duration");
				data[row][5] = rs2.getString("title_media");
				data[row][6] = rs2.getString("title_year");
				data[row][7] = rs2.getString("memberships_membership_id");
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
			String query_two = "SELECT * FROM customers WHERE cust_id LIKE '%"+customer+"%' OR "
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
			
			data = new String[line][5];
			int row = 0;
			
			while(rs2.next()) {
				System.out.println(rs2.getString("cust_id") + "\t" + 
									rs2.getString("cust_name") + "\t" +
									rs2.getString("cust_phone_no") + "\t" +
									rs2.getString("cust_email") + "\t" + 
									rs2.getString("cust_address"));
				
				// Adding data from DB into Data[][]
				data[row][0] = rs2.getString("cust_id");
				data[row][1] = rs2.getString("cust_name");
				data[row][2] = rs2.getString("cust_phone_no");
				data[row][3] = rs2.getString("cust_email");
				data[row][4] = rs2.getString("cust_address");
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

	public void rent(String customer_email, String title1, String rentDate) {
		
		// Variable declaration
		String rent_return = rentDate.substring(0, 8);
		String cust_id;
		String subscription;
		String type;
		int points;
		
		// Simple validation to calculate return date
		int day = Integer.parseInt(rentDate.substring(8, 10));
		
		if(day > 28) {
			day = day - 27;
		}else {
			day = day + 3;
		}
		
		rent_return = rent_return.concat(Integer.toString(day));
		
		
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
				new addMessage(5);
			}
			else {
				// Step 5
				// Check total of customer rents per time
				if(!checkCustomerRents(cust_id)) {
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
							new addMessage(3);
							points = 0;
							String query3 = "UPDATE customers SET cust_points = '"+ points +"' WHERE cust_id = '"+ cust_id +"'";
							stmt.execute(query1);
							stmt.execute(query2);
							stmt.execute(query3);
							
						}else {
							points = points + 10;
							String query3 = "UPDATE customers SET cust_points = '"+ points +"' WHERE cust_id = '"+ cust_id +"'";
							stmt.execute(query1);
							stmt.execute(query2);
							stmt.execute(query3);
						}
								
						new addMessage(1);
				
					}else {
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

	private boolean checkCustomerRents(String cust_id) {
		
		boolean limitRent = true;
		
		try {
			String check_limit = "SELECT cust_rents FROM customers WHERE cust_id = '"+ cust_id +"'";
			ResultSet rs_limit = stmt.executeQuery(check_limit);
			ArrayList<String> result_limit = new ArrayList<>();
			while(rs_limit.next()) {
				result_limit.add(rs_limit.getString("available"));
			}
			
			if(result_limit.get(0).equals("true")) {
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

}
