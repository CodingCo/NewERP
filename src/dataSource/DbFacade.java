package dataSource;

import domain.Apartment;
import domain.Booking;
import domain.Customer;
import java.sql.Connection;
import java.util.ArrayList;

public class DbFacade {

    private UnitOfWorkProcess uow;
    private Connection con;
    private static DbFacade instance;

    private DbFacade() {
        this.uow = new UnitOfWorkProcess();
        con = DBConnector.getInstance().getConnection();
    }

    public static DbFacade getInstance() {
        if (instance == null) {
            instance = new DbFacade();
        }
        return instance;
    }

    public boolean addNewBooking(Booking booking) {
        boolean status = false;
        if (uow != null) {
            status = uow.registerNewBooking(booking);
        }
        return status;
    }

    public boolean updateBooking(Booking booking) {
        return true;
    }

    public boolean deleteBooking(int b_id) {
//        if (this.uow != null) {
//            // do shit
//        }
        return true;
    }

    public boolean newCustomer(Customer customer) {
        boolean status = false;
        if (uow != null) {
            this.uow.registerNewCustomer(customer);
        }
        return status;
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
        this.uow = new UnitOfWorkProcess();
    }

    public boolean commitBusinessTransaction() {
        boolean status = false;
        if (this.uow != null) {
            this.uow.commit(con);
            this.uow = null;
        }
        return status;
    }

    public boolean loadBookings() {
        boolean status = false;
        if (this.con != null) {
            status = this.uow.loadBookings();
        }
        return status;
    }

    public boolean loadCustomers() {
        boolean status = false;
        if (this.con != null) {
            status = this.uow.loadCustomers();
        }
        return status;
    }

    public boolean loadApartments() {
        return true;
    }

}
