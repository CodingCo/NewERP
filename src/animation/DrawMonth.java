package animation;

import domain.Controller;
import errorHandling.ConnectionException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author simon Grønborg
 */
public class DrawMonth extends JPanel implements DrawPropertyInterface {

    private JPanel panel;
    private ArrayList<int[]> list;
    private Controller controller;

    private int boxWidth;
    private int month;
    private int year;
    private int cdm;
    private int[] coor;

    private int showings;
    private int apartment;
    private int increment;
    private int numOfRows;

    public DrawMonth(JPanel panel) {
        this.setSize(panel.getSize());
        this.panel = panel;
        this.list = new ArrayList();
        this.coor = new int[31];
        this.boxWidth = 0;
        this.apartment = 1;
        this.increment = 0;
        this.showings = 0;

        try {
            this.controller = new Controller();
        } catch (ConnectionException ex) {
            JOptionPane.showMessageDialog(panel.getRootPane(), ex.getMessage(), "", 1);
        }
    }

    /**
     * @Author Simon Grønborg
     * @param list
     * @param date
     */
    public void initializeListAndMonth(ArrayList<int[]> list, String date) {
        this.list = list;
        try {
            month = Integer.parseInt(date.substring(3, 5));
            year = Integer.parseInt(date.substring(6, 8));
            Calendar c = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
            try {
                c.setTime(sdf.parse(date));

                this.cdm = c.getActualMaximum(Calendar.DAY_OF_MONTH);
            } catch (ParseException e) {

            }
        } catch (NumberFormatException ex) {

        }
    }

    /**
     * @Author Simon Grønborg
     * @param date
     * @return
     */
    public String nextMonth(String date) {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
        try {
            c.setTime(sdf.parse(date));

        } catch (ParseException ex) {
        }
        c.add(Calendar.MONTH, 1);
        String s = sdf.format(c.getTime());
        return s;
    }

    /**
     * @Author Simon grønborg
     * @param date
     * @return date
     */
    public String previousMonth(String date) {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
        try {
            c.setTime(sdf.parse(date));

        } catch (ParseException ex) {
        }
        c.add(Calendar.MONTH, -1);
        String s = sdf.format(c.getTime());
        return s;
    }

    /**
     * @Author Robert Elving
     */
    public void up() {
        int aStart = apartment;
        if ((apartment > this.numOfRows + 1)) {
            while (apartment > (aStart - (this.numOfRows * 2)) - 2) {
                if (this.list.get(increment)[5] == apartment) {
                    increment--;
                    if (increment <= numOfRows) {
                        apartment = 1;
                        increment = 0;
                        showings = 0;
                        break;
                    }
                } else {
                    apartment--;
                }
            }
            showings = 0;
        } else {
            apartment = 1;
            showings = 0;
        }
        repaint();

    }

    public void reset() {
        apartment = 1;
        increment = 0;
        showings = 0;
        repaint();
    }

    public void down() {
        if (apartment >= 104) {

        } else {
            showings = 0;

            repaint();
        }

    }

