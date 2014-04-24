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
public class StreetAddressException extends Exception {
       public StreetAddressException() {
    }

    public StreetAddressException(String message) {
        super(message);
    }
}
