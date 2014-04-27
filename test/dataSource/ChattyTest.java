/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dataSource;

import domain.Apartment;
import domain.Booking;
import domain.Controller;
import domain.Customer;
import errorHandling.BookingException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kasper
 */
public class ChattyTest {
    
    public Chatty c;
    public Connection con;
    
    public Booking upbook;
    public Customer upcust;  
    
    public ChattyTest() {
	DBConnector.getInstance();
	con = DBConnector.getConnection();
	
	
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
	c = new Chatty();
	
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findAvailableApartment method, of class Chatty.
     */
    @Test
    public void testFindAvailableApartment() throws Exception {
	ArrayList<Apartment> list = c.findAvailableApartment("01-05-14", 1, "Single", 0, con);
	assertTrue(list.size() == 39);
    }

    /**
     * Test of getCustomer method, of class Chatty.
     */
    @Test
    public void testGetCustomer() {
	c.updateLists(con);
	Customer cust = c.getCustomer(1);	
	assertTrue(cust.getCust_id() == 1);
    }

    /**
     * Test of getBooking method, of class Chatty.
     */
    @Test
    public void testGetBooking() {
	c.updateLists(con);
	Booking book = c.getBooking(1);	
	assertTrue(book.getB_id() == 1);
    }

    /**
     * Test of findBookings method, of class Chatty.
     */
    @Test
    public void testFindBookings() {
	c.updateLists(con);
	HashMap<Booking, Customer> map1 = c.findBookings(1, "", "", 0, con);
	HashMap<Booking, Customer> map2 = c.findBookings(0, "Kasper", "", 0, con);
	HashMap<Booking, Customer> map3 = c.findBookings(0, "", "01-05-14", 0, con);
	HashMap<Booking, Customer> map4 = c.findBookings(0, "", "", 1, con);
	HashMap<Booking, Customer> map5 = c.findBookings(0, "", "", 0, con);
	
	assertTrue(!map1.isEmpty());
	assertTrue(!map2.isEmpty());
	assertTrue(!map3.isEmpty());
	assertTrue(!map4.isEmpty());
	assertTrue(map5.isEmpty());
	
    }

    /**
     * Test of updateLists method, of class Chatty.
     */
    @Test
    public void testUpdateLists() {
	c.updateLists(con);
	
	assertTrue(c.getBooking(1) != null);
	assertTrue(c.getCustomer(1) != null);
    }

    /**
     * Test of getApartments method, of class Chatty.
     */
    @Test
    public void testGetApartments() {
	ArrayList list = c.getApartments(con);
	assertTrue(list.size() == 104);
    }

    /**
     * Test of createNewBookingTransaction method, of class Chatty.
     */
//    @Test
//    public void testCreateNewBookingTransaction() {
//	DBConnector.getInstance();
//	Connection cone = DBConnector.getConnection();
//	
//	Customer incust = new Customer("Jane", "Doe", "1234", "smexymommy@hotmail.com", "USA", "Syracuse", "100", "street");
//
//	Controller controller = new Controller();
//	try{
//	    controller.newBooking(incust, 41, "01-05-14", 1, "Agency", 1, 1, "Jane", "Doe", "1234");    
//	}catch(BookingException ex){
//	    
//	}
//	
//	controller.updateLists();
//	HashMap<Booking, Customer> map = controller.findBookings(0,"Jane", "", 0);
//	assertTrue(!map.isEmpty());
//    }

    /**
     * Test of updateBookingTransaction method, of class Chatty.
     */
    @Test
    public void testUpdateBookingTransaction() throws Exception {
	c.updateLists(con);
	HashMap<Booking, Customer> map1 = c.findBookings(7, "", "", 0, con);
	for (Booking b : map1.keySet()){
	    b.setNum_of_nights(5);
	    upbook = b;
	}
	c.updateBookingTransaction(upbook, map1.get(upbook), con);
	
	HashMap<Booking, Customer> map2 = c.findBookings(0, "Janet", "", 0, con);
	for (Booking b : map2.keySet()){
	    assertTrue(b.getNum_of_nights() == 5);
	}
    }

    /**
     * Test of deleteBookingTransaction method, of class Chatty.
     */
    @Test
    public void testDeleteBookingTransaction() throws Exception {
	c.deleteBookingTransaction(6, con);
	
	c.updateLists(con);
	HashMap<Booking, Customer> map = c.findBookings(0, "Kiley", "", 0, con);
	assertTrue(map.isEmpty());
    }

    /**
     * Test of updateCustomerTransaction method, of class Chatty.
     */
    @Test
    public void testUpdateCustomerTransaction() throws Exception {
	c.updateLists(con);
	HashMap<Booking, Customer> map1 = c.findBookings(8, "", "", 0, con);
	for (Customer c : map1.values()){
	    c.setEmail("smexyman@hotmail.com");
	    upcust = c;
	}
	c.updateCustomerTransaction(upcust, con);
	
	HashMap<Booking, Customer> map2 = c.findBookings(0, "Janette", "", 0, con);
	assertTrue(!map2.isEmpty());
	for (Customer c : map2.values()){
	    assertTrue("smexyman@hotmail.com".equals(c.getEmail()));
	}
    }

    /**
     * Test of searchForCustomers method, of class Chatty.
     */
    @Test
    public void testSearchForCustomers() {
	c.updateLists(con);
	ArrayList<Customer> list = c.searchForCustomers("o");
	assertTrue(!list.isEmpty());
	list = c.searchForCustomers("hald");
	assertTrue(!list.isEmpty());
	list = c.searchForCustomers("555");
	assertTrue(!list.isEmpty());
	list = c.searchForCustomers("This should fail");
	assertTrue(list.isEmpty());
    }

    /**
     * Test of getBookingsToDay method, of class Chatty.
     */
    @Test
    public void testGetBookingsToDay() {
	c.updateLists(con);
	ArrayList<Booking[]> list = c.getBookingsToDay();
	assertTrue(!list.isEmpty());
	assertTrue(list.get(0)[0].getLast_name().equals("I"));
	assertTrue(list.get(1)[1].getLast_name().equals("II"));
	assertTrue(list.get(2)[1].getLast_name().equals("IV"));
    }

    /**
     * Test of getBookingsByMonth method, of class Chatty.
     */
    @Test
    public void testGetBookingsByMonth() {
	c.updateLists(con);
	ArrayList<int[]> list = c.getBookingsByMonth("01-05-14");
	System.out.println("Bookings this month: " + list.size());
	assertTrue(list.get(0)[7] == 1);
    }

//    /**
//     * Test of getBookingsByApartment method, of class Chatty.
//     */
//    @Test
//    public void testGetBookingsByApartment() {
//	c.updateLists(con);
//	ArrayList<int[]> list = c.getBookingsByApartment(1, 1);
//	System.out.println("Bookings in apartment 1: " + list.size());
//	assertTrue(list.size() == 1);
//	
//	list = c.getBookingsByApartment(3, 1);
//	System.out.println("Bookings in apartment 3: " + list.size());
//	assertTrue(list.size() == 2);
//    }
}
