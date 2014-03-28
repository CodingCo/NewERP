package domain;

import dataSource.DbFacade;
import java.util.ArrayList;

public class Controller {

    private DbFacade facade;

    public Controller() {

        this.facade = DbFacade.getInstance();
    }

    // ======= BOOKING
    public boolean addNewBooking(Customer cust, Apartment a, int num_of_nights, String date, String travel_agency, double rent) {
        boolean status;
        Booking booking = new Booking(a, cust, num_of_nights, date, travel_agency, rent);
        status = this.facade.addNewBooking(booking);
        return status;
    }

    public boolean updateBooking(Booking b, int a_num, int cust_id, int num_of_nights, double rent) {
        b.setApartment(this.facade.getApartment(a_num));
        b.setCustomer(this.facade.getCustomer(cust_id));
        b.setNum_of_nights(num_of_nights);
        b.setRent(rent);
        this.facade.updateBooking(null);
        return true;
    }

    private Apartment getApartment(int a_num) {
        return this.facade.getApartment(a_num);
    }

    public boolean deleteBooking(int b_id) {

        this.facade.deleteBooking(b_id);

        return false;
    }
    // ======= 

    // ====== CUSTOMER
    public Customer addNewCustomer(String name, String family_name, int age, String email, String phone, String country, String city, String street, int zipcode) {
        return new Customer(name, family_name, age, email, phone, country, city, street, zipcode);
    }

    public boolean updateCustomer(String name, String family_name, int age, String email, int phone, String country, String city, String street, int zipcode) {
        return false;
    }

    public boolean deleteCustomer(int cust_id) {
        return true;
    }
    //=======  

    public boolean resetTransaction() {

        return true;
    }

    public boolean saveTransaction() {
        this.facade.commitBusinessTransaction();
        return true;
    }

    public ArrayList<Booking> findBookingsByParams(int bookingNr, String name, String date, int roomNr) {
        this.facade.startNewBusinessTransaction();
        return null;
    }

    public Apartment findAvailableApartment(String date, int days, String type) {
        if (this.facade != null) {
            return this.facade.findAvailableApartment(date, days, type);
        }
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
