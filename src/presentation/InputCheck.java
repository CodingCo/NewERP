package presentation;

import Exception.DateException;
import Exception.EmailException;
import Exception.NameException;
import Exception.RoomException;

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

    public static int apartmentCheck(String apartmentNr) throws RoomException {
        int roomNumber;
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

    public static void dateCheck(String date) throws DateException {

        if (date.isEmpty()) {
            throw new DateException("Must enter a Date - no charecters entered ");
        }

        if (date.length() != 8) {
            throw new DateException("Date entered has errounous dimensions - must be in DD-MM-YY format");
        }

        if (date.charAt(3) != '-' || date.charAt(6) != '-') {
            throw new DateException("Date must be in DD-MM-YY format");
        }

        if (!Character.isDigit(date.charAt(1)) || !Character.isDigit(date.charAt(2)) || !Character.isDigit(date.charAt(4)) || !Character.isDigit(date.charAt(5)) || !Character.isDigit(date.charAt(7)) || !Character.isDigit(date.charAt(8))) {
            throw new DateException("Date must consist of digits - in DD-MM-YY format");

        }

        if (date.contains("--")) {
            throw new DateException("No -- allowed");
        }

    }

    public static void main(String[] args) {
        Character c = 'ö';
        System.out.println(Character.isLetter(c));
    }
}
