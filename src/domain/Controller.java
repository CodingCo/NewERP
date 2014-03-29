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

    public static void main(String[] args) {
        Controller ct = new Controller();
        //ct.loadLists();
//        Customer c = ct.addNewCustomer("Robert", "APL", 20, "@mail", "23232323", "denmark", "city", "street", 8888);
//        Apartment p = ct.findAvailableApartment("23-10-13", 5, "Family");
//        ct.addNewBooking(c, p, 5, "23-10-13", "agency", 200);
//        System.out.println(ct.saveTransaction());
        //System.out.println(ct.loadLists());
        //System.out.println(ct.facade.getCustomer(1));
        //Booking b = ct.facade.getBooking(1);
        //b.getCustomer().setName("testname");
        //System.out.println(ct.facade.getCustomer(1));
    }

    // ======= BOOKING
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

    public boolean updateBooking(Booking b, int a_num, int cust_id, int num_of_nights, double rent) {
        boolean status = false;
        if (!this.transaction) {
            this.transaction = true;
            b.setApartment(this.facade.getApartment(a_num));
            b.setCustomer(this.facade.getCustomer(cust_id));
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
    // ======= 

    // ====== CUSTOMER
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
            this.facade.findBookingsByParams(bookingNr, name, date, roomNr);
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
