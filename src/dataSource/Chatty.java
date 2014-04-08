package dataSource;

import domain.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * @author Christopher & Thomas
 */
public class Chatty {

    //== Fields
    private ArrayList<Booking> bookings;
    private ArrayList<History> history;
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

    /////////////////////////////////////////// FINDERS
    public ArrayList<Apartment> findAvailableApartment(String date, int days, String type, int apartment_nr, Connection con) {
        ArrayList<Apartment> apartmentToReturn = new ApartmentMapper().findAvailableApartment(date, days, type, apartment_nr, con);
        return apartmentToReturn;
    }

    public HashMap findBookings(int b_id, String name, String date, int apartment_nr, Connection con) {
        updateLists(con);
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
            //== Compares the remaining params --> First filtering
            if (booking.getFirst_name().equalsIgnoreCase(name)
                    || booking.getDate_from().equalsIgnoreCase(date)
                    || booking.getA_num() == apartment_nr) {

                for (Customer customer : customers) {
                    if (booking.getCust_id() == customer.getCust_id()) {
                        relevantBooking.put(booking, customer);
                    }
                }
            }

            //== Sorting relevant bookings --> Second Filtering
            for (Booking bKey : relevantBooking.keySet()) {

                if (!name.isEmpty() && !bKey.getFirst_name().equalsIgnoreCase(name)) {
                    relevantBooking.remove(bKey);
                }
                if (!date.isEmpty() && !bKey.getDate_from().equalsIgnoreCase(date)) {
                    relevantBooking.remove(bKey);
                }
                if (apartment_nr != 0 && bKey.getA_num() != apartment_nr) {
                    relevantBooking.remove(bKey);
                }
            }

        }
        return relevantBooking;
    }

    public void updateLists(Connection con) {
        bookings = bookingMapper.getAllBookings(con);
        customers = customerMapper.getAllCustomers(con);
    }

    
    public ArrayList<Apartment> getApartments(Connection con){
      return  this.apartmentMapper.getAllApartments(con);
    }
    
    ///////////////////////////////////////////////// TRANSACTIONS
    public boolean createNewBookingTransaction(Booking b, Customer c, Connection con) {
        int bookingStatus = 0;
        int customerStatus = 0;

        try {
            String lock = "LOCK TABLE booking IN EXCLUSIVE MODE";
            con.setAutoCommit(false);
            Statement statement = con.createStatement();
            statement.execute(lock);

            if (apartmentMapper.checkAvailAbleApartment(b.getDate_from(), b.getNum_of_nights(), b.getA_num(), con)) {
                customerStatus = customerMapper.insertNewCustomer(c, con);
                bookingStatus = bookingMapper.insertNewBooking(b, customerStatus, con);
            }
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

    public boolean updateBookingTransaction(Booking booking, Customer customer, Connection con) {
        int bookingStatus;
        int customerStatus;

        try {
            con.setAutoCommit(false);

            bookingStatus = bookingMapper.updateBooking(booking, con);
            customerStatus = customerMapper.updateCustomer(con, customer);

            if (bookingStatus == 0 || customerStatus == 0) {
                con.rollback();
                return false;
            } else {
                con.commit();
            }
        } catch (SQLException ex) {
            System.err.println("Fail in updateBooking - Hilsen Thomas og Christopher");
            System.out.println(ex);
        }

        return true;
    }

    public boolean deleteBookingTransaction(int b_id, Connection con) {
        int status;
        status = bookingMapper.deleteBooking(con, b_id);
        return status != 0;
    }

    public ArrayList<Customer> searchForCustomers(String keyword) {
        ArrayList<Customer> tmpList = new ArrayList();

        for (Customer c : customers) {
            if (c.getFirst_name().toLowerCase().contains(keyword)
                    || c.getLast_name().toLowerCase().contains(keyword)
                    || c.getPhone().toLowerCase().contains(keyword)) {
                tmpList.add(c);
            }
        }
        return tmpList;
    }

    //======== Sotring method underneath
    public ArrayList<Booking> getBookingsBySpecificDate(String date, Connection con) {
        ArrayList<Booking> relevantBookings = new ArrayList();
        ArrayList<Booking> sortedRelevantBookings = new ArrayList();
        updateLists(con);

        for (Booking booking : bookings) {
            if (booking.getDate_from().equalsIgnoreCase(date)) {
                relevantBookings.add(booking);
            }
        }

        //== Sort by Apartment-Num
        for (int i = 0; i <= 104; i++) {
            for (Booking booking : relevantBookings) {
                if (booking.getA_num() == i) {
                    sortedRelevantBookings.add(booking);
                }
            }
        }

        return sortedRelevantBookings;
    }

    public ArrayList<Booking> getBookingsBySpecificMonth(String date, Connection con) {
        updateLists(con);
        ArrayList<Booking> relevantBookings = new ArrayList();
        ArrayList<Booking> sortedBookings = new ArrayList();

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");

            Calendar desiredDate = new GregorianCalendar();
            desiredDate.setTime(sdf.parse(date));

            for (Booking currentBooking : bookings) {
                Calendar currentDate = new GregorianCalendar();
                currentDate.setTime(sdf.parse(currentBooking.getDate_from()));

                if (desiredDate.get(2) == currentDate.get(2)) {
                    relevantBookings.add(currentBooking);
                } else {
                    currentDate.add(Calendar.DATE, currentBooking.getNum_of_nights());
                    if (desiredDate.get(2) == currentDate.get(2)) {
                        relevantBookings.add(currentBooking);
                    }
                }
            }
        } catch (ParseException ex) {
            System.out.println("Fail in Chatty getBookingsBySpecificMonth()");
            ex.printStackTrace();
        }

        //== Sort by Apartment-Num
        for (int i = 0; i <= 104; i++) {
            for (Booking booking : relevantBookings) {
                if (booking.getA_num() == i) {
                    sortedBookings.add(booking);
                }
            }
        }

        return sortedBookings;
    }

    public ArrayList<Booking> getBookingsByApartment(int a_nr, Connection con) {
        updateLists(con);
        
        ArrayList<Booking> relevantBookings = new ArrayList();
       
        Calendar endDate = new GregorianCalendar();
        endDate.setTime(Calendar.getInstance().getTime());
        endDate.add(2, 3); 
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
        
        try{
            for(Booking currentBooking : bookings){
            Calendar currentDate = new GregorianCalendar();
            currentDate.setTime(sdf.parse(currentBooking.getDate_from()));
            if(currentBooking.getA_num() == a_nr && currentDate.get(2) <= endDate.get(2)){
                relevantBookings.add(currentBooking);
            }
        }
        }catch(ParseException ex){
            System.out.println("Fail in getBookingsByApartment");
            ex.printStackTrace();
        }
        
        //== Sort by date beneith
        Collections.sort(relevantBookings); 
        
        return relevantBookings;
    }

}
