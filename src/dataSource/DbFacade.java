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
            newCustomer(booking.getCustomer());
            status = uow.registerNewBooking(booking);
        }
        return status;
    }

    public boolean updateBooking(Booking booking) {
        return true;
    }

    public boolean deleteBooking(int b_id) {
        if (this.uow != null) {
            this.uow.registerDeletedBooking(null);
        }
        return true;
    }

    private boolean newCustomer(Customer customer) {
        boolean status = false;
        if (uow != null) {
            this.uow.registerNewCustomer(customer);
        }
        return status;
    }

    public boolean updateCustomer(Customer customer) {
        boolean status = false;
        if (this.uow != null) {
            status = this.uow.registerDirtyCustomer(customer);
        }
        return status;
    }

    public boolean deleteCustomer(int cust_id) {
        boolean status = false;
        if (this.uow != null) {

        }
        return status;
    }

    public Apartment findAvailableApartment(String date, int days, String type) {
        if (uow != null) {
            return this.uow.findAvalibleApartment(date, days, type, con);
        }
        return null;
    }

    public ArrayList<Booking> findBookingsByParams(int bookingNr, String name, String date, int roomNr) {
        return null;
    }

    public void startNewBusinessTransaction() {
        this.uow = new UnitOfWorkProcess();
    }

    public boolean commitBusinessTransaction() {

        boolean status = this.uow.commit(con);
        return status;
    }

    public boolean loadBookings() {
        boolean status = false;
        if (this.con != null) {
            status = this.uow.loadBookings(con);
        }
        return status;
    }

    public boolean loadCustomers() {
        boolean status = false;
        if (this.con != null) {
            status = this.uow.loadCustomers(con);
        }
        System.out.println(status);
        return status;
    }

    public boolean loadApartments() {
        boolean status = false;
        if (this.con != null) {
            status = this.uow.loadApartments(con);
        }
        return status;
    }

    public Apartment getApartment(int a_num) {
        ArrayList<Apartment> list = this.uow.getApartment();
        for (Apartment x : list) {
            if (x.getA_num() == a_num) {
                return x;
            }
        }
        return null;
    }

    public Customer getCustomer(int cust_id) {
        ArrayList<Customer> list = this.uow.getCustomer();
        for (Customer x : list) {
            if (x.getCust_id() == cust_id) {
                return x;
            }
        }
        return null;
    }

}
