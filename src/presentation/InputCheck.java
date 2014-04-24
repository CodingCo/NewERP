package presentation;

import Exception.BookingException;
import Exception.DateException;
import Exception.EmailException;
import Exception.NameException;
import Exception.RoomException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author simon
 */
public class InputCheck {

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

    public static void nameCheck(String name) throws NameException {

        if (name.isEmpty()) {
            throw new NameException("No name entered - try with John");
        }

        if (!name.trim().matches("[a-zA-Z]+")) {
            throw new NameException("must type in a real name");
        }

        if (name.length() < 1) {
            throw new NameException("Name must be longer than one charecter");
        }

    }
     
    public static void custInfoCheck(String name) throws NameException {

        if (name.isEmpty()) {
            throw new NameException("Must enter valid location information");
        }

        if (!name.trim().matches("[a-zA-Z]+")) {
            throw new NameException("Can only contain latters");
        }

        if (name.length() < 1) {
            throw new NameException("Lacation information must be longer than one charecter");
        }

    }
    

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

    public static String apartmentTypeCheck(int num) throws RoomException {
        String apartment = "";

        if (num > 0 && num <= 40) {
            apartment = "Single";

        } else if (num > 40 && num <= 90) {
            apartment = "Double";

        } else if (num > 90 && num <= 104) {
            apartment = "Family";
        } else {

            throw new RoomException("no apartment matches the specified apartment type");
        }
        return apartment;
    }

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

}
