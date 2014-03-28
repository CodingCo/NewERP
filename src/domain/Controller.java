package domain;

import dataSource.DbFacade;
import java.util.ArrayList;

public class Controller {

    private DbFacade facade;

    public Controller() {
        this.facade = DbFacade.getInstance();
    }

    public boolean addNewBooking(Customer cust, Apartment a, int num_of_nights, String date, String travel_agency, double rent) {
        boolean status = false;
        System.out.println(date);
        Booking booking = new Booking(a, cust, num_of_nights, date, travel_agency, rent);
        status = this.facade.addNewBooking(booking);
        return status;
    }

    public Customer addNewCustomer(String name, String family_name, int age, String email, String phone, String country, String city, String street, int zipcode) {
        return new Customer(name, family_name, age, email, phone, country, city, street, zipcode);
    }

    public int saveTransaction() {
        this.facade.commitBusinessTransaction();
        return 1;
    }

    public Apartment findAvailableApartment(String date, int days, String type) {
        if (this.facade != null) {
            return this.facade.findAvailableApartment(date, days, type);
        }
        return null;
    }
}
