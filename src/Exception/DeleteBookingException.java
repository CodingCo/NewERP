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
