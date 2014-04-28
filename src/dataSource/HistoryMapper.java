package dataSource;

import domain.History;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author kasper
 */
public class HistoryMapper {

    /**
     * Retrieves a list containing all archived bookings.
     * @param con
     * @return
     * @author kasper
     */
    public ArrayList<History> getAllBookings(Connection con) {
        ArrayList<History> historyList = new ArrayList();
        String SQLString = "SELECT history.*, to_char(history.DATE_FROM, 'DD-MM-YY'), customer.FIRST_NAME, customer.LAST_NAME, customer.PHONE "
                + "FROM history, customer "
                + "WHERE history.cust_id = customer.cust_id";

        PreparedStatement st = null;

        try {
            st = con.prepareStatement(SQLString);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                historyList.add(new History(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(9), rs.getInt(5), rs.getString(6), rs.getInt(7), rs.getDouble(8), rs.getString(10), rs.getString(11), rs.getString(12)));
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
        return historyList;
    }
}
