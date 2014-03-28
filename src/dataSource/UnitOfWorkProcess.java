package dataSource;

import domain.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Christopher & Thomas
 */
public class UnitOfWorkProcess {

    //== Fields
    private ArrayList<Booking> newBookings;
    private ArrayList<Booking> dirtyBookings;
    private ArrayList<Booking> deletedBookings;
    private ArrayList<Booking> cleanBookings;
    private ArrayList<Customer> newCustomers;
    private ArrayList<Customer> dirtyCustomers;
    private ArrayList<Customer> cleanCustomers;
    private ArrayList<Apartment> cleanApartments;

    //== Constructor
    public UnitOfWorkProcess() {
        this.newBookings = new ArrayList();
        this.dirtyBookings = new ArrayList();
        this.deletedBookings = new ArrayList();
        this.cleanBookings = new ArrayList();
        this.newCustomers = new ArrayList();
        this.dirtyCustomers = new ArrayList();
        this.cleanCustomers = new ArrayList();
        this.cleanApartments = new ArrayList();

    }

    public boolean registerNewBooking(Booking currentBooking) {
        System.out.println(currentBooking);
        if (!newBookings.contains(currentBooking)
                && !dirtyBookings.contains(currentBooking)
                && !deletedBookings.contains(currentBooking)
                && !cleanBookings.contains(currentBooking)) {
            newBookings.add(currentBooking);
            return true;
        }
        return false;
    }

    public boolean registerDirtyBooking(Booking currentBooking) {

        if (!newBookings.contains(currentBooking)
                && !dirtyBookings.contains(currentBooking)
                && !deletedBookings.contains(currentBooking)
                && !cleanBookings.contains(currentBooking)) {
            dirtyBookings.add(currentBooking);
            return true;
        }
        return false;
    }

    public boolean registerDeletedBooking(Booking currentBooking) {

        if (!newBookings.contains(currentBooking)
                && !dirtyBookings.contains(currentBooking)
                && !deletedBookings.contains(currentBooking)
                && cleanBookings.contains(currentBooking)) { // CLEAN HAS TO CONTAIN THIS!!!
            deletedBookings.add(currentBooking);
            return true;
        }
        return false;
    }

    public boolean registerNewCustomer(Customer currentCustomer) {

        if (!dirtyCustomers.contains(currentCustomer)
                && !cleanCustomers.contains(currentCustomer)
                && !newCustomers.contains(currentCustomer)) {
            newCustomers.add(currentCustomer);
            return true;
        }
        return false;
    }

    public boolean registerDirtyCustomer(Customer currentCustomer) {

        if (!dirtyCustomers.contains(currentCustomer)
                && !newCustomers.contains(currentCustomer)
                && cleanCustomers.contains(currentCustomer)) {
            dirtyCustomers.add(currentCustomer);
            return true;
        }
        return false;
    }

    public Apartment findAvalibleApartment(String date, int days, String type, Connection con) {
        Apartment apartmentToReturn = new ApartmentMapper().findAvailableApartment(date, days, type, con);
        return apartmentToReturn;
    }

    public ArrayList<Booking> findBookingsByParams(int bookingNum, String name, String date, int apartmentNum) {
        // Is name == guestName??
        return null;
    }

    public boolean loadBookings(Connection con) {
        ArrayList<Booking> oldBookings = new ArrayList(cleanBookings);
        cleanBookings.clear();
        cleanBookings = new BookingMapper().getAllBookings(con);

        if (oldBookings.size() == cleanBookings.size()) {
            for (int i = 0; i < oldBookings.size(); i++) {
                if (oldBookings.get(i) != cleanBookings.get(i)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public boolean loadCustomers(Connection con) {
        ArrayList<Customer> oldCustomers = new ArrayList(cleanCustomers);
        cleanCustomers.clear();
        cleanCustomers = new CustomerMapper().getAllCustomers(con);

        if (oldCustomers.size() == cleanCustomers.size()) {
            for (int i = 0; i < oldCustomers.size(); i++) {
                if (oldCustomers.get(i) != cleanCustomers.get(i)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public boolean loadApartments(Connection con) {
        ArrayList<Apartment> oldApartments = new ArrayList(cleanApartments);
        cleanApartments.clear();
        cleanApartments = new ApartmentMapper().getAllApartments(con);

        if (oldApartments.size() == cleanApartments.size()) {
            for (int i = 0; i < oldApartments.size(); i++) {
                if (oldApartments.get(i) != cleanApartments.get(i)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public boolean commit(Connection con) {
        boolean status = true;

        try {
            con.setAutoCommit(false);
            CustomerMapper customerMapper = new CustomerMapper();
            BookingMapper bookingMapper = new BookingMapper();

            status = status && customerMapper.insertCustomers(newCustomers, con);
            status = status && bookingMapper.insertBookings(newBookings, con);
            con.commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException kl) {
                kl.printStackTrace();
            }
            status = false;
        }

        return status;
    }

}
