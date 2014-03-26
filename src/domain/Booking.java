package domain;

public class Booking {

    private int b_id;
    private Apartment apartment;
    private Customer customer;
    private int num_of_nights;
    private String date;
    private String travel_agency;
    private double rent;
    private final int version;

    public Booking(int b_id, Apartment apartment, Customer customer, int num_of_nights, String date, String travel_agency, double rent, int version) {
        this.apartment = apartment;
        this.customer = customer;
        this.num_of_nights = num_of_nights;
        this.date = date;
        this.travel_agency = travel_agency;
        this.rent = rent;
        this.version = version;
        this.b_id = b_id;
    }

    public Booking(Apartment apartment, Customer customer, int num_of_nights, String date, String travel_agency, double rent) {
        this.apartment = apartment;
        this.customer = customer;
        this.num_of_nights = num_of_nights;
        this.travel_agency = travel_agency;
        this.rent = rent;
        this.version = 0;
    }

    public int getB_id() {
        return b_id;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getNum_of_nights() {
        return num_of_nights;
    }

    public String getDate() {
        return date;
    }

    public String getTravel_agency() {
        return travel_agency;
    }

    public double getRent() {
        return rent;
    }

    public int getVersion() {
        return version;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setNum_of_nights(int num_of_nights) {
        this.num_of_nights = num_of_nights;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTravel_agency(String travel_agency) {
        this.travel_agency = travel_agency;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    @Override
    public String toString() {
        return "Booking{" + "b_id=" + b_id
                + ", apartment=" + apartment
                + ", customer=" + customer
                + ", num_of_nights=" + num_of_nights
                + ", travel_agency=" + travel_agency
                + ", rent=" + rent
                + ", version=" + version + '}';
    }

}
