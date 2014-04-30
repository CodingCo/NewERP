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
 * @author simon Grønborg
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
    private final int boxHeight = 60;
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

    /**
     * @param page
     * @Author = Simon Grønborg Draws onscreen
     */
    @Override
    public void paintComponent(Graphics page) {
        paintCalendar(page, screenRows);

        int month = thisMonth;
        int year = thisYear;
        int day = thisDay;

        // muligvis en for lang
        for (int x = 0; x < screenRows; ++x) {

            for (int y = 0; y < list.size(); ++y) {
                int[] tmp = list.get(y);

                if ((tmp[2] * 100) + tmp[1] == (year * 100) + month && (tmp[10] * 100) + tmp[9] == (year * 100) + month) {
                    // i denne måned
                    addBookingBox(xCoor[tmp[0] - 1] + (boxWidth / 2), yCoor[x] + 40, boxWidth(tmp[4]), boxHeight, blue, hblue, "" + tmp[6], tmp[6]);
                }

                if ((tmp[2] * 100) + tmp[1] < (year * 100) + month && (tmp[10] * 100) + tmp[9] > (year * 100) + month) {
                    // whole month
                    addBookingBox(xCoor[0], yCoor[x] + 40, boxWidth(30), boxHeight, orange, hOrange, "" + tmp[6], tmp[6]);
                }

                if ((tmp[2] * 100) + tmp[1] < (year * 100) + month && (tmp[10] * 100) + tmp[9] == (year * 100) + month) {
                    // in this month

                    addBookingBox(xCoor[0], yCoor[x] + 40, boxWidth(tmp[8]) - (boxWidth / 2), boxHeight, green, hGreen, "" + tmp[6], tmp[6]);
                }

                if ((tmp[2] * 100) + tmp[1] == (year * 100) + month && (tmp[10] * 100) + tmp[9] > (year * 100) + month) {
                    //ud af måneden
                    int nights = (tmp[3] - tmp[0]) + 1;
                    addBookingBox(xCoor[tmp[0] - 1] + (boxWidth / 2), yCoor[x] + 40, boxWidth(nights), boxHeight, green, hGreen, "nr. " + tmp[5] + ">> ", tmp[6]);
                }

            }

            month = nextMonth(x + 1)[0];
        }

    }

    /**
     * Adds a panel on the specified coordinates and the given size. Must match
     * a booking
     *
     * @Author Simon Grønborg
     */
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

    /**
     * @Author Simon Grønborg Make one calender bar
     */
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

    /**
     * @Author Simon Grønborg Draws the calender bar for the whole screen
     */
    private void paintCalendar(Graphics page, int rows) {
        int y = 0;
        for (int x = 0; x < rows; ++x) {
            makeCalendar(page, y, nextMonth(x));
            y = y + this.spaceBuffer + this.calendarHeight;
        }
    }

    /**
     * Creates to integer arrays, with sizes based on screen size. These arrays
     * holds coordinates matching each calender, which makes plotting easyer.
     *
     * @Author Simon Grønborg
     */
    private void calcScreenCoor() {
        this.screenRows = this.panel.getHeight() / (this.spaceBuffer + this.calendarHeight);
        this.boxWidth = (this.panel.getWidth() - 1) / 31;

        int x = 0;
        this.xCoor = new int[31];
        this.xCoor[0] = 0;
        for (int i = 1; i < 31; i++) {
            x = x + boxWidth + 1;
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

    private int boxWidth(int nights) {
        return ((this.boxWidth * nights) + (nights - 1));
    }

}
