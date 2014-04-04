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

    public ArrayList<Apartment> findAvailableApartment(String date, int days, String type, int apartment_nr, Connection con) {
        ArrayList<Apartment> aplist = new ArrayList();

        String SQLString = "select * "
                + "from apartment "
                + "where a_num not in(select a_num from booking "
                + "where (to_date(?) between (date_from) and date_from + number_of_nights) or "
                + "((to_date(?)+?) between (date_from) and (date_from +number_of_nights)) or "
                + "date_from between to_date(?) and (to_date(?)+?)) and type = ?";

        String withNr = "select * from apartment where a_num not in (select a_num from booking where (to_date(?)  between (date_from) and date_from + number_of_nights) or ((to_date(?)+?) between (date_from) and (date_from +number_of_nights)) or date_from  between to_date(?) and (to_date(?)+?)) and a_num = ?";
        String SQL2 = "ALTER SESSION SET NLS_DATE_FORMAT = 'DD-MM-YY'";

        PreparedStatement statement = null;

        if (apartment_nr != 0) {
            SQLString = withNr;
        }

        try {
            statement = con.prepareStatement(SQL2);
            statement.executeQuery();
        } catch (Exception d) {
        }

        try {
            statement = con.prepareStatement(SQLString);
            statement.setString(1, date);
            statement.setString(2, date);
            statement.setInt(3, days);
            statement.setString(4, date);
            statement.setString(5, date);
            statement.setInt(6, days);

            if (apartment_nr != 0) {
                statement.setInt(7, apartment_nr);
            } else {
                statement.setString(7, type);
            }
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

    public boolean checkAvailAbleApartment(String date, int days, int a_num, Connection con) {
        boolean status = false;
        days = days - 1;
        String SQL = "select a_num from apartment where a_num not in (select a_num from booking where (to_date(?)  between (date_from) and date_from + number_of_nights) or ((to_date(?)+?) between (date_from) and (date_from +number_of_nights)) or date_from  between to_date(?) and (to_date(?)+?)) and a_num = ?";
        String SQL2 = "ALTER SESSION SET NLS_DATE_FORMAT = 'DD-MM-YY'";
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(SQL2);
            statement.executeQuery();
        } catch (Exception d) {

        }
        try {
            statement = con.prepareStatement(SQL);
            statement.setString(1, date);
            statement.setString(2, date);
            statement.setInt(3, days);
            statement.setString(4, date);
            statement.setString(5, date);
            statement.setInt(6, days);
            statement.setInt(7, a_num);

            ResultSet st = statement.executeQuery();

            if (st.next()) {
                status = st.getInt(1) == a_num;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return status;
    }
}
