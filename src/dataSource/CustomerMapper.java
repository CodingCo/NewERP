package dataSource;

import domain.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author kasper
 */
public class CustomerMapper {

    public int insertNewCustomer(Customer customer, Connection con) {

        String insertCustomerSQL = "INSERT INTO CUSTOMER VALUES(customer_seq.NEXTVAL,?,?,?,?,?,?,?,?,0)";
        int rowsInserted = 0;
        PreparedStatement statement = null;

        try {

            statement = (PreparedStatement) con.prepareStatement(insertCustomerSQL);
            statement.setString(1, customer.getFirst_name());
            statement.setString(2, customer.getLast_name());
            statement.setString(3, customer.getPhone());
            statement.setString(4, customer.getEmail());
            statement.setString(5, customer.getCountry());
            statement.setString(6, customer.getCity());
            statement.setString(7, customer.getZipcode());
            statement.setString(8, customer.getStreet());
            rowsInserted = statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try {
            statement.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return rowsInserted;
    }

}
