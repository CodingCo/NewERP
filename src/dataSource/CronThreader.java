/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Robert
 */
public class CronThreader {

    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    Connection con;
    int c = 0;

    public CronThreader(Connection con) {
        this.con = con;
    }

    public void runThread() {
        this.executor.scheduleAtFixedRate(periodicTask, 1, 24, TimeUnit.HOURS);
    }

    public void doCronJob() {

        String SQLString = "EXECUTE MOVEBOOKING";
        PreparedStatement st = null;

        try {

            st = con.prepareStatement(SQLString);
            st.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    Runnable periodicTask = new Runnable() {
        public void run() {

            doCronJob();
            
            c++;
            System.out.println("Hey " + c);
        }
    };
}
