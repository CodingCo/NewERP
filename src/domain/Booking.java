package domain;

public class Booking implements Comparable {

    private int b_id;
    private int cust_id;
    private int a_num;
    private String date_from;
    private int num_of_nights;
    private String travel_agency;
    private int number_of_guests;
    private double price;
    private int version;
    private String first_name;
    private String last_name;
    private String phone;

    public Booking(int b_id, int cust_id, int a_num, String date_from, int num_of_nights, String travel_agency, int number_of_guests, double price, int version, String first_name, String last_name, String phone) {
        this.b_id = b_id;
        this.cust_id = cust_id;
        this.a_num = a_num;
        this.date_from = date_from;
        this.num_of_nights = num_of_nights;
        this.travel_agency = travel_agency;
        this.number_of_guests = number_of_guests;
        this.price = price;
        this.version = version;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
    }

    public Booking(int a_num, String date_from, int num_of_nights, String travel_agency, int number_of_guests, double price, String first_name, String last_name, String phone) {
        this.a_num = a_num;
        this.date_from = date_from;
        this.num_of_nights = num_of_nights;
        this.travel_agency = travel_agency;
        this.number_of_guests = number_of_guests;
        this.price = price;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
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

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPhone() {
        return phone;
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

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return b_id + ", " + first_name + ", Apartment " + a_num + ", Date " + date_from + ", Nights " + num_of_nights;
    }

    @Override
    public int compareTo(Object o) {

        Booking compareBooking = (Booking) o;
        String[] thisDate = this.getDate_from().split("-");
        int thisDay = Integer.parseInt(thisDate[0]);
        int thisMonth = Integer.parseInt(thisDate[1]);
        int thisYear = Integer.parseInt(thisDate[2]);

        String[] compareDate = compareBooking.getDate_from().split("-");
        int compareDay = Integer.parseInt(compareDate[0]);
        int compareMonth = Integer.parseInt(compareDate[1]);
        int compareYear = Integer.parseInt(compareDate[2]);

        if (thisYear > compareYear) {
            return 1;
        } else if (thisYear < compareYear) {
            return -1;
        } else {
            if (thisMonth > compareMonth) {
                return 1;
            } else if (thisMonth < compareMonth) {
                return -1;
            } else {
                if (thisDay > compareDay) {
                    return 1;
                } else if (thisDay < compareDay) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }
}
