package domain;

public class Booking {

    private final int b_id;
    private Apartment apartment;
    private Customer customer;
    private int num_of_nights;
    private int travel_agency;
    private double rent;
    private final int version;

    /**
     * booking entity
     * 
     * @param b_id
     * @param apartment
     * @param customer
     * @param num_of_nights
     * @param travel_agency
     * @param rent
     * @param version
     */
    public Booking(int b_id, Apartment apartment, Customer customer, int num_of_nights, int travel_agency, int rent, int version) {
        this.b_id = b_id;
        this.apartment = apartment;
        this.customer = customer;
        this.num_of_nights = num_of_nights;
        this.travel_agency = travel_agency;
        this.rent = rent;
        this.version = version;
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

    public void setTravel_agency(int travel_agency) {
        this.travel_agency = travel_agency;
    }

    public void setRent(double rent) {
        this.rent = rent;
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

    public int getTravel_agency() {
        return travel_agency;
    }

    public double getRent() {
        return rent;
    }

    public int getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "Booking{" + "b_id=" + b_id + ", apartment=" + apartment + ", customer=" + customer + ", num_of_nights=" + num_of_nights + ", travel_agency=" + travel_agency + ", rent=" + rent + ", version=" + version + '}';
    }

}
