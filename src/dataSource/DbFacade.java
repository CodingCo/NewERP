package dataSource;

import domain.Booking;
import domain.Customer;
import java.sql.Connection;

/**
 *
 * @author kasper
 */
public class DbFacade {

    //== Fields
    private UnitOfWorkProcess uow;
    private Connection con;

    //== Singleton Start
    private static DbFacade instance;

    
    
    private DbFacade() {
        uow = UnitOfWorkProcess.getInstance();
        con = DBConnector.getInstance().getConnection();
    }

    public static DbFacade getInstance() {
        if (instance == null) {
            instance = new DbFacade();
        }
        return instance;
    }

    public void addNewBooking(Booking booking) {

    }

    public void updateBooking(Booking booking) {

    }

    public void deleteBooking(Booking booking) {

    }

    public void addNewCustomer(Customer customer) {

    }

    public void updateCustomer(Customer customer) {

    }

    public void deleteCustomer(Customer customer) {

    }
}
