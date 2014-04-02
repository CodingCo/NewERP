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

    public boolean createNewBookingTransaction(Booking b, Customer c) {

        return true;
    }

}
