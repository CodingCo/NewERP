package domain;

import dataSource.DbFacade;
import java.util.ArrayList;

public class Controller {

    private DbFacade facade;
    private boolean transaction;

    public Controller() {
        this.transaction = false;
        this.facade = DbFacade.getInstance();
        loadLists();
    }

    public boolean addNewBooking(Customer cust, Apartment a, int num_of_nights, String date, String travel_agency, double rent) {
        boolean status = false;
        if (!this.transaction) {
            this.transaction = true;
            Booking booking = new Booking(a, cust, num_of_nights, date, travel_agency, rent);
            status = this.facade.addNewBooking(booking);
        }
        System.out.println(status);
        return status;
    }

    public boolean updateBooking(Booking b, Apartment a, int num_of_nights, double rent) {
        boolean status = false;
        if (!this.transaction) {
            this.transaction = true;
            b.setApartment(a);
            b.setNum_of_nights(num_of_nights);
            b.setRent(rent);
            status = this.facade.updateBooking(b);
        }
        return status;
    }

    public boolean deleteBooking(int b_id) {
        boolean status = false;
        if (!this.transaction) {
            this.transaction = true;
            status = this.facade.deleteBooking(b_id);
        }
        return status;
    }

    public Customer addNewCustomer(String name, String family_name, int age, String email, String phone, String country, String city, String street, int zipcode) {
        return new Customer(name, family_name, age, email, phone, country, city, street, zipcode);
    }

    public boolean updateCustomer(Customer c, String name, String family_name, int age, String email, String phone, String country, String city, String street, int zipcode) {
        boolean status = false;
        if (!this.transaction) {
            this.transaction = true;
            c.setName(name);
            c.setFamily_name(family_name);
            c.setAge(age);
            c.setEmail(email);
            c.setPhone(phone);
            c.setCountry(country);
            c.setCity(city);
            c.setStreet(street);
            c.setZipcode(zipcode);
            status = this.facade.updateCustomer(c);
        }
        return status;
    }

    public boolean saveTransaction() {
        boolean status = false;
        if (this.transaction) {
            this.transaction = false;
            status = this.facade.commitBusinessTransaction();
            loadLists();
        }
        return status;
    }

    public ArrayList<Booking> findBookingsByParams(int bookingNr, String name, String date, int roomNr) {
        if (this.facade != null) {
            return this.facade.findBookingsByParams(bookingNr, name, date, roomNr);
        }
        return null;
    }

    public Apartment findAvailableApartment(String date, int days, String type) {
        if (this.facade != null) {
            return this.facade.findAvailableApartment(date, days, type);
        }
        return null;
    }

    private boolean loadLists() {
        boolean status = true;
        if (this.facade != null) {
            status = status && this.facade.loadApartments();
            status = status && this.facade.loadBookings();
            status = status && this.facade.loadCustomers();
            status = status && this.facade.loadMerger();
        }
        return status;
    }
}
