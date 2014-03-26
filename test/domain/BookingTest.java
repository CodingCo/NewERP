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
  

    /**
     * Test of getApartmentID method, of class Booking.
     */
   

    /**
     * Test of getCustomerID method, of class Booking.
     */
  

    /**
     * Test of getNumberOfNights method, of class Booking.
     */
   

    /**
     * Test of getTravelAgency method, of class Booking.
     */
   
   

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
