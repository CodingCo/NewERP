package Exception;

/**
 *
 * @author Robert
 */
public class DeleteBookingException extends Exception{
        public DeleteBookingException() {
    }

    public DeleteBookingException(String string) {
        super(string);
    }

    public DeleteBookingException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public DeleteBookingException(Throwable thrwbl) {
        super(thrwbl);
    }

    public String getMessage() {
        return super.getMessage();
    }
}
