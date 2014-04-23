package presentation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author simon
 */
public class DrawMonth extends JPanel {

    private JPanel panel;
    private final Color blue;
    private final Color green;
    private final Color orange;
    private final Color grey;
    private final Color hGreen;
    private final Color hOrange;
    private final Color hblue;
    private int boxWidth;

    private int month;
    private int year;
    private int cdm;
    private int[] coor;
    private ArrayList<int[]> list;
    private int showings;
    private int apartment;
    private int increment;
    private int numOfRows;
    private String[] sMonths;
    private int lastIncrement;
    private int lastApartment;

    public DrawMonth(JPanel panel) {
        this.setSize(panel.getSize());
        this.panel = panel;
        this.list = new ArrayList();
        this.coor = new int[31];
        this.blue = new Color(0, 153, 204);
        this.green = new Color(119, 204, 51);
        this.orange = new Color(255, 204, 51);
        this.grey = new Color(176, 179, 180);
        this.hGreen = new Color(100, 184, 31);
        this.hOrange = new Color(235, 174, 21);
        this.hblue = new Color(0, 127, 178);
        this.boxWidth = 0;
        this.apartment = 1;
        this.increment = 0;
        this.lastIncrement = 0;
        this.lastApartment = 0;
        this.showings = 0;
        this.sMonths = new String[12];
    }

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

    public void previous() {
        int aStart = apartment;
        while (apartment > (aStart - (this.numOfRows * 2)) - 2) {
            if (this.list.get(increment)[5] == apartment) {
                increment--;
                if (increment == 0) {
                    break;
                }
            } else {
                apartment--;
            }
        }
        showings = 0;
        repaint();
    }

    public void reset() {
        apartment = 1;
        increment = 0;
        showings = 0;
        repaint();
    }

    public void next() {

        if (apartment == 104) {

        } else {
            showings = 0;
            apartment++;
            increment++;
        }
        repaint();
    }

    @Override
    public void paintComponent(Graphics page) {
        this.setSize(panel.getSize());
        int width = this.panel.getWidth() - 1;
        int height = this.panel.getHeight() - 1;
        int ySpaceBuffer = 5;
        int boxHeight = 60;
        boxWidth = (width / this.cdm);
        numOfRows = (height / (boxHeight + ySpaceBuffer)) - 1;
        

/////// draw
        drawCalendarBar(page);
        calcScreenCoor();
        ///////

        int y = 40;

        while (list.get(increment)[5] == apartment) {
            int[] tmp = list.get(increment);

            if (tmp[0] == 0) {
                // empty
                addBookingPanel(coor[0], y, this.panel.getWidth(), boxHeight, Color.WHITE, Color.lightGray, " No bookings this month - nr. " + tmp[5], "");

            } else if (this.month > tmp[1] && (tmp[9] > this.month || tmp[10] > this.year)) {

                // whole month
                addBookingPanel(coor[0], y, this.panel.getWidth(), boxHeight, orange, hOrange, " continious - Nr. " + tmp[5], "" + tmp[4]);

            } else if (this.month > tmp[1] || this.year > tmp[3]) {
                // ind i

                int nights = tmp[8];
                addBookingPanel(coor[0], y, calcSize(nights) - (boxWidth / 2), boxHeight, green, hGreen, " << - nr. " + tmp[5], "" + tmp[4] + " - " + tmp[0] + tmp[1] + "   " + tmp[3]);

            } else if ((tmp[0] + tmp[4]) > tmp[3]) {
                //ud af måneden
                int nights = (tmp[3] - tmp[0]) + 1;
                addBookingPanel(coor[tmp[0] - 1] + (boxWidth / 2), y, calcSize(nights), boxHeight, green, hGreen, "nr. " + tmp[5] + ">> ", "" + tmp[4]);
            } else {
                // this month
                addBookingPanel(coor[tmp[0] - 1] + (boxWidth / 2), y, calcSize(tmp[4]), boxHeight, blue, hblue, "nr. " + tmp[5], "" + tmp[4]);
            }

            if (!(showings < numOfRows)) {
                break;
            }

            if (!((increment + 1) > list.size() - 1)) {
                if (list.get(increment + 1)[5] != apartment) {
                    y = y + boxHeight + ySpaceBuffer;
                    apartment++;
                    showings++;
                }
            } else {
                break;
            }
            System.out.println(increment);
            increment++;

            if (increment >= list.size()) {
                increment --;
            }
        }

    }

    private void addBookingPanel(int x, int y, int width, int height, Color c, Color hc, String message, String message2) {
        JPanel p = new JPanel();
        JLabel h = new JLabel();
        JLabel k = new JLabel();
        p.setLayout(new GridLayout(2, 1));

        p.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showConfirmDialog(panel.getRootPane(), "not yet implemented");
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

    private int calcSize(int nights) {
        return (this.boxWidth * nights) + (nights - 1);
    }

    private void drawCalendarBar(Graphics page) {
        int size = (this.panel.getWidth() - 1) / this.cdm;
        int x = 0;
        int y = 0;
        for (int i = 0; i < 31; i++) {
            page.setColor(this.grey);
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
