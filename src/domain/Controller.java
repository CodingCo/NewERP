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

    public boolean newBooking(Customer c, int a_num, String date_from, int num_of_nights, String travel_agency, int number_of_guests, double price, String first_name, String last_name, String phone) {
        boolean status = false;
        if (facade != null) {
            Booking b = new Booking(a_num, date_from, num_of_nights, travel_agency, number_of_guests, (price * num_of_nights), first_name, last_name, phone);
            status = this.facade.addNewBooking(b, c);
        }
        return status;
    }

    public Customer newCustomer(String first_name, String last_name, String phone, String email, String country, String city, String zipcode, String street) {
        return new Customer(first_name, last_name, phone, email, country, city, zipcode, street);
    }

    public boolean updateBooking(Booking b, Apartment a, int num_of_nights, double rent) {
        /* boolean status = false;
         if (!this.transaction) {
         this.transaction = true;
         b.setApartment(a);
         b.setNum_of_nights(num_of_nights);
         b.setRent(rent);
         status = this.facade.updateBooking(b);
         }
         return status;*/
        return true;
    }

    public boolean deleteBooking(int b_id) {
        boolean status = false;
        if (!this.transaction) {
            this.transaction = true;
            status = this.facade.deleteBooking(b_id);
        }
        return status;
    }

    /*public boolean updateCustomer(Customer c, String name, String family_name, int age, String email, String phone, String country, String city, String street, int zipcode) {
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
     }*/
    public ArrayList<Booking> findBookingsByParams(int bookingNr, String name, String date, int roomNr) {

        return null;
    }

    public ArrayList<Apartment> findAvailableApartment(String date, int days, String type, int room) {
        if (this.facade != null) {
            return this.facade.findAvailableApartment(date, days, type, room);
        }
        return null;
    }

    public boolean loadLists() {
        boolean status = true;
//        if (this.facade != null) {
//            status = status && this.facade.loadApartments();
//            status = status && this.facade.loadBookings();
//            status = status && this.facade.loadCustomers();
//            status = status && this.facade.loadMerger();
//        }
        return status;
    }
}
