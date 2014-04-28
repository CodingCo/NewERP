package dataSource;

import errorHandling.ConnectionException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DBConnector contains the methods for making database connections.
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

    public static DBConnector getInstance() {
        if (instance == null) {
            instance = new DBConnector();
        }
        return instance;
    }

    /**
     * Makes connection
     *
     * @return Connection
     * @throws errorHandling.ConnectionException
     * @author Kasper
     */
    public static Connection getConnection() throws ConnectionException {
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@datdb.cphbusiness.dk:1521:dat", username, password);
        } catch (ClassNotFoundException e) {
            throw new ConnectionException("Connection could not be established to the database \n check your internet connection and try again");
        } catch (SQLException e) {
            throw new ConnectionException("Connection could not be established to the database \n check your internet connection and try again");
        }
        return con;
    }

    /**
     * Ends chosen connection
     *
     * @param con - Chosen connection
     * @author kasper
     */
    public static void releaseConnection(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {

        }
    }
}
