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

    public boolean addNewBooking(Customer cust, Apartment a, int num_of_nights, String date, String travel_agency, double rent) {
        if (!processingTransaction) {
            Booking booking = new Booking(a, cust, num_of_nights, date, travel_agency, rent);
            this.facade.addNewBooking(booking);
            this.processingTransaction = true;
            return true;
        }
        return false;
    }

    public boolean updateBooking(int a_num, int cust_id, int num_of_nights, double rent) {
        if (!processingTransaction) {
            return true;
        }
        return false;
    }

    public boolean deleteBooking(int b_id) {
        if (!processingTransaction) {
            this.facade.deleteBooking(b_id);
            this.processingTransaction = true;
            return true;
        }
        return false;
    }

    public Customer addNewCustomer(String name, String family_name, int age, String email, String phone, String country, String city, String street, int zipcode) {
        return new Customer(name, family_name, age, email, phone, country, city, street, zipcode);
    }

    public boolean updateCustomer(String name, String family_name, int age, String email, int phone, String country, String city, String street, int zipcode) {
        return false;
    }

    public boolean deleteCustomer(int cust_id) {
        return true;
    }

    public int saveTransaction() {
        if (this.facade != null) {
            this.facade.commitBusinessTransaction();
            this.processingTransaction = false;
            return 1;
        }
        return 0;
    }

    public int resetTransaction() {
        this.processingTransaction = false;
        return 1;
    }

    public Apartment findAvailableApartment(String date, int days, String type) {
        if (this.facade != null) {
            return this.facade.findAvailableApartment(date, days, type);
        }
        return null;
    }

    public ArrayList<Booking> findBookingsByParams(int bookingNr, String name, String date, int roomNr) {
        this.facade.startNewBusinessTransaction();
        return null;
    }

    private boolean loadBookings() {
        return this.facade.loadBookings();
    }

    private boolean loadCustomers() {
        return this.facade.loadCustomers();
    }

    private boolean loadApartments() {
        return this.facade.loadApartments();
    }

}
