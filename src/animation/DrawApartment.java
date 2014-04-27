package animation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
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
    private int cdm;
    private int[] xCoor;
    private int[] yCoor;
    private int screenRows;

    private final int calHeight = 100;
    private final int boxheight = 60;
    private final int spaceBuffer = 50;

    private int thisYear;
    private int thisMonth;
    private int thisDay;
    private int thisCdm;

    public DrawApartment(JPanel panel) {
        this.panel = panel;
        this.setSize(this.panel.getSize());
        calculateCurrentDate();
    }

    @Override
    public void paintComponent(Graphics page) {
        paintCalendar(page, screenRows);

    }

    private void addBookingBox(int x, int y, int width, int height, Color c, Color hc, String message) {
        JPanel p = new JPanel();
        JLabel h = new JLabel();
        p.setLayout(new GridLayout(1, 1));

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

        h.setHorizontalAlignment(SwingConstants.CENTER);
        h.setText(message);
        h.setBackground(Color.black);

        p.setLocation(x, y);
        p.setSize(width, height);
        p.setBackground(c);
    }

    private void drawCalendarBar(Graphics page, int y, int days) {
        int size = (this.panel.getWidth() - 1) / 31;
        int x = 0;

        for (int i = 0; i < days; i++) {
            page.setColor(grey);
            page.fillRect(x, y, size, 100);
            page.setColor(Color.WHITE);
            page.drawString("" + (i + 1), x + 10, y + 25);
            x = x + size + 1;
        }
    }

    private void paintCalendar(Graphics page, int rows) {
        int y = 0;
        for (int x = 0; x < rows; ++x) {
            drawCalendarBar(page, y, daysOfNextmonth(x));
            y = y + this.spaceBuffer + this.calHeight;
        }
    }

    private void calcScreenCoor() {
        this.screenRows = this.panel.getHeight() / (this.spaceBuffer + this.calHeight);

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
            y = y + spaceBuffer + calHeight;
        }
    }

    private void calculateCurrentDate() {
        try {
            Calendar c = Calendar.getInstance();
            this.thisDay = c.get(Calendar.DAY_OF_MONTH);
            this.thisMonth = c.get(Calendar.MONTH);
            this.thisYear = Integer.parseInt(("" + c.get(Calendar.YEAR)).substring(2));
            this.cdm = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        } catch (NumberFormatException ex) {

        }
    }

    private int daysOfNextmonth(int amount) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, thisMonth);
        c.add(Calendar.MONTH, amount);
        return c.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

}
