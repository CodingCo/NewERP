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
        CronThreader c = new CronThreader(con);
        new Thread(c).start();
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

    public boolean updateBooking(Booking booking, Customer customer) /*throws UpdateBookingException*/ {
        boolean status = false;
        if (this.chatty != null) {
            status = this.chatty.updateBookingTransaction(booking, customer, con);
        }
        return status;
    }

    public boolean deleteBooking(int b_id) {
        boolean status = false;
        if (this.chatty != null) {
            status = this.chatty.deleteBookingTransaction(b_id, con);
        }
        return status;
    }

    public ArrayList<Apartment> findAvailableApartment(String date, int days, String type, int apartment_nr) {
        if (chatty != null) {
            return this.chatty.findAvailableApartment(date, days, type, apartment_nr, con);
        }
        return null;
    }

    public HashMap<Booking, Customer> findBookings(int bookingNr, String name, String date, int apartment_nr) {
        if (this.chatty != null) {
            return this.chatty.findBookings(bookingNr, name, date, apartment_nr, con);
        }
        return null;
    }

    public ArrayList<Customer> searchForCustomers(String keyword) {
        if (this.chatty != null) {
            return this.chatty.searchForCustomers(keyword);
        }
        return null;
    }

    public ArrayList<Booking[]> getBookingsToDay() {
        if (this.chatty != null) {
            return this.chatty.getBookingsToDay();
        }
        return null;
    }

    public ArrayList<int[]> getBookingsBySpecificMonth(String month) {
        if (this.chatty != null) {
            return this.chatty.getBookingsByMonth(month);
        }
        return null;
    }

    public ArrayList<int[]> getBookingsByApartment(int a_num) {
        if (this.chatty != null) {
            return this.chatty.getBookingsByApartment(a_num);
        }
        return null;
    }

    public void updateLists() {
        if (this.chatty != null) {
            this.chatty.updateLists(con);
        }
    }

    public ArrayList<Apartment> getApartments() {
        if (this.chatty != null) {
            return this.chatty.getApartments(con);
        }
        return null;
    }
}
