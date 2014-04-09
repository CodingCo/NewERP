package dataSource;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author kasper
 */
public class DBConnector {
    
    private static DBConnector instance;

    private static String username;
    private static String password;

    private DBConnector() {
	username = "cphre31";
	password = "krumme24";
    }
    
    public static DBConnector getInstance(){
	if(instance == null)
            instance = new DBConnector();
        return instance;
    }
    
    /**
     * Makes connection
     * 
     * @return Connection
     */
    public static Connection getConnection() {
	Connection con = null;
	try {
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	    con = DriverManager.getConnection(
		    "jdbc:oracle:thin:@datdb.cphbusiness.dk:1521:dat", username, password);
	} catch (Exception e) {
	    System.err.println(e);
	}

	return con;
    }
    
    /**
     * Ends chosen connection
     * 
     * @param con - Chosen connection
     */
    public static void releaseConnection(Connection con)
	  {
	      try{
	          con.close();
	      }
	      catch (Exception e)
	      {
		  System.err.println(e);
	      }
	  }
}
