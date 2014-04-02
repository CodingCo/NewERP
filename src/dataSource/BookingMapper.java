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
        return null;
    }

    public int insertNewBooking(Booking booking, Connection con) {
        return 0;
    }

}
