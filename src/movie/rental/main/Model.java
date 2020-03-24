package movie.rental.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
*
* @author mrosa
*/
public class Model {
	
	String dbServer = "jdbc:mysql://'address'/'dbname'";
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

}
