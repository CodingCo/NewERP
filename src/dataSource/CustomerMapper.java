package dataSource;

import domain.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kasper
 */
public class CustomerMapper {
    
    public Customer getCostumer(int cust_id, Connection con){
	Customer tmpCu = null;
	PreparedStatement statement = null;

	String SQLString
		= "select * "
		+ "from customer"
		+ "where a_num = ?";

	try {

	    statement = con.prepareStatement(SQLString);

	    statement.setInt(1, cust_id);     // primary key value
	    ResultSet rs = statement.executeQuery();
	    if (rs.next()) {
		tmpCu = new Customer(cust_id,
			rs.getString(2),
			rs.getString(3),
			rs.getInt(4),
			rs.getString(5),
			rs.getInt(6),
			rs.getString(7),
			rs.getString(8),
			rs.getString(9),
			rs.getInt(10));
	    }

	} catch (SQLException e) {
	    System.err.print(e);
	} finally {
	    try {
		statement.close();
	    } catch (SQLException e) {
		System.err.print(e);
	    }
	}
	return tmpCu;
    }
}
