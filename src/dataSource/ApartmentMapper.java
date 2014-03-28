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

    public Apartment findAvailableApartment(String date, int days, String type, Connection con) {
        Apartment ap = null;

        String SQLString = "select * "
                + "from apartment "
                + "where a_num not in (select a_num from bookings "
                + "where (to_date(?) between (date_from) and date_from + number_of_nights) or "
                + "((to_date(?)+?) between (date_from) and (date_from + number_of_nights)) or "
                + "date_from between to_date(?) and (to_date(?)+?)) and type = ? and rownum <= 1";
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
            ResultSet rs1 = statement.executeQuery();

            while (rs1.next()) {
                int s = rs1.getInt(1);
                String t = rs1.getString(2);
                System.out.println(s);
                System.out.println(t);
                ap = new Apartment(s, 0, t);
            }

//	    if (rs1.next()){
//		String SQLString2 = "select * from apartment_type where type = ?";
//		statement = con.prepareStatement(SQLString2);
//		statement.setString(1, rs1.getString(2));
//		ResultSet rs2 = statement.executeQuery();
//		
//		ap = new Apartment(rs1.getInt(1), rs2.getInt(2), rs1.getString(2));
//	    }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return ap;
    }

    public ArrayList<Apartment> getAllApartments(Connection con) {
        ArrayList<Apartment> list = new ArrayList();
        String SQLString1 = "select * from apartment";
        PreparedStatement statement = null;

        try {
            statement = con.prepareStatement(SQLString1);
            ResultSet rs1 = statement.executeQuery();

            while (rs1.next()) {
                String SQLString2 = "select * from apartment_type where type = ?";
                statement = con.prepareStatement(SQLString2);
                statement.setString(1, rs1.getString(2));
                ResultSet rs2 = statement.executeQuery();
                    rs2.next();
                
                list.add(new Apartment(rs1.getInt(1), rs2.getInt(2), rs1.getString(2)));
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
        return list;
    }

}
