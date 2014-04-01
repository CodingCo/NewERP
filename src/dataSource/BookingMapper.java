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

    public boolean insertBookings(ArrayList<Booking> blist, Connection con) {
        return true;
    }

    public boolean updateBookings(ArrayList<Booking> blist, Connection con) {
        return true;
    }

   
    public boolean deleteBookings(ArrayList<Booking> blist, Connection con) {
        return true;
    }
}
