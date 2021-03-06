package presentation;

import errorHandling.PhoneException;
import errorHandling.BookingException;
import errorHandling.DateException;
import errorHandling.EmailException;
import errorHandling.NameException;
import errorHandling.RoomException;
import errorHandling.StreetAddressException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author simon & Robert
 */
public class InputCheck {

    /**
     * Checks that email param doesn't violate standard email format
     *
     * @param email
     * @throws EmailException
     * @author Simon
     */
    public static void emailCheck(String email) throws EmailException {

        if (email.trim().length() == 0) {
            throw new EmailException("Must enter an email address - no charecters entered ");
        }

        if (!email.contains("@")) {
            throw new EmailException("must enter a valid email - no @");
        }

        if (!email.contains(".")) {
            throw new EmailException("must enter a valid email - no \".\" ");
        }

        int tmp = 0;
        for (char c : email.toCharArray()) {
            if (c == '@') {
                tmp = 1;
            }
            if (c == '.') {
                tmp = 2;
            }
        }
        if (tmp == 1) {
            throw new EmailException("wrong order @ must be before .");
        }

        if (email.length() < 5) {
            throw new EmailException("The email must be a full email");
        }

        if (email.contains("@@")) {
            throw new EmailException("no @@ allowed");
        }

        if (email.contains("..")) {
            throw new EmailException("no .. allowed");

        }

        String sb = email.substring(email.indexOf("@") + 1);
        if (sb.indexOf(".") == 0) {
            throw new EmailException("Invalid domain name");
        }

    }

    /**
     * Checks for name violations on String name
     *
     * @param name
     * @throws NameException
     * @author Simon
     */
    public static void nameCheck(String name) throws NameException {

        if (name.isEmpty()) {
            throw new NameException("No name entered - try with John");
        }

        if (name.trim().matches("[0-9]+")) {
            throw new NameException("must type in a real name");
        }

        if (name.length() < 1) {
            throw new NameException("Name must be longer than one character");
        }

    }

    /**
     * Checks for location violations on String name
     *
     * @param name
     * @throws NameException
     * @author Simon
     */
    public static void custInfoCheck(String name) throws NameException {

        if (name.isEmpty()) {
            throw new NameException("Must enter valid location information");
        }

        if (name.trim().matches("[0-9]+")) {
            throw new NameException("Can only contain letters");
        }

        if (name.length() < 1) {
            throw new NameException("Location information must be longer than one character");
        }

    }

    /**
     * Checks for Format violation on String bookingNr
     *
     * @param bookingNr
     * @return bookingNr parsed to int
     * @throws BookingException
     * @author Robert
     */
    public static int bookingNrCheck(String bookingNr) throws BookingException {
        for (char c : bookingNr.trim().toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new BookingException("Booking nr must be Digits");
            }
        }

