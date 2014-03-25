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

}
