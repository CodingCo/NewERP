package dataSource;

import errorHandling.BookingException;
import domain.*;
import errorHandling.CustomerException;
import errorHandling.DateException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * @author Christopher & Thomas
 */
public class Chatty {

    private ArrayList<Booking> bookings;
    private ArrayList<History> history;
    private ArrayList<Customer> customers;
    private BookingMapper bookingMapper;
    private CustomerMapper customerMapper;
    private ApartmentMapper apartmentMapper;

    public Chatty() {
        this.bookings = new ArrayList();
        this.history = new ArrayList();
        this.bookingMapper = new BookingMapper();
        this.customerMapper = new CustomerMapper();
        this.apartmentMapper = new ApartmentMapper();
        this.customers = new ArrayList();
    }

    protected ArrayList<Apartment> findAvailableApartment(String date, int days, String type, int apartment_nr, Connection con) throws DateException {
        ArrayList<Apartment> apartmentToReturn = new ApartmentMapper().findAvailableApartment(date, days, type, apartment_nr, con);
        return apartmentToReturn;
    }

    /**
     * @Author Simon
     *
     * Finds a Customer, with matching customer ID If none is found with the
     * input ID, it returns null
     *
     * @param custId - Customer ID to search for
     * @return Customer - returns the desired customer
     */
    protected Customer getCustomer(int custId) {
        for (Customer c : this.customers) {
            if (c.getCust_id() == custId) {
                return c;
            }
        }
        return null;
    }

    /**
     * @Author Simon
     *
     * Finds a booking with matching booking ID if none is found with the input
     * ID, it returns null
     *
     * @param bID - Booking ID to search for
     *
     * @return A Booking object, corresponding to the input
     */
    protected Booking getBooking(int bID) {
        for (Booking b : this.bookings) {
            if (b.getB_id() == bID) {
                return b;
            }
        }
        return null;
    }

