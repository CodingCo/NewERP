package errorHandling;

/**
 *
 * @author Robert
 */
public class StreetAddressException extends Exception {
       public StreetAddressException() {
    }

    public StreetAddressException(String message) {
        super(message);
    }
}
