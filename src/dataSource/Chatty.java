package dataSource;

import domain.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Christopher & Thomas
 */
public class Chatty {

    //== Fields
    private ArrayList<Booking> bookings;
    private ArrayList<Booking> history;
    private ArrayList<Customer> customers;
    private BookingMapper bookingMapper;
    private CustomerMapper customerMapper;
    private ApartmentMapper apartmentMapper;

    //== Constructor
    public Chatty() {
        this.bookings = new ArrayList();
        this.history = new ArrayList();
        this.bookingMapper = new BookingMapper();
        this.customerMapper = new CustomerMapper();
        this.apartmentMapper = new ApartmentMapper();
        this.customers = new ArrayList();
    }

    public ArrayList<Apartment> findAvailableApartment(String date, int days, String type, Connection con) {
        ArrayList<Apartment> apartmentToReturn = new ApartmentMapper().findAvailableApartment(date, days, type, con);
        return apartmentToReturn;
    }

    public HashMap findBookings(int b_id, String name, String date, int num_nights, Connection con) {
        updateBookingsList(con);
        updateCustomersList(con);
        HashMap<Booking, Customer> relevantBooking = new HashMap();

        for (Booking booking : bookings) {
            //== Compares the b_id
            if (booking.getB_id() == b_id) {
                for (Customer customer : customers) {
                    if (booking.getCust_id() == customer.getCust_id()) {
                        relevantBooking.clear();
                        relevantBooking.put(booking, customer);
                        return relevantBooking;
                    }
                }
            }
            //== Compares the remaining params
            if (booking.getFirst_name().equalsIgnoreCase(name)
                    || booking.getDate_from().equalsIgnoreCase(date)
                    || booking.getNum_of_nights() == num_nights) {

                for (Customer customer : customers) {
                    if (booking.getCust_id() == customer.getCust_id()) {
                        relevantBooking.put(booking, customer);
                    }
                }
            }
            
        }
        return relevantBooking;
    }

    public boolean createNewBookingTransaction(Booking b, Customer c, Connection con) {
        int bookingStatus = 0;
        int customerStatus = 0;

        try {
            String lock = "LOCK TABLE booking IN SHARE MODE";
            con.setAutoCommit(false);
            Statement statement = con.createStatement();
            statement.execute(lock);

            //== is it available --> We expect a boolean
//            if (bookingMapper.checkApartmentAvailability(con)) {
            customerStatus = customerMapper.insertNewCustomer(c, con);
            bookingStatus = bookingMapper.insertNewBooking(b, customerStatus, con);
//            }
            if (customerStatus == 0 || bookingStatus == 0) {
                con.rollback();
                return false;
            } else {
                con.commit();
            }
        } catch (SQLException ex) {
            System.err.println("Fail in createNewBooking()");
            System.out.println(ex);
        }
        return true;
    }

    public void updateBookingsList(Connection con) {
        bookings = bookingMapper.getAllBookings(con);
    }

    public void updateCustomersList(Connection con) {
        customers = customerMapper.getAllCustomers(con);
    }
    
    public boolean updateBookingTransaction(Booking booking, Customer customer, Connection con){
        int bookingStatus;
        int customerStatus;
        
        try{
            con.setAutoCommit(false);
        
        bookingStatus = bookingMapper.updateBooking(booking, con);
        customerStatus = customerMapper.updateCustomer(con, customer);
        
        if (bookingStatus == 0 || customerStatus == 0) {
                con.rollback();
                return false;
            } else {
                con.commit();
            }
        } catch(SQLException ex){
            System.err.println("Fail in updateBooking - Hilsen Thomas og Christopher");
            System.out.println(ex);
        }
        
        return true;
    }
    
    public boolean deleteBooking(int b_id, Connection con){
        int status;
        status = bookingMapper.deleteBooking(con, b_id);        
        return status != 0;
    }
    
    
    
    
}
