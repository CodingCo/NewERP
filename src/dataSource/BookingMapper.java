package dataSource;

import domain.Booking;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookingMapper {

    public BookingMapper() {
    }

    //== Methods
    public ArrayList<Booking> getAllBookings(Connection con) {
        ArrayList<Booking> list = new ArrayList();

        String SQLString1 = "select * from bookings";
        String SQLString2 = "select * from customer where cust_id = ?";
        String SQLString3 = "select * from apartment where a_num = ?";

        PreparedStatement statement1 = null;
        PreparedStatement statement2 = null;
        PreparedStatement statement3 = null;

        try {
            statement1 = con.prepareStatement(SQLString1); // Use this to get information from "booking" table
            ResultSet rs1 = statement1.executeQuery();

            statement2 = con.prepareStatement(SQLString2); // Use this to get information from "customer" table
            ResultSet rs2 = statement2.executeQuery();

            statement3 = con.prepareStatement(SQLString3); // Use this to get information from "apartment" table
            ResultSet rs3 = statement3.executeQuery();

            while (rs1.next()) { // The constructor for a booking takes a whole Apartment object and Customer, so you need to create them inside the constructor of the 
//		list.add(new Booking(
//                        rs1.getInt(1),
//			rs1.getString(2),
//			rs1.getString(3),
//			rs1.getInt(4),
//			rs1.getString(6),
//			rs1.getString(5),
//			rs1.getString(7),
//			rs1.getString(8),
//			rs1.getString(10),
//			rs1.getInt(9),
//			rs1.getInt(11)));

            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                statement1.close();
                statement2.close();
                statement3.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return list;
    }

    /**
     * Takes a list of bookings, and inserts them into the database.
     *
     * @param blist
     * @param con
     * @return boolean
     */
    public boolean insertBookings(ArrayList<Booking> blist, Connection con) {

        String SQLString = "insert into bookings values (booking_seq.NEXTVAL,?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = null;

        if (!blist.isEmpty()) {
            try {
                for (Booking book : blist) {
                    statement = con.prepareStatement(SQLString);
                    statement.setInt(1, book.getCustomer().getCust_id());
                    statement.setInt(2, book.getApartment().getA_num());
                    statement.setString(3, book.getDate());
                    statement.setInt(4, book.getNum_of_nights());
                    statement.setString(5, book.getTravel_agency());
                    statement.setDouble(6, book.getRent());
                    statement.setInt(7, 0);
                    statement.executeUpdate();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            } finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    /**
     * Takes a list of customer, and updates the database with the relevant
     * customers
     *
     * @param blist
     * @param con
     * @return boolean
     */
    public boolean updateBookings(ArrayList<Booking> blist, Connection con) {
        String SQLString = "update bookings set date_from = ?, "
                + "num_of_nights = ?, "
                + "travel_agency = ?, "
                + "rent = ?, "
                + "version_num = ?,"
                + " where b_id = ?";
        PreparedStatement statement = null;

        try {
            for (Booking booking : blist) {
                statement = con.prepareStatement(SQLString);
                statement.setString(1, booking.getDate());
                statement.setInt(2, booking.getNum_of_nights());
                statement.setString(3, booking.getTravel_agency());
                statement.setDouble(4, booking.getRent());
                statement.setInt(5, booking.getVersion());
                statement.setInt(6, booking.getB_id());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    /**
     * Takes a list of bookings, and deletes them from the database.
     *
     * @param blist
     * @param con
     * @return boolean
     */
    public boolean deleteBookings(ArrayList<Booking> blist, Connection con) {
        String SQLString = "delete from bookings where b_id = ?";
        PreparedStatement statement = null;

        try {
            for (Booking booking : blist) {
                statement = con.prepareStatement(SQLString);
                statement.setInt(1, booking.getB_id());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return true;
    }
}
