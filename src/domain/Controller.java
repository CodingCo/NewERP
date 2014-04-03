package domain;

import dataSource.DbFacade;
import java.util.ArrayList;
import java.util.HashMap;

public class Controller {

    private DbFacade facade;
    private boolean transaction;

    public Controller() {
        this.transaction = false;
        this.facade = DbFacade.getInstance();
    }

    public boolean newBooking(Customer c, int a_num, String date_from, int num_of_nights, String travel_agency, int number_of_guests, double price, String first_name, String last_name, String phone) {
        boolean status = false;
        if (facade != null) {
            Booking b = new Booking(a_num, date_from, num_of_nights, travel_agency, number_of_guests, (price * num_of_nights), first_name, last_name, phone);
            status = this.facade.newBooking(b, c);
        }
        return status;
    }

    public Customer newCustomer(String first_name, String last_name, String phone, String email, String country, String city, String zipcode, String street) {
        return new Customer(first_name, last_name, phone, email, country, city, zipcode, street);
    }

    public boolean updateBooking(Booking b, int a_num, String date_from, int number_of_nights, double price, Customer c, String first_name, String last_name, String phone, String email, String country, String city, String zipcode, String street) {
        boolean status = false;
        if (this.facade != null) {
            b.setA_num(a_num);
            b.setDate_from(date_from);
            b.setNum_of_nights(number_of_nights);
            b.setPrice(price);
            c.setFirst_name(first_name);
            c.setLast_name(last_name);
            c.setEmail(email);
            c.setPhone(phone);
            c.setCountry(country);
            c.setCity(city);
            c.setStreet(street);
            c.setZipcode(zipcode);
            status = this.facade.updateBooking(b, c);
        }
        return status;
    }

    public boolean deleteBooking(int b_id) {
        boolean status = false;
        if (this.facade != null) {
            status = this.facade.deleteBooking(b_id);
        }
        return status;
    }

    public HashMap<Booking, Customer> findBookings(int bookingNr, String name, String date, int roomNr) {
        if (this.facade != null) {
            return this.facade.findBookings(bookingNr, name, date, roomNr);
        }
        return null;
    }

    public ArrayList<Apartment> findAvailableApartment(String date, int days, String type, int room) {
        if (this.facade != null) {
            return this.facade.findAvailableApartment(date, days, type, room);
        }
        return null;
    }

}
