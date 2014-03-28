package dataSource;

import domain.Apartment;
import domain.Booking;
import domain.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookingMapper {
    
    public ArrayList<Booking> getAllBookings(Connection con) {
	ArrayList<Booking> list = new ArrayList();

	String SQLString1 = "select * from bookings";
	String SQLString2 = "select * from customer where cust_id = ?";
	String SQLString3 = "select * from apartment where a_num = ?";
	String SQLString4 = "select* from apartment_type where type = ?";

	PreparedStatement statement1 = null;
	PreparedStatement statement2 = null;
	PreparedStatement statement3 = null;
	PreparedStatement statement4 = null;

	try {

	    statement1 = con.prepareStatement(SQLString1);
	    ResultSet rs1 = statement1.executeQuery();

	    while (rs1.next()) {
		statement2 = con.prepareStatement(SQLString2);
		statement2.setInt(1, rs1.getInt(2));
		ResultSet rs2 = statement2.executeQuery();
		rs2.next();
		
		statement3 = con.prepareStatement(SQLString3);
		statement3.setInt(1, rs1.getInt(3));
		ResultSet rs3 = statement3.executeQuery();
		rs3.next();
		
		statement4 = con.prepareStatement(SQLString4);
		statement4.setString(1, rs3.getString(2));
		ResultSet rs4 = statement4.executeQuery();
		rs4.next();
		
		Customer cus = new Customer(rs2.getInt(1),
			rs2.getString(2),
			rs2.getString(3),
			rs2.getInt(4),
			rs2.getString(5),
			rs2.getString(6),
			rs2.getString(7),
			rs2.getString(8),
			rs2.getString(10),
			rs2.getInt(9),
			rs2.getInt(11));
		
		Apartment ap = new Apartment(rs3.getInt(1),
			rs4.getInt(2),
			rs3.getString(2));
		
		list.add(new Booking(rs1.getInt(1),
			ap,
			cus,
			rs1.getInt(5),
			rs1.getString(4),
			rs1.getString(6),
			rs1.getDouble(7),
			rs1.getInt(8)));
	    }

	} catch (SQLException e) {
	    e.printStackTrace();
	} finally {
	    try {
		statement1.close();
		statement2.close();
		statement3.close();
		statement4.close();
	    } catch (SQLException e) {
		   e.printStackTrace();
	    }
	}
	return list;
    }

    /**
     * Takes a list of bookings, and inserts them into the database.
     *
     * @param blist
     * @param con
     * @return boolean
     */
    public boolean insertBookings(ArrayList<Booking> blist, Connection con) {

	String SQLString = "insert into bookings values (booking_seq.NEXTVAL,?, ?, ?, ?, ?, ?, ?)";
	String alterString = "ALTER SESSION SET NLS_DATE_FORMAT = 'DD-MM-YY'";
	PreparedStatement statement = null;

	try {
	    statement = con.prepareStatement(alterString);
	    statement.executeUpdate();
	    
	    for (Booking book : blist) {
		statement = con.prepareStatement(SQLString);
		statement.setInt(1, book.getCustomer().getCust_id());
		statement.setInt(2, book.getApartment().getA_num());
		statement.setString(3, book.getDate());
		statement.setInt(4, book.getNum_of_nights());
		statement.setString(5, book.getTravel_agency());
		statement.setDouble(6, book.getRent());
		statement.setInt(7, 0);
		statement.executeUpdate();
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
     * Takes a list of customer, and updates the database with the relevant
     * customers
     *
     * @param blist
     * @param con
     * @return boolean
     */
    public boolean updateBookings(ArrayList<Booking> blist, Connection con) {
	String SQLString = "update bookings set date_from = ?, "
		+ "num_of_nights = ?, "
		+ "travel_agency = ?, "
		+ "rent = ?, "
		+ "version_num = ?,"
		+ " where b_id = ?";
	PreparedStatement statement = null;

	try {
	    for (Booking booking : blist) {
		statement = con.prepareStatement(SQLString);
		statement.setString(1, booking.getDate());
		statement.setInt(2, booking.getNum_of_nights());
		statement.setString(3, booking.getTravel_agency());
		statement.setDouble(4, booking.getRent());
		statement.setInt(5, booking.getVersion());
		statement.setInt(6, booking.getB_id());
		statement.executeUpdate();
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
     * Takes a list of bookings, and deletes them from the database.
     *
     * @param blist
     * @param con
     * @return boolean
     */
    public boolean deleteBookings(ArrayList<Booking> blist, Connection con) {
	String SQLString = "delete from bookings where b_id = ?";
	PreparedStatement statement = null;

	try {
	    for (Booking booking : blist) {
		statement = con.prepareStatement(SQLString);
		statement.setInt(1, booking.getB_id());
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
}
