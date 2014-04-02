package dataSource;

import domain.Apartment;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kasper
 */
public class ApartmentMapper {

    public ArrayList<Apartment> findAvailableApartment(String date, int days, String type, Connection con) {
        ArrayList<Apartment> aplist = new ArrayList();

        String SQLString = "select * "
                + "from apartment "
                + "where a_num not in(select a_num from booking "
                + "where (to_date(?) between (date_from) and date_from + number_of_nights) or "
                + "((to_date(?)+?) between (date_from) and (date_from +number_of_nights)) or "
                + "date_from between to_date(?) and (to_date(?)+?)) and type = ?";
        PreparedStatement statement = null;

        try {
            statement = con.prepareStatement(SQLString);

            statement.setString(1, date);
            statement.setString(2, date);
            statement.setInt(3, days);
            statement.setString(4, date);
            statement.setString(5, date);
            statement.setInt(6, days);
            statement.setString(7, type);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                aplist.add(new Apartment(rs.getInt(1), rs.getInt(3), rs.getString(2), rs.getInt(4)));
            }

        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }

        return aplist;
    }
}
