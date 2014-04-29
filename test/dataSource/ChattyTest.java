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

        int i = 0;

        try {
            chatty.createNewBookingTransaction(b, c, con, false);
            i++;
        } catch (BookingException ex) {
        }

        // Too long email
        try {
            c.setEmail("emailemailemailemailemailemailemailemailemail@mail.com");
            if (chatty.createNewBookingTransaction(b, c, con, false)) {
                i++;
            }
        } catch (BookingException ex) {
        }

        // Zipcode not a number
        try {
            c = resetToValidCustomer();
            c.setZipcode("not a num");
            if (chatty.createNewBookingTransaction(b, c, con, false)) {
                i++;
            }
        } catch (BookingException ex) {
        }

        // Too long phone number
        try {
            c = resetToValidCustomer();
            c.setPhone("123456789987654321");
            if (chatty.createNewBookingTransaction(b, c, con, false)) {
                i++;
            }
        } catch (BookingException ex) {
        }

        // null-value in a string where SQL constriant is not null 
        try {
            c = resetToValidCustomer();
            c.setFirst_name(null);
            if (chatty.createNewBookingTransaction(b, c, con, false)) {
                i++;
            }
        } catch (BookingException ex) {
        }

        try {
            c = null;
            if (chatty.createNewBookingTransaction(b, c, con, false)) {
                i++;
            }
        } catch (BookingException ex) {
        }

        try {
            c = resetToValidCustomer();
            c.setZipcode("-500");
            if (chatty.createNewBookingTransaction(b, c, con, false)) {
                i++;
            }
        } catch (BookingException ex) {
        }

        c = resetToValidCustomer();
        b = resetToValidBooking(c);

        // Too high apartnumber
        try {
            b.setA_num(105);
            if (chatty.createNewBookingTransaction(b, c, con, false)) {
                i++;
            }
        } catch (BookingException ex) {
            i++;
        }

        // negative apartment number
        try {
            b = resetToValidBooking(c);
            b.setA_num(-1);
            if (chatty.createNewBookingTransaction(b, c, con, false)) {
                i++;
            }
        } catch (BookingException ex) {
        }

        // Date not in number
        try {
            b = resetToValidBooking(c);
            b.setDate_from("dette er en dato");
            if (chatty.createNewBookingTransaction(b, c, con, false)) {
                i++;
            }
        } catch (BookingException ex) {
        }

        // invalid date
        try {
            b = resetToValidBooking(c);
            b.setDate_from("99-99-99");
            if (chatty.createNewBookingTransaction(b, c, con, false)) {
                i++;
            }
        } catch (BookingException ex) {
        }

        // Too long travel agency
        try {
            b = resetToValidBooking(c);
            b.setTravel_agency("i am a travel agancy and you are all my scrum slaves");
            if (chatty.createNewBookingTransaction(b, c, con, false)) {
                i++;
            }
        } catch (BookingException ex) {
        }
        assertEquals(1, i);
    }

    /**
     * Test of updateBookingTransaction method, of class Chatty.
     */
    @Test
    public void testUpdateBookingTransaction() throws Exception {

    }

}
