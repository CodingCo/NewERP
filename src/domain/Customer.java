package domain;

public class Customer {

    private int cust_id;
    private String first_name;
    private String last_name;
    private String phone;
    private String email;
    private String country;
    private String city;
    private long zipcode;
    private String street;
    private int version;

    public Customer(int cust_id, String first_name, String last_name, String phone, String email, String country, String city, long zipcode, String street, int version) {
	this.cust_id = cust_id;
	this.first_name = first_name;
	this.last_name = last_name;
	this.phone = phone;
	this.email = email;
	this.country = country;
	this.city = city;
	this.zipcode = zipcode;
	this.street = street;
	this.version = version;
    }

    public Customer(String first_name, String last_name, String phone, String email, String country, String city, long zipcode, String street) {
	this.first_name = first_name;
	this.last_name = last_name;
	this.phone = phone;
	this.email = email;
	this.country = country;
	this.city = city;
	this.zipcode = zipcode;
	this.street = street;
    }
    
    public void setCust_id(int cust_id) {
	this.cust_id = cust_id;
    }

    public void setFirst_name(String first_name) {
	this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
	this.last_name = last_name;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public void setCountry(String country) {
	this.country = country;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public void setZipcode(long zipcode) {
	this.zipcode = zipcode;
    }

    public void setStreet(String street) {
	this.street = street;
    }

    public void setVersion(int version) {
	this.version = version;
    }

    public int getCust_id() {
	return cust_id;
    }

    public String getFirst_name() {
	return first_name;
    }

    public String getLast_name() {
	return last_name;
    }

    public String getPhone() {
	return phone;
    }

    public String getEmail() {
	return email;
    }

    public String getCountry() {
	return country;
    }

    public String getCity() {
	return city;
    }

    public long getZipcode() {
	return zipcode;
    }

    public String getStreet() {
	return street;
    }

    public int getVersion() {
	return version;
    }

    @Override
    public String toString() {
	return cust_id + ": " + first_name + " " + last_name;
    }

}
