package domain;

import Exception.DateException;
import Exception.BookingException;
import dataSource.DbFacade;
import java.util.ArrayList;
import java.util.HashMap;

public class Controller {

    private final DbFacade facade;

    public Controller() {
        this.facade = DbFacade.getInstance();
    }

    public boolean newBooking(Customer c, int a_num, String date_from, int num_of_nights, String travel_agency, int number_of_guests, double price, String first_name, String last_name, String phone) throws BookingException {
        boolean status = false;
        if (facade != null) {
            Booking b = new Booking(a_num, date_from, num_of_nights, travel_agency, number_of_guests, price, first_name, last_name, phone);
            status = this.facade.newBooking(b, c);
        }
        return status;
    }

    public Customer newCustomer(String first_name, String last_name, String phone, String email, String country, String city, String zipcode, String street) {
        return new Customer(first_name, last_name, phone, email, country, city, zipcode, street);
    }

    public boolean updateBooking(Booking b, int a_num, String date_from, int number_of_nights, double price, Customer c, String first_name, String last_name, String phone, String email, String country, String city, String zipcode, String street, int guests) throws BookingException {
        boolean status = false;
        Booking btmp = null;
        Customer ctmp = null;
        try {
            btmp = (Booking) b.clone();
            ctmp = (Customer) c.clone();
        } catch (CloneNotSupportedException ex) {
            System.out.println("damn");
        }

        if (this.facade != null) {
            btmp.setA_num(a_num);
            btmp.setDate_from(date_from);
            btmp.setNum_of_nights(number_of_nights);
            btmp.setNumber_of_guests(guests);
            btmp.setPrice(price);
            ctmp.setFirst_name(first_name);
            ctmp.setLast_name(last_name);
            ctmp.setEmail(email);
            ctmp.setPhone(phone);
            ctmp.setCountry(country);
            ctmp.setCity(city);
            ctmp.setStreet(street);
            ctmp.setZipcode(zipcode);

            status = this.facade.updateBooking(btmp, ctmp);
            if (status) {
                b = btmp;
                c = ctmp;
            }
        }
        return status;
    }

    public boolean deleteBooking(int b_id) throws BookingException {
        boolean status = false;
        if (this.facade != null) {
            status = this.facade.deleteBooking(b_id);
        }
        return status;
    }

    public Customer getCustomer(int custId) {
        if (this.facade != null) {
            return this.facade.getCustomer(custId);
        }
        return null;

    }

    public ArrayList<Apartment> getApartments() {
        if (this.facade != null) {
            return this.facade.getApartments();
        }
        return null;
    }

    public HashMap<Booking, Customer> findBookings(int bookingNr, String name, String date, int apartment_nr) {
        if (this.facade != null) {
            return this.facade.findBookings(bookingNr, name, date, apartment_nr);
        }
        return null;
    }

    public ArrayList<Apartment> findAvailableApartment(String date, int days, String type, int apartment_nr) throws DateException {
        if (this.facade != null) {
            return this.facade.findAvailableApartment(date, days, type, apartment_nr);
        }
        return null;
    }

    public ArrayList<Customer> searchForCustomers(String keyword) {
        if (this.facade != null) {
            return this.facade.searchForCustomers(keyword);
        }
        return null;
    }

    public ArrayList<Booking[]> getBookingsToDay() {
        if (this.facade != null) {
            return this.facade.getBookingsToDay();
        }
        return null;
    }

    public ArrayList<int[]> getBookingsBySpecificMonth(String date) {
        if (this.facade != null) {
            return this.facade.getBookingsBySpecificMonth(date);
        }
        return null;
    }

    public ArrayList<int[]> getBookingsByApartment(int a_num) {
        if (this.facade != null) {
            return this.facade.getBookingsByApartment(a_num);
        }
        return null;
    }

    public void updateLists() {
        if (this.facade != null) {
            this.facade.updateLists();
        }
    }

}
