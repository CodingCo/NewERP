package dataSource;

import domain.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author kasper
 */
public class CustomerMapper {

    public boolean insertCustomers(ArrayList<Customer> clist, Connection con) {
        return true;
    }

    public boolean updateCustomers(ArrayList<Customer> clist, Connection con) {
        return true;
    }

    public ArrayList<Customer> getAllCustomers(Connection con) {
        return null;
    }
}
