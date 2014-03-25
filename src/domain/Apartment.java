package domain;

public class Apartment {

    //== Fields
    private final int apartmentNumber;
    private String type;

    /**
     *
     * @param apartmentID
     * @param type
     */
    public Apartment(int apartmentID, String type) {
        this.apartmentNumber = apartmentID;
        this.type = type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public int getApartmentID() {
        return apartmentNumber;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Apartment{" + "apartmentID=" + apartmentNumber 
                + ", type=" + type + '}';
    }

}
