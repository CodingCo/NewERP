package domain;

/**
 *
 * @author kasper
 */
public class History extends Booking {

    public History(int b_id, int cust_id, int a_num, String date_from, int num_of_nights, String travel_agency, int number_of_guests, double price, int version, String first_name, String last_name, String phone) {
        super(b_id, cust_id, a_num, date_from, num_of_nights, travel_agency, number_of_guests, price, version, first_name, last_name, phone);
    }
}
