package Exception;

/**
 *
 * @author Robert
 */
public class UpdateBookingException extends Exception {

    public UpdateBookingException() {
    }

    public UpdateBookingException(String string) {
        super(string);
    }

    public UpdateBookingException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public UpdateBookingException(Throwable thrwbl) {
        super(thrwbl);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

}
