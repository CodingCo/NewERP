package domain;

public class Apartment {

    private final int a_num;
    private final int cost;
    private final String type;

    public Apartment(int a_num, int cost, String type) {
        this.a_num = a_num;
        this.cost = cost;
        this.type = type;
    }

    public int getA_num() {
        return a_num;
    }

    public int getCost() {
        return cost;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Number: " + a_num + "    " + " Type: " + type;
    }

}
