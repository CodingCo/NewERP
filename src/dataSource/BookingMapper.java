package dataSource;

import domain.Booking;
import java.sql.Connection;
import java.util.ArrayList;

public class BookingMapper {

    
    
    public BookingMapper() {
    }

    //== Methods
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
