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
        String SQLString = "insert into customer values (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = null;
        String alterString = "ALTER SESSION SET NLS_DATE_FORMAT = 'DD-MM-YY'";

        if (!clist.isEmpty()) {
            String SQLID = "select customer_seq.NEXTVAL from dual";
            int id = 0;
            try {
                statement = con.prepareStatement(SQLID);
                ResultSet s = statement.executeQuery();
                while (s.next()) {
                    id = s.getInt(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {

                statement = con.prepareStatement(alterString);
                statement.execute();
                statement = con.prepareStatement(SQLString);
                for (Customer cust : clist) {
                    cust.setCust_id(id);
                    statement.setInt(1, cust.getCust_id());
                    statement.setString(2, cust.getName());
                    statement.setString(3, cust.getFamily_name());
                    statement.setInt(4, cust.getAge());
                    statement.setString(5, cust.getEmail());
                    statement.setString(6, cust.getPhone());
                    statement.setString(7, cust.getCountry());
                    statement.setString(8, cust.getCity());
                    statement.setInt(9, cust.getZipcode());
                    statement.setString(10, cust.getStreet());
                    statement.setInt(11, 0);
                    statement.executeUpdate();

                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            } finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    /**
     * Takes a list of costumers, and changes the relevant costumers in the
     * database.
     *
     * @param clist
     * @param con
     * @return
     */
    public boolean updateCustomers(ArrayList<Customer> clist, Connection con) {
        String SQLString = "update customer set first_name = ?,family_name = ?, age = ?, email = ?,phone = ?,country = ?, city = ?, zipcode = ? ,street = ? where cust_id = ? and version_num = ?";
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(SQLString);
            for (Customer cust : clist) {
                statement.setString(1, cust.getName());
                statement.setString(2, cust.getFamily_name());
                statement.setInt(3, cust.getAge());
                statement.setString(4, cust.getEmail());
                statement.setString(5, cust.getPhone());
                statement.setString(6, cust.getCountry());
                statement.setString(7, cust.getCity());
                statement.setInt(8, cust.getZipcode());
                statement.setString(9, cust.getStreet());
                statement.setInt(10, cust.getCust_id());
                statement.setInt(11, cust.getVersion());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    /**
     * Retrieves all customers in the database, as objects in an ArrayList.
     *
     * @param con
     * @return
     */
    public ArrayList<Customer> getAllCustomers(Connection con) {
        ArrayList<Customer> list = new ArrayList();
        String SQLString = "select * from customer";
        PreparedStatement statement = null;

        try {
            statement = con.prepareStatement(SQLString);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                list.add(new Customer(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(6),
                        rs.getString(5),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(10),
                        rs.getInt(9),
                        rs.getInt(11)));

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
