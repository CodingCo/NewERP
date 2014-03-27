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

    //====== Methods to register changes START ==========================
    /**
     * Adds the current booking if it doesn't exists already
     *
     * @param currentBooking The new Booking object
     * @return boolean
     */
    public boolean registerNewBooking(Booking currentBooking) {

        if (!newBookings.contains(currentBooking)
                && !dirtyBookings.contains(currentBooking)
                && !deletedBookings.contains(currentBooking)
                && !cleanBookings.contains(currentBooking)) {
            newBookings.add(currentBooking);
            return true;
        }

        return false;
    }

    /**
     * Adds the current updated booking to dirtyBookings, if it exists in
     * cleanBookings, but not in the other lists.
     *
     * @param currentBooking The updated Booking object
     * @return boolean
     */
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

    /**
     * Adds the current booking to the deletedBookings, if it only exists in
     * cleanBookings list
     *
     * @param currentBooking The Booking object to delete
     * @return boolean
     */
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

    /**
     * Adds the current customer to newCustomers, if it exists in
     * cleanCustomers, but not in the other lists.
     *
     * @param currentCustomer The new Customer Object
     * @return boolean
     */
    public boolean registerNewCustomer(Customer currentCustomer) {

        if (!dirtyCustomers.contains(currentCustomer)
                && !cleanCustomers.contains(currentCustomer)
                && !newCustomers.contains(currentCustomer)) {
            newCustomers.add(currentCustomer);
            return true;
        }
        return false;
    }

    /**
     * Adds the current updated customer to dirtyCustomers, if it exists in
     * cleanCustomers, but not in the other lists.
     *
     * @param currentCustomer The updated Customer object
     * @return boolean
     */
    public boolean registerDirtyCustomer(Customer currentCustomer) {

        if (!dirtyCustomers.contains(currentCustomer)
                && !newCustomers.contains(currentCustomer)
                && cleanCustomers.contains(currentCustomer)) {
            dirtyCustomers.add(currentCustomer);
            return true;
        }
        return false;
    }

    //====== Methods to register END ==========================
    /**
     * Calls findAvailableApartment() from ApartmentMapper
     * to instantiate the Apartment that is the return value. 
     *
     * @param date The startdate of the particular search
     * @param days The total number of days
     * @param type The type of Apartment
     * @param con Connection object
     * @return boolean
     */
    public Apartment findAvalibleApartment(String date, int days, String type, Connection con) {
        Apartment apartmentToReturn = new ApartmentMapper().findAvailableApartment(date, days, type, con);
        return apartmentToReturn;
    }

    /**
     * No logic made yet, returns null. 
     * 
     * @param bookingNum The Booking Number
     * @param name The FirstName of Customer
     * @param date The Start Date
     * @param apartmentNum The Apartment Number
     * @return findBookingsByParams
     */
    public ArrayList<Booking> findBookingsByParams(int bookingNum, String name, String date, int apartmentNum) {
        // Is name == guestName??
        return null;
    }

    //====== Methods to update the clean lists to DB ==========================
    /**
     * Uses the BookingMapper to retrieve a full List
     * of all our existing bookings.
     * 
     * Returns false, if no changes were made since last 
     * update. 
     *
     * @param con Connection Object
     * @return boolean
     */
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

    /**
     * Uses the CustomerMapper to retrieve a full List
     * of all our existing customers.
     * 
     * Returns false, if no changes were made since last 
     * update. 
     *
     * @param con Connection Object
     * @return boolean
     */
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

    /**
     * Uses the ApartmentMapper to retrieve a full List
     * of all our existing apartments.
     * 
     * Returns false, if no changes were made since last 
     * update. 
     *
     * @param con Connection Object
     * @return boolean
     */
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

    //====== Method to save changes to DB ==========================
     /**
     * Uses the mapperclasses to manipulate and define
     * the DB, with the data from from all the Lists in UOW
     * except the clean Lists. 
     * 
     * If anything throws an exception, it calls the rollBack()
     * and returns false. 
     * 
     * @throws SQLException
     *
     * @param con Connection Object
     * @return boolean
     */
    public boolean commit(Connection con) throws SQLException {
        boolean status = true;

        try {
            con.setAutoCommit(false);
            CustomerMapper customerMapper = new CustomerMapper();
            BookingMapper bookingMapper = new BookingMapper();

            status = status && customerMapper.insertCustomer(newCustomers, con);
            status = status && customerMapper.updateCustomer(dirtyCustomers, con);
            status = status && bookingMapper.insertBookings(newBookings, con);
            status = status && bookingMapper.updateBookings(dirtyBookings, con);
            status = status && bookingMapper.deleteBookings(deletedBookings, con);

            if (!status) {
                throw new Exception("Business Transaction aborted!");
            }
            con.commit();

        } catch (Exception ex) {
            System.out.println("Fail in UnitOfWorkProcess - commit method");
            System.err.println(ex);
            con.rollback();

            status = false;
        }

        return status;
    }
    
}
