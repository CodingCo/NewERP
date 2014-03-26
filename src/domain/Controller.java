package domain;

import java.util.ArrayList;

public class Controller {

    public Controller() {

    }

    /**
     * Create new customer
     *
     * @param a_num
     * @param cust_id
     * @param num_of_nights
     * @param travel_agency
     * @param rent
     * @return
     */
    public boolean addNewBooking(int a_num, int cust_id, int num_of_nights, String travel_agency, double rent) {
        return true;
    }

    /**
     * Uddate a current booking
     *
     * @param a_num
     * @param cust_id
     * @param num_of_nights
     * @param rent
     * @return
     */
    public boolean updateBooking(int a_num, int cust_id, int num_of_nights, double rent) {
        return true;
    }

    public boolean deleteBooking(int b_id) {
        return true;
    }

    /**
     * Create new customer
     *
     * @param name
     * @param family_name
     * @param age
     * @param email
     * @param phone
     * @param country
     * @param city
     * @param street
     * @param zipcode
     * @return
     */
    public Customer addNewCustomer(String name, String family_name, int age, String email, int phone, String country, String city, String street, int zipcode) {
        return null;
    }

    /**
     * Upate a current customer
     *
     * @param name
     * @param family_name
     * @param age
     * @param email
     * @param phone
     * @param country
     * @param city
     * @param street
     * @param zipcode
     * @return
     */
    public boolean updateCustomer(String name, String family_name, int age, String email, int phone, String country, String city, String street, int zipcode) {
        return false;
    }

    public boolean deleteCustomer(int cust_id) {
        return true;
    }

    public int saveTransaction() {
        return 0;
    }

    public int resetTransaction() {
        return 1;
    }

    /**
     * Find available apartments
     * @param date
     * @param days
     * @param type
     * @return
     */
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
