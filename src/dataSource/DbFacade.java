package dataSource;

import domain.Apartment;
import domain.Booking;
import domain.Customer;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

public class DbFacade {

    private Chatty chatty;
    private Connection con;
    private static DbFacade instance;

    private DbFacade() {
        this.chatty = new Chatty();
        con = DBConnector.getInstance().getConnection();
    }

    public static DbFacade getInstance() {
        if (instance == null) {
            instance = new DbFacade();
        }
        return instance;
    }

    public boolean newBooking(Booking booking, Customer customer) {
        boolean status = false;
        if (this.chatty != null) {
            status = this.chatty.createNewBookingTransaction(booking, customer, con);
        }
        return status;
    }

    public boolean updateBooking(Booking booking, Customer customer) {
        boolean status = false;
        if (this.chatty != null) {
            this.chatty.updateBookingTransaction(booking, customer, con);
        }
        return status;
    }

    public boolean deleteBooking(int b_id) {
        boolean status = false;
        if (this.chatty != null) {

        }
        return status;
    }

    public ArrayList<Apartment> findAvailableApartment(String date, int days, String type, int room) {
        if (chatty != null) {
            return this.chatty.findAvailableApartment(date, days, type, con);
        }
        return null;
    }

    public HashMap<Booking, Customer> findBookings(int bookingNr, String name, String date, int roomNr) {
        if (this.chatty != null) {
            return this.chatty.findBookings(roomNr, name, date, bookingNr, con);
        }
        return null;
    }
}
