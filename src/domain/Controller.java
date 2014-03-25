package domain;

import java.util.ArrayList;

public class Controller {
    private static Controller instance;

    
    private Controller() {
    
    }

    
    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }

        return instance;
    }

    /**
     * Creates a new booking
     * @param a_num
     * @param cust_id
     * @param num_of_nights
     * @param travel_agency
     * @param rent
     * @return
     */
    public Booking addNewBooking(int a_num, int cust_id, int num_of_nights, String travel_agency, double rent) {
        return null;
    }

    /**
     * Update a current booking
     * @param a_num
     * @param cust_id
     * @param num_of_nights
     * @param rent
     * @return
     */
    public Booking updateBooking(int a_num, int cust_id, int num_of_nights, double rent) {
        return null;
    }

    public boolean deleteBooking(int b_id) {
        return true;
    }

    /**
     * Creates a new customer
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
     * updates a current customer
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
    public Customer updateCustomer(String name, String family_name, int age, String email, int phone, String country, String city, String street, int zipcode) {
        return null;
    }

    public boolean deleteCustomer(int cust_id) {
        return true;
    }

    public boolean saveTransaction() {
        return true;
    }

    public boolean resetTransaction() {
        return true;
    }

    /**
     * Use this method for finding available apartments based on search criteria
     * @param date
     * @param days
     * @param type
     * @return
     */
    public ArrayList<Apartment> findAvailableApartments(String date, int days, String type) {
        return null;
    }

    /**
     * Use this method for searching through current bookings
     * @param bookingNr
     * @param name
     * @param date
     * @param roomNr
     * @return
     */
    public ArrayList<Apartment> findBookingByParams(int bookingNr, String name, String date, int roomNr) {
        return null;
    }

    /**
     * Loads in all bookings from database
     */
    public void getBookings() {

    }

    /**
     * Loads in all customers from database
     */
    public void getCustomers() {

    }

    /**
     * Loads in all 104 apartments from database
     */
    public void getApartments() {

    }

}
