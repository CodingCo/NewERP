package domain;

public class Apartment {

    //== Fields
    private final int a_num;
    private String type;

    /**
     *
     * @param a_num
     * @param type
     */
    public Apartment(int a_num, String type) {
        this.a_num = a_num;
        this.type = type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public int getANum() {
        return a_num;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Apartment{" + "a_num=" + a_num 
                + ", type=" + type + '}';
    }

}