        return Integer.parseInt(bookingNr);
    }

    /**
     * Checks for format violations on String streetAdress
     *
     * @param streetAddress
     * @throws StreetAddressException
     * @author Robert
     */
    public static void streetAddressCheck(String streetAddress) throws StreetAddressException {

        if (streetAddress.isEmpty()) {
            throw new StreetAddressException("No Address entered");
        }

        if (streetAddress.length() < 3) {
            throw new StreetAddressException("Address must be longer than 3 characters ");
        }
    }

    /**
     * Checks for apartment violations on String apartmentNr
     *
     * @param apartmentNr
     * @return int roomNumber: apartmentNr parsed to int
     * @throws RoomException
     * @author Simon
     */
    public static int apartmentCheck(String apartmentNr) throws RoomException {
        int roomNumber = 0;
        try {
            roomNumber = Integer.parseInt(apartmentNr.trim());

        } catch (NumberFormatException ex) {
            throw new RoomException("must enter a room number");
        }

        if (roomNumber == 0 || roomNumber > 104) {
            throw new RoomException("Room nr. must be between 1 and 104");
        }
        return roomNumber;
    }

    /**
     * Checks for violations on number of guests and apartment type
     *
     * @param guests
     * @param type
     * @return int numberOfGuests
     * @throws RoomException
     */
    public static int guestCheck(String guests, String type) throws RoomException {
        int numberOfGuests = 0;
        try {
            numberOfGuests = Integer.parseInt(guests);
        } catch (NumberFormatException ex) {
            throw new RoomException("Number of guests must be a number");
        }

        if (type.equals("Single") && numberOfGuests > 1) {
            throw new RoomException("Single apartments can only hold 1 guest");
        }

        if (type.equals("Double") && numberOfGuests > 2) {
            throw new RoomException("Double apartments can only hold 2 guests");
        }

        if (type.equals("Family") && numberOfGuests > 5) {
            throw new RoomException("Family apartments can only hold 5 guests");
        }
        return numberOfGuests;
    }

    /**
     * Checks for violations on price
     *
     * @param num
     * @return int price
     * @throws RoomException
     * @author Simon
     */
    public static int priceCheck(int num) throws RoomException {
        int price = 0;

        if (num > 0 && num <= 40) {
            price = 60;

        } else if (num > 40 && num <= 90) {
            price = 80;

        } else if (num > 90 && num <= 104) {
            price = 100;
        } else {

            throw new RoomException("no prices on that apartment");
        }
        return price;
    }

    /**
     * checl for boundary violations on String nights
     *
     * @param nights
     * @return int x: nights
     * @throws BookingException
     * @author Simon
     */
    public static int nightsCheck(String nights) throws BookingException {
        int x = 0;
        try {
            x = Integer.parseInt(nights);

        } catch (NumberFormatException ex) {
            throw new BookingException("Must enter a number");
        }

        if (x > 999) {
            throw new BookingException("Booking must not be over 999 nights");
        }
        return x;
    }

    /**
     * Checks for violations
     *
     * @param guests
     * @param num
     * @return int x: guests
     * @throws RoomException
     *
     * @Author Simon
     */
    public static int editApartmentTypeCheck(String guests, int num) throws RoomException {
        int x = 0;

        try {
            x = Integer.parseInt(guests);
        } catch (NumberFormatException ex) {
            throw new RoomException("Number of nights must be a number");
        }

        if (num > 0 && num <= 40) {
            if (x > 1) {
                throw new RoomException("That apartment can only contain 1 resident");
            }

        } else if (num > 40 && num <= 90) {
            if (x > 2) {
                throw new RoomException("That apartment can only contain 2 residents");
            }

        } else if (num > 90 && num <= 104) {
            if (x > 5) {
                throw new RoomException("That apartment can only contain 5 residents");
            }

        } else {

            throw new RoomException("no apartment matches the specified apartment type");
        }
        return x;
    }

    /**
     * Checks for format violations on String date
     *
     * @param date
     * @throws DateException
     * @author Robert
     */
    public static void dateFormatCheck(String date) throws DateException {

        if (date.isEmpty()) {
            throw new DateException("Must enter a Date - no charecters entered ");
        }

        if (date.length() != 8) {
            throw new DateException("Date entered has errounous dimensions - must be in DD-MM-YY format");
        }

        if (date.charAt(2) != '-' || date.charAt(5) != '-') {
            throw new DateException("Date must be in DD-MM-YY format");
        }

        if (!Character.isDigit(date.charAt(0)) || !Character.isDigit(date.charAt(1)) || !Character.isDigit(date.charAt(3)) || !Character.isDigit(date.charAt(4)) || !Character.isDigit(date.charAt(6)) || !Character.isDigit(date.charAt(7))) {
            throw new DateException("Date must consist of digits - in DD-MM-YY format");

        }

        if (date.contains("--")) {
            throw new DateException("No -- allowed");
        }
    }

    /**
     * Checks for format violations on String phone
     *
     * @param phone
     * @throws PhoneException
     * @author Robert
     */
    public static void phoneCheck(String phone) throws PhoneException {

        if (phone.isEmpty()) {
            throw new PhoneException("Must enter a Phone nr - no charecters entered ");
        }

        if (phone.length() < 1) {
            throw new PhoneException("Phone nr must be at least 1 characters");
        }

        if (phone.length() > 16) {
            throw new PhoneException("Phone nr is too long");
        }

        int tmp = 0;
        for (char c : phone.toCharArray()) {
            if (Character.isDigit(c)) {
                tmp = 1;
            } else if (Character.isAlphabetic(c)) {
                tmp = 2;
                break;
            } else if (!Character.isLetterOrDigit(c)) {
                if (c == '-' || c == '+') {
                    tmp = 1;
                } else {
                    tmp = 3;
                    break;
                }
            }
        }

        if (tmp == 2) {
            throw new PhoneException("Phone nr can't contain letters");
        } else if (tmp == 3) {
            throw new PhoneException("Phone nr must be Digits. Only character allowed is - and +");
        }
    }

    /**
     * Checks if String date is a past date
     *
     * @param date
     * @throws DateException
     * @Author christopher
     */
    public static void timeDateCheck(String date) throws DateException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
        Calendar currentDate = null;
        Calendar dateToCheck = null;
        try {
            currentDate = new GregorianCalendar();
            dateToCheck = new GregorianCalendar();
            currentDate.setTime(Calendar.getInstance().getTime());
            currentDate.add(Calendar.DAY_OF_MONTH, -1);
            dateToCheck.setTime(sdf.parse(date));
            if (dateToCheck.compareTo(currentDate) != 1) {
                throw new DateException("Can not create a booking on that date");
            }
        } catch (ParseException ex) {

        }
    }

    /**
     * @param date
     * @throws errorHandling.DateException
     * @Author Simon Grønborg
     */
    public static void invalidTimeCheck(String date) throws DateException {
        int day = 0;
        int month = 1;

        try {
            day = Integer.parseInt(date.substring(0, 2));
            month = Integer.parseInt(date.substring(3, 5));
        } catch (NumberFormatException ex) {
            throw new DateException("not numbers");
        }

        if (day > 31) {
            throw new DateException("non exsisting day");
        }

        if (day <= 0) {
            throw new DateException("non exsisting day - too small");
        }

        if (month > 12) {
            throw new DateException("non exsisting month");
        }

        if (month == 0) {
            throw new DateException("non exsisting month - too small");
        }

    }

}
