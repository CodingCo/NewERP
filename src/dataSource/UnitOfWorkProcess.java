package dataSource;

import domain.*;
import java.sql.Connection;
import java.util.ArrayList;

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
     * @param currentBooking
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
     * @param currentBooking
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
     * @param currentBooking
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
     * @param currentCustomer
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
     * @param currentCustomer
     * @return boolean
     */
    public boolean registerDirtyCustomer(Customer currentCustomer) {

        if (!dirtyCustomers.contains(currentCustomer)
                && !cleanCustomers.contains(currentCustomer)) {
            dirtyCustomers.add(currentCustomer);
            return true;
        }
        return false;
    }

    //====== Methods to register END ==========================

    public Apartment findAvalibleApartment(String date, int days, String type) {
        return null;
    }
    
    //====== Methods to update the clean lists to DB ==========================
    public boolean loadBookings(Connection con){
        ArrayList<Booking> oldBookings = new ArrayList(cleanBookings);
        cleanBookings.clear();
        cleanBookings = new BookingMapper().getAllBookings(con);
        
        if(oldBookings.size() == cleanBookings.size()){
            for (int i = 0; i < oldBookings.size(); i++) {
                if(oldBookings.get(i) != cleanBookings.get(i))
                return true;
            } return false;
        }
        return true;
    }
    
    public boolean loadCustomers(Connection con){
        ArrayList<Customer> oldCustomers = cleanCustomers;
        cleanCustomers.clear();
        cleanCustomers = new CustomerMapper().getAllCustomers(con);
        
        if(oldCustomers.size() == cleanCustomers.size()){
            for (int i = 0; i < oldCustomers.size(); i++) {
                if(oldCustomers.get(i) != cleanCustomers.get(i))
                return true;
            } return false;
        }
        return true;
    }
    
    public boolean loadApartments(Connection con){
        ArrayList<Apartment> oldApartments = cleanApartments;
        cleanApartments.clear();
        cleanApartments = new ApartmentMapper().getAllApartments(con);
        
        if(oldApartments.size() == cleanApartments.size()){
            for (int i = 0; i < oldApartments.size(); i++) {
                if(oldApartments.get(i) != cleanApartments.get(i))
                return true;
            } return false;
        }
        return true;
    }

    //====== Method to save changes to DB ==========================
    public boolean commit(Connection con){
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        return true;
    }
}
