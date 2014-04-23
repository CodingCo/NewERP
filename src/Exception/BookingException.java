package Exception;

/**
 *
 * @author Robert
 */
public class BookingException extends Exception{
        public BookingException() {
    }

    public BookingException(String string) {
        super(string);
    }

    public BookingException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public BookingException(Throwable thrwbl) {
        super(thrwbl);
    }

    public String getMessage() {
        return super.getMessage();
    }
}
