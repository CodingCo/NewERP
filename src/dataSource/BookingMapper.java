package dataSource;

import domain.Booking;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookingMapper {

    
    public static void main(String[] args) {
        BookingMapper bm = new BookingMapper();
        DBConnector dcon = DBConnector.getInstance();
        Connection con = DBConnector.getConnection();
        ArrayList<Booking> al = bm.getAllBookings(con);
        
        for(Booking x: al){
            System.out.println(x);
        }
    }
    
    public ArrayList<Booking> getAllBookings(Connection con) {

        ArrayList<Booking> aB = new ArrayList();

        String SQLString = "SELECT booking.*, to_char(booking.DATE_FROM, 'DD-MM-YY'), customer.FIRST_NAME, customer.LAST_NAME, customer.PHONE "
                         + "FROM booking, customer "
                         + "WHERE booking.cust_id = customer.cust_id";
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            
            st = con.prepareStatement(SQLString);
            rs = st.executeQuery();
            
            
            while(rs.next()){
                aB.add(new Booking(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(10),rs.getInt(5),rs.getString(6),rs.getInt(7),rs.getDouble(8),rs.getInt(9),rs.getString(11),rs.getString(12),rs.getString(13)));
            }            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return aB;
    }

    public int insertNewBooking(Booking bo, int id, Connection con) {
        int rowsInserted = 0;
        String SQLString = "insert into booking values (booking_seq.NEXTVAL,?,?,?,?,?,?,?,0)";
        PreparedStatement st = null;

        try {
            st = con.prepareStatement(SQLString);
            st.setInt(1, id);
            st.setInt(2, bo.getA_num());
            st.setString(3, bo.getDate_from());
            st.setInt(4, bo.getNum_of_nights());
            st.setString(5, bo.getTravel_agency());
            st.setInt(6, bo.getNumber_of_guests());
            st.setDouble(7, bo.getPrice());
            rowsInserted = st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rowsInserted;
    }

    public int updateBooking(Booking b, Connection con) {

        int rowsIns = 0;
        String sQLString = "UPDATE BOOKING SET a_num = ?, date_from = ?, number_of_nights = ?, "
                + "travel_agency = ?, number_of_guests = ?, price = ?, version_num = (version_num + 1) "
                + "WHERE b_id = ? AND version_num = ?";
        PreparedStatement st = null;

        try {
            st = con.prepareStatement(sQLString);
            st.setInt(1, b.getA_num());
            st.setString(2, b.getDate_from());
            st.setInt(3, b.getNum_of_nights());
            st.setString(4, b.getTravel_agency());
            st.setInt(5, b.getNumber_of_guests());
            st.setDouble(6, b.getPrice());
            st.setInt(7, b.getB_id());
            st.setInt(8, b.getVersion());
            rowsIns = st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rowsIns;
    }

    public boolean checkRoomAvailability(Connection con) {
        boolean avail = false;
        String SQLString = ""; // TODO Indsæt korrekt sql-sætning
        PreparedStatement st = null;

        try {
            st = con.prepareStatement(SQLString);

            // TODO Set statement korrekt
            ResultSet rs = st.executeQuery();

            // TODO Håndter 'avail' returnerer det korrekte
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return avail;
    }

}
