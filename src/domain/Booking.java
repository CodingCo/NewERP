package domain;

public class Booking {

    private int b_id;
    private int cust_id;
    private int a_num;
    private String date_from;
    private int num_of_nights;
    private String travel_agency;
    private int number_of_guests;
    private double price;
    private int version;

    public Booking(int b_id, int cust_id, int a_num, String date_from, int num_of_nights, String travel_agency, int number_of_guests, double price, int version) {
	this.b_id = b_id;
	this.cust_id = cust_id;
	this.a_num = a_num;
	this.date_from = date_from;
	this.num_of_nights = num_of_nights;
	this.travel_agency = travel_agency;
	this.number_of_guests = number_of_guests;
	this.price = price;
	this.version = version;
    }

    public Booking(int cust_id, int a_num, String date_from, int num_of_nights, String travel_agency, int number_of_guests, double price) {
	this.cust_id = cust_id;
	this.a_num = a_num;
	this.date_from = date_from;
	this.num_of_nights = num_of_nights;
	this.travel_agency = travel_agency;
	this.number_of_guests = number_of_guests;
	this.price = price;
    }

    public void setB_id(int b_id) {
	this.b_id = b_id;
    }

    public void setCust_id(int cust_id) {
	this.cust_id = cust_id;
    }

    public void setA_num(int a_num) {
	this.a_num = a_num;
    }

    public void setDate_from(String date_from) {
	this.date_from = date_from;
    }

    public void setNum_of_nights(int num_of_nights) {
	this.num_of_nights = num_of_nights;
    }

    public void setTravel_agency(String travel_agency) {
	this.travel_agency = travel_agency;
    }

    public void setNumber_of_guests(int number_of_guests) {
	this.number_of_guests = number_of_guests;
    }

    public void setPrice(double price) {
	this.price = price;
    }

    public void setVersion(int version) {
	this.version = version;
    }

    public int getB_id() {
	return b_id;
    }

    public int getCust_id() {
	return cust_id;
    }

    public int getA_num() {
	return a_num;
    }

    public String getDate_from() {
	return date_from;
    }

    public int getNum_of_nights() {
	return num_of_nights;
    }

    public String getTravel_agency() {
	return travel_agency;
    }

    public int getNumber_of_guests() {
	return number_of_guests;
    }

    public double getPrice() {
	return price;
    }

    public int getVersion() {
	return version;
    }

    @Override
    public String toString() {
	return b_id + ": " + cust_id + " in room " + a_num;
    }

}
