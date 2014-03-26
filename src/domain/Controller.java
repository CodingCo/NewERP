package domain;

import dataSource.DbFacade;
import java.util.ArrayList;

public class Controller {

    private boolean processingTransaction; // flag 
    private DbFacade facade;

    public Controller() {
        this.processingTransaction = false;
        this.facade = DbFacade.getInstance();
    }

    public boolean addNewBooking(Customer cust, Apartment a, int num_of_nights, String travel_agency, double rent) {
        if (!processingTransaction) {
            Booking booking = new Booking(a, cust, num_of_nights, travel_agency, rent);
            this.facade.addNewBooking(booking);
            this.processingTransaction = true;
            return true;
        }
        return false;
    }

    public boolean updateBooking(int a_num, int cust_id, int num_of_nights, double rent) {
        return true;
    }

    public boolean deleteBooking(int b_id) {
        return true;
    }

    public Customer addNewCustomer(String name, String family_name, int age, String email, int phone, String country, String city, String street, int zipcode) {
        return null;
    }

    public boolean updateCustomer(String name, String family_name, int age, String email, int phone, String country, String city, String street, int zipcode) {
        return false;
    }

    public boolean deleteCustomer(int cust_id) {
        return true;
    }

    public int saveTransaction() {
        this.facade.commitBusinessTransaction();
        
        return 1; 
    }

    public int resetTransaction() {
        return 1;
    }

    public Apartment findAvailableApartment(String date, int days, String type) {
        return null;
    }

    public ArrayList<Booking> findBookingsByParams(int bookingNr, String name, String date, int roomNr) {
        return null;
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
