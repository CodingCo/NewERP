package dataSource;

import errorHandling.ConnectionException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author simon
 */
public class Fixture {

    private final String username = "cphso59";
    private final String password = "cphso59";

    public void runScript() {
        try {
            Connection con = this.getConnection();
            con.setAutoCommit(false);

            dropAndDeleteTables(con);
            insertApartments(con);
            insertData(con);

            con.commit();

        } catch (ConnectionException e) {

        } catch (SQLException ex) {

        } catch (Exception exx) {

        }
    }

    private Connection getConnection() throws ConnectionException {
        Connection con = null;
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@datdb.cphbusiness.dk:1521:dat", username, password);

        } catch (ClassNotFoundException e) {
            throw new ConnectionException("Connection could not be established to the database \n check your internet connection and try again");
        } catch (SQLException e) {
            throw new ConnectionException("Connection could not be established to the database \n check your internet connection and try again");
        }
        return con;
    }

    private void insertData(Connection con) {
        Statement statement = null;
        String[] inserCustomer = new String[8];
        String[] insertBooking = new String[8];

        inserCustomer[0] = "insert into customer values(customer_seq.NEXTVAL, 'Kasper', 'Hald', '555', 'k@asp.er', 'Danmark', 'Lyngby', 2800, 'Eremitageparken', 1)";
        inserCustomer[1] = "insert into customer values(customer_seq.NEXTVAL, 'John', 'I', '1234', 'smexyman@hotmail.com', 'USA', 'Syracuse', 100, '1st Street 911', 1)";
        inserCustomer[2] = "insert into customer values(customer_seq.NEXTVAL, 'John', 'II', '1234', 'smexyman@hotmail.com', 'USA', 'Syracuse', 100, '1st Street 911', 1)";
        inserCustomer[3] = "insert into customer values(customer_seq.NEXTVAL, 'John', 'III', '1234', 'smexyman@hotmail.com', 'USA', 'Syracuse', 100, '1st Street 911', 1)";
        inserCustomer[4] = "insert into customer values(customer_seq.NEXTVAL, 'John', 'IV', '1234', 'smexyman@hotmail.com', 'USA', 'Syracuse', 100, '1st Street 911', 1)";
        inserCustomer[5] = "insert into customer values(customer_seq.NEXTVAL, 'Kiley', 'Minnow', '4321', 'smexymum@hotmail.com', 'USA', 'Philadelphia', 100, '99st Street 199', 1)";
        inserCustomer[6] = "insert into customer values(customer_seq.NEXTVAL, 'Janet', 'Doe', '4321', 'smexymumma@hotmail.com', 'USA', 'Philadelphia', 100, '99st Street 199', 1)";
        inserCustomer[7] = "insert into customer values(customer_seq.NEXTVAL, 'Janette', 'Doe', '4321', 'smexymama@hotmail.com', 'USA', 'Philadelphia', 100, '99st Street 199', 1)";

        insertBooking[0] = "insert into booking values(booking_seq.NEXTVAL, 1, 1, '01-05-14', 3, 'Michelin', 1, 180, 1)";
        insertBooking[1] = "insert into booking values(booking_seq.NEXTVAL, 2, 1, '26-04-14', 1, 'Michelin', 1, 60, 1)";
        insertBooking[2] = "insert into booking values(booking_seq.NEXTVAL, 3, 2, '27-04-14', 1, 'Michelin', 1, 60, 1)";
        insertBooking[3] = "insert into booking values(booking_seq.NEXTVAL, 4, 3, '26-04-14', 1, 'Michelin', 1, 60, 1)";
        insertBooking[4] = "insert into booking values(booking_seq.NEXTVAL, 5, 3, '27-04-14', 1, 'Michelin', 1, 60, 1)";
        insertBooking[5] = "insert into booking values(booking_seq.NEXTVAL, 6, 104, '27-07-18', 1, 'Michelin', 1, 60, 1)";
        insertBooking[6] = "insert into booking values(booking_seq.NEXTVAL, 7, 1, '08-05-14', 1, 'Michelin', 1, 60, 1)";
        insertBooking[7] = "insert into booking values(booking_seq.NEXTVAL, 8, 1, '15-05-14', 1, 'Michelin', 1, 60, 1)";

        for (String dt : inserCustomer) {
            try {
                statement = con.createStatement();
                statement.execute(dt);
            } catch (SQLException ex) {

            }
        }

        for (String dt : insertBooking) {
            try {
                statement = con.createStatement();
                statement.execute(dt);
            } catch (SQLException ex) {

            }
        }

    }

    private void dropAndDeleteTables(Connection con) {

        Statement statement = null;
        String[] dropTable = new String[5];
        String[] dropSeq = new String[3];

        dropTable[0] = "DROP TABLE guest";
        dropTable[1] = "DROP TABLE booking";
        dropTable[2] = "DROP TABLE history";
        dropTable[3] = "DROP TABLE apartment";
        dropTable[4] = "DROP TABLE customer";
        dropSeq[0] = "DROP SEQUENCE customer_seq";
        dropSeq[1] = "DROP SEQUENCE booking_seq";
        dropSeq[2] = "DROP SEQUENCE guest_seq";

        String d9 = "CREATE SEQUENCE booking_seq MINVALUE 0 MAXVALUE 99999999 START WITH 0 INCREMENT BY 1";
        String d10 = "CREATE SEQUENCE customer_seq MINVALUE 0 MAXVALUE 99999999 START WITH 0 INCREMENT BY 1";
        String d11 = "CREATE SEQUENCE guest_seq MINVALUE 0 MAXVALUE 99999999 START WITH 0 INCREMENT BY 1";

        String d12 = "CREATE TABLE apartment( a_num NUMBER PRIMARY KEY, type varchar(6) NOT NULL, price NUMBER(4) NOT NULL, capacity NUMBER(1) NOT NULL)";
        String d13 = "CREATE TABLE customer( cust_id NUMBER(8) PRIMARY KEY, first_name VARCHAR2(32) NOT NULL, last_name VARCHAR2(32) NOT NULL, phone VARCHAR2(16) NOT NULL, email VARCHAR2(32), country VARCHAR2(32) NOT NULL, city VARCHAR2(32) NOT NULL, zipcode NUMBER, street VARCHAR2(32) NOT NULL, version_num NUMBER)";
        String d14 = "CREATE TABLE booking( b_id NUMBER(8) PRIMARY KEY, cust_id NUMBER(8) NOT NULL REFERENCES customer(cust_id), a_num NUMBER NOT NULL REFERENCES apartment(a_num), date_from DATE NOT NULL, number_of_nights NUMBER(4) NOT NULL, travel_agency VARCHAR2(30), number_of_guests NUMBER(1),  price DECIMAL(10,2) NOT NULL, version_num NUMBER )";
        String d15 = "CREATE TABLE history( b_id  NUMBER(8) PRIMARY KEY, cust_id NUMBER(8) NOT NULL REFERENCES customer(cust_id), a_num NUMBER NOT NULL REFERENCES apartment(a_num), date_from DATE NOT NULL, number_of_nights NUMBER(4) NOT NULL, travel_agency VARCHAR2(30), number_of_guests NUMBER(1) NOT NULL, price DECIMAL(10,2) NOT NULL )";
        String d16 = "CREATE TABLE guest( b_id NUMBER(8) REFERENCES booking (b_id), guest_id VARCHAR2(10))";

        try {

            statement = con.createStatement();
            statement.execute("ALTER SESSION SET NLS_DATE_FORMAT = 'DD-MM-YY'");

        } catch (SQLException ex) {

        }

        for (String dt : dropTable) {
            try {
                statement = con.createStatement();
                statement.execute(dt);
            } catch (SQLException ex) {

            }
        }

        for (String ds : dropSeq) {
            try {
                statement = con.createStatement();
                statement.execute(ds);
            } catch (SQLException ex) {

            }
        }

        try {
            statement = con.createStatement();
            statement.execute(d9);
            statement.execute(d10);
            statement.execute(d11);
            statement.execute(d12);
            statement.execute(d13);
            statement.execute(d14);
            statement.execute(d15);
            statement.execute(d16);
        } catch (SQLException e) {

        }
    }

    private void insertApartments(Connection con) {

        String SQL = "INSERT INTO APARTMENT (a_num, type, price, capacity) values (?, ?, ?, ?)";
        PreparedStatement ps = null;

        try {

            ps = con.prepareStatement(SQL);

            for (int i = 0; i < 40; i++) {
                ps.setInt(1, i + 1);
                ps.setString(2, "Single");
                ps.setDouble(3, 60.0);
                ps.setInt(4, 1);
                ps.addBatch();
            }

            for (int i = 40; i < 90; i++) {
                ps.setInt(1, i + 1);
                ps.setString(2, "Double");
                ps.setDouble(3, 80.0);
                ps.setInt(4, 2);
                ps.addBatch();
            }

            for (int i = 90; i < 104; i++) {
                ps.setInt(1, i + 1);
                ps.setString(2, "Family");
                ps.setDouble(3, 100.0);
                ps.setInt(4, 5);
                ps.addBatch();
            }

            ps.executeBatch();

        } catch (SQLException ex) {

        }

    }

}
