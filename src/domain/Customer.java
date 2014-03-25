package domain;

public class Customer {
    //== Fields
    private int customerID;
    private String name;
    private String familyName;
    private int age;
    private String eMail;
    private int phoneNum;
    private String country;
    private String city;
    private String street;
    private int zipCode;
    
    //== Constructor
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
    
    //== Methods
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
