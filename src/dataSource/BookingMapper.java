package dataSource;

import domain.Booking;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookingMapper {

    public ArrayList<Booking> getAllBookings(Connection con) {
        return null;
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
    
    public boolean checkRoomAvailability(Connection con){
	boolean avail = false;
	String SQLString = ""; // TODO Indsæt korrekt sql-sætning
	PreparedStatement st = null;
	
	try {
	    st = con.prepareStatement(SQLString);
	    
	    // TODO Set statement korrekt
	    
	    ResultSet rs = st.executeQuery();
	    
	    // TODO Håndter 'avail' returnerer det korrekte
	    
	} catch (Exception e){
	    e.printStackTrace();
	} finally {
	    try {
		st.close();
	    } catch (Exception e){
		e.printStackTrace();
	    }
	}
	return avail;
    }

}
