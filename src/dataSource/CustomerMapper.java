package dataSource;

import domain.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author kasper
 */
public class CustomerMapper {

    /**
     * Takes a list of costumer, and inserts them into the database.
     * 
     * @param clist
     * @param con
     * @return
     */
    public boolean insertCustomers(ArrayList<Customer> clist, Connection con) {
	String SQLString = "insert into costumer values (customer_seq.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";
	PreparedStatement statement = null;

	try {
	    for (Customer cust : clist) {
		statement = con.prepareStatement(SQLString);
		statement.setString(1, cust.getName());
		statement.setString(2, cust.getFamily_name());
		statement.setInt(3, cust.getAge());
		statement.setString(4, cust.getEmail());
		statement.setString(5, cust.getPhone());
		statement.setString(6, cust.getCountry());
		statement.setString(7, cust.getCity());
		statement.setInt(8, cust.getZipcode());
		statement.setString(9, cust.getStreet());
		statement.setInt(10, 0);
		int c = statement.executeUpdate();
                System.out.println(c);
	    }
	} catch (SQLException e) {
	    e.printStackTrace();
	    return false;
	} finally {
	    try {
		statement.close();
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	return true;
    }

    /**
     *Takes a list of costumers, and changes the relevant costumers in the database.
     * @param clist
     * @param con
     * @return
     */
    public boolean updateCustomers(ArrayList<Customer> clist, Connection con) {
	String SQLString = "update costumer set first_name = ?,"
		+ "family_name = ?,"
		+ "age = ?,"
		+ "email = ?,"
		+ "phone = ?,"
		+ "country = ?,"
		+ "city = ?,"
		+ "zipcode = ?,"
		+ "street = ?,"
		+ "version_num = ?"
		+ " where cust_id = ?";
	PreparedStatement statement = null;

	try {
	    for (Customer cust : clist) {
		statement = con.prepareStatement(SQLString);
		statement.setInt(1, cust.getCust_id());
		statement.setString(2, cust.getName());
		statement.setString(3, cust.getFamily_name());
		statement.setInt(4, cust.getAge());
		statement.setString(5, cust.getEmail());
		statement.setString(6, cust.getPhone());
		statement.setString(7, cust.getCountry());
		statement.setString(8, cust.getCity());
		statement.setInt(9, cust.getZipcode());
		statement.setString(10, cust.getStreet());
		statement.setInt(11, cust.getVersion());
		statement.executeUpdate();
	    }
	} catch (SQLException e) {
	    System.err.println(e);
	    return false;
	} finally {
	    try {
		statement.close();
	    } catch (SQLException e) {
		System.err.println(e);
	    }
	}
	return true;
    }

    /**
     *Retrieves all customers in the database, as objects in an ArrayList.
     * @param con
     * @return
     */
    public ArrayList<Customer> getAllCustomers(Connection con) {
	ArrayList<Customer> list = new ArrayList();
	String SQLString = "select * from bookings";
	PreparedStatement statement = null;

	try {
	    statement = con.prepareStatement(SQLString);
	    ResultSet rs = statement.executeQuery();

	    while (rs.next()) {
		list.add(new Customer(rs.getInt(1),
			rs.getString(2),
			rs.getString(3),
			rs.getInt(4),
			rs.getString(6),
			rs.getString(5),
			rs.getString(7),
			rs.getString(8),
			rs.getString(10),
			rs.getInt(9),
			rs.getInt(11)));

	    }
	} catch (SQLException e) {
	    System.err.println(e);
	} finally {
	    try {
		statement.close();
	    } catch (SQLException e) {
		System.err.println(e);
	    }
	}
	return list;
    }
}
