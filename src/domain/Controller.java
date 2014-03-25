package domain;

public class Controller {

    //== Fields
    private static Controller instance;

    //== Constructor
    private Controller() {
    }

    //== Methods
    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }

        return instance;
    }

    
<<<<<<< HEAD
    public Booking addNewBooking(){
        return null;
    }
    
    public Booking updateBooking(){
        return null;
    }
    
    public boolean deleteBooking(){
        return true;
    }
    
    public Customer addNewCustomer(){
        return null;
    }
    
    public Customer updateCustomer(){
        return null;
    }
    
    public Customer deleteCustomer(){
        return null;
    }
    
    public boolean saveTransaction(){
        return true;
    }
    
    public void resetTransaction(){
    
    }
    
    public Booking getBooking(){
    return null;
    }
=======
    
    // JEg har en stor pikkermand
    
>>>>>>> FETCH_HEAD
    
}
