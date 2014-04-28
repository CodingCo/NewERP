package animation;

import domain.Controller;
import errorHandling.ConnectionException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author simon
 */
public class DrawApartment extends JPanel implements DrawPropertyInterface {

    private JPanel panel;
    private ArrayList<int[]> list;
    private Controller controller;
    private int cdm;
    private int[] xCoor;
    private int[] yCoor;
    private int screenRows;
    private int boxWidth;
    private final int calendarHeight = 120;
    private final int boxheight = 60;
    private final int spaceBuffer = 40;

    private int thisYear;
    private int thisMonth;
    private int thisDay;
    private int thisCdm;

    public DrawApartment(JPanel panel, int anum) {
        this.panel = panel;
        this.setSize(this.panel.getSize());
        try {
            this.controller = new Controller();
        } catch (ConnectionException ex) {
            JOptionPane.showMessageDialog(panel.getRootPane(), ex.getMessage(), "", 1);
        }
        calculateCurrentDate();
        getList(anum);
        calcScreenCoor();
    }

    @Override
    public void paintComponent(Graphics page) {
        paintCalendar(page, screenRows);

        int month = thisMonth;
        int year = thisYear;
        int day = thisDay;

        for (int x = 0; x < list.size(); ++x) {
            int[] tmp = list.get(x);

            for (int y = 0; y < screenRows; ++y) {

                if (tmp[1] == month && tmp[9] == month) {
                    // i denne måned
                    addBookingBox(xCoor[tmp[0] - 1], yCoor[y] + 40, boxWidth(tmp[4]), boxheight, blue, hblue, ""+tmp[6], tmp[6]);
                }

                month = nextMonth(1)[0];
            }
        }

//        if ((tmp[2] * 100) + tmp[1] < (thisYear * 100) + thisMonth && (tmp[10] * 100) + tmp[9] > (thisYear * 100) + thisMonth) {
//            // whole month
//        }
    }

    private int boxWidth(int nights) {
        return (this.boxWidth * nights) + (nights - 1);
    }

    private void addBookingBox(int x, int y, int width, int height, Color c, Color hc, String message, int id) {
        JPanel p = new JPanel();
        JLabel h = new JLabel();
        p.setLayout(new GridLayout(1, 1));

        p.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(panel.getRootPane(), controller.getBooking(id).toGuiListString(), "", 1);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                p.setBackground(hc);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                p.setBackground(c);
            }
        });

        this.panel.add(p);
        p.add(h);

        h.setHorizontalAlignment(SwingConstants.CENTER);
        h.setText(message);
        h.setBackground(Color.black);

        p.setLocation(x, y);
        p.setSize(width, height);
        p.setBackground(c);
    }

    private void makeCalendar(Graphics page, int yCoor, int[] date) {
        int size = (this.panel.getWidth() - 1) / 31;
        int x = 0;
        for (int i = 0; i < date[1]; i++) {
            page.setColor(grey);
            page.fillRect(x, yCoor, size, calendarHeight);
            page.setColor(Color.WHITE);
            page.drawString("" + (i + 1), x + 10, yCoor + 25);
            x = x + size + 1;
        }
        page.drawString("Date: " + (date[0]) + "/ " + date[2], this.panel.getWidth() / 2, yCoor + 115);
    }

    private void paintCalendar(Graphics page, int rows) {
        int y = 0;
        for (int x = 0; x < rows; ++x) {
            makeCalendar(page, y, nextMonth(x));
            y = y + this.spaceBuffer + this.calendarHeight;
        }
    }

    private void calcScreenCoor() {
        this.screenRows = this.panel.getHeight() / (this.spaceBuffer + this.calendarHeight);
        this.boxWidth = (this.panel.getWidth() - 1) / 31;

        int x = 0;
        this.xCoor = new int[31];
        this.xCoor[0] = 0;
        for (int i = 1; i < 31; i++) {
            x = x + ((this.panel.getWidth() - 1) / this.cdm) + 1;
            xCoor[i] = x;
        }

        int y = 0;
        this.yCoor = new int[screenRows];
        this.yCoor[0] = y;
        for (int j = 1; j < screenRows; ++j) {
            y = y + spaceBuffer + calendarHeight;
            yCoor[j] = y;
        }
    }

    private void calculateCurrentDate() {
        try {
            GregorianCalendar c = new GregorianCalendar();
            this.thisDay = c.get(Calendar.DAY_OF_MONTH);
            this.thisMonth = c.get(GregorianCalendar.MONTH) + 1;
            this.thisYear = Integer.parseInt(("" + c.get(Calendar.YEAR)).substring(2));
            this.cdm = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        } catch (NumberFormatException ex) {
        }

    }

    private int[] nextMonth(int amount) {
        int[] dates = new int[3];
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, amount);
        dates[0] = c.get(Calendar.MONTH) + 1;
        dates[1] = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        dates[2] = c.get(Calendar.YEAR);
        return dates;
    }

    private void getList(int anum) {
        this.list = controller.getBookingsByApartment(anum, this.thisMonth);
    }
}
