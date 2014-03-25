/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

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
public class BookingTest {
    
    public BookingTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getBookingID method, of class Booking.
     */
    @Test
    public void testGetBookingID() {
	System.out.println("getBookingID");
	Booking instance = null;
	int expResult = 0;
	int result = instance.getBookingID();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of getApartmentID method, of class Booking.
     */
    @Test
    public void testGetApartmentID() {
	System.out.println("getApartmentID");
	Booking instance = null;
	int expResult = 0;
	int result = instance.getApartmentID();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerID method, of class Booking.
     */
    @Test
    public void testGetCustomerID() {
	System.out.println("getCustomerID");
	Booking instance = null;
	int expResult = 0;
	int result = instance.getCustomerID();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of getNumberOfNights method, of class Booking.
     */
    @Test
    public void testGetNumberOfNights() {
	System.out.println("getNumberOfNights");
	Booking instance = null;
	int expResult = 0;
	int result = instance.getNumberOfNights();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of getTravelAgency method, of class Booking.
     */
    @Test
    public void testGetTravelAgency() {
	System.out.println("getTravelAgency");
	Booking instance = null;
	int expResult = 0;
	int result = instance.getTravelAgency();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of getRent method, of class Booking.
     */
    @Test
    public void testGetRent() {
	System.out.println("getRent");
	Booking instance = null;
	int expResult = 0;
	double result = instance.getRent();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Booking.
     */
    @Test
    public void testToString() {
	System.out.println("toString");
	Booking instance = null;
	String expResult = "";
	String result = instance.toString();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }
    
}
