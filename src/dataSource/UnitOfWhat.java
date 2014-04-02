package dataSource;

import domain.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Christopher & Thomas
 */
public class UnitOfWhat {

    //== Fields
   private ArrayList<Booking> bookings;
   private ArrayList<Booking> history;
   
    //== Constructor
    public UnitOfWhat() {
        this.bookings = new ArrayList();
        this.history = new ArrayList();
    }

    public Apartment findAvalibleApartment(String date, int days, String type, Connection con) {
//        Apartment apartmentToReturn = new ApartmentMapper().findAvailableApartment(date, days, type, con);
//        return apartmentToReturn;
        return null;
    }

    public ArrayList<Booking> findBookingsByParams(int bookingNum, String name, String date, int apartmentNum) {
        ArrayList<Booking> relevantBookings = new ArrayList();

        return relevantBookings;
    }

    public boolean updateBookings(Connection con) {
       // ArrayList<Booking> oldBookings = new ArrayList(cleanBookings);
//        cleanBookings.clear();
//        cleanBookings = new BookingMapper().getAllBookings(con);
//
//        if (oldBookings.size() == cleanBookings.size()) {
//            for (int i = 0; i < oldBookings.size(); i++) {
//                if (oldBookings.get(i) != cleanBookings.get(i)) {
//                    return true;
//                }
//            }
//            return false;
//        }
        return true;
    }
    
    public boolean updateHistory(Connection con){
        return true;
    }

    public boolean commit(Connection con) {
        boolean status = true;

        return status;
    }
}
