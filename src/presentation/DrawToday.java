/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.Booking;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author simon
 */

public class DrawToday extends JPanel {

    private JPanel panel;
    private final Color blue;
    private final Color green;
    private final Color orange;
    private final Color hoverBlue;
    private final Color hoverGreen;
    private String checkOut = "Check out";
    private String checkIn = "Check in";
    private int pointer;
    
    private ArrayList<Booking[]> list;
    private int index;

    public DrawToday(JPanel panel) {
        this.panel = panel;
        this.setSize(panel.getSize());
        this.blue = new Color(0, 153, 204);
        this.green = new Color(119, 204, 51);
        this.orange = new Color(255, 204, 51);
        this.hoverBlue = new Color(0, 127, 178);
        this.hoverGreen = new Color(100, 184, 31);
        this.list = new ArrayList();
        this.pointer = 0;
    }

    public void loadInList(ArrayList<Booking[]> list) {
        this.list = list;
    }

    
    public void next(){
    
    
    
    }
    
    @Override
    public void paintComponent(Graphics page) {
        this.setSize(this.panel.getWidth(), this.panel.getHeight());
        int width = this.panel.getWidth() - 1;
        int height = this.panel.getHeight() - 1;
        Graphics2D graphics2D = (Graphics2D) page;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        int xSpaceBuffer = width / 20;
        int ySpaceBuffer = 20;
        int boxHeight = 70;
        int boxLength = (width / 2) - xSpaceBuffer;
        int fullBoxlength = width;
        int numOfRows = (height / (boxHeight + ySpaceBuffer)) - 1;
        int xOnePos = 0;
        int xTwoPos = boxLength + (xSpaceBuffer * 2);
        int yBoxPos = 0;
        String date = "";
        
        page.setColor(Color.WHITE);
        page.fillRect(0, 0, width, boxHeight);
        yBoxPos = boxHeight + ySpaceBuffer;

        
        
        if(numOfRows < this.list.size()){
                this.index = numOfRows;
        }else{
            this.index = this.list.size();
        }
        
        int numberOfGuests = 0;
        
        
        //[0] checkout booking
        //[1] checkin booking
        for (int i = 0; i < index; ++i) {
            Booking b1 = list.get(i)[0];
            Booking b2 = list.get(i)[1];

            if (b1 != null && b2 != null) {
                // draw two small check -in/out                
                inBookingPanel(xOnePos, yBoxPos, boxLength, boxHeight, blue, hoverBlue, b1,checkOut);
                inBookingPanel(xTwoPos, yBoxPos, boxLength, boxHeight, green, hoverGreen,b2,checkIn);
                numberOfGuests = numberOfGuests + b1.getNumber_of_guests() + b2.getNumber_of_guests();
                
            } else if (b1 != null) {
                // draw long checkout
                inBookingPanel(xOnePos, yBoxPos, fullBoxlength, boxHeight, blue, hoverBlue,b1,checkOut);
                numberOfGuests = numberOfGuests + b1.getNumber_of_guests();
                date = b1.getDate_from();

            } else {
                // draw long checkin
                inBookingPanel(xOnePos, yBoxPos, fullBoxlength, boxHeight, green, hoverGreen,b2,checkIn);
                numberOfGuests = numberOfGuests + b2.getNumber_of_guests();
            }
            yBoxPos = yBoxPos + ySpaceBuffer + boxHeight;
        }
        
        page.setColor(Color.black);
        page.setFont(new Font("Arial", 1, 18));
        page.drawString("Guests Today " + numberOfGuests + "    --    Todays date " + date, 10, 35);
    }

    private void inBookingPanel(int x, int y, int width, int height, Color c, Color hover, Booking b, String check) {
        JPanel p = new JPanel();
        JLabel l = new JLabel();
        JLabel k = new JLabel();
        JLabel h = new JLabel();
        p.setLayout(new GridLayout(3,1));
        p.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showConfirmDialog(panel.getRootPane(), "not yet implemented");
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
        k.setText("Name: " + b.getLast_name()+", "+b.getFirst_name() + "  --  Phone number: " + b.getPhone());
        
        l.setHorizontalAlignment(SwingConstants.CENTER);
        l.setText("Apartment nr. " + b.getA_num() + "  --  Residents: " +b.getNumber_of_guests() + " date " +b.getDate_from() );
        l.setBackground(Color.black);
        
        h.setHorizontalAlignment(SwingConstants.CENTER);
        h.setText(check);
        h.setBackground(Color.black);
        
        p.setLocation(x, y);
        p.setSize(width, height);
        p.setBackground(c);
    }

}
