package dataSource;

import domain.Apartment;
import domain.Booking;
import domain.Customer;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author kasper
 */
public class DbFacade {

    private UnitOfWorkProcess uow;
    private Connection con;

    private static DbFacade instance;

    private DbFacade() {
        uow = UnitOfWorkProcess.getInstance();
        con = DBConnector.getInstance().getConnection();
    }

    public static DbFacade getInstance() {
        if (instance == null) {
            instance = new DbFacade();
        }
        return instance;
    }

    public boolean addNewBooking(Booking booking) {
        return true;
    }

    public boolean updateBooking(Booking booking) {
        return true;
    }

    public boolean deleteBooking(int b_id) {
        
        if(this.uow != null){
        // do shit
        }
    return true;
    }

    public boolean newCustomer(Customer customer) {
        return true;
    }

    public boolean updateCustomer(Customer customer) {
        return true;
    }

    public boolean deleteCustomer(int cust_id) {
        return true;
    }

    public Apartment findAvailableApartment(String date, int days, String type) {
        return null;
    }

    public ArrayList<Booking> findBookingsByParams(int bookingNr, String name, String date, int roomNr) {
        return null;
    }

    public void startNewBusinessTransaction() {

    }

    public boolean commitBusinessTransaction() {
        this.uow = null;
        return true;
    }

    public boolean loadBookings() {
        return true;
    }

    public boolean loadCustomers() {
        return true;
    }

    public boolean loadApartments() {
        return true;
    }

}
