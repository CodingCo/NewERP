/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private int boxWidth;

    private int month;
    private int cdm;
    private int[] coor;
    private ArrayList<int[]> list;
    private int showings;
    private int apartment;
    private int increment;

    private int lastIncrement;
    private int lastApartment;
    
    
    public DrawMonth(JPanel panel) {
        this.panel = panel;
        this.setSize(panel.getSize());
        this.blue = new Color(0, 153, 204);
        this.green = new Color(119, 204, 51);
        this.orange = new Color(255, 204, 51);
        this.list = new ArrayList();
        this.coor = new int[31];
        this.boxWidth = 0;
        this.apartment = 1;
        this.increment = 0;
        this.lastIncrement = 0;
        this.lastApartment = 0;
    }

    public void initializeListAndMonth(ArrayList<int[]> list, String date) {
        this.list = list;
        try {
            month = Integer.parseInt(date.substring(3, 5));
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

    public void previous() {
        
        
        
        

    }

    public void reset() {
        apartment = 1;
        increment = 0;
        showings = 0;
        repaint();
    }

    public void next() {
        showings = 0;
        apartment++;
        increment++;
        repaint();
    }

    @Override
    public void paintComponent(Graphics page) {
        int width = this.panel.getWidth() - 1;
        int height = this.panel.getHeight() - 1;
        int ySpaceBuffer = 5;
        int boxHeight = 60;
        boxWidth = (width / this.cdm);
        int numOfRows = (height / (boxHeight + ySpaceBuffer)) - 1;
        /////// draw
        drawCalendarBar(page);
        calcScreenCoor();
        ///////

        int x = 0;
        int y = boxHeight + ySpaceBuffer;

        
        
        
        while (list.get(increment)[5] == apartment) {
            int[] tmp = list.get(increment);

            if (tmp[0] == 0) {
                // empty
                addBookingPanel(coor[0], y, width, boxHeight, Color.WHITE, " No bookings this month " + tmp[5]);

            } else if (this.month > tmp[1] && (tmp[4] - (this.cdm + (tmp[3] - tmp[0]))) > 0) {
                // whole month
                addBookingPanel(coor[0], y, width, boxHeight, orange, " continious - a " + tmp[5]);
            } else if (this.month > tmp[1]) {
                // ind i
                int nights = (tmp[0] + tmp[4]) - tmp[3];
                addBookingPanel(coor[0], y, calcSize(nights), boxHeight, orange, " <<a " + tmp[5]);
            } else if ((tmp[0] + tmp[4]) > tmp[3]) {
                //ud af måneden
                int nights = (tmp[3] - tmp[0]) + 1;
                addBookingPanel(coor[tmp[0] - 1], y, calcSize(nights), boxHeight, orange, "" + tmp[5] + " a>> ");
            } else {
                // this month
                addBookingPanel(coor[tmp[0] - 1], y, calcSize(tmp[4]), boxHeight, blue, "a" + tmp[5]);
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

            increment++;
        }

    }

    private void addBookingPanel(int x, int y, int width, int height, Color c, String message) {
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
            }

            @Override
            public void mouseExited(MouseEvent e) {
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

    private int calcSize(int nights) {
        return (this.boxWidth * nights) + (nights - 1);
    }

    private void drawCalendarBar(Graphics page) {
        int size = (this.panel.getWidth() - 1) / this.cdm;
        int x = 0;
        int y = 0;
        for (int i = 0; i < 31; i++) {
            page.setColor(Color.GRAY);
            page.fillRect(x, y, size, (this.panel.getHeight()));
            page.setColor(Color.WHITE);
            page.drawString("" + (i + 1), x + 5, y + 20);
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
