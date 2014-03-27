package dataSource;

import domain.Booking;
import domain.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookingMapper {

    public BookingMapper() {
    }

    //== Methods
    public ArrayList<Booking> getAllBookings(Connection con) {
        return null;
    }

    public boolean insertBookings(ArrayList<Booking> blist, Connection con) {
        
	String SQLString = "insert into bookings values (bookings_seq.NEXTVAL,"
		+ "";
	PreparedStatement statement = null;

	try {
	    for (Booking book : blist) {
		statement = con.prepareStatement(SQLString);
		statement.setInt(1, book.getB_id());
		statement.setInt(2, book.getCustomer().getCust_id());
		statement.setInt(3, book.getApartment().getA_num());
		statement.setInt(4, book.getB_id());
		statement.setInt(5, book.getB_id());
		statement.setInt(6, book.getB_id());
		statement.setInt(7, book.getB_id());
		statement.setInt(8, book.getB_id());
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
	}return true;
    }

    public boolean updateBookings(ArrayList<Booking> blist, Connection con) {
        return true;
    }

    public boolean deleteBookings(ArrayList<Booking> blist, Connection con) {
        return true;

    }
}
