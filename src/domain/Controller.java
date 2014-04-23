package domain;

import Exception.DateException;
import Exception.BookingException;
import dataSource.DbFacade;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class Controller {

    private DbFacade facade;
    private boolean transaction;

    public Controller() {
        this.transaction = false;
        this.facade = DbFacade.getInstance();
    }

    public boolean newBooking(Customer c, int a_num, String date_from, int num_of_nights, String travel_agency, int number_of_guests, double price, String first_name, String last_name, String phone) throws BookingException{
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

    public boolean updateBooking(Booking b, int a_num, String date_from, int number_of_nights, double price, Customer c, String first_name, String last_name, String phone, String email, String country, String city, String zipcode, String street) throws BookingException {
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

    public boolean deleteBooking(int b_id) throws BookingException{
        boolean status = false;
        if (this.facade != null) {
            status = this.facade.deleteBooking(b_id);
        }
        return status;
    }

    public ArrayList<Apartment> getApartments() {
        if (this.facade != null) {
            return this.facade.getApartments();
        }
        return null;
    }

    public HashMap<Booking, Customer> findBookings(int bookingNr, String name, String date, int apartment_nr) throws BookingException{
        if (this.facade != null) {
            return this.facade.findBookings(bookingNr, name, date, apartment_nr);
        }
        return null;
    }

    public ArrayList<Apartment> findAvailableApartment(String date, int days, String type, int apartment_nr) {
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

    public void updateLists() throws BookingException{
        if (this.facade != null) {
            this.facade.updateLists();
        }
    }

    //== No booking back in time - method
    public void isDateValid(String date) throws DateException{
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
        Calendar currentDate = null;
        Calendar dateToCheck = null;
        try {
            currentDate = new GregorianCalendar();
            dateToCheck = new GregorianCalendar();
            currentDate.setTime(Calendar.getInstance().getTime());
            currentDate.add(Calendar.DAY_OF_MONTH, -1);
            dateToCheck.setTime(sdf.parse(date));
            
            
            if(dateToCheck.compareTo(currentDate) != 1)
                throw new DateException("Can not create a booking on that date ");
            
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }
}
