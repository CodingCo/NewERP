package dataSource;

import domain.Apartment;
import domain.Booking;
import domain.Customer;
import java.sql.Connection;
import java.util.ArrayList;

public class DbFacade {

    private Chatty uow;
    private Connection con;
    private static DbFacade instance;

    private DbFacade() {
        this.uow = new Chatty();
        con = DBConnector.getInstance().getConnection();
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

    public boolean updateBooking(Booking booking) {
//        boolean status = false;
//        if (this.uow != null) {
//            status = this.uow.registerDirtyBooking(booking);
//        }
        return true;
    }

    public boolean deleteBooking(int b_id) {
        boolean status = false;
//        if (this.uow != null) {
//            status = this.uow.registerDeletedBooking(getBooking(b_id));
//        }
        return status;
    }

    private boolean newCustomer(Customer customer) {
        boolean status = false;
//        if (uow != null) {
//            this.uow.registerNewCustomer(customer);
//        }
        return status;
    }

    public boolean updateCustomer(Customer customer) {
        boolean status = false;
//        if (this.uow != null) {
//            status = this.uow.registerDirtyCustomer(customer);
//        }
        return status;
    }

    public Apartment findAvailableApartment(String date, int days, String type) {
        if (uow != null) {
            return this.uow.findAvailableApartment(date, days, type, con);
        }
        return null;
    }

    public ArrayList<Booking> findBookingsByParams(int bookingNr, String name, String date, int roomNr) {
//        if (this.uow != null) {
//            return this.uow.findBookingsByParams(bookingNr, name, date, roomNr);
//        }
        return null;
    }

    public void startNewBusinessTransaction() {
        //this.uow = new UnitOfWorkProcess();
    }

    public boolean commitBusinessTransaction() {
        //boolean status = this.uow.commit(con);
        return false;
    }

    public boolean loadBookings() {
        boolean status = false;
//        if (this.con != null) {
//            status = this.uow.loadBookings(con);
//        }
        return status;
    }

    public boolean loadCustomers() {
        boolean status = false;
//        if (this.con != null) {
//            status = this.uow.loadCustomers(con);
//        }
        return status;
    }

    public boolean loadApartments() {
        boolean status = false;
//        if (this.con != null) {
//            status = this.uow.loadApartments(con);
//        }
        return status;
    }

    public boolean loadMerger() {
        int errorCount = 0;
//        ArrayList<Booking> b = this.uow.getBooking();
//        ArrayList<Apartment> a = this.uow.getApartment();
//        ArrayList<Customer> c = this.uow.getCustomer();
//        for (Booking x : b) {
//            int anum = x.getApartment().getA_num();
//            x.setApartment(a.get(anum - 1));
//            int custid = x.getCustomer().getCust_id();
//            for (int y = 0; y < c.size(); ++y) {
//                if (c.get(y).getCust_id() == custid) {
//                    x.setCustomer(c.get(y));
//                    break;
//                } else if (y == c.size() - 1) {
//                    errorCount++;
//                }
//            }
//        }
        return errorCount == 0;
    }

    public Booking getBooking(int b_id) {
//        ArrayList<Booking> list = this.uow.getBooking();
//        for (Booking x : list) {
//            if (x.getB_id() == b_id) {
//                return x;
//            }
//        }
        return null;
    }

}
