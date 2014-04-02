package dataSource;

import domain.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kasper
 */
public class CustomerMapper {

    public int insertNewCustomer(Customer customer, Connection con) {

        String insertCustomerSQL = "INSERT INTO CUSTOMER VALUES(?,?,?,?,?,?,?,?,?,0)";
        int rowsInserted = 0;
        PreparedStatement statement = null;

        String SQLID = "select customer_seq.NEXTVAL from dual";
        int id = 0;
        try {
            statement = con.prepareStatement(SQLID);
            ResultSet s = statement.executeQuery();
            while (s.next()) {
                id = s.getInt(1);
            }
        } catch (Exception e) {

        }

        try {

            statement = (PreparedStatement) con.prepareStatement(insertCustomerSQL);
            statement.setInt(1, id);
            statement.setString(2, customer.getFirst_name());
            statement.setString(3, customer.getLast_name());
            statement.setString(4, customer.getPhone());
            statement.setString(5, customer.getEmail());
            statement.setString(6, customer.getCountry());
            statement.setString(7, customer.getCity());
            statement.setString(8, customer.getZipcode());
            statement.setString(9, customer.getStreet());
            rowsInserted = statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try {
            statement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return id;
    }

}