    /**
     * @Author = Simon og Robert
     * @param page
     */
    @Override
    public void paintComponent(Graphics page) {
        page.setColor(this.panel.getBackground());
        page.fillRect(0, 0, getWidth(), getHeight());
        page.setColor(this.panel.getForeground());
        int width = this.panel.getWidth() - 1;
        int height = this.panel.getHeight() - 1;
        int ySpaceBuffer = 5;
        int boxHeight = 60;
        boxWidth = (width / this.cdm);
        numOfRows = (height / (boxHeight + ySpaceBuffer)) - 1;

        drawCalendarBar(page);
        calcScreenCoor();

        int y = 40;

        while (showings <= numOfRows) {
            while (list.get(increment)[5] == apartment) {
                if (increment + 1 > list.size()) {
                    break;
                }
                int[] tmp = list.get(increment);

                // tegne stuff
                if (tmp[0] == 0) {
                    // empty
                    addEmptyPanel(coor[0], y, this.panel.getWidth(), boxHeight, Color.WHITE, Color.white, " No bookings this month - nr. " + tmp[5],"" + tmp[5]);

                } else if ((tmp[2] * 100) + tmp[1] < (this.year * 100) + this.month && (tmp[10] * 100) + tmp[9] > (this.year * 100) + this.month) {

                    // whole month
                    addBookingPanel(coor[0], y, this.panel.getWidth(), boxHeight, orange, hOrange, " Continious Booking - Nr. " + tmp[5], "" + tmp[4], tmp[6]);

                } else if ((tmp[2] * 100) + tmp[1] < (this.year * 100) + this.month && (tmp[10] * 100) + tmp[9] == (this.year * 100) + this.month) {
                    // ind i
                    int nights = tmp[8];
                    addBookingPanel(coor[0], y, calcSize(nights) - (boxWidth / 2), boxHeight, green, hGreen, " << - nr. " + tmp[5], "" + tmp[4], tmp[6]);

                } else if ((tmp[2] * 100) + tmp[1] == (this.year * 100) + this.month && (tmp[10] * 100) + tmp[9] > (this.year * 100) + this.month) {
                    //ud af måneden
                    int nights = (tmp[3] - tmp[0]) + 1;
                    addBookingPanel(coor[tmp[0] - 1] + (boxWidth / 2), y, calcSize(nights), boxHeight, green, hGreen, "nr. " + tmp[5] + ">> ", "" + tmp[4], tmp[6]);
                } else {
                    // this month
                    addBookingPanel(coor[tmp[0] - 1] + (boxWidth / 2), y, calcSize(tmp[4]), boxHeight, blue, hblue, "nr. " + tmp[5], "" + tmp[4], tmp[6]);
                }

                increment++;

                if (increment >= list.size()) {
                    increment--;
                    break;
                }
            }

            y = y + boxHeight + ySpaceBuffer;
            apartment++;
            showings++;
        }
    }

    /**
     * @Author Simon Grønborg
     */
    private void addBookingPanel(int x, int y, int width, int height, Color c, Color hc, String message, String message2, int id) {
        JPanel p = new JPanel();
        JLabel h = new JLabel();
        JLabel k = new JLabel();
        p.setLayout(new GridLayout(2, 1));

        p.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    JOptionPane.showMessageDialog(panel.getRootPane(), controller.getBooking(id).toGuiListString(), "", WIDTH);
                } catch (HeadlessException ex) {

                }
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
        p.add(k);

        h.setHorizontalAlignment(SwingConstants.CENTER);
        h.setText(message);
        h.setBackground(Color.black);

        k.setHorizontalAlignment(SwingConstants.CENTER);
        k.setText(message2);
        k.setBackground(Color.black);

        p.setLocation(x, y);
        p.setSize(width, height);
        p.setBackground(c);
    }

    private void addEmptyPanel(int x, int y, int width, int height, Color c, Color hc, String message, String m2) {

        JPanel p = new JPanel();
        JLabel h = new JLabel();
        JLabel k = new JLabel();
        p.setLayout(new GridLayout(2, 1));

        p.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    JOptionPane.showMessageDialog(panel.getRootPane(), "There are no bookings for apartment " + m2 + " in this month ", "", WIDTH);
                } catch (HeadlessException ex) {

                }
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
        p.add(k);

        h.setHorizontalAlignment(SwingConstants.CENTER);
        h.setText(message);
        h.setBackground(Color.black);

        k.setHorizontalAlignment(SwingConstants.CENTER);
        k.setBackground(Color.black);

        p.setLocation(x, y);
        p.setSize(width, height);
        p.setBackground(c);

    }

    private int calcSize(int nights) {
        return (this.boxWidth * nights) + (nights - 1);
    }

    private void drawCalendarBar(Graphics page) {
        int size = (this.panel.getWidth() - 1) / this.cdm;
        int x = 0;
        int y = 0;
        for (int i = 0; i < 31; i++) {
            page.setColor(grey);
            page.fillRect(x, y, size, (this.panel.getHeight()));
            page.setColor(Color.WHITE);

            page.drawString("" + (i + 1), x + 10, y + 25);
            x = x + size + 1;
        }
    }

    private void calcScreenCoor() {
        int x = 0;
        this.coor = new int[31];
        coor[0] = 0;
        for (int i = 1; i < 31; i++) {
            x = x + ((this.panel.getWidth() - 1) / this.cdm) + 1;
            coor[i] = x;
        }

    }

}
