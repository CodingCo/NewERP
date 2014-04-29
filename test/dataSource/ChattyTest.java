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
    }

    @After
    public void tearDown() {

    }

    /**
     * Test of createNewBookingTransaction method, of class Chatty.
     */
    @Test
    public void testCreateNewBookingTransaction() throws Exception {
        System.out.println("createNewBookingTransaction");
        Booking b = null;
        Customer c = null;
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
