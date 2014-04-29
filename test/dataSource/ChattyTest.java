package dataSource;

import domain.Booking;
import domain.Customer;
import errorHandling.BookingException;
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

    private Customer resetToValidCustomer() {
        return new Customer("Kasper", "Hald", "5555", "email@mail.dk", "Danmark", "køge", "8888", "Street 88");
    }

    private Booking resetToValidBooking(Customer c) {
        return new Booking(1, "12-12-14", 1, "travel agency", 1, 60, c.getFirst_name(), c.getLast_name(), c.getPhone());
    }

    /**
     * Test of createNewBookingTransaction method, of class Chatty.
     */
    @Test
    public void testCreateNewBookingTransaction() {
        Customer c = resetToValidCustomer();
        Booking b = resetToValidBooking(c);

        try {
            chatty.createNewBookingTransaction(b, c, con, false);
            assertTrue(true);
        } catch (BookingException ex) {
            assertFalse(true);

        }

        // Too long email
        try {
            c.setEmail("emailemailemailemailemailemailemailemailemail@mail.com");
            chatty.createNewBookingTransaction(b, c, con, false);
            assertFalse(false);
        } catch (BookingException ex) {
            assertTrue(true);
        }

        // Zipcode not a number
        try {
            c = resetToValidCustomer();
            c.setZipcode("not a num");
            chatty.createNewBookingTransaction(b, c, con, false);
            assertFalse(true);
        } catch (BookingException ex) {
            assertTrue(true);
        }

        // Too long phone number
        try {
            c = resetToValidCustomer();
            c.setPhone("123456789987654321");
            chatty.createNewBookingTransaction(b, c, con, false);
            assertFalse(true);
        } catch (BookingException ex) {
            assertTrue(true);
        }

        // null-value in a string where SQL constriant is not null 
        try {
            c = resetToValidCustomer();
            c.setFirst_name(null);
            chatty.createNewBookingTransaction(b, c, con, false);
            assertFalse(true);
        } catch (BookingException ex) {
            assertTrue(true);
        }

        try {
            c = null;
            chatty.createNewBookingTransaction(b, c, con, false);
            assertFalse(true);
        } catch (BookingException ex) {
            assertTrue(true);
        }

        try {
            c = resetToValidCustomer();
            c.setZipcode("-500");
            chatty.createNewBookingTransaction(b, c, con, false);
            assertFalse(true);
        } catch (BookingException ex) {
            assertTrue(true);
        }

        c = resetToValidCustomer();
        b = resetToValidBooking(c);

        // Too high apartnumber
        try {
            b.setA_num(105);
            chatty.createNewBookingTransaction(b, c, con, false);
            assertFalse(true);
        } catch (BookingException ex) {
            assertTrue(true);
        }

        // negative apartment number
        try {
            b = resetToValidBooking(c);
            b.setA_num(-1);
            chatty.createNewBookingTransaction(b, c, con, false);
            assertFalse(true);
        } catch (BookingException ex) {
            assertTrue(true);
        }

        // Date not in number
        try {
            b = resetToValidBooking(c);
            b.setDate_from("dette er en dato");
            chatty.createNewBookingTransaction(b, c, con, false);
            assertFalse(true);
        } catch (BookingException ex) {
            assertTrue(true);
        }

        // invalid date
        try {
            b = resetToValidBooking(c);
            b.setDate_from("99-99-99");
            chatty.createNewBookingTransaction(b, c, con, false);
            assertFalse(true);
        } catch (BookingException ex) {
            assertTrue(true);
        }

        // Too long travel agency
        try {
            b = resetToValidBooking(c);
            b.setTravel_agency("i am a travel agancy and you are all my scrum slaves");
            chatty.createNewBookingTransaction(b, c, con, false);
            assertFalse(true);
        } catch (BookingException ex) {
            assertTrue(true);
        }
    }

    /**
     * Test of updateBookingTransaction method, of class Chatty.
     */
    @Test
    public void testUpdateBookingTransaction() throws Exception {

    }

}
