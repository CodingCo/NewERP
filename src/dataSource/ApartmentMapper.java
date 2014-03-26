package dataSource;

import domain.Apartment;

import java.util.ArrayList;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kasper
 */

public class ApartmentMapper {
    
    /**
     *
     * @param a_num
     * @param con
     * @return
     */
    public Apartment getApartment(int a_num, Connection con) {
	Apartment tmpAp = null;
	PreparedStatement statement = null;

	String SQLString
		= "select * "
		+ "from apartments "
		+ "where a_num = ?";

	try {

	    statement = con.prepareStatement(SQLString);

	    statement.setInt(1, a_num);     // primary key value
	    ResultSet rs = statement.executeQuery();
	    if (rs.next()) {
		tmpAp = new Apartment(a_num,
			rs.getString(2));
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
	return tmpAp;
    }

    
    //== Methods


}
