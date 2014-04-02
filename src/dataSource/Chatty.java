package dataSource;

import domain.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Christopher & Thomas
 */
public class Chatty {

    //== Fields
    private ArrayList<Booking> bookings;
    private ArrayList<Booking> history;
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
    }

    public ArrayList<Apartment> findAvailableApartment(String date, int days, String type, Connection con) {
        ArrayList<Apartment> apartmentToReturn = new ApartmentMapper().findAvailableApartment(date, days, type, con);
        return apartmentToReturn;
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
            bookingStatus = bookingMapper.insertNewBooking(b,customerStatus ,con);
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

    public boolean commit() {
        return true;
    }

}
