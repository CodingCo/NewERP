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
public class ApartmentTest {
    
    public ApartmentTest() {
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
     * Test of getApartmentID method, of class Apartment.
     */
    @Test
    public void testGetApartmentID() {
	System.out.println("getApartmentID");
	Apartment instance = null;
	int expResult = 0;
	int result = instance.getANum();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of getType method, of class Apartment.
     */
    @Test
    public void testGetType() {
	System.out.println("getType");
	Apartment instance = null;
	String expResult = "";
	String result = instance.getType();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Apartment.
     */
    @Test
    public void testToString() {
	System.out.println("toString");
	Apartment instance = null;
	String expResult = "";
	String result = instance.toString();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }
    
}
