package domain;

public class Customer {
    //== Fields
    private final int cust_id;
    private String name;
    private String family_name;
    private int age;
    private String email;
    private int phone;
    private String country;
    private String city;
    private String street;
    private int zipcode;
    
    /**
     *  Customer entity 
     * 
     * @param cust_id
     * @param name
     * @param family_name
     * @param age
     * @param email
     * @param phone
     * @param country
     * @param city
     * @param street
     * @param zipcode
     */
    public Customer(int cust_id, String name, String family_name, int age, String email, int phone, String country, String city, String street, int zipcode){
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
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFamilyName(String familyName) {
        this.family_name = familyName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void seteMail(String eMail) {
        this.email = eMail;
    }

    public void setPhoneNum(int phoneNum) {
        this.phone = phoneNum;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setZipCode(int zipCode) {
        this.zipcode = zipCode;
    }
    
    public int getCustID(){
        return cust_id;
    }
    public String getName(){
        return name;
    }
    public String getFamilyName(){
        return family_name;
    }
    public int getAge(){
        return age;
    }
    public String getEmail(){
        return email;
    }
    public int getPhoneNum(){
        return phone;
    }
    public String getCountry(){
        return country;
    }
    public String getCity(){
        return city;
    }
    public String getStreet(){
        return street;
    }
    public int getZipcode(){
        return zipcode;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerID=" + cust_id 
                + ", name=" + name 
                + ", familyName=" + family_name 
                + ", age=" + age 
                + ", eMail=" + email 
                + ", phoneNum=" + phone 
                + ", country=" + country 
                + ", city=" + city 
                + ", street=" + street 
                + ", zipCode=" + zipcode + '}';
    }

    
    
    
    
}
