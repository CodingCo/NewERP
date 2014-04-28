package dataSource;

import errorHandling.BookingException;
import errorHandling.DateException;
import domain.Apartment;
import domain.Booking;
import domain.Customer;
import errorHandling.ConnectionException;
import errorHandling.CustomerException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author Simon Grønborg
 *
 */
public class DbFacade {

    private Chatty chatty;
    private Connection con;
    private static DbFacade instance;

    private DbFacade() throws ConnectionException {
        this.chatty = new Chatty();
        con = DBConnector.getInstance().getConnection();

        CronThreader c = new CronThreader(con);
        new Thread(c).start();
    }

    public static DbFacade getInstance() throws ConnectionException {
        if (instance == null) {
            instance = new DbFacade();
        }
        return instance;
    }

    /**
     *
     * @param booking
     * @param customer
     * @param previousCustomerFlag
     * @return
     * @throws BookingException
     *
     * @Author Simon
     */
    public boolean newBooking(Booking booking, Customer customer, boolean previousCustomerFlag) throws BookingException {
        boolean status = false;
        if (this.chatty != null) {
            status = this.chatty.createNewBookingTransaction(booking, customer, con, previousCustomerFlag);
        }
        return status;
    }

    /**
     *
     * @param booking
     * @param customer
     * @return
     * @throws BookingException
     *
     * @Author Simon
     */
    public boolean updateBooking(Booking booking, Customer customer) throws BookingException {
        boolean status = false;
        if (this.chatty != null) {
            status = this.chatty.updateBookingTransaction(booking, customer, con);
        }
        return status;
    }

    public boolean deleteBooking(int b_id) throws BookingException {
        boolean status = false;
        if (this.chatty != null) {
            status = this.chatty.deleteBookingTransaction(b_id, con);
        }
        return status;
    }

    /**
     *
     * @param date
     * @param days
     * @param type
     * @param apartment_nr
     * @return
     * @throws DateException
     *
     * @Author Simon
     */
    public ArrayList<Apartment> findAvailableApartment(String date, int days, String type, int apartment_nr) throws DateException {
        if (chatty != null) {
            return this.chatty.findAvailableApartment(date, days, type, apartment_nr, con);
        }
        return null;
    }

    /**
     * @param bookingNr
     * @param name
     * @param date
     * @param apartment_nr
     * @return
     *
     * @Author Simon
     */
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

    public ArrayList<int[]> getBookingsByApartment(int a_num, int months) {
        if (this.chatty != null) {
            return this.chatty.getBookingsByApartment(a_num, months);
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

    public Customer getCustomer(int custId) {
        if (this.chatty != null) {
            return this.chatty.getCustomer(custId);
        }
        return null;
    }

    public Booking getBooking(int bid) {
        if (this.chatty != null) {
            return this.chatty.getBooking(bid);
        }
        return null;
    }

    /**
     * @param ctmp
     * @return
     * @throws errorHandling.CustomerException
     * @Author Robert
     */
}