    /**
     *
     * @Author Thomas & Christopher
     *
     * Finds bookings depending on the params, the user wants to search for
     *
     * @param b_id The booking ID to search for
     * @param name name on customer to search for
     * @param date the date to to search for
     * @param apartment_nr Apartment num to search for
     * @param con Mandatory Connection
     * @return Returns a HashMap with Booking as the key, and Customer as value
     */
    protected HashMap findBookings(int b_id, String name, String date, int apartment_nr, Connection con) {
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

    /**
     * @Author Thomas & Christopher
     *
     * Updates the lists: bookings and customers. When the list is updated the
     * newest information from the database is retriewed
     *
     * @param con The mandatory Connection
     */
    protected void updateLists(Connection con) {
        bookings = bookingMapper.getAllBookings(con);
        customers = customerMapper.getAllCustomers(con);
    }

    protected ArrayList<Apartment> getApartments(Connection con) {
        return this.apartmentMapper.getAllApartments(con);
    }

    ///////////////////////////////////////////////// TRANSACTIONS'
    /**
     * @param previousCustomerFlag
     * @Author Thomas & Christopher
     *
     * Creates a booking on the DB Commits if it succeeds, if not it rolls back
     *
     * @param b Booking
     * @param c Customer
     * @param con Connection
     * @return status, depending on wether the transaction succeded or not
     * @throws BookingException
     */
    protected boolean createNewBookingTransaction(Booking b, Customer c, Connection con, boolean previousCustomerFlag) throws BookingException {

        int bookingStatus = 0;
        int customerId = 0;

        try {
            String lock = "LOCK TABLE booking IN EXCLUSIVE MODE";
            con.setAutoCommit(false);
            Statement statement = con.createStatement();
            boolean lockStatus = statement.execute(lock);

            if (!lockStatus) {

                if (apartmentMapper.checkAvailAbleApartment(b.getB_id(), b.getDate_from(), b.getNum_of_nights(), b.getA_num(), con)) {
                    if (previousCustomerFlag) {
                        customerId = customerMapper.updateCustomer(con, c);
                    } else {
                        customerId = customerMapper.insertNewCustomer(c, con);
                    }
                    bookingStatus = bookingMapper.insertNewBooking(b, customerId, con);
                }
                if (customerId == 0 || bookingStatus == 0) {
                    con.rollback();
                    return false;
                } else {
                    con.commit();
                    return true;
                }
            }

        } catch (SQLException ex) {
            throw new BookingException("Booking could not be created");

        }
        return false;
    }

    /**
     * @Author Thomas & Christopher
     *
     * Updates a booking with mathcing bookig ID, stored in the param
     *
     * @param b Booking
     * @param customer Customer
     * @param con Connection
     * @return true if booking was updated, false if not
     * @throws BookingException
     */
    protected boolean updateBookingTransaction(Booking b, Customer customer, Connection con) throws BookingException {
        int bookingStatus = 0;
        int customerStatus = 0;

        try {
            String lock = "LOCK TABLE booking IN EXCLUSIVE MODE";
            con.setAutoCommit(false);
            Statement statement = con.createStatement();
            boolean lockStatus = statement.execute(lock);

            if (!lockStatus) {
                if (apartmentMapper.checkAvailAbleApartment(b.getB_id(), b.getDate_from(), b.getNum_of_nights(), b.getA_num(), con)) {
                    bookingStatus = bookingMapper.updateBooking(b, con);
                    customerStatus = customerMapper.updateCustomer(con, customer);
                }

                if (bookingStatus == 0 || customerStatus == 0) {
                    con.rollback();
                    return false;
                } else {
                    con.commit();
                    return true;
                }
            }
        } catch (SQLException ex) {
            throw new BookingException("Booking could not be updated");
        }
        return false;
    }

    protected boolean deleteBookingTransaction(int b_id, Connection con) throws BookingException {
        int status;
        status = bookingMapper.deleteBooking(con, b_id);
        return status != 0;
    }

    /**
     * @Author Robert
     *
     * Updates a customer with the customer ID, stored in the param
     *
     * @param ctmp Customer
     * @param con Connection
     * @return true if the update succeeded
     */
    protected boolean updateCustomerTransaction(Customer ctmp, Connection con) throws CustomerException {

        int customerStatus = 0;

        try {
            String lock = "LOCK TABLE customer IN EXCLUSIVE MODE";
            con.setAutoCommit(false);
            Statement statement = con.createStatement();
            boolean lockStatus = statement.execute(lock);

            if (!lockStatus) {

                customerStatus = customerMapper.updateCustomer(con, ctmp);

                if (customerStatus == 0) {
                    con.rollback();
                    return false;
                } else {
                    con.commit();
                    return true;
                }
            }
        } catch (SQLException ex) {
            throw new CustomerException("Customer could not be updated");
        }
        return false;
    }

    /**
     * @Author Simon
     *
     * Searches through the Customer list
     *
     * @param keyword - String
     * @return ArrayLIst of customers, which are related with the keyword
     */
    protected ArrayList<Customer> searchForCustomers(String keyword) {
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

    /**
     *
     * @Author Thomas
     *
     * Finds all bookings which starts today, or ends today The return ArrayList
     * contains int[] for each booking with relevant data, unique for each
     * booking
     *
     * @return All Bookings which starts or ends today
     */
    protected ArrayList<Booking[]> getBookingsToDay() {
        ArrayList<Booking> oldBookings = new ArrayList();
        ArrayList<Booking> newBookings = new ArrayList();
        ArrayList<Booking[]> BookingPairs = new ArrayList(); // The list to return
        String toDay;

        Calendar c = Calendar.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
        Date date = new Date();
        toDay = sdf.format(date);

        for (Booking currentBooking : bookings) {

            if (currentBooking.getDate_from().equals(toDay)) {
                newBookings.add(currentBooking);
            } else {
                int num_nights = currentBooking.getNum_of_nights();
                String bookingDateBegin = currentBooking.getDate_from();

                try {
                    c.setTime(sdf.parse(bookingDateBegin));
                } catch (ParseException ex) {

                }

                c.add(Calendar.DATE, num_nights);
                String bookingDateEnd = sdf.format(c.getTime());

                if (bookingDateEnd.equals(toDay)) {
                    oldBookings.add(currentBooking);
                }

            }

        }

        int i = 1;
        while (i <= 104) {
            Booking[] bookingPair = new Booking[2];

            for (Booking current : oldBookings) {
                if (current.getA_num() == i) {
                    bookingPair[0] = current;
                    break;
                }
            }

            for (Booking current : newBookings) {
                if (current.getA_num() == i) {
                    bookingPair[1] = current;
                    break;
                }
            }

            if (bookingPair[0] != null || bookingPair[1] != null) {
                BookingPairs.add(bookingPair);
            }

            i++;
        }
        return BookingPairs;
    }

    /**
     *
     * @Author: Thomas
     *
     * Finds all bookings which starts, ends or overlaps this month
     *
     * @param date String
     * @return ArrayList<int[]>
     */
    protected ArrayList<int[]> getBookingsByMonth(String date) {
        ArrayList<int[]> finalList = new ArrayList();
        ArrayList<int[]> listToReturn = new ArrayList();
        ArrayList<Booking> relevantBookings = new ArrayList();

        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");

        int month = Integer.parseInt(date.substring(3, 5));
        int year = Integer.parseInt(date.substring(6, 8));

        for (Booking current : bookings) {

            int bookingStartMonth = Integer.parseInt(current.getDate_from().substring(3, 5));
            int bookingStartYear = Integer.parseInt(current.getDate_from().substring(6, 8));

            if (bookingStartMonth == month && bookingStartYear == year) {
                relevantBookings.add(current);
            } else {
                int num_nights = current.getNum_of_nights();
                String bookingStartDate = current.getDate_from();

                try {
                    c.setTime(sdf.parse(bookingStartDate));
                } catch (ParseException ex) {
                }
                c.add(Calendar.DATE, num_nights);
                String bookingDateEnd = sdf.format(c.getTime());

                int bookingEndMonth = Integer.parseInt(bookingDateEnd.substring(3, 5));
                int bookingEndYear = Integer.parseInt(bookingDateEnd.substring(6, 8));

                if (bookingEndYear == year) {
                    if (bookingEndMonth >= month && bookingStartMonth <= month) {
                        relevantBookings.add(current);
                    }
                }

                if (bookingStartYear < year) {
                    if (bookingEndYear == year) {
                        if (bookingEndMonth >= month) {
                            relevantBookings.add(current);
                        }
                    }

                    if (bookingEndYear > year) {
                        relevantBookings.add(current);
                    }

                }

                if (bookingEndYear > year) {
                    if (bookingStartYear < year) {
                        relevantBookings.add(current);

                    }

                    if (bookingStartYear == year) {
                        if (bookingStartMonth <= month) {
                            relevantBookings.add(current);
                        }
                    }
                }

            }
        }

        for (Booking current : relevantBookings) {
            int[] bookingValues = new int[11];

            bookingValues[0] = Integer.parseInt(current.getDate_from().substring(0, 2));
            bookingValues[1] = Integer.parseInt(current.getDate_from().substring(3, 5));
            bookingValues[2] = Integer.parseInt(current.getDate_from().substring(6, 8));

            try {
                c.setTime(sdf.parse(current.getDate_from()));
            } catch (ParseException e) {
                System.out.println("Error in getBookingsByMonth method");
            }

            bookingValues[3] = c.getActualMaximum(Calendar.DAY_OF_MONTH);
            bookingValues[4] = current.getNum_of_nights();
            bookingValues[5] = current.getA_num();
            bookingValues[6] = current.getB_id();
            bookingValues[7] = current.getCust_id();

            // End Date info
            c.add(Calendar.DATE, current.getNum_of_nights());
            String bookingDateEnd = sdf.format(c.getTime());

            bookingValues[8] = Integer.parseInt(bookingDateEnd.substring(0, 2));
            bookingValues[9] = Integer.parseInt(bookingDateEnd.substring(3, 5));
            bookingValues[10] = Integer.parseInt(bookingDateEnd.substring(6, 8));
            listToReturn.add(bookingValues);
        }

        int i = 1;
        while (i <= 104) {

            boolean isEmpty = true;

            for (int[] current : listToReturn) {
                if (current[5] == i) {      // If (a_num == i) it adds it to finalList
                    isEmpty = false;
                    finalList.add(current);
                }
            }

            if (isEmpty) {
                int[] emptyAparment = new int[8];
                emptyAparment[5] = i;
                finalList.add(emptyAparment);
            }

            i++;
        }

        return finalList;
    }

    /**
     *
     * @Author: Thomas & Christopher
     *
     * Finds all bookings, which have the same apartment number, and starts,
     * ends or overlaps the period from today and the number of months into the
     * future.
     *
     * @param aNum int
     * @param months int
     * @return ArrayList<int[]>
     */
    protected ArrayList<int[]> getBookingsByApartment(int aNum, int months) {
        ArrayList<Booking> bookingsToSort = new ArrayList(bookings);
        ArrayList<int[]> relevantBookings = new ArrayList();
        boolean relevant = false;

        // Get current date to count from, and into the future
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
        Calendar today = new GregorianCalendar();
        Calendar endDate = new GregorianCalendar();
        Calendar bookingStartDate = new GregorianCalendar();
        Calendar bookingEndDate = new GregorianCalendar();

        try {
            // Find the END month and year                           
            endDate.add(Calendar.MONTH, (months));
            endDate.set(Calendar.DAY_OF_MONTH, 1);
            endDate.add(Calendar.DATE, -1);

            Collections.sort(bookingsToSort);

            for (Booking current : bookingsToSort) {

                if (current.getA_num() == aNum) {

                    bookingStartDate.setTime(sdf.parse(current.getDate_from()));
                    bookingEndDate.setTime(sdf.parse(current.getDate_from()));
                    bookingEndDate.add(Calendar.DATE, current.getNum_of_nights());

                    if ((bookingStartDate.compareTo(today) < 0) && (bookingEndDate.compareTo(today) >= 0)) {
                        relevant = true;
                    } else if ((bookingStartDate.compareTo(today) >= 0) && (bookingStartDate.compareTo(endDate) <= 0)) {
                        relevant = true;
                    }

                    if (relevant) {
                        int[] bookingValues = new int[11];
                        bookingValues[0] = Integer.parseInt(current.getDate_from().substring(0, 2));
                        bookingValues[1] = Integer.parseInt(current.getDate_from().substring(3, 5));
                        bookingValues[2] = Integer.parseInt(current.getDate_from().substring(6, 8));
                        bookingValues[3] = bookingStartDate.getActualMaximum(Calendar.DAY_OF_MONTH);
                        bookingValues[4] = current.getNum_of_nights();
                        bookingValues[5] = current.getA_num();
                        bookingValues[6] = current.getB_id();
                        bookingValues[7] = current.getCust_id();
                        bookingValues[8] = Integer.parseInt(sdf.format(bookingEndDate.getTime()).substring(0, 2));
                        bookingValues[9] = Integer.parseInt(sdf.format(bookingEndDate.getTime()).substring(3, 5));
                        bookingValues[10] = Integer.parseInt(sdf.format(bookingEndDate.getTime()).substring(6, 8));

                        relevantBookings.add(bookingValues);
                    }

                }

                relevant = false;

            }
        } catch (ParseException ex) {

        }

        return relevantBookings;
    }
}
