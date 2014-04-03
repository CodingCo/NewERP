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

    public int insertNewCustomer(Customer customer, Connection con) {

	String insertCustomerSQL = "INSERT INTO CUSTOMER VALUES(?,?,?,?,?,?,?,?,?,0)";
	int rowsInserted = 0;
	PreparedStatement statement = null;

	String SQLID = "select customer_seq.NEXTVAL from dual";
	int id = 0;
	try {
	    statement = con.prepareStatement(SQLID);
	    ResultSet s = statement.executeQuery();
	    while (s.next()) {
		id = s.getInt(1);
	    }
	} catch (Exception e) {

	}

	try {

	    statement = (PreparedStatement) con.prepareStatement(insertCustomerSQL);
	    statement.setInt(1, id);
	    statement.setString(2, customer.getFirst_name());
	    statement.setString(3, customer.getLast_name());
	    statement.setString(4, customer.getPhone());
	    statement.setString(5, customer.getEmail());
	    statement.setString(6, customer.getCountry());
	    statement.setString(7, customer.getCity());
	    statement.setString(8, customer.getZipcode());
	    statement.setString(9, customer.getStreet());
	    rowsInserted = statement.executeUpdate();

	} catch (SQLException ex) {
	    ex.printStackTrace();
	} finally {
	    try {
		statement.close();
	    } catch (Exception ex) {
		ex.printStackTrace();
	    }
	}
	return id;
    }

    public int updateCustomer(Connection con, Customer cus) {
	String SQLString = "update customer set"
		+ " first_name = ?,"
		+ " last_name = ?,"
		+ " phone = ?,"
		+ " email = ?,"
		+ " country = ?,"
		+ " city = ?,"
		+ " zipcode = ?,"
		+ " street = ?,"
		+ " version_num = (version_num + 1)"
		+ " where cust_id = ?"
		+ " and version_num = ?";
	int rowIns = 0;
	PreparedStatement stat = null;

	try {
	    stat = con.prepareStatement(SQLString);
	    stat.setString(1, cus.getFirst_name());
	    stat.setString(2, cus.getLast_name());
	    stat.setString(3, cus.getPhone());
	    stat.setString(4, cus.getEmail());
	    stat.setString(5, cus.getCountry());
	    stat.setString(6, cus.getCity());
	    stat.setString(7, cus.getZipcode());
	    stat.setString(8, cus.getStreet());
	    stat.setInt(9, cus.getCust_id());
	    stat.setInt(10, cus.getVersion());
	    
	    rowIns = stat.executeUpdate();
	} catch (SQLException e) {
	    System.err.println(e);
	    e.printStackTrace();
	} finally {
	    try {
		stat.close();
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	return rowIns;
    }
    
    public ArrayList<Customer> getAllCustomers(Connection con){
	ArrayList<Customer> list = new ArrayList();
	String SQLString = "select * from customer";
	PreparedStatement stat = null;
	
	try {
	    stat = con.prepareStatement(SQLString);
	    ResultSet rs = stat.executeQuery();
	    
	    while (rs.next()){
		list.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10)));
	    }
	}catch (SQLException e){
	    System.err.println(e);
	    e.printStackTrace();
	} finally {
	    try {
		stat.close();
	    } catch (SQLException e) {
		e.printStackTrace();
	    }
	}
	return list;
    }
}
