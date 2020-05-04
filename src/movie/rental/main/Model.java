package movie.rental.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
	
	// Using an Inner Class to add a completion message
	class addMessage extends JFrame implements movie.rental.interfaces.Message{
		
		public addMessage() {
			addMessage();
		}
		@Override
		public void addMessage() {
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        //Setting visible to false in order to show only the JPtioinPane, not the Frame
	        this.setVisible(false);
	        this.setSize(300,300);
	        
	        JOptionPane.showMessageDialog(this, "Title added!");
	        
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

	public void addNewTitle(String name, String director, String genre, String duration, String media, String year, String membership) {
		
		try {
			String query = "INSERT INTO titles (title_name, title_director, title_genre, title_duration, title_media, title_year, memberships_membership_id)"
					+ " VALUES ('"+ name +"', '"+ director +"', '"+ genre +"', '"+ duration +"', '"+ media +"'"
							+ ", '"+ year +"', '"+ membership +"')" ;
			
			stmt.execute(query);
			new addMessage();
			
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
