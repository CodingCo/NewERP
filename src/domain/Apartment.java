package domain;

/**
 * Contains information about an apartment.
 *
 * @author kasper
 */
public class Apartment {

    private final int a_num;
    private final String type;
    private final int price;
    private final int capacity;

    public Apartment(int a_num, int price, String type, int capacity) {
        this.a_num = a_num;
        this.price = price;
        this.type = type;
        this.capacity = capacity;
    }

    public int getA_num() {
        return a_num;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Nr " + a_num + ": " + type + " room";
    }
}
