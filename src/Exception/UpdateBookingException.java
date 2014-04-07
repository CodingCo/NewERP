/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    public String getMessage() {
        return super.getMessage();
    }

}
