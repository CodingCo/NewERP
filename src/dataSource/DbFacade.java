package dataSource;

import domain.Apartment;
import domain.Booking;
import domain.Customer;
import java.sql.Connection;
import java.util.ArrayList;

public class DbFacade {

    private UnitOfWorkProcess uow;
    private Connection con;
    private static DbFacade instance;

    private DbFacade() {
        this.con = DBConnector.getInstance().getConnection();
        this.uow = new UnitOfWorkProcess();
    }

    public static DbFacade getInstance() {
        if (instance == null) {
            instance = new DbFacade();
        }
        return instance;
    }

    public boolean addNewBooking(Booking booking) {
        boolean status = false;
        if (uow != null) {
            newCustomer(booking.getCustomer());
            status = uow.registerNewBooking(booking);
        }
        System.out.println(status);
        return status;
    }

    private boolean newCustomer(Customer customer) {
        boolean status = false;
        if (uow != null) {
            this.uow.registerNewCustomer(customer);
        }
        return status;
    }

    public Apartment findAvailableApartment(String date, int days, String type) {
        if (uow != null) {
            return this.uow.findAvalibleApartment(date, days, type, con);
        }
        return null;
    }

    public void startNewBusinessTransaction() {
        this.uow = new UnitOfWorkProcess();
    }

    public boolean commitBusinessTransaction() {
        boolean status = false;
        status = this.uow.commit(con);
        return status;
    }

}
