package domain;

public class Booking {

    //== Fields
    private int bookingID;
    private int apartmentID;
    private int customerID;
    private int numberOfNights;
    private int travelAgency;
    private int rent;

    //== Constructor
    public Booking(int bookingID, int apartmentID, int customerID, int numberOfNights, int travelAgency, int rent) {
        this.bookingID = bookingID;
        this.apartmentID = apartmentID;
        this.customerID = customerID;
        this.numberOfNights = numberOfNights;
        this.travelAgency = travelAgency;
        this.rent = rent;
    }

    //== Methods
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
