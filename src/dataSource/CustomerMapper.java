package dataSource;

import domain.Customer;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author kasper
 */
public class CustomerMapper {

    public CustomerMapper() {

    }

    public boolean insertCustomer(ArrayList<Customer> clist, Connection con) {
        return true;
    }

    public boolean updateCustomer(ArrayList<Customer> clist, Connection con) {
        return true;
    }

    public ArrayList<Customer> getAllCustomers(Connection con) {
        return null;
    }
}
