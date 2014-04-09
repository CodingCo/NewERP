/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataSource;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Robert
 */
public class CronThreader implements Runnable {

    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    Connection con;
    int hour_delay = 25-Calendar.getInstance().getTime().getHours();
    int c = 0;

    public CronThreader(Connection con) {
        this.con = con;
    }

    @Override
    public void run() {
        System.out.println("hej");
        this.executor.scheduleAtFixedRate(periodicTask, hour_delay, 24, TimeUnit.HOURS);
    }

    public static void main(String[] args) {
        DBConnector dcon = DBConnector.getInstance();
        Connection con = dcon.getConnection();
        CronThreader c = new CronThreader(con);
        new Thread(c).start();
    }
    
    
    public void doCronJob() {

        String SQL1 = "BEGIN CPHRE31.MOVEBOOKING; END;";
        String SQL2 = "ALTER SESSION SET NLS_DATE_FORMAT = 'DD-MM-YY'";
        PreparedStatement st = null;
        CallableStatement st2 = null;

        try {
            st = con.prepareStatement(SQL2);
            st.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            st2 = con.prepareCall(SQL1);
            st2.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
                st2.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    Runnable periodicTask = new Runnable() {
        public void run() {
            doCronJob();

            c++;
            System.out.println("Cron nr: " + c);
        }
    };
}
