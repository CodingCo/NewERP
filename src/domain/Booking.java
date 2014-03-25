package domain;

public class Booking {

    
    private final int bookingID;
    private int apartmentID;
    private int customerID;
    private int numberOfNights;
    private int travelAgency;
    private int rent;

    /**
     * Booking entity
     * 
     * @param bookingID
     * @param apartmentID
     * @param customerID
     * @param numberOfNights
     * @param travelAgency
     * @param rent
     */
    public Booking(int bookingID, int apartmentID, int customerID, int numberOfNights, int travelAgency, int rent) {
        this.bookingID = bookingID;
        this.apartmentID = apartmentID;
        this.customerID = customerID;
        this.numberOfNights = numberOfNights;
        this.travelAgency = travelAgency;
        this.rent = rent;
    }

    public void setApartmentID(int apartmentID) {
        this.apartmentID = apartmentID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public void setTravelAgency(int travelAgency) {
        this.travelAgency = travelAgency;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }
    
    public int getBookingID() {
        return bookingID;
    }

    public int getApartmentID() {
        return apartmentID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public int getTravelAgency() {
        return travelAgency;
    }

    public int getRent() {
        return rent;
    }

    @Override
    public String toString() {
        return "Booking{" + "bookingID=" + bookingID
                + ", apartmentID=" + apartmentID
                + ", customerID=" + customerID
                + ", numberOfNights=" + numberOfNights
                + ", travelAgency=" + travelAgency
                + ", rent=" + rent + '}';
    }

}
