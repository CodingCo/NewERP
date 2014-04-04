package dataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GuestMapper {

    public GuestMapper() {
    }

    public ArrayList<Integer> getGuestIDs(int b_id, Connection con) {
        ArrayList<Integer> guest_ids = new ArrayList();

        String SQLString
                = "select guest_id "
                + "from guest "
                + "where b_id = " + b_id;

        PreparedStatement statement = null;

        try {
            statement = con.prepareStatement(SQLString);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                guest_ids.add(rs.getInt(2));
            }

        } catch (SQLException ex) {
            System.err.println("Fail in getGuestID");
            ex.printStackTrace();
        }

        return guest_ids;
    }

    public boolean insertGuest(int b_id, int apartment_nr, Connection con) {
        int rowsinserted = 0;

        String SQLString
                = "insert into guest "
                + "values (" + b_id + ", " + apartment_nr + " || guest_seq.NEXTVAL)";

        PreparedStatement statement = null;

        try {
            statement = con.prepareStatement(SQLString);
            rowsinserted = statement.executeUpdate();

        } catch (SQLException ex) {
            System.err.println("Fail in insertGuest");
            ex.printStackTrace();
        }

        return rowsinserted != 0;
    }
}
