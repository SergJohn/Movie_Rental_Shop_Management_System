package movie.rental.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

	public String[][] movieList() {
		
		String[][] data = null;
		
		try {
			
			String query = "SELECT * FROM titles;";
			String query_two = "SELECT * FROM titles WHERE memberships_membership_id = 2;"; 
			
			ResultSet rs = stmt.executeQuery(query);
			
			int line = 0;
			while(rs.next()) {
				line++;
			}
			
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
			
			//return data;
			
			
		}catch( SQLException se ){
			System.out.println( "SQL Exception:" );
			
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
		
		return data;
	}

}
