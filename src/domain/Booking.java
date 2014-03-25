package domain;

public class Booking {

    
    private final int b_id;
    private int a_num;
    private int cust_id;
    private int num_of_nights;
    private int travel_agency;
    private double rent;

    /**
     * Booking entity
     * 
     * @param b_id
     * @param a_num
     * @param cust_id
     * @param num_of_nights
     * @param travel_agency
     * @param rent
     */
    public Booking(int b_id, int a_num, int cust_id, int num_of_nights, int travel_agency, int rent) {
        this.b_id = b_id;
        this.a_num = a_num;
        this.cust_id = cust_id;
        this.num_of_nights = num_of_nights;
        this.travel_agency = travel_agency;
        this.rent = rent;
    }

    public void setApartmentID(int apartmentID) {
        this.a_num = apartmentID;
    }

    public void setCustomerID(int customerID) {
        this.cust_id = customerID;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.num_of_nights = numberOfNights;
    }

    public void setTravelAgency(int travelAgency) {
        this.travel_agency = travelAgency;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }
    
    public int getBookingID() {
        return b_id;
    }

    public int getApartmentID() {
        return a_num;
    }

    public int getCustomerID() {
        return cust_id;
    }

    public int getNumberOfNights() {
        return num_of_nights;
    }

    public int getTravelAgency() {
        return travel_agency;
    }

    public double getRent() {
        return rent;
    }

    @Override
    public String toString() {
        return "Booking{" + "bookingID=" + b_id
                + ", apartmentID=" + a_num
                + ", customerID=" + cust_id
                + ", numberOfNights=" + num_of_nights
                + ", travelAgency=" + travel_agency
                + ", rent=" + rent + '}';
    }

}
