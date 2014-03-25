package domain;

public class Apartment {

    //== Fields
    private int apartmentID;
    private String type;

    //== Constructor
    public Apartment(int apartmentID, String type) {
        this.apartmentID = apartmentID;
        this.type = type;
    }

    //== Methods
    public int getApartmentID() {
        return apartmentID;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Apartment{" + "apartmentID=" + apartmentID 
                + ", type=" + type + '}';
    }

}
