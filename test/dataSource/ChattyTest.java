package dataSource;

import domain.Booking;
import domain.Customer;
import errorHandling.ConnectionException;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author simon
 */
public class ChattyTest {

    private static Connection con;
    private Chatty chatty;

    public ChattyTest() {

    }

    @BeforeClass
    public static void setUpClass() {
        DBConnector.getInstance();
        try {
            con = DBConnector.getConnection();
        } catch (ConnectionException ex) {
        }

    }

    @AfterClass
    public static void tearDownClass() {
        try {
            con.close();
        } catch (SQLException ex) {
        }
    }

    @Before
    public void setUp() {
        Fixture f = new Fixture();
        f.runScript();
        chatty = new Chatty();
    }

    @After
    public void tearDown() {

    }

    /**
     * Test of createNewBookingTransaction method, of class Chatty.
     */
    @Test(expected = Exception.class)
    public void testCreateNewBookingTransaction() throws Exception {
        Customer c = new Customer("Kebab", "Smith", "5555", "email@mail.dk", "denmark", "køge", "8888", "Street 88");
        Booking b = new Booking(1, "12-12-14", 1, "travel agency", 1, 60, c.getFirst_name(), c.getLast_name(), c.getPhone());

        // gyldig customer        
        // Ugyldig customer        
        // - for lang email 
        // - zipcode som ikke nummer
        // - for lang phone
        // - en null værdi 
        // - En tom customer
        // - En negativ zipcode
        
        
        
        // Gyldig booking
        // ugyldig booking
        // - ugyldig cust id
        // - ugyldig apartment 
        //  - forkert dato format bogstaver og høje tal
        // - travel agency length
        
        
        Connection con = null;
        boolean previousCustomerFlag = false;
        Chatty instance = new Chatty();
        boolean expResult = false;
        boolean result = instance.createNewBookingTransaction(b, c, con, previousCustomerFlag);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateBookingTransaction method, of class Chatty.
     */
    @Test
    public void testUpdateBookingTransaction() throws Exception {
        System.out.println("updateBookingTransaction");
        Booking b = null;
        Customer customer = null;
        Connection con = null;
        Chatty instance = new Chatty();
        boolean expResult = false;
        boolean result = instance.updateBookingTransaction(b, customer, con);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
