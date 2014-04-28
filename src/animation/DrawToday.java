package animation;

import domain.Booking;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author simon Grønborg
 */
public class DrawToday extends JPanel implements DrawPropertyInterface {

    private JPanel panel;

    private final Font font;
    private String checkOut = "Check out";
    private String checkIn = "Check in";
    private String date;
    private int pointer;

    private ArrayList<Booking[]> list;

    public DrawToday(JPanel panel, ArrayList<Booking[]> list) {
        this.panel = panel;
        this.setSize(panel.getSize());
        this.font = new Font("Areal", 1, 12);
        this.list = new ArrayList();
        this.pointer = 0;
        this.list = list;
        setDate();
    }

    private void setDate() {
        SimpleDateFormat f = new SimpleDateFormat("dd   MMMMMMMMMM   yyyy");
        Date d = new Date();
        this.date = f.format(d);
    }

    public void next() {
        ++pointer;
        repaint();
    }

    public void reset() {
        this.pointer = 0;
        repaint();
    }

    public void previous() {
        --pointer;
        if (pointer < 0) {
            pointer = 0;
        }
        repaint();
    }

    /**
     * @param page
     * @Author Simon Grønborg
     */
    @Override
    public void paintComponent(Graphics page) {
        //this.setSize(this.panel.getWidth(), this.panel.getHeight());
        page.setColor(this.panel.getBackground());
        page.fillRect(0, 0, getWidth(), getHeight());
        page.setColor(this.panel.getForeground());
        int width = this.panel.getWidth() - 1;
        int height = this.panel.getHeight() - 1;
        Graphics2D graphics2D = (Graphics2D) page;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        int xSpaceBuffer = width / 20;
        int ySpaceBuffer = 20;
        int boxHeight = 70;
        int boxLength = (width / 2) - xSpaceBuffer;
        int fullBoxlength = width;
        int numOfRows = (height / (boxHeight + ySpaceBuffer)) - 1;
        int xOnePos = 0;
        int xTwoPos = boxLength + (xSpaceBuffer * 2);
        int yBoxPos = 0;

        page.setColor(Color.WHITE);
        page.fillRect(0, 0, width, boxHeight);
        yBoxPos = boxHeight + ySpaceBuffer;

        int rIndex = pointer;
        int index = 1 + pointer;
        int aSize = list.size();
        int to = (aSize - (aSize - (numOfRows * index)));
        int from = numOfRows * rIndex;
        if (to > list.size()) {
            to = list.size();
        }

        page.setColor(Color.black);
        page.setFont(new Font("Arial", 1, 18));
        page.drawString("Welcome \t \t" + "  \t \t Date: " + date, 10, 35);

        for (int i = from; i < to; ++i) {
            Booking b1 = list.get(i)[0];
            Booking b2 = list.get(i)[1];
            if (b1 != null && b2 != null) {
                // draw two small check -in/out                
                addBookingPanel(xOnePos, yBoxPos, boxLength, boxHeight, blue, hblue, b1, checkOut);
                addBookingPanel(xTwoPos, yBoxPos, boxLength, boxHeight, green, hGreen, b2, checkIn);
            } else if (b1 != null) {
                // draw long checkout
                addBookingPanel(xOnePos, yBoxPos, fullBoxlength, boxHeight, blue, hblue, b1, checkOut);
            } else {
                // draw long checkin
                addBookingPanel(xOnePos, yBoxPos, fullBoxlength, boxHeight, green, hGreen, b2, checkIn);
            }
            yBoxPos = yBoxPos + ySpaceBuffer + boxHeight;
        }

    }

    /**
     * Adds a pooking panel on the specified coordinates
     *
     * @Author Simon Grønborg
     */
    private void addBookingPanel(int x, int y, int width, int height, Color c, Color hover, Booking b, String check) {
        JPanel p = new JPanel();
        JLabel l = new JLabel();
        JLabel k = new JLabel();
        JLabel h = new JLabel();
        p.setLayout(new GridLayout(3, 1));
        p.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(panel.getRootPane(), b.toGuiListString(), "", WIDTH);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                p.setBackground(hover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                p.setBackground(c);
            }
        });

        this.panel.add(p);
        p.add(k);
        p.add(l);
        p.add(h);

        k.setHorizontalAlignment(SwingConstants.CENTER);
        k.setBackground(Color.black);
        k.setText("Name: " + b.getLast_name() + ", " + b.getFirst_name() + "  --  Phone number: " + b.getPhone());

        l.setHorizontalAlignment(SwingConstants.CENTER);
        l.setText("Apartment nr. " + b.getA_num() + "  --  Residents: " + b.getNumber_of_guests() + " date " + b.getDate_from());
        l.setBackground(Color.black);

        h.setHorizontalAlignment(SwingConstants.CENTER);
        h.setFont(font);
        h.setText(check);
        h.setBackground(Color.black);

        p.setLocation(x, y);
        p.setSize(width, height);
        p.setBackground(c);
    }

}
