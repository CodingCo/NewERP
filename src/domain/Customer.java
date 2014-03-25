package domain;

public class Customer {
    //== Fields
    private final int customerID;
    private String name;
    private String familyName;
    private int age;
    private String eMail;
    private int phoneNum;
    private String country;
    private String city;
    private String street;
    private int zipCode;
    
    /**
     *  Customer entity 
     * 
     * @param customerID
     * @param name
     * @param familyName
     * @param age
     * @param eMail
     * @param phoneNum
     * @param country
     * @param city
     * @param street
     * @param zipCode
     */
    public Customer(int customerID, String name, String familyName, int age, String eMail, int phoneNum, String country, String city, String street, int zipCode){
        this.customerID = customerID;
        this.name = name;
        this.familyName = familyName;
        this.age = age;
        this.eMail = eMail;
        this.phoneNum = phoneNum;
        this.country = country;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
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
        this.zipCode = zipCode;
    }
    
    public int getCustomerID(){
        return customerID;
    }
    public String getName(){
        return name;
    }
    public String getFamilyName(){
        return familyName;
    }
    public int getAge(){
        return age;
    }
    public String getEMail(){
        return eMail;
    }
    public int getPhoneNum(){
        return phoneNum;
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
    public int getZipCode(){
        return zipCode;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerID=" + customerID 
                + ", name=" + name 
                + ", familyName=" + familyName 
                + ", age=" + age 
                + ", eMail=" + eMail 
                + ", phoneNum=" + phoneNum 
                + ", country=" + country 
                + ", city=" + city 
                + ", street=" + street 
                + ", zipCode=" + zipCode + '}';
    }

    
    
    
    
}
