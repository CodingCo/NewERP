package domain;

public class Customer {

    //== Fields
    private int cust_id;
    private String name;
    private String family_name;
    private int age;
    private String email;
    private String phone;
    private String country;
    private String city;
    private String street;
    private int zipcode;
    private int version;

    public Customer(int cust_id, String name, String family_name, int age, String email, String phone, String country, String city, String street, int zipcode, int version) {
        this.cust_id = cust_id;
        this.name = name;
        this.family_name = family_name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.country = country;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
        this.version = version;
    }

    public Customer(String name, String family_name, int age, String email, String phone, String country, String city, String street, int zipcode) {
        this.name = name;
        this.family_name = family_name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.country = country;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
        this.version = 0;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }

    public int getCust_id() {
        return cust_id;
    }

    public String getName() {
        return name;
    }

    public String getFamily_name() {
        return family_name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getZipcode() {
        return zipcode;
    }

    public int getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "Customer{" + "cust_id=" + cust_id + ", name=" + name + ", family_name=" + family_name + ", age=" + age + ", email=" + email + ", phone=" + phone + ", country=" + country + ", city=" + city + ", street=" + street + ", zipcode=" + zipcode + ", version=" + version + '}';
    }

}
